package com.general.lneartao.lib.datastructure;

/**
 * 缺点 树可能太高了
 * Created by lneartao on 2017/12/9.
 */

public class QuickUnionUF {
    private int[] id;
    private int[] sz;

    public QuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    // 使用了路径压缩
    private int root(int a) {
//        第一种写法
//        if (id[a] != a) {
//            return id[a] = root(id[a]);
//        } else {
//            return a;
//        }
        while (a != id[a]) {
            id[a] = id[id[a]]; // 路径压缩的关键代码
            a = id[a];
        }
        return a;
    }

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    // worst O(N)
    public void unionUgly(int a, int b) {
        int i = root(a);
        int j = root(b);
        id[i] = j;
    }

    // 维护一个树大小的数组,保证每次合并都把小树合并到大树上去
    public void union(int a, int b) {
        int i = root(a);
        int j = root(b);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

}
