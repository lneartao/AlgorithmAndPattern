package com.general.lneartao.lib.puzzlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述有点复杂～
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class P91 {
    public static void main(String[] args) {
        Sub sub = new Sub(666);
        sub.checkInvariant();
        Sub copy = (Sub) deepCopy(sub);
        copy.checkInvariant();
    }

    public static Object deepCopy(Object obj) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            new ObjectOutputStream(bos).writeObject(obj);
            ByteArrayInputStream bin = new ByteArrayInputStream(bos.toByteArray());
            return new ObjectInputStream(bin).readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}

class Super implements Serializable {
    final Set<Super> set = new HashSet<>();
}

final class Sub extends Super {
    private int id;

    public Sub(int id) {
        this.id = id;
        set.add(this);
    }

    public void checkInvariant() {
        if (!set.contains(this)) {
            throw new AssertionError("invariant violated");
        }
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Sub) && (id == ((Sub) obj).id);
    }

}