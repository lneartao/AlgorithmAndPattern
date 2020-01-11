package com.general.lneartao.lib.effectivejava.r2.i10;

import java.util.Objects;

/**
 * @author lneartao
 * @date 2020/1/9.
 * 覆盖equals时请遵守通用约定（难点）
 * <p>
 * 不覆盖equals方法的情况：
 * 1. 类的每个实例都只与它自身相等
 * 2. 超类已经覆盖了equals，而且超类的行为对于这个类也合适
 * 3. 类是私有的，或者是包级私有的，可以确定它的equals方法永远不会被调用
 * 需要覆盖equals方法的情况：提供特有的逻辑相等。
 * <p>
 * 覆盖equals时，必须遵守的一些通用约定：
 * 1. 自反性，a == a，如果违反，那么集合的contains方法就会果断地告诉你，找不到你刚刚添加进集合的实例
 * 2. 对称性，a == b, 那么b == a.
 * 3. 传递性，a == b, b == c, 那么 a == c.（难点）
 * 我们无法在扩展可实例化的类的同时，既增加新的值组件，同时又保留equals约定，除非愿意放弃面向对象的抽象所带来的优势
 * @see java.sql.Timestamp#equals(Object) ，扩展了Date，增加了nanoseconds域，这个equals方法就确实违反了对称性
 * 但是，可以在一个抽象类的子类中增加新的值组件且不违反equals约定，比如抽象的Shape类，Circle子类添加了radius域，而Rectangle子类添加了length和width域
 * @see java.awt.Shape
 * @see javafx.scene.shape.Circle#equals(Object)
 * @see java.awt.Rectangle#equals(Object)
 * 4. 一致性，a == b，那么任何时刻都保证 a == b，如果两个对象相当，它们就必须始终保持相等，除非它们中有一个对象被修改了。
 * 此外，不要使equals方法依赖于不可靠的资源 {@link java.net.URL#equals(Object)}
 * 5. 非空性，a.equals(null)时必须返回false
 * <p>
 * 实现高质量equals方法的诀窍：
 * 1. 使用==操作符检查“参数是否为这个对象的引用”
 * 2。使用instanceof操作符检查“参数是否为正确的参数”
 * 3. 把参数转换成正确的类型
 * 4. 对于该类中的每个关键域，检查参数中的域是否与该对象中对应域相匹配
 * 对于float，使用Float.compare(float, float)检查是否相等，因为存在着-0.0f等常量，以及排出了自动装箱
 * 对于double，使用Double.compare(double, double)检查是否相等
 * 如果有些域包含null可能是合法的，那么避免导致空指针异常，可以使用Objects.equals(Object, Object)
 * <p>
 * 三个告诫：
 * 1. 覆盖equals时总要覆盖hashCode
 * 2. 不要企图让equals方法过于智能
 * 3. 不要将equals声明中的Object对象替换为其他的类型
 * <p>
 * 推荐使用Google开源的AutoValue
 */
public class PhoneNumber {
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
}
