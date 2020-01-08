package com.general.lneartao.lib.effectivejava.r1.i2;

/**
 * 遇到多个构造器参数时要考虑使用构造器
 * 优点：
 * 1. 易于扩展（增加参数），易于阅读
 * 2。保证构造过程中数据状态的一致性
 * <p>
 * 缺点：
 * 1. 由于创建对象前，必须先创建它的构造器，所以会有一些额外的性能开销
 * 2. Builder模式会比较冗长（写出来的代码）
 * <p>
 * 总而言之：
 * 如果类的构造器或者静态工厂中具有多个参数，设计这种类时，Builder模式就是一种不错的选择。
 *
 * @author lneartao
 * @date 2020/1/3.
 */
public class NutritionFacts {

    /**
     * required
     */
    private int servingSize;

    /**
     * required
     */
    private int servings;

    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static final class Builder {
        private int servingSize;
        private int servings;
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100)
                                                                    .sodium(35)
                                                                    .carbohydrate(27)
                                                                    .build();
    }
}
