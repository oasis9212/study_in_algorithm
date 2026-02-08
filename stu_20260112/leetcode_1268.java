package stu_20260112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_1268 {
    public static void main(String[] args) {
        System.out.println(sol_1268(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
    }

    private static List<List<String>> sol_1268(String[] products, String searchWord) {

        List<List<String>> list = new ArrayList<>();
        Trie td = new Trie();
        for (String s : products) {
            td.insert(s);
        }
        Trie_1268_Node tn = td.root;
        String prefix = "";
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            prefix+=c;
            if(tn!=null){
                tn = tn.child[c -'a'];
            }
            List<String> l = new ArrayList<>();
            if (tn != null) {
                dfs(tn, prefix, l);
            }
            list.add(l);
        }
        return list;
    }

    private static void dfs(
            Trie_1268_Node node,
            String prefix,
            List<String> result
    ) {
        if (result.size() == 3) return;

        if (node.isEnd) {
            result.add(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                dfs(node.child[i], prefix + (char) ('a' + i), result);
            }
            if (result.size() == 3) return;
        }
    }
}

class Trie_1268_Node {

    Trie_1268_Node[] child = new Trie_1268_Node[26];
    boolean isEnd;
}

class Trie {
    Trie_1268_Node root;

    public Trie() {
        this.root = new Trie_1268_Node();
    }

    public void insert(String word) {
        Trie_1268_Node n = this.root;

        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (n.child[c] == null) {
                n.child[c] = new Trie_1268_Node();
            }
            n = n.child[c];
        }
        n.isEnd = true;
    }
}
