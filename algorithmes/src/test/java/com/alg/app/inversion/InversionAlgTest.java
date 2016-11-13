package com.alg.app.inversion;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrewavetisov on 13.11.16.
 */
public class InversionAlgTest {

    @Test
    public void countInversionsSixTest() {
        InversionAlg inversionAlg = new InversionAlg();
        int[] arr = new int[]{4, 2, 3, 5, 1};
        int inversions = inversionAlg.countInversions(arr);
        assertEquals("6 inversions:", 6, inversions);
    }

    @Test
    public void countInversionsTwoTest() {
        InversionAlg inversionAlg = new InversionAlg();
        int[] arr = new int[]{2, 1, 4, 3, 5};
        int inversions = inversionAlg.countInversions(arr);
        assertEquals("2 inversions:", 2, inversions);
    }

    @Test
    public void countInversionsZeroTest() {
        InversionAlg inversionAlg = new InversionAlg();
        int[] arr = new int[]{1};
        int inversions = inversionAlg.countInversions(arr);
        assertEquals("0 inversions:", 0, inversions);
    }

    @Test
    public void countInversionsNullTest() {
        InversionAlg inversionAlg = new InversionAlg();
        int[] arr = null;
        int inversions = inversionAlg.countInversions(arr);
        assertEquals("without inversions:", 0, inversions);
    }
}
