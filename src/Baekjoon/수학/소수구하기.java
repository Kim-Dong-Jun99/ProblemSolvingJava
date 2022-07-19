package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer st = new StringBuffer();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = m; i <= n; i++) {
            if (i > 1){
                boolean check = true;
                for (int j = 2; j < ((int)Math.sqrt(i))+1; j++) {
                    if (i % j == 0) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    st.append(i).append("\n");
                }
            }
        }
        System.out.println(st);
    }
}
