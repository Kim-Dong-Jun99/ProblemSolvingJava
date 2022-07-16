package CodegroundSCPC.연습문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Practice09 {


    static String Answer;
    static String[] chemStrings = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
            "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
            "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr",
            "Y","Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
            "Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au",
            "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg",
            "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La", "Ce", "Pr", "Nd",
            "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac",
            "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
            "No", "Lr"};
    static HashSet<String> chem = new HashSet<>();

    static String given;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : chemStrings) {
            chem.add(s.toLowerCase());
        }
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++){
            Answer = "NO";
            given = br.readLine();

            HashSet<Integer> visited = new HashSet<>();
            boolean end = false;
            HashSet<Integer> next = new HashSet<>();
            next.add(0);
            while (!next.isEmpty()){
                HashSet<Integer> temp = new HashSet<>();
                for (Integer i : next) {
                    visited.add(i);
                    if (i >= given.length()){
                        end = true;
                        break;
                    }
                    if (chem.contains(Character.toString(given.charAt(i))) && !visited.contains(i+1)){
                        temp.add(i+1);
                    }
                    if (i+2 <= given.length() && chem.contains(given.substring(i, i+2)) && !visited.contains(i+2)){
                        temp.add(i+2);
                    }
                }
                if (end){
                    Answer = "YES";
                    break;
                }
                next = temp;
            }


            bw.write("Case #"+(test_case+1));
            bw.newLine();
            bw.write(Answer);
            bw.newLine();
            bw.flush();
        }
    }

    
}
