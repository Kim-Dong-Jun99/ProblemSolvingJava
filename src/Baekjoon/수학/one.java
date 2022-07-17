package Baekjoon.수학;

import java.math.BigInteger;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            BigInteger n = BigInteger.valueOf(scanner.nextInt());
            BigInteger result = BigInteger.ONE;
            while (!result.remainder(n).equals(BigInteger.ZERO)) {
                result = result.multiply(BigInteger.TEN).add(BigInteger.ONE);
            }
            System.out.println(String.valueOf(result).length());
        }
    }
}
