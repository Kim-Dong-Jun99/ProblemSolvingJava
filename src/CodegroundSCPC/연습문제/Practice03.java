package CodegroundSCPC.연습문제;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Practice03 {
    static int Answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test_case = 0; test_case < T; test_case++){
            Answer = 0;
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++){
                nums.add(sc.nextInt());
            }

            nums.sort(Comparator.reverseOrder());
            int i = 0;
            for (Integer num : nums) {
                if (i < k){
                    Answer += num;
                    i += 1;
                }else{
                    break;
                }

            }

            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
