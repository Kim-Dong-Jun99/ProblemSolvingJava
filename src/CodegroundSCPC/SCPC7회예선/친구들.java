package CodegroundSCPC.SCPC7회예선;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 친구들 {
    static long Answer;
    static int[] friends;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;

            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            friends = new int[N];
            int[] relation = new int[N];
            for (int i = 0; i < N; i++) {
                friends[i] = i;
                relation[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                if (i + relation[i] < N) {
                    union(i, i + relation[i]);
                }
            }
            HashSet<Integer> temp = new HashSet<>();
            for (int f : friends) {
                temp.add(find(f));
            }
            bw.write("Case #" + (test_case + 1));
            bw.newLine();
            bw.write(String.valueOf(temp.size()));
            bw.newLine();
            bw.flush();
        }
    }


    static void union(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (x != y) {
            friends[x] = y;

        }
    }

    static int find(int i) {
        if (friends[i] == i) {
            return i;
        }
        friends[i] = find(friends[i]);
        return friends[i];
    }


}
