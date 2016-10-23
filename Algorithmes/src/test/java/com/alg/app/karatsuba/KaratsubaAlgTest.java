package com.alg.app.karatsuba;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;


/**
 * Created by andrewavetisov on 23.10.16.
 */
public class KaratsubaAlgTest {



    @Test
    public void multiplyTest() throws Exception {
        KaratsubaAlg alg = new KaratsubaAlg();
        String result = alg.multiply("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627");
        BigDecimal x = new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592");
        BigDecimal y = new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627");
        BigDecimal z = x.multiply(y);
        Assert.assertEquals("check multiplication:", z.toString(), result);
    }

    @Test
    public void sumBigDecimalTest() {
        KaratsubaAlg alg = new KaratsubaAlg();
        BigDecimal x = new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592");
        BigDecimal y = new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627");
        BigDecimal z = x.add(y);
        String result = alg.sum("3141592653589793238462643383279502884197169399375105820974944592", "2718281828459045235360287471352662497757247093699959574966967627");

        Assert.assertEquals("check sum:", z.toString(), result);
    }

    @Test
    public void sumTest() {
        KaratsubaAlg alg = new KaratsubaAlg();
        String result = alg.sum("99999", "99");
        int expectedSum = 99999 + 99;

        Assert.assertEquals("check sum:", String.valueOf(expectedSum), result);
    }

}