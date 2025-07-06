package stu_20250614;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1233 {
    public static void main(String[] args) {
        System.out.println(sol_1233(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
        System.out.println(sol_1233(new String[]{"/a/b/c","/a/b/ca","/a/b/d"}));
    }

    private static List<String> sol_1233(String[] folder) {

        Arrays.sort(folder);//어쩌피 폴더명의 길이 와 알파벳이 우선 순위로 오면 순차적으로 정렬한다.

        String file=folder[0];
        List<String> list = new ArrayList<>();
        list.add(file);

        for (int i = 1; i < folder.length; i++) {
            if(folder[i].indexOf(file + "/")!=0){
                list.add(folder[i]);
                file=folder[i];
            }
        }
        // trie 구조

        return list;
     }
}
