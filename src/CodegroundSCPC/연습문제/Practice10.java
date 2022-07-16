package CodegroundSCPC.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;
/*
2
3 4 2
2 2
2 3
100 100 3
15 16
16 15
99 88
 */

public class Practice10 {

    static int n, m;

//    static long[][] cb;
    static Map<Integer, HashSet<Integer>> cb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            // n행 m열
            cb = new HashMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                if (1 <= r && r <= n) {
                    if (1 <= c && c <= m) {
                        if (!cb.containsKey(r-1)){
                            HashSet<Integer> temp = new HashSet<Integer>();
                            temp.add(c - 1);
                            cb.put(r - 1, temp);
                        }else{
                            cb.get(r - 1).add(c - 1);
                        }

                    }
                }
            }
            BigInteger[] dfs = new BigInteger[m];
            BigInteger compare = new BigInteger("1000000007");

            for (int j = 0; j < m; j++){
                if (j == 0) {
                    dfs[j] = new BigInteger("1");
                }else {
                    dfs[j] = new BigInteger("0");
                }
            }
            for (int i = 0; i < n; i++) {
//                BigInteger[] temp = new BigInteger[m];
                for (int j = 0; j < m; j++) {
                    if (i != 0 && cb.containsKey(i-1) && cb.get(i-1).contains(j)) {
                        dfs[j] = dfs[j].subtract(dfs[j]);
                    }
                    if (j != 0 && (!cb.containsKey(i) || !cb.get(i).contains(j-1))) {
                        dfs[j] = dfs[j].add(dfs[j - 1]);
                    }
                    if (dfs[j].compareTo(compare) > 0){
                        dfs[j] = dfs[j].remainder(compare);
                    }
                    System.out.print(dfs[j]+ " ");
                }
                System.out.println();
//                dfs = temp;
            }

            bw.write("Case #"+(test_case + 1));
            bw.newLine();
            bw.write(String.valueOf(dfs[m - 1].remainder(BigInteger.valueOf(1000000007))));
            bw.newLine();
            bw.flush();

        }
    }


}
