package Baekjoon.수학;

import java.util.Scanner;

public class 약수의합2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = 0;
        for (int i = 1; i <= n; i++) {

            result += i*(n/i);

        }
        System.out.println(result);

    }
}
