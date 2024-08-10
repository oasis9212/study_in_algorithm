package stu_20240804;

import java.util.ArrayList;
import java.util.List;

public class Without_Adjacent_Zeros {


    public static void main(String[] args) {
        int n= 3;
        List<String> result = new ArrayList<>();
        makeBinary(n, new StringBuilder("0"), 0,result);
        makeBinary(n, new StringBuilder("1"), 0,result);

        System.out.println(result.toString());

    }

    private static void makeBinary(int n, StringBuilder binary, int loc,List<String> result) {
        if (binary.length() == n) {
            result.add(binary.toString());
            return;
        }

        if (binary.charAt(loc) != '0') {
            StringBuilder bir = new StringBuilder();
            bir.append(binary).append('0');
            makeBinary(n, bir, ++loc,result);
            --loc;
        }
        StringBuilder bir = new StringBuilder();
        bir.append(binary).append('1');
        makeBinary(n, bir, ++loc,result);
    }



}
