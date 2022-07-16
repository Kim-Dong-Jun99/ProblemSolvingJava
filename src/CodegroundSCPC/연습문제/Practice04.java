package CodegroundSCPC.연습문제;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice04 {
    static int Answer;
    static int[] score = {6,13,13,4,4,18,18,1,1,20,20,5,5,12,12,9,9,14,14,11,11,8,8,16,16,7,7,19,19,3,3,17,17,2,2,15,15,10,10,6};
    public static void main(String args[]) throws Exception	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int bull = Integer.parseInt(st.nextToken());
            int triple_s = Integer.parseInt(st.nextToken());
            int triple_e = Integer.parseInt(st.nextToken());
            int double_s = Integer.parseInt(st.nextToken());
            int double_e = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++){
                StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());

                double temp = calcDis(x,y);
                double angle = getAngle(x,y);
                int tempScore = getScore(angle);
                if (temp < double_e){
                    if (temp < bull){
                        Answer += 50;
                    }else{
                        if (triple_s < temp && temp < triple_e){
                            Answer += tempScore*3;
                        }else if(double_s < temp && temp < double_e){
                            Answer += tempScore*2;
                        }else{
                            Answer += tempScore;
                        }
                    }
                }


            }
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }


    public static double calcDis(int x, int y){
        return Math.sqrt(x*x + y*y);
    }

    public static double getAngle(int x, int y) {
        double dy = y;
        double dx = x;
        double angle = Math.atan(dy/dx) * (180.0/Math.PI);
        if(dx < 0.0) {
            angle += 180.0;
        } else {
            if(dy<0.0) angle += 360.0;
        }
        return angle;
    }

    public static int getScore(double angle){
        double temp = angle / 9;
        return score[(int) temp];
    }

}
