package com.general.lneartao.lib.basic.annotation;

import java.util.HashMap;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * 如果MethodInfo的@Retention是CLASS，要通过这个例子进行解析
 *
 * @author lneartao
 * @date 2018/5/31.
 */
//@SupportedAnnotationTypes(MethodInfo)
public class MethodInfoProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        HashMap<String, String> map = new HashMap<>();
        for (TypeElement te : set) {
            for (Element element : roundEnvironment.getElementsAnnotatedWith(te)) {
                MethodInfo methodInfo = element.getAnnotation(MethodInfo.class);
                map.put(element.getEnclosingElement().toString(), methodInfo.author());
            }
        }
        return false;
    }
}
