package com.general.lneartao.lib.jvm.annotation;

import java.util.EnumSet;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner6;
import javax.tools.Diagnostic;

/**
 * 程序名称规范的编译器插件
 * 如果程序命名不合规范，将会输出一个编译器的WARNING信息
 *
 * @author lneartao
 * @date 2018/5/18.
 */
public class NameChecker {
    private final Messager mMessager;
    NameCheckScanner mNameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnvironment) {
        this.mMessager = processingEnvironment.getMessager();
    }

    /**
     * 对Java程序名进行检查
     * 类或接口：符合驼峰命名法，首字母大写
     * 方法：符合驼峰命名，首字母小写
     * 类、实例变量：符合驼峰命名法，首字母小写
     * 常量：要求全部大写
     *
     * @param element
     */
    public void checkNames(Element element) {
        mNameCheckScanner.scan(element);
    }

    /**
     * 名称检查器实现类，继承了JDK1.6中新提供的ElementScanner6
     * 将会以Visitor模式访问抽象语法树中的元素
     */
    private class NameCheckScanner extends ElementScanner6<Void, Void> {

        /**
         * 此方法用于检查Java类
         *
         * @param typeElement
         * @param aVoid
         * @return
         */
        @Override
        public Void visitType(TypeElement typeElement, Void aVoid) {
            scan(typeElement.getTypeParameters(), aVoid);
            checkCamelCase(typeElement, true);
            super.visitType(typeElement, aVoid);
            return null;
        }

        /**
         * 检查方法命名是否合法
         *
         * @param executableElement
         * @param aVoid
         * @return
         */
        @Override
        public Void visitExecutable(ExecutableElement executableElement, Void aVoid) {
            if (executableElement.getKind() == ElementKind.METHOD) {
                Name name = executableElement.getSimpleName();
                if (name.contentEquals(executableElement.getEnclosingElement().getSimpleName())) {
                    mMessager.printMessage(Diagnostic.Kind.WARNING, "一个普通方法" + name + "不应当与类名重复，避免与构造函数产生混淆");
                    checkCamelCase(executableElement, false);
                }
            }
            super.visitExecutable(executableElement, aVoid);
            return null;
        }

        /**
         * 检查变量命名是否合法
         *
         * @param variableElement
         * @param aVoid
         * @return
         */
        @Override
        public Void visitVariable(VariableElement variableElement, Void aVoid) {
            // 如果这个Variable是枚举或常量，则按大写命名检查，否则按照驼峰命名法则检查
            if (variableElement.getKind() == ElementKind.ENUM_CONSTANT || variableElement.getConstantValue() != null || heuristicallyConstant(variableElement)) {
                checkAllCaps(variableElement);
            } else {
                checkCamelCase(variableElement, false);
            }
            return null;
        }

        /**
         * 判断一个变量是否是常量
         *
         * @param e
         * @return
         */
        private boolean heuristicallyConstant(VariableElement e) {
            if (e.getEnclosingElement().getKind() == ElementKind.INTERFACE) {
                return true;
            } else if (e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL))) {
                return true;
            } else {
                return false;
            }
        }

        private void checkCamelCase(Element element, boolean initialCaps) {
            String name = element.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);
            if (Character.isUpperCase(firstCodePoint)) {
                previousUpper = true;
                if (!initialCaps) {
                    mMessager.printMessage(Diagnostic.Kind.WARNING, "名称" + name + "应当以小写字母开头", element);
                    return;
                }
            } else if (Character.isLowerCase(firstCodePoint)) {
                if (initialCaps) {
                    mMessager.printMessage(Diagnostic.Kind.WARNING, "名称" + name + "应当以大写字母开头", element);
                    return;
                }
            } else {
                conventional = false;
            }
            if (conventional) {
                int cp = firstCodePoint;
                for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
                    cp = name.codePointAt(i);
                    if (Character.isUpperCase(cp)) {
                        if (previousUpper) {
                            conventional = false;
                            break;
                        }
                        previousUpper = true;
                    } else {
                        previousUpper = false;
                    }
                }
            }
            if (!conventional) {
                mMessager.printMessage(Diagnostic.Kind.WARNING, "名称" + name + "应当符合驼峰命名法", element);
            }
        }
    }

    /**
     * 大写命名检查，要求第一个字母必须是大写的英文字母，其余部分可以是下划线或大写字母
     *
     * @param e
     */
    private void checkAllCaps(Element e) {
        String name = e.getSimpleName().toString();
        boolean conventional = true;
        int firstCodePoint = name.codePointAt(0);
        if (!Character.isUpperCase(firstCodePoint)) {
            conventional = false;
        } else {
            boolean previousUnderscore = false;
            int cp = firstCodePoint;
            for (int i = Character.charCount(cp); i < name.length(); i += Character.charCount(cp)) {
                cp = name.codePointAt(i);
                if (cp == (int) '_') {
                    if (previousUnderscore) {
                        conventional = false;
                        break;
                    }
                    previousUnderscore = true;
                } else {
                    previousUnderscore = false;
                    if (!Character.isUpperCase(cp) && !Character.isDigit(cp)) {
                        conventional = false;
                        break;
                    }
                }
            }
        }
        if (!conventional) {
            mMessager.printMessage(Diagnostic.Kind.WARNING, "常量" + name + "应当全部以大写字母或下划线命名，并且以字母开头", e);
        }

    }
}
