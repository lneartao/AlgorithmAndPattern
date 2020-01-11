package com.general.lneartao.lib.effectivejava.r2.i14;

import java.util.Objects;

/**
 * 考虑实现Comparable接口
 * <p>
 * 通用约定
 * 1. 必须确保所有的x和y都满足 x.compareTo(y) = - y.compareTo(x)
 * 2. 必须确保这个关系是可传递的 x.compareTo(y) > 0 && y.compareTo(z) > 0, so x.compareTo(z) > 0
 * 3. 必须确保 x.compareTo(y) = 0
 * 4. 强烈建议 (x.compareTo(y) == 0) == (x.equals(y))
 * <p>
 * 在比较中使用类提供的compareTo方法，不要使用 > 或 <
 *
 * @author lneartao
 * @date 2020/1/11.
 */
public class PhoneNumber implements Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode &&
                prefix == that.prefix &&
                lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }

    @Override
    public int compareTo(PhoneNumber pn) {
        int compare = Short.compare(areaCode, pn.areaCode);
        if (compare == 0) {
            compare = Short.compare(prefix, pn.prefix);
            if (compare == 0) {
                compare = Short.compare(lineNum, pn.lineNum);
            }
        }
        return compare;
    }
}
