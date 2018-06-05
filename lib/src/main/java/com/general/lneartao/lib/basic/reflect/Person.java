package com.general.lneartao.lib.basic.reflect;

/**
 * @author lneartao
 * @date 2018/5/30.
 */
public class Person {
    String mName;
    public int mAge;

    public Person(String aName) {
        mName = aName;
    }

    private void sayHello(String friendName) {
        System.out.println(mName + " say hello to " + friendName);
    }

    protected void showMyName() {
        System.out.println("My name is " + mName);
    }

    public void breathe() {
        System.out.println(" take breathe ");
    }
}
