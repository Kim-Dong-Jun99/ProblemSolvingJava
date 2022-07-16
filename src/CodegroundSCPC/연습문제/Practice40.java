package CodegroundSCPC.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Practice40 {
    static long Answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> dishes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int m = Integer.parseInt(st.nextToken());
                int[] temp = new int[m];
                for (int j = 0; j < m; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                dishes.add(temp);
            }


            bw.write("Case #" + (test_case + 1));
            bw.newLine();
            bw.write(Long.toString(Answer));
            bw.newLine();
            bw.flush();
        }
    }

}
