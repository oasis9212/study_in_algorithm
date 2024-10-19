package stu_20241014;

import java.util.ArrayList;
import java.util.List;

public class programmers_17677 {
    public static void main(String[] args) {
        String str1 = "";
        String str2 = "french";
        List<String> str1zip = makelist(str1);
        List<String> str2zip = makelist(str2);

        int N = intersection(str1zip, str2zip);// 교집합을 뜻함.
        int U = str1zip.size() + str2zip.size()-N;// 합집합
        int answer=0;
        if(N!=0){
            answer = N * 65536 / U;
        }else if(U==0){
            answer=65536;
        }
        System.out.println(answer);


    }

    private static int intersection(List<String> str1zip, List<String> str2zip) {
        int N = 0;
        List<String> aa= new ArrayList<>(str1zip);
        List<String> bb= new ArrayList<>(str2zip);
        while (!aa.isEmpty()) {
            String str1val = aa.remove(0);
            if (bb.contains(str1val)) {
                bb.remove(str1val);
                N++;
            }
        }
        return N;

    }

    private static List<String> makelist(String str1) {
        List<String> an = new ArrayList<>();
        for (int i = 1; i < str1.length(); i++) {
            char str1a = str1.charAt(i - 1);
            char str1b = str1.charAt(i);
            if (str1a >= 97 && str1a <= 122) {
                str1a -= 32;
            } else if (str1a < 65 || str1a > 90) {
                continue;
            }
            if (str1b >= 97 && str1b <= 122) {
                str1b -= 32;
            } else if (str1b < 65 || str1b > 90) {
                continue;
            }

            String change = (char) str1a + "" + (char) str1b;
            an.add(change);
        }
        return an;
    }
}
