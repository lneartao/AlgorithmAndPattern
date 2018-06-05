package com.general.lneartao.lib.basic.reflect;

/**
 * @author lneartao
 * @date 2018/5/30.
 */
@Test(tag = "Student class Test Annotation")
public class Student extends Person implements Examination {
    @Test(tag = "mGrade Test Annotation")
    int mGrade;

    private int mAge;

    public Student(String aName) {
        super(aName);
    }

    public Student(int grade, String aName) {
        super(aName);
        mGrade = grade;
    }

    private void learn(String course) {
        System.out.println(mName + " learn " + course);
    }

    @Override
    public void takeAnExamination() {
        System.out.println(" takeAnExamination ");
    }

    @Override
    public String toString() {
        return " Student :  " + mName;
    }

    private class A {

    }

    protected class B {

    }

    public class C {

    }
}
