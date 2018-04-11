package com.general.lneartao.lib.puzzlers;

/**
 * 在一个final类型的实例被赋值之前，存在着取用其值的可能，而此时它包含的仍然是其所属类型的缺省值
 * 提醒：千万不要在构造器中调用可覆写的方法，直接调用或间接调用都不行，这项禁令应该扩展到实例初始器和伪构造器readObject和clone
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P51 extends Point {
    private final String color;

    public P51(int x, int y, String color) {
        // 2. chain to Point constructor
        super(x, y);
        // 5. Initialize blank final -- Too late
        this.color = color;
    }

    @Override
    protected String makeName() {
        // 4. Executes before subclass constructor body!
        return super.makeName() + ":" + color;
    }

    public static void main(String[] args) {
        // 1.invoke subclass constructor
        System.out.println(new P51(4, 2, "purple"));
    }
}

class Point {
    protected final int x, y;
    private final String name;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        // 3. Invoke subclass method
        name = makeName();
    }

    protected String makeName() {
        return "[" + x + "," + y + "]";
    }

    @Override
    public final String toString() {
        return name;
    }
}

/**
 * 修正版本的Point
 * 尽管懒性加载可以修正这个问题，但是对于让一个值类去扩展另一个值类，并且在其中添加一个会对equals比较方法产生影响的域的这种做法仍旧不是一个好主意
 * 你无法在超类和子类上都提供一个基于值的equals方法，而同时又不违反Object.equals方法的通用约定，或是是不消除在超类和子类之间进行有实际意义的比较操作的可能性
 */
class ModifiedPoint {
    protected final int x, y;
    private String name;

    public ModifiedPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected String makeName() {
        return "[" + x + "," + y + "]";
    }

    @Override
    public final synchronized String toString() {
        if (name == null) {
            name = makeName();
        }
        return name;
    }
}
