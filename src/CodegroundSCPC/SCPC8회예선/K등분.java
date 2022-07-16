package CodegroundSCPC.SCPC8회예선;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class K등분 {
    static BigInteger Answer;
    static BigInteger[] dp;
    static int end;
    static int[] numbers;

    static Map<BigInteger[], BigInteger> table;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Answer = BigInteger.ZERO;
            int N = Integer.parseInt(st.nextToken());
            end = N;
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            numbers = new int[N];

            dp = new BigInteger[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    dp[i] = BigInteger.valueOf(numbers[i]);
                }else{
                    dp[i] = BigInteger.valueOf(numbers[i]).add(dp[i - 1]);
                }
            }
            int max = N - K + 1;
            int min = 1;
            // 한 등분의 최댓값에 대한 min, max 설정 해놓음,
            for (int i = min; i <= max; i++) {
                BigInteger target = dp[i - 1]; // 다 같아져야하는 sum 값, i-1로 해야 처음부터 i개의 합을 구할 수 있다,
                table = new HashMap<>();
                Answer = Answer.add(backTrack(i,K - 1, target));
            }



            bw.write("Case #" + (test_case + 1));
            bw.newLine();
            bw.write(String.valueOf(Answer.remainder(BigInteger.valueOf(1000000007))));
            bw.newLine();
            bw.flush();
        }
    }

    static BigInteger backTrack(int start, int K, BigInteger target) {
        if (K == 0 && start == end){
            return BigInteger.ONE;
        } else if (K == 0) {
            return BigInteger.ZERO;
        }
        if (K == 1) {
            if (dp[end - 1].subtract(dp[start - 1]).equals(target)) {
                return BigInteger.ONE;
            } else {
                return BigInteger.ZERO;
            }
        }
        int max = (end - start) - K + 1;
        BigInteger result = BigInteger.ZERO;
        for (int i = start; i < start + max; i++) {
            if (dp[i].subtract(dp[start - 1]).equals(target)) {
                BigInteger[] tempCon = {BigInteger.valueOf(i + 1), BigInteger.valueOf(K - 1), target};
                if (!table.containsKey(tempCon)) {
                    BigInteger tempResult = backTrack(i + 1, K - 1, target);
                    table.put(tempCon, tempResult);
                }
                result = result.add(table.get(tempCon));
            }
        }
        if (result.compareTo(BigInteger.valueOf(1000000007)) > 0) {
            result = result.remainder(BigInteger.valueOf(1000000007));
        }
        return result;
    }


}
