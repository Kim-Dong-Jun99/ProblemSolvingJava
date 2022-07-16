package CodegroundSCPC.SCPC8회예선;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 개미 {

    static long Answer;

    static Map<Integer, List<Integer>> table;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> keyList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] p = new int[N];
            Answer = 0;
            table = new HashMap<>();
            for (int i = 0; i < N; i++) {
                p[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int[] v = new int[N];
            for (int i = 0; i < N; i++) {
                v[i] = Integer.parseInt(st.nextToken());
                if (table.containsKey(v[i])) {
                    table.get(v[i]).add(p[i]);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    keyList.add(v[i]);
                    temp.add(p[i]);
                    table.put(v[i], temp);
                }
            }

            Collections.sort(keyList);
            int index = 0;
            int subindex = 0;
            for (int i = 0; i < N; i++) {
                int smallestPosition = table.get(keyList.get(index)).get(subindex);
                Answer += Math.abs(smallestPosition - p[i]);
                subindex += 1;
                if (table.get(keyList.get(index)).size() == subindex) {
                    index += 1;
                    subindex = 0;
                }
            }


            bw.write("Case #" + (test_case + 1));
            bw.newLine();
            bw.write(String.valueOf(Answer));
            bw.newLine();
            bw.flush();


        }
    }
}
