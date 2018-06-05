package com.general.lneartao.lib.basic.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1、所有方法没有方法体，参数没有修饰符，不允许抛异常
 * 2、方法返回值只能是基本类型，String, Class, annotation, Enum或他们的一维数组
 * 3、可以加default表示默认值
 *
 * @author lneartao
 * @date 2018/5/30.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
public @interface MethodInfo {
    String author() default "l.neartao@gmail.com";

    String date();

    int version() default 1;
}
