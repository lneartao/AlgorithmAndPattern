package com.general.lneartao.lib.effectivejava.r1.i2;

/**
 * @author lneartao
 * @date 2020/1/3.
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static void main(String[] args) {
        Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
    }
}
