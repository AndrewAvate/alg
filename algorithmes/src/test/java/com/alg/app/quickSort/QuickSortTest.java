package com.alg.app.quickSort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
/**
 * Created by andrewavetisov on 17.11.16.
 */
public class QuickSortTest {

    @Test
    public void sortTest() {
        int[] arr = {3, 9, 8, 4, 6, 10, 2, 5, 7, 1};
        int[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        assertArrayEquals("checkQuickSort:", expectedArr, arr);
    }
}
