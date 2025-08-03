package stu_20250706;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_139 {
    public static void main(String[] args) {
        String[] word = new String[]{"leet", "code"};
        List<String> s = new ArrayList<>(List.of(word));
//        System.out.println(sol_139("leetcode", s));
//        word = new String[]{"aaaa","aa"};
//        s = new ArrayList<>(List.of(word));
//        System.out.println(sol_139("aaaaaaa", s));
        word = new String[]{"aaaa","aaa"};
        s = new ArrayList<>(List.of(word));
        System.out.println(sol_139("aaaaaaa", s));

    }

    private static boolean sol_139(String s, List<String> wordDict) {

        Trie td = new Trie();

        for (int i = 0; i < wordDict.size(); i++) {
            td.insert(wordDict.get(i));
        }
        Boolean[] memo = new Boolean[s.length()];
        return dfs_139(s, 0, td.root, td, memo);
    }

    private static boolean dfs_139(String s, int start, Trie_139_Node root, Trie trie, Boolean[] memo) {
        if (start == s.length()) return true;  // 끝까지 가면 사용가능
        if (memo[start] != null) return memo[start];
        Trie_139_Node node = root;

        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.child.containsKey(c)) break;

            node = node.child.get(c);
            if (node.endWord && dfs_139(s, i + 1, root, trie, memo)) {
                return memo[start] = true;
            }

        }
        return memo[start] = false;  //
    }
}

class Trie_139_Node {

    HashMap<Character, Trie_139_Node> child;
    boolean endWord;

    public Trie_139_Node() {
        this.child = new HashMap<>();
        this.endWord = false;
    }
}

class Trie {
    Trie_139_Node root;

    public Trie() {
        this.root = new Trie_139_Node();
    }

    public void insert(String str) {
        Trie_139_Node node = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            node.child.putIfAbsent(c, new Trie_139_Node());
            node = node.child.get(c);
        }
        node.endWord = true;
    }
}