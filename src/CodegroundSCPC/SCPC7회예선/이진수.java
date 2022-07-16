package CodegroundSCPC.SCPC7회예선;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/*
2
5 1
00111
10 2
1111111000
 */

public class 이진수 {

    static int n,t;
    static String b;

    static char[] Answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            b = br.readLine();
            List<Integer> possible;
            Answer = new char[n];
            for (int i = 0; i < n; i++) {
                possible = possible(i);
                if (possible.isEmpty()) {
                    Answer[i] = '0';
                }else {
                    int result = numOnes(possible);
                    if (result == 0) {
                        Answer[i] = '0';
                    } else if (result == 1) {
                        if (i - t < 0 ) {
                            if (i + 3 * t < n && b.charAt(i + 3 * t) == '1') {
                                Answer[i] = '0';
                            } else {
                                Answer[i] = '1';
                            }
                        } else if (i + t >= n) {
                            if (i - 3 * t >= 0 && b.charAt(i - 3 * t) == '1' && Answer[i - 2 * t] == '1') {
                                Answer[i] = '0';
                            } else {
                                Answer[i] = '1';
                            }
                        } else {
                            Answer[i] = '0';
                        }
                    }else{
                        if (canBeZero(i)) {
                            Answer[i] = '0';
                        } else {
                            Answer[i] = '1';
                        }
                    }
                }
            }

            bw.write("Case #" + (test_case + 1));
            bw.newLine();
            bw.write(Answer);
            bw.newLine();
            bw.flush();
        }
    }

    static List<Integer> possible(int i) {
        List<Integer> result = new ArrayList<>();
        if (i - t >= 0) {
            result.add(i - t);
        }
        if (i + t < n) {
            result.add(i + t);
        }
        return result;
    }

    static int numOnes(List<Integer> temp) {
        int result = 0;
        for (Integer integer : temp) {
            if (b.charAt(integer) == '1') {
                result += 1;
            }
        }
        return result;
    }

    static boolean canBeZero(int i) {
        if (i - 2 * t >= 0 && Answer[i - 2 * t] == '1') {
            if (i + 2 * t < n) {
                if (numOnes(possible(i + 2 * t)) == 2) {
                    return true;
                } else {
                    return i + 3 * t >= n && numOnes(possible(i + 2 * t)) == 1;
                }
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

}
