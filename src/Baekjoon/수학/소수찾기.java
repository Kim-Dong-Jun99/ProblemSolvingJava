package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 소수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer st = new StringBuffer();

        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, false);
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 1001; i++) {
            boolean temp = true;
            for (Integer prime : primes) {
                if (i % prime == 0) {
                    temp = false;
                    break;
                }
                if (prime > 2 * i) {
                    break;
                }
            }
            if (temp) {
                primes.add(i);
                isPrime[i] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(tokens.nextToken());
            if (isPrime[temp]) {
                result += 1;
            }
        }
        System.out.println(result);

    }

}
