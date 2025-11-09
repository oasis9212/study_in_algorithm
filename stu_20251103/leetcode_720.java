package stu_20251103;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class leetcode_720 {
    public static void main(String[] args) {
        System.out.println(sol_720(new String[]{"a","banana","app","appl","ap","apply","apple"}));

    }

    private static String sol_720(String[] words) {

        Trie_720 tr=new Trie_720();
        for (int i = 0; i < words.length; i++) {
            tr.insert(words[i]);
        }
        return findLongestWord(tr.root);
    }

    private static String findLongestWord(Trie_720_Node root) {
        StringBuilder sb = new StringBuilder();
        return dfs(root, sb);
    }

    private static String dfs(Trie_720_Node node, StringBuilder sb) {
        String best = sb.toString();

        List<Character> keys = new ArrayList<>(node.child.keySet());
        Collections.sort(keys);
        for (char c : keys) {
            Trie_720_Node next = node.child.get(c);
            // 다음 노드가 단어의 끝인 경우만 계속 진행
            if (next.isConnect) {
                sb.append(c);
                String candidate = dfs(next, sb);
                sb.deleteCharAt(sb.length() - 1);
                if (candidate.length() > best.length() ||
                        (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                    best = candidate;
                }
            }
        }
        return best;
    }

}

class Trie_720_Node {

    HashMap<Character,Trie_720_Node> child;
    boolean isConnect;

    public Trie_720_Node() {
        this.child = new HashMap<>();
        this.isConnect = false;
    }
}


class Trie_720{
    Trie_720_Node root;

    public Trie_720() {
        this.root = new Trie_720_Node();
    }

    public void insert(String str){
        Trie_720_Node node = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c= str.charAt(i);
            node.child.putIfAbsent(c,new Trie_720_Node());
            node=node.child.get(c);
        }
        node.isConnect=true;
    }
}