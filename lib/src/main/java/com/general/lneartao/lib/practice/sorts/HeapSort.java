package com.general.lneartao.lib.practice.sorts;

/**
 * 堆排序
 * 堆顶元素在下标为1的位置，左节点是2*i，右节点是2*i+1
 *
 * @author lneartao
 * @date 2020/3/27.
 */
public class HeapSort {

    /**
     * 排序，完成后从小到大排序
     * <p>
     * 堆元素是从数组下标0开始
     *
     * @param arr
     */
    public static void sort(int[] arr, int n) {
        buildHeap(arr, n);
        int k = n;
        while (k > 1) {
            swap(arr, 1, k);
            --k;
            heapify(arr, k, 1);
        }
    }

    /**
     * 建堆（大顶堆）
     *
     * @param arr
     */
    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(arr, n, i);
        }
    }

    /**
     * 堆化，对下标从n/2开始到1的数据进行堆化，因为从n/2都是叶子节点，不需要堆化比较
     *
     * @param arr 要堆化的数组
     * @param n 最后堆元素下标
     * @param i 要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && arr[i] < arr[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && arr[maxPos] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
