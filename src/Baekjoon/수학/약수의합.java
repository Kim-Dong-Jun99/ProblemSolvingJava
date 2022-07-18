package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 약수의합{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            long result = 0;
            for (int i = 1; i <= N; i++) {

                result += i*(N/i);

            }

            bw.write(String.valueOf(result));
            bw.newLine();
            bw.flush();


        }
        
    }
}
