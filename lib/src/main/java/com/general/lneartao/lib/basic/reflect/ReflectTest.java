package com.general.lneartao.lib.basic.reflect;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * 含有Declared是当前类的所有域、方法、类等，包括私有修饰符；不含有的是当前类和父类的所有公有的域、方法、类等
 * getDeclaredMethods()
 * getMethod()等
 * @author lneartao
 * @date 2018/5/30.
 */
public class ReflectTest {

    public static void main(String[] args) {
//        showClazz();
//        getClazz();
        getInstance();
//        showDeclaredMethods();
//        showMethods();
//        showDeclaredFields();
//        showFields();
//        showSuperClass();
//        showInterface();
//        getAnnotationInfos();
    }

    private static void showClazz() {
        Class<?> studentClass = Student.class;
        for (Class clazz : studentClass.getClasses()) {
            Logger.printl("class name: " + clazz.getName());
        }
    }

    private static void getClazz() {
        try {
            Class<?> clazz = Class.forName("com.general.lneartao.lib.basic.reflect.Student");
            Logger.printl(clazz.toString());
            Class<?> clazz1 = Student.class;
            Logger.printl(clazz1.toString());
            Class<?> clazz2 = new Student("Mr.simple").getClass();
            Logger.printl(clazz2.toString());
            byte[] bytes = new byte[1024];
            Class<?> clazz3 = bytes.getClass();
            Logger.printl(clazz3);
            Set<String> set = new HashSet<>();
            Class<?> clazz4 = set.getClass();
            Logger.printl(clazz4);
            // primitive类型的有点特殊
            Class<?> clazz5 = boolean.class;
            Logger.printl(clazz5);
            Class<?> classB = Boolean.TYPE;
            Logger.printl(classB);
            Class<?> classV = Void.TYPE;
            Logger.printl(classV);
            Class<?> clazz6 = int[][][].class;
            Logger.printl(clazz6);

            Class<?> cDoubleArray = Class.forName("[D");
            Logger.printl(cDoubleArray);
            Class<?> cStringArray = Class.forName("[[Ljava.lang.String;");
            Logger.printl(cStringArray);
            Class<?> cString = String[][].class;
            Logger.printl(cString);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void getInstance() {
        try {
            Class<?> clazz = Class.forName("com.general.lneartao.lib.basic.reflect.Dog");

            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            // 这个方法可以取消Java语言的访问检查，可以提升反射速度
            constructor.setAccessible(true);
            Object object = constructor.newInstance("Mr.simple");
            if (object instanceof Student) {
                Student student = (Student) object;
                student.mGrade = 11;
                Logger.printl(student.mGrade);
            }
            Logger.printl(object.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前类中定义的方法，包括所有修饰符
     */
    private static void showDeclaredMethods() {
        Student student = new Student("Mr.simple");
        Method[] methods = student.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Logger.printl("declared method name: " + method.getName());
        }

        try {
            Method learnMethod = student.getClass().getDeclaredMethod("learn", String.class);
            // 当调用private方法时，需要设置这个，否则Java语言访问检查失败报错
            learnMethod.setAccessible(true);
            // 获取方法的参数类型
            Class<?>[] paramClasses = learnMethod.getParameterTypes();
            for (Class<?> class1 : paramClasses) {
                Logger.printl("learn方法的参数类型: " + class1.getName());
            }
            Logger.printl(learnMethod.getName() + " is private " + Modifier.isPrivate(learnMethod.getModifiers()));
            learnMethod.invoke(student, "java ---> ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前类、父类中定义的公有方法
     */
    private static void showMethods() {
        Student student = new Student("Mr.simple");
        Method[] methods = student.getClass().getMethods();
        for (Method method : methods) {
            Logger.printl("method name: " + method.getName());
        }

        try {
            Method learnMethod = student.getClass().getMethod("learn", String.class);
            Logger.printl(learnMethod.getName() + " is private " + Modifier.isPrivate(learnMethod.getModifiers()));
            learnMethod.invoke(student, "java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前类中定义的属性
     */
    private static void showDeclaredFields() {
        Student student = new Student("Mr.simple");
        Field[] publicFields = student.getClass().getDeclaredFields();
        for (Field field : publicFields) {
            Logger.printl("declared field name: " + field.getName());
        }
        try {
            Field gradeField = student.getClass().getDeclaredField("mAge");
            gradeField.setAccessible(true);
            Logger.printl("my age is: " + gradeField.getInt(student));
            gradeField.set(student, 10);
            Logger.printl("my age is: " + gradeField.getInt(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取当前类、父类中定义的公有属性
     */
    private static void showFields() {
        Student student = new Student("Mr.simple");
        Field[] publicFields = student.getClass().getFields();
        for (Field field : publicFields) {
            System.out.println("field name : " + field.getName());
        }
        try {
            // 获取当前类和父类的某个公有属性
            Field ageField = student.getClass().getField("mAge");
            System.out.println("age is : " + ageField.getInt(student));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取父类
     */
    private static void showSuperClass() {
        Student student = new Student("Mr.simple");
        Class<?> superClass = student.getClass().getSuperclass();
        while (superClass != null) {
            Logger.printl("Student's super class is: " + superClass.getName());
            superClass = superClass.getSuperclass();
        }
    }

    /**
     * 获取接口
     */
    private static void showInterface() {
        Student student = new Student("Mr.simple");
        Class<?>[] interfaces = student.getClass().getInterfaces();
        for (Class<?> class1 : interfaces) {
            Logger.printl("Student's interface is: " + class1.getName());
        }
    }

    /**
     * 获得注解信息
     */
    private static void getAnnotationInfos() {
        Student student = new Student("Mr.simple");
        Test classTest = student.getClass().getAnnotation(Test.class);
        Logger.printl(student.getClass().isAnnotationPresent(Test.class));
        Logger.printl("class Annotation tag = " + classTest.tag());
        Field field;
        try {
            field = student.getClass().getDeclaredField("mGrade");
            Test testAnnotation = field.getAnnotation(Test.class);
            Logger.printl("属性 Test 注解 tag: " + testAnnotation.tag());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
