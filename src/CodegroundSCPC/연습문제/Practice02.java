package CodegroundSCPC.연습문제;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Practice02 {
    static int Answer;
    static int TempMax;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int test_case = 0; test_case < T; test_case++) {
            TempMax = 0;
            Answer = 0;
            int n = sc.nextInt();
            HashMap<Integer,Integer> nums = new HashMap<>();
            ArrayList<Integer> numlist = new ArrayList<>();
            for (int i = 0; i<n;i ++){
                int temp = sc.nextInt();
                if (nums.containsKey(temp)){
                    nums.put(temp, nums.get(temp) + 1);
                }else {
                    nums.put(temp, 1);
                    numlist.add(temp);
                }

            }
            numlist.sort(Comparator.reverseOrder());
            int addV = 0;
            for (Integer integer : numlist) {
                addV += nums.get(integer);
                if (integer + addV > TempMax) {
                    TempMax = integer + addV;
                }
            }

            for (Integer integer : numlist) {
                if (integer + n >= TempMax){
                    Answer += nums.get(integer);
                }
            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }

}

