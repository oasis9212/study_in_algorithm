package stu_20251006;

import java.util.*;

public class 단어변환 {
    public static void main(String[] args) {
        System.out.println(sol_단어변환("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }

    private static int sol_단어변환(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        Queue<wordNode> qu= new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        qu.add(new wordNode(begin,0));

        while (!qu.isEmpty()){
            wordNode n= qu.poll();

            if(n.word.equals(target)){
                return n.dep;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(n.word, words[i])) {
                    visited[i] = true;
                    qu.add(new wordNode(words[i], n.dep + 1));
                }
            }

        }
        return 0;
    }

    private static boolean canConvert (String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

}

class wordNode{
    String word;
    int dep;

    public wordNode(String word, int dep) {
        this.word = word;
        this.dep = dep;
    }
}