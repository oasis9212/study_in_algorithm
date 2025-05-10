package stu_20250506;


import java.util.Stack;

public class 표편집 {


    public static void main(String[] args) {

        System.out.println(표편집_sol(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));

    }

    private static String 표편집_sol(int n, int k, String[] cmd) {
        Stack<Node> deleteed = new Stack<>();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();

            if (i == 0) {
                continue;
            }

            nodes[i - 1].next = nodes[i];
            nodes[i].prev = nodes[i - 1];
        }

        Node cur = nodes[k];
        for (String command : cmd) {
            char operation = command.charAt(0);

            switch (operation) {
                case 'U':
                    int move = Integer.parseInt(command.split(" ")[1]);
                    cur = cur.movePrev(move);
                    break;
                case 'D':
                    move = Integer.parseInt(command.split(" ")[1]);
                    cur = cur.moveNext(move);
                    break;
                case 'C':
                    deleteed.add(cur);
                    cur = cur.delete();
                    break;
                case 'Z':
                    Node node = deleteed.pop();
                    node.restore();
                    break;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nodes[i].deleted) {
                answer.append("X");
                continue;
            }
            answer.append("O");
        }

        return answer.toString();
    }


}


class Node {


    Node prev = null;
    Node next = null;
    boolean deleted;

    public Node movePrev(int move) {
        Node node = this;
        for (int i = 0; i < move; i++) {
            node = node.prev;
        }
        return node;
    }

    public Node moveNext(int move) {
        Node node = this;
        for (int i = 0; i < move; i++) {
            node = node.next;
        }
        return node;
    }

    public Node delete() {
        this.deleted = true;
        Node prev = this.prev;
        Node next = this.next;

        if (prev != null) {
            prev.next = next;
        }

        if (next != null) {
            next.prev = prev;
            return next;
        }

        return prev;
    }

    public void restore() {
        this.deleted = false;
        Node prev = this.prev;
        Node next = this.next;

        if (prev != null) {
            prev.next = this;
        }

        if (next != null) {
            next.prev = this;
        }
    }

}