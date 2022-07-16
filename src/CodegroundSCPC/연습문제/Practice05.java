package CodegroundSCPC.연습문제;
/*
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Practice05 {
    static int Answer;

    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {

             Answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Answer %= 1000000007;
            bw.write("Case #"+(test_case+1));
            bw.newLine();
            bw.write(Integer.toString(Answer));
            bw.newLine();
            bw.flush();
        }
    }
}