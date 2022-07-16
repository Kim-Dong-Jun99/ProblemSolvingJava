package CodegroundSCPC.연습문제;

import java.util.HashMap;
import java.util.Scanner;

public class Practice01 {

    static int Answer;
    static int n;
    // 숫자 골라내기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {

             Answer = 0;
             n = sc.nextInt();
            HashMap<Integer, Integer> s = new HashMap<>();
            for (int i = 0; i < n; i++){
                Integer temp = sc.nextInt();
                if (s.containsKey(temp)){
                    s.put(temp, s.get(temp)+1);
                }else{
                    s.put(temp,1);
                }
            }
            for (Integer integer : s.keySet()) {
                if (s.get(integer) % 2 == 1){
                    Answer = Answer ^ integer;
                }
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
