package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와최소공배수 {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = 0;
        int lcm = 0;
        for (int i = Math.min(a, b); i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                System.out.println(gcd);
                break;
            }
        }
        a /= gcd;
        b /= gcd;

        if (Math.max(a, b) % Math.min(a, b) == 0){
            System.out.println(gcd * Math.max(a, b));
        }else{
            System.out.println(gcd * a * b);
        }
    }
}
