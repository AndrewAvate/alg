package com.alg.app.karatsuba;

/**
 * Created by andrewavetisov on 22.10.16.
 */
public class KaratsubaAlg {
    //3141592653589793238462643383279502884197169399375105820974944592

    //2718281828459045235360287471352662497757247093699959574966967627

    /**
     * multiplication of two numbers
     *
     * @param x
     * @param y
     * @return multiplication result
     */
    public String multiply(String x, String y) {
        String result = "";
        int xLength = x.length();
        int yLength = y.length();

        if (xLength <= 2 && yLength <= 2) {
            int i = Integer.valueOf(x) * Integer.valueOf(y);
            return String.valueOf(i);
        }

        String a = x.substring(0, xLength / 2);
        String b = x.substring(xLength / 2, xLength);

        String c = y.substring(0, yLength / 2);
        String d = y.substring(yLength / 2, yLength);

        String s1 = multiply(a, c);
        String s2 = multiply(b, d);

        String ad = multiply(a, d);
        String bc = multiply(b, c);

        String s3 = sum(ad, bc);


        result = sum(s1 + getZeroPadding(xLength), s3 + getZeroPadding(xLength / 2));
        result = sum(result, s2);

        //s1 = ac; // step 1
        //s2 = bd; // step 2
        //s3 = ad + bc; //step 3
        //X * Y = 10^n * s1 + 10^(n/2) * s3 + s2;


        return result;
    }

    public String sum(String x, String y) {
        String result = "";

        String longNumber = getLongerNumber(x, y);
        String shortNumber = getShorterNumber(x, y);
        int temp = 0;

        for (int i = longNumber.length(); i > 0; i--) {
            int x1 = Integer.valueOf(longNumber.substring(i - 1, i));
            int x2 = Integer.valueOf(shortNumber.substring(i - 1, i));
            int x3 = x1 + x2 + temp;

            if (x3 > 9) {
                x3 = x3 - 10;
                temp = 1;
            } else {
                temp = 0;
            }

            result = x3 + result;
        }
        if (temp > 0) {
            result = temp + result;
        }


        return result;
    }

    private String getZeroPadding(int length) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            res.append("0");
        }
        return res.toString();
    }


    private String getLongerNumber(String x, String y) {
        return x.length() >= y.length() ? x : y;
    }

    private String getShorterNumber(String x, String y) {
        String shorterNumber = x.length() < y.length() ? x : y;
        String longerNumber = getLongerNumber(x, y);

        while (shorterNumber.length() < longerNumber.length()) {
            shorterNumber = "0" + shorterNumber;
        }
        return shorterNumber;
    }
}
