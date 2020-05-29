package Alg.Home_6;

import java.math.BigInteger;
import java.util.Arrays;

public class Task_4 {
    public static void main(String[] args) {
        System.out.println("It compiles senpai!");
        System.out.println("##############################\n");
        System.out.println(getBinLength(1));
        System.out.println(getBinLength(7));
        System.out.println(getBinLength(16));
        BigInteger num1 = BigInteger.valueOf(123456789);
        BigInteger num2 = BigInteger.valueOf(100000000);
        System.out.println(karatsuba(num1, num2));
    }

    private static BigInteger karatsuba(BigInteger i, BigInteger j) {
        boolean[] x = convertToBoolArr(i);
        boolean[] y = convertToBoolArr(j);

        double n = Math.max(x.length,y.length);

        if (n < 32) return i.multiply(j);

        boolean[] a = divBoolArr(x, (int) Math.pow(2, Math.round(n/2)));
        boolean[] b =  modBoolArr(x, (int) Math.pow(2, Math.round(n/2)));
        boolean[] c = divBoolArr(y, (int) Math.pow(2, Math.round(n/2)));
        boolean[] d =  modBoolArr(y, (int) Math.pow(2, Math.round(n/2)));

        BigInteger first = karatsuba(convertToBigInt(a), convertToBigInt(c));
        BigInteger second = karatsuba(convertToBigInt(b), convertToBigInt(d));
        BigInteger third = karatsuba(convertToBigInt(sumBoolArr(a,b)),convertToBigInt(sumBoolArr(c,d)));

        return  first.multiply(BigInteger.valueOf((int) Math.pow(2, Math.round(n))) ).add((third.subtract(second).subtract(first))
                .multiply(BigInteger.valueOf((int)Math.pow(2, Math.round(n/2))))).add(second);
    }

    public static int getBinLength(int num) {
        return Integer.toBinaryString(num).length();
    }


    public static boolean[] divBoolArr(boolean[] bool, int num) {
        return Arrays.copyOfRange(bool, 0, bool.length - getBinLength(num) + 1);
    }

    public static boolean[] modBoolArr(boolean[] bool, int num) {
        return Arrays.copyOfRange(bool, bool.length - getBinLength(num) + 1, bool.length);
    }


    public static boolean[] sumBoolArr(boolean[] boolOne, boolean[] boolTwo) {
        BigInteger num1 = convertToBigInt(boolOne);
        BigInteger num2 = convertToBigInt(boolTwo);
        BigInteger result = num1.add(num2);
        return convertToBoolArr(result);
    }


    public static BigInteger convertToBigInt(boolean[] bool) {
        StringBuilder binStr = new StringBuilder();
        for (int i = 0; i < bool.length; i++) {
            if (bool[i]) {
                binStr.append('1');
            }
            else{
                binStr.append('0');
            }
        }
        return new BigInteger(binStr.toString(), 2);
    }

    private static boolean[] convertToBoolArr(BigInteger num) {
        char[] binArr = num.toString(2).toCharArray();
        boolean[] result = new boolean[binArr.length];
        for (int i = 0; i < binArr.length; i++) {
            if (binArr[i] == '1'){
                result[i] = true;
            }
            else {
                result[i] = false;
            }
        }
        return result;
    }
}
