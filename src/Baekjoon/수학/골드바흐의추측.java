package Baekjoon.수학;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 골드바흐의추측 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer st = new StringBuffer();
        Set<Integer> primes = new HashSet<>();
        List<Integer> primeList = new ArrayList<>();
        for (int i = 3; i < 1000000; i+=2) {
            boolean check = true;
            for (int j = 2; j < ((int)Math.sqrt(i))+1; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                primes.add(i);
                primeList.add(i);
            }
        }
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            } else {
                boolean check = true;
                for (int i = 0; i < primeList.size() / 2 + 1; i++) {
                    if (primes.contains(n - primeList.get(i))) {
                        check = false;
                        st.append(n).append(" = ").append(primeList.get(i)).append(" + ").append(n - primeList.get(i)).append("\n");
                        break;
                    }
                }
                if (check) {
                    st.append("Goldbach's conjecture is wrong.\n");
                }
            }
        }
        System.out.println(st);
    }
}
