package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 以类取代类型码：以一个新的类替换该数值类型码
 *
 * @author lneartao
 * @date 2018/10/12.
 */
public class ReplaceTypeCodeWithClass {

}

class Person {
    public static final int O = BloodGroup.O.getCode();
    public static final int A = BloodGroup.A.getCode();
    public static final int B = BloodGroup.B.getCode();
    public static final int AB = BloodGroup.AB.getCode();

    private BloodGroup bloodGroup;

    public Person(int bloodGroup) {
        this.bloodGroup = BloodGroup.code(bloodGroup);
    }

    public Person(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setBloodGroup(int bloodGroup) {
        this.bloodGroup = BloodGroup.code(bloodGroup);
    }
}

class BloodGroup {

    public static final BloodGroup O = new BloodGroup(0);
    public static final BloodGroup A = new BloodGroup(1);
    public static final BloodGroup B = new BloodGroup(2);
    public static final BloodGroup AB = new BloodGroup(3);
    private static final BloodGroup[] values = {O, A, B, AB};
    private final int code;

    public BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BloodGroup code(int arg) {
        return values[arg];
    }
}
