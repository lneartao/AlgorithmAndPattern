package com.general.lneartao.lib.datastructure;

import com.general.lneartao.lib.Logger;

/**
 * 动态链接问题
 * Created by lneartao on 2017/12/9.
 */

public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // O(N)
    public void union(int a, int b) {
        int aid = id[a];
        int bid = id[b];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == aid) {
                id[i] = bid;
            }
        }
    }

    // O(1)
    public boolean connected(int a, int b) {
        return id[a] == id[b];
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(4, 3);
        uf.union(3, 8);
//        uf.union(6, 5);
//        uf.union(9, 4);
//        uf.union(2, 1);
        Logger.printl(uf.connected(0, 7));
        Logger.printl(uf.connected(8, 9));
        uf.union(0, 5);
        uf.union(7, 2);
//        uf.union(6, 1);
//        uf.union(1, 0);
        Logger.printl(uf.connected(0, 7));
    }
}
