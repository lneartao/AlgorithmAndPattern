package com.general.lneartao.lib.algorithm;

/**
 * Created by lneartao on 2017/11/22.
 */

public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 321321, 32, 321, 321, 321};
//        quickSortRecursive(arr, 0, arr.length - 1);
//        int[] reg = new int[arr.length];
//        mergeSortRecursive(arr, reg, 0, arr.length);
//        shellSort(arr);
        quickSort(arr);
        for (Integer s : arr) {
            System.out.print(s + " ");
        }
    }

    /**
     * 插入排序
     *
     * @param a 数组
     */
    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 小优化的插入排序
     *
     * @param a 数组
     */
    public static void insertionSortV2(int[] a) {
        int j;
        for (int p = 1; p < a.length; p++) {
            int temp = a[p];
            for (j = p; j > 0 && temp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    /**
     * 插入排序
     *
     * @param a     数组
     * @param left  数组左下标
     * @param right 数组右下标
     */
    public static void insertionSortV2(int[] a, int left, int right) {
        int j;
        for (int p = left + 1; p <= right; p++) {
            int temp = a[p];
            for (j = p; j > left && temp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
    }

    /**
     * 快速排序 递归版本
     *
     * @param arr   数组
     * @param start 左标
     * @param end   右标
     */
    public static void quickSortRecursive(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = arr[end];
        int left = start;
        int right = end - 1;
        while (left < right) {
            while (arr[left] < mid && left < right) {
                left++;
            }
            while (arr[right] >= mid && left < right) {
                right--;
            }
            swap(arr, left, right);
        }
        if (arr[left] >= arr[end]) {
            swap(arr, left, end);
        } else {
            left++;
        }
        quickSortRecursive(arr, start, left - 1);
        quickSortRecursive(arr, left + 1, end);
    }

    /**
     * 快速排序
     *
     * @param arr 数组
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static final int CUTOFF = 10;

    /**
     * 快速排序，数组小于10的时候使用插入排序，否则使用快排，pivot放在数组最右端
     *
     * @param arr   数组
     * @param left  坐标
     * @param right 右标
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left + CUTOFF <= right) {
            int pivot = median3(arr, left, right);

            // 开始分治 这里还要减1是因为pivot在right的位置上
            int i = left, j = right - 1;
            for (; ; ) {
                while (arr[++i] < pivot) {
                }
                while (arr[--j] > pivot) {
                }
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
            // i和j已经交错，故不再交换，分割的最后一步是将pivot与i所指的元素交换
            swap(arr, i, right - 1);

            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        } else {
            insertionSortV2(arr, left, right);
        }
    }

    private static void quickSelect(int[] arr, int left, int right, int target) {
        if (left + CUTOFF <= right) {
            int pivot = median3(arr, left, right);
            int i = left, j = right - 1;
            while (true) {
                while (arr[++i] < pivot) {
                }
                while (arr[--j] > pivot) {
                }
                if (i < j) {
                    swap(arr, i, j);
                } else {
                    break;
                }
            }
            swap(arr, i, right - 1);
            if (target <= i) {
                quickSelect(arr, left, i - 1, target);
            } else if (target > i + 1) {
                quickSelect(arr, i + 1, right, target);
            }
        } else {
            insertionSortV2(arr, left, right);
        }
    }

    /**
     * 用于快排的三数中值分割法
     *
     * @param arr   数组
     * @param left  左标
     * @param right 右标
     * @return 用于快排的pivot
     */
    private static int median3(int[] arr, int left, int right) {
        int center = (left + right) / 2;
        if (arr[center] < arr[left]) {
            swap(arr, left, center);
        }
        if (arr[right] < arr[left]) {
            swap(arr, left, right);
        }
        if (arr[right] < arr[center]) {
            swap(arr, center, right);
        }
        // 把pivot放到 right-1的位置
        swap(arr, center, right - 1);
        return arr[right - 1];
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

    /**
     * 希尔排序
     *
     * @param arr 数组
     */
    public static void shellSort(int[] arr) {
        int i, j, temp, gap = 1, len = arr.length;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }

    public static void shellSortV2(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    /**
     * 堆排序
     *
     * @param arr 数组
     */
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            percDown(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            percDown(arr, 0, i);
        }
    }

    private static void percDown(int[] arr, int i, int n) {
        int child;
        int temp;
        for (temp = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++;
            }
            if (temp < arr[child]) {
                arr[i] = arr[child];
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
