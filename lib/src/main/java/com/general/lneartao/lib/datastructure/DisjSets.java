package com.general.lneartao.lib.datastructure;

/**
 * 使用森林的数据结构来处理数据，数组的值为负表示该树的根节点，
 * 具体数值的绝对值是该树估计的高度（因为使用路径压缩已经改变了每棵树所存储的高度）
 * Created by lneartao on 2017/12/8.
 */

public class DisjSets {
    private int[] s;

    public DisjSets(int numElements) {
        s = new int[numElements];
        for (int i = 0; i < s.length; i++) {
            s[i] = -1;
        }
    }

    // 按高度求并，总让较浅的树成为较深的树的子树
    public void union(int root1, int root2) {
        if (s[root2] < s[root1]) {               // root2更深
            s[root1] = s[root2];               // root2是新的根
        } else {
            if (s[root1] == s[root2]) {
                s[root1]--;                  // 一样深，更新高度
            }
            s[root2] = s[root1];               // root1是新的根
        }
    }

    // 路径压缩
    public int find(int x) {
        if (s[x] < 0) {
            return x;
        } else {
            return s[x] = find(s[x]); // 这里是一种优化的方式，可以减少树的高度
        }
    }

//    public boolean isConnected(int a, int b) {
//        return find(a) == find(b);
//    }

    public static void main(String[] args) {
        int NumElements = 128;
        int NumInSameSet = 16;

        DisjSets ds = new DisjSets(NumElements);
        int set1, set2;

        for (int k = 1; k < NumInSameSet; k *= 2) {
            for (int j = 0; j + k < NumElements; j += 2 * k) {
                set1 = ds.find(j);
                set2 = ds.find(j + k);
                ds.union(set1, set2);
            }
        }

        for (int i = 0; i < NumElements; i++) {
            System.out.print(ds.find(i) + "*");
            if (i % NumInSameSet == NumInSameSet - 1) {
                System.out.println();
            }
        }
        System.out.println();

//        int a, b;
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            a = random.nextInt(NumElements);
//            b = random.nextInt(NumElements);
//            System.out.print(a + " " + b + " is connected? ");
//            System.out.println(ds.isConnected(a, b));
//        }
    }
}
