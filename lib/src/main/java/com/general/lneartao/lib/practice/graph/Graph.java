package com.general.lneartao.lib.practice.graph;


import java.util.LinkedList;

/**
 * 无向图
 */
public class Graph {
    // 顶点的个数
    private int v;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 无向图一条边存两次
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索，可以得到最短路径
     *
     * @param s 起始点
     * @param t 终止点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        // 初始化 visited数组
        // 用来记录已经被访问的顶点，用来避免顶点被重复访问。如果顶点 q 被访问，
        // 那相应的 visited[q] 会被设置为 true。
        boolean[] visited = new boolean[v];
        visited[s] = true;
        // 初始化队列
        // 用来存储已经被访问、但相连的顶点还没有被访问的顶点。
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        // 初始化前驱数组 用来记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        // 队列不等于空，循环，取出队列然后遍历链表，如果没有visited才处理
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    // 标记前驱
                    prev[q] = w;
                    // 如果找到了，那么打印返回
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    // 标记visited和增加队列
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    boolean found = false; // 全局变量或者类成员变量

    /**
     * 深度优先搜索，结果不一定是最短路径
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        found = false;
        // 初始化visited
        boolean[] visited = new boolean[v];
        // 初始化prev
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        // 递归查找
        recurDfs(s, t, visited, prev);
        // 打印
        print(prev, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        // 找到 直接返回
        if (found) {
            return;
        }
        // 标记w
        visited[w] = true;
        // 如果w==t，也找到，返回
        if (w == t) {
            found = true;
            return;
        }
        // 遍历w的链表，如果没访问过，那么置前驱，继续递归
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }

    /**
     * 递归打印 s --> t 的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
