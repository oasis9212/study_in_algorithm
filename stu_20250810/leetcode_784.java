package stu_20250810;

import java.util.*;

public class leetcode_784 {
    public static void main(String[] args) {
      //  System.out.println(sol_784("a1b2"));
        System.out.println(sol_784("C"));
    }

    private static List<String> sol_784(String s) {

        List<String> str = new ArrayList<>();

        Trie t = new Trie();
        t.insert(s);
        //trie???
        Queue<Trie_Node> tq= new LinkedList<>();

        tq.add(t.root);

        while (!tq.isEmpty()){
            Trie_Node x= tq.poll();
            if(x.child.isEmpty()){
               str.add(x.sb);
            }
            for (char q:x.child.keySet()){
               tq.add(x.child.get(q));
            }
        }
        return str;

    }
}

class Trie_Node {

    HashMap<Character, Trie_Node> child;
    String sb = "";

    public Trie_Node() {
        this.child = new HashMap<>();

    }
}

class Trie {
    Trie_Node root;

    public Trie() {
        this.root = new Trie_Node();
    }

    public void insert(String str) {
        Trie_Node n = this.root;
        char upperval = 'a' - 'A';
        Queue<Trie_Node> list = new LinkedList<>();
        list.add(n);
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            c = (c >='A' && c<='Z') ? (char) (c + upperval) : c;

            int listsize = list.size();
            for (int j = 0; j < listsize; j++) {
                Trie_Node l = list.poll();
                if (c >= 'a' && c <= 'z') {
                    l.child.put((char) (c - upperval), new Trie_Node());
                    l.child.put(c, new Trie_Node());
                    list.add(l.child.get((char) (c - upperval)));
                    list.add(l.child.get(c));
                    l.child.get((char) (c - upperval)).sb = l.sb + (char) (c - upperval);
                    l.child.get((char) (c)).sb = l.sb + (char) c;
                } else {
                    l.child.put(c, new Trie_Node());
                    list.add(l.child.get(c));
                    l.child.get(c).sb = l.sb + (char) c;

                }
            }
        }
    }
}