package com.general.lneartao.lib.puzzlers.p83;

import com.general.lneartao.lib.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author lneartao
 * @date 2018/4/10.
 */
public class CopyDog {

    public static void main(String[] args) {
        Dog newDog = (Dog) deepCopy(Dog.INSTANCE);
        Logger.printl(newDog==Dog.INSTANCE);
        Logger.printl(newDog);
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
