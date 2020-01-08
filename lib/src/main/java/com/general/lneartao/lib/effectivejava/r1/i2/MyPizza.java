package com.general.lneartao.lib.effectivejava.r1.i2;

import java.util.Objects;

/**
 * @author lneartao
 * @date 2020/1/3.
 */
public class MyPizza extends Pizza {

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        MyPizza build() {
            return new MyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private MyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static void main(String[] args) {
        MyPizza pizza = new MyPizza.Builder(MyPizza.Size.SMALL).addTopping(Topping.SAUSAGE)
                                                               .addTopping(Topping.ONION)
                                                               .build();
    }
}
