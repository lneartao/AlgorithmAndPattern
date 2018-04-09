package com.general.lneartao.lib.puzzlers.p47;

import com.general.lneartao.lib.Logger;

/**
 * 这个例子说明了该使用组合还是继承的问题，因为猫和狗都不是一种计数器，然而它们都需要一个计数器，所以应该使用组合而不是继承
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class Ruckus {
    public static void main(String[] args) {
        wrongOne();
        correctOne();
    }

    private static void wrongOne() {
        DogWrong[] dogs = {new DogWrong(), new DogWrong()};
        for (int i = 0; i < dogs.length; i++) {
            dogs[i].woof();
        }
        CatWrong[] cats = {new CatWrong(), new CatWrong(), new CatWrong()};
        for (int i = 0; i < cats.length; i++) {
            cats[i].meow();
        }
        Logger.printl(DogWrong.getCount() + " woofs");
        Logger.printl(CatWrong.getCount() + " meows");
    }

    private static void correctOne() {
        Dog[] dogs = {new Dog(), new Dog()};
        for (int i = 0; i < dogs.length; i++) {
            dogs[i].woof();
        }
        Cat[] cats = {new Cat(), new Cat(), new Cat()};
        for (int i = 0; i < cats.length; i++) {
            cats[i].meow();
        }
        Logger.printl(Dog.woofCount() + " woofs");
        Logger.printl(Cat.meowCount() + " meows");
    }
}
