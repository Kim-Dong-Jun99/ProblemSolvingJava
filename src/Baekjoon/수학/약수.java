package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 약수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] ns = new long[(int) n];
        for (int i = 0; i < n; i++) {
            ns[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(ns);
        if (n % 2 == 0) {
            System.out.println(ns[0] * ns[(int) n - 1]);
        } else {
            System.out.println(ns[(int) n / 2] * ns[(int) n / 2]);
        }

    }
}
