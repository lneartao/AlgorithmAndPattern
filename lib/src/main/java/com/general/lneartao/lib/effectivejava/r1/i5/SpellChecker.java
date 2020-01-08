package com.general.lneartao.lib.effectivejava.r1.i5;

/**
 * 优先考虑依赖注入来引用资源
 * 下面的例子就是一个简单的依赖注入实现：当创建一个新的实例时，就将该资源传到构造器中。
 * 依赖注入同样也适用于构造器、静态工厂{@link com.general.lneartao.lib.effectivejava.r1.I1}、
 * 和构建器{@link com.general.lneartao.lib.effectivejava.r1.i2.NutritionFacts}
 * 不过为了灵活性和可测试性，大型项目可以使用Dagger等依赖注入框架
 *
 * @author lneartao
 * @date 2020/1/7.
 */
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }
}
