package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 약수의합{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        long[] fx = new long[1000001];
        long[] dp = new long[1000001];

        Arrays.fill(fx, 1);

        for(int i=2; i<fx.length; i++) {			
            for(int j=1; i*j<fx.length; j++) {				
                fx[i*j] += i;			
            }
        }

        for(int i=1; i<dp.length; i++) {			
            dp[i] += dp[i-1] + fx[i];		
        }

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case  < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }


   

}
