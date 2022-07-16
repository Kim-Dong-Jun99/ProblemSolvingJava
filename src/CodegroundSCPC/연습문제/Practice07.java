package CodegroundSCPC.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Practice07 {
    static long Answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            Answer = 0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashSet<Integer> couple = new HashSet<>();
            HashSet<Integer> single = new HashSet<>();
            for (int i = 0; i  < n;i ++){
                int temp = Integer.parseInt(st.nextToken());
                for (Integer integer : single) {
                    if (couple.contains(temp-integer)){
                        Answer += 1;
                        break;
                    }
                }
                single.add(temp);
                for (Integer integer : single) {
                    couple.add(integer+temp);
                }
            }

            bw.write("Case #"+(test_case+1));
            bw.newLine();
            bw.write(Long.toString(Answer));
            bw.newLine();
            bw.flush();
        }

    }
}
