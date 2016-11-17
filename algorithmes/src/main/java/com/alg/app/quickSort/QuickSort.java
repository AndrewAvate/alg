package com.alg.app.quickSort;

/**
 * Created by andrewavetisov on 17.11.16.
 */
public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        int firstElemIdx = 0;
        int lastElemIdx = arr.length - 1;
        sort(arr, firstElemIdx, lastElemIdx);

    }

    private void sort(int[] arr, int firstElemIdx, int lastElemIdx) {
        if (lastElemIdx <= firstElemIdx) {
            return;
        }
        int partitionIdx = quickSortRoutine(arr, firstElemIdx, lastElemIdx);
        sort(arr, firstElemIdx, partitionIdx-1);
        sort(arr, partitionIdx+1, lastElemIdx);

    }


    //return partition index
    private int quickSortRoutine(int[] arr, int firstElemIdx, int lastElemIdx) {
        int pivotIdx = getPivotIdx(arr, firstElemIdx, lastElemIdx);
        int pivotElem = arr[pivotIdx];
        int minBorder = pivotIdx + 1;
        int maxBorder = pivotIdx + 1;

        while (maxBorder <=  lastElemIdx) {
            int value = arr[maxBorder];
            if (value < pivotElem) {
                swap(arr, minBorder, maxBorder);
                minBorder++;
            }
            maxBorder++;

        }
        int partitionIdx = minBorder - 1;
        swap(arr, pivotIdx, partitionIdx);
        return partitionIdx;

    }

    private void swap(int [] arr, int firstIdx, int secondIdx) {
        int temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }

    private int getPivotIdx(int[] arr, int firstElemIdx, int lastElemIdx) {
        return firstElemIdx;
    }
}
