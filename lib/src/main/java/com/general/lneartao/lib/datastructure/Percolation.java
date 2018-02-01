package com.general.lneartao.lib.datastructure;

/**
 * 渗透系统
 * TODO 有点难,之后看看要不要实现
 * Created by lneartao on 2017/12/9.
 */

public abstract class Percolation {
    public Percolation(int n) {

    }

    public abstract void open(int row, int col);

    public abstract boolean isOpen(int row, int col);

    public abstract boolean isFull(int row, int col);

    public abstract int numberOfOpenSites();

    public static void main(String[] args) {

    }
}
