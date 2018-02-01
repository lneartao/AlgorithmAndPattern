package com.general.lneartao.lib.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lneartao on 2017/11/23.
 */

public class ListFun {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(2);
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);

        removeEvensVer3(linkedList);
    }

    // 这个方法对于ArrayList和LinkedList来说,实际上都是O(n2)的
    public static void removeEvensVer1(List<Integer> list) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) % 2 == 0) {    // LinkedList 的get方法耗时,这里花费O(n)的时间
                list.remove(i);            // ArrayList 的remove方法耗时,这里花费O(n)的时间
            } else {
                i++;
            }
        }
    }

    // 这个方法如果不注意的话,还是会挺容易写出来的,但是会产生异常, 因为当一项被删除时,由增强的for循环所使用的基础迭代器是非法的
    public static void removeEvensVer2(List<Integer> list) {
        for (Integer x : list) {
            if (x % 2 == 0) {
                list.remove(x);
            }
        }
    }

    // 对于ArrayList是二次的,对于LinkedList是线性的
    public static void removeEvensVer3(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
    }
}
