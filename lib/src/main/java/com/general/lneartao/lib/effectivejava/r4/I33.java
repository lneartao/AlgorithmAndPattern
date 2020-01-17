package com.general.lneartao.lib.effectivejava.r4;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 优先考虑类型安全的异构容器
 * <p>
 * 将键进行参数化而不是将容器参数化，然后将参数化的键提交给容器来插入或获取值，如下 {@link Favorites}
 * asSubclass()方法在编译时读取类型未知的注解
 *
 * @author lneartao
 * @date 2020/1/17.
 */
public class I33 {

    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    private static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(Objects.requireNonNull(type), type.cast(instance));
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }

        public static void main(String[] args) {
            Favorites f = new Favorites();
            f.putFavorite(String.class, "java");
            f.putFavorite(Integer.class, 0xcafebabe);
            f.putFavorite(Class.class, Favorites.class);
            String favoriteString = f.getFavorite(String.class);
            int favoriteInteger = f.getFavorite(Integer.class);
            Class<?> favoriteClass = f.getFavorite(Class.class);
            System.out.printf("%s %x %s%n",
                              favoriteString,
                              favoriteInteger,
                              favoriteClass.getSimpleName());
        }
    }
}
