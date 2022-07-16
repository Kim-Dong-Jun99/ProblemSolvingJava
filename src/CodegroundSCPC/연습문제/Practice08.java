package CodegroundSCPC.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Practice08 {
    static long Answer;
    static int time;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            Answer = 0;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] blocks = new int[n];
            int[] count = new int[n];
            for (int i = 0; i < n; i++){
                blocks[i] = Integer.parseInt(st.nextToken());
                if (i >= n/ 2){
                    time = n - i;
                }else{
                    time = i + 1;
                }
                count[i] = min(time, blocks[i]);
                if (i != 0){
                    if (count[i] > count[i-1] + 1){
                        count[i] = count[i-1]+1;
                    }else if (count[i] + 1 < count[i-1]){
                        for (int j = i-1; j > 0; j--){
                            if (count[j] > count[j+1] +1){
                                count[j] = count[j+1]  + 1;
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
            Answer = Arrays.stream(count).max().getAsInt();

            // 0 1 2, 0 1 2 3
            // 1 2 1, 1 2 2 1
            // 0 1 2 3 4, 0 1 2 3 4 5 , n = 6
            // 1 2 3 2 1, 1 2 3 3 2 1
            // 하나하나 돌면서 brute force로 다하는건 오바고
            // 관계를 잘 파악해야할듯하다, 어차피 n/2번이면 모두 다 사라지고, 무조건적으로 사라지게 되는 시간도 존재함
            // 그 시간이랑 주변 관계가 중요할듯??
            // 골짜기 V 를 찾는게 중요해 보인댜,
            bw.write("Case #"+(test_case+1));
            bw.newLine();
            bw.write(Long.toString(Answer));
            bw.newLine();
            bw.flush();
        }

    }
}
