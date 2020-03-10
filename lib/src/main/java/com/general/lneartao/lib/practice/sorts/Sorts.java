package com.general.lneartao.lib.practice.sorts;

/**
 * 冒泡排序、插入排序、选择排序
 *
 * @author lneartao
 * @date 2020/1/21.
 */
public class Sorts {

    /**
     * 冒泡排序
     *
     * @param a 数组
     * @param n 数组大小
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     *
     * @param a
     * @param n
     */
    public static void bubbleSort2(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        // 最后一次交换的位置
        int lastExchange = 0;
        // 无序数据的边界,每次只需要比较到这里即可退出
        int sortBorder = n - 1;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < sortBorder; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                    // 更新最后一次交换的位置
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param a
     * @param n
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    // 数据移动
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    /**
     * 选择排序
     *
     * @param a
     * @param n
     */
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) {
            return;
        }
//        for (int i = 0; i < n; i++) {
//            int min = a[i];
//            int minIndex = i;
//            for (int j = i; j < n; j++) {
//                if (a[j] < min) {
//                    min = a[j];
//                    minIndex = j;
//                }
//            }
//            int temp = a[i];
//            a[i] = a[minIndex];
//            a[minIndex] = temp;
//        }
        for (int i = 0; i < n - 1; i++) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    /**
     * 归并排序
     *
     * @param arr 数组
     */
    public static void mergeSort(int[] arr) {
        int[] tempArr = new int[arr.length];
        mergeSort(arr, tempArr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tempArr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(arr, tempArr, left, center);
            mergeSort(arr, tempArr, center + 1, right);
            merge(arr, tempArr, left, center + 1, right);
        }
    }

    private static void merge(int[] arr, int[] tempArr, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (arr[leftPos] <= arr[rightPos]) {
                tempArr[tmpPos++] = arr[leftPos++];
            } else {
                tempArr[tmpPos++] = arr[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tempArr[tmpPos++] = arr[leftPos++];
        }

        while ((rightPos <= rightEnd)) {
            tempArr[tmpPos++] = arr[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            arr[rightEnd] = tempArr[rightEnd];
        }
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);
            quickSort(a, left, p - 1);
            quickSort(a, p + 1, right);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int i = left;
        for (int j = left; j < right; j++) {
            if (a[j] < a[right]) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, right, i);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int temp;
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    private static int findK(int a[], int k) {
        return findK(a, k, 0, a.length - 1);
    }

    private static int findK(int[] a, int k, int left, int right) {
        if (left < right) {
            int p = partition(a, left, right);
            if (p + 1 == k) {
                return a[p];
            } else if (k > p + 1) {
                return findK(a, k, p + 1, right);
            } else {
                return findK(a, k, left, p - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] array = new int[]{3, 4, 2, 1, 5, 6, 7, 8};
//        quickSort(array);
        int[] array = new int[]{4, 2, 5, 12, 3};
        System.out.println(findK(array, 3));
//        System.out.println(Arrays.toString(array));
    }

}
