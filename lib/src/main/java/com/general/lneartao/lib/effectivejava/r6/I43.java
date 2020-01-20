package com.general.lneartao.lib.effectivejava.r6;

/**
 * 方法引用优先于Lambda
 * <p>
 * map.merge(key, 1, Integer::sum); 这个就叫方法引用
 * service.execute(() -> action()); 这个叫Lambda
 * 有一种技巧性的方法：从Lambda中提取代码，放到一个新的方法中，并用改方法的一个引用代替Lambda。
 * 只要方法引用更加简洁、清晰，就用方法引用；如果方法引用并不简洁，就坚持使用Lambda
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public class I43 {
}
