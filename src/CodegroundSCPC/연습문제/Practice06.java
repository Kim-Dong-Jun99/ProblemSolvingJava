package CodegroundSCPC.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Practice06 {

    static long Answer;
    static int n,k;
    static int[] table;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            Answer = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            String path = br.readLine();
            table = new int[(n-1)*2+1];
            table[0] = 1;
            int index = 2;
            for (int i = 1; i < (n-1)*2+1; i++){
                table[i] = table[i-1] + index;
                if (i < n-1){
                    index += 1;
                }else{
                    index -= 1;
                }
            }
            int r = 0;
            int c = 0;
            for (int i = 0; i < k; i++){
                if (path.charAt(i) == 'U'){
                    r -= 1;
                }else if (path.charAt(i) == 'D'){
                    r += 1;
                }else if (path.charAt(i) == 'L'){
                    c -= 1;
                }else if (path.charAt(i) == 'R'){
                    c += 1;
                }
                Answer += score(r, c);
            }
            bw.write("Case #"+(test_case+1));
            bw.newLine();
            bw.write(Long.toString(Answer));
            bw.newLine();
            bw.flush();
        }
    }

   static int score(int r, int c){
        int temp = r+c;
        if (r == 0 && c == 0){
            return 1;
        }
        if (temp % 2 == 1){
            // 왼쪽 밑으로 간다, r
            if (temp < n){
                return table[temp-1] + 1 + r;
            }else{
                return table[temp-1] + 1 + Math.abs(n-1-c);
            }


        }else{
            // 우상향, c
           if (temp < n){
               return table[temp-1] + 1 + c;
           }else{
               return table[temp-1] + 1 + Math.abs(n-1-r);
           }
        }
   }


}
