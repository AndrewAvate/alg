package com.alg.app.inversion;

import java.util.Arrays;

/**
 * Created by andrewavetisov on 13.11.16.
 */
public class InversionAlg {

    public int countInversions(int[] arr) {
        int inversions = 0;

        if (null == arr || arr.length < 2) {
            return inversions;
        }


        int[] firstArr = Arrays.copyOf(arr, arr.length / 2);
        int[] secondArr = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        inversions += countInversions(firstArr);
        inversions += countInversions(secondArr);
        inversions += merge(firstArr, secondArr, arr);
        return inversions;
    }

    private int merge(int[] firstArr, int[] secondArr, int[] targetArr) {
        int firstCount = 0;
        int secondCount = 0;
        int targetCount = 0;
        int inversions = 0;

        while (targetCount < targetArr.length && firstCount < firstArr.length && secondCount < secondArr.length) {
            if (firstArr[firstCount] <= secondArr[secondCount]) {
                targetArr[targetCount] = firstArr[firstCount];
                firstCount++;
            } else {
                targetArr[targetCount] = secondArr[secondCount];
                secondCount++;
                inversions += firstArr.length - firstCount;
            }
            targetCount++;
        }

        while (targetCount < targetArr.length && firstCount < firstArr.length) {
            targetArr[targetCount] = firstArr[firstCount];
            firstCount++;
            targetCount++;
        }

        while (targetCount < targetArr.length && secondCount < secondArr.length) {
            targetArr[targetCount] = secondArr[secondCount];
            secondCount++;
            targetCount++;
        }
        return inversions;

    }
}
