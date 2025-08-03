package stu_20250730;


import java.util.Arrays;

public class leetcode_2487 {
    public static void main(String[] args) {

        //    System.out.println(sol_2487(new int[]{5, 2, 13, 3, 8}));
       // System.out.println(sol_2487(new int[]{1, 1, 1, 1}));
       // System.out.println(sol_2487(new int[]{5,2,3,5}));
        System.out.println(sol_2487(new int[]{998,112,660,961,943,721,480,522,133,129,276,362,616,52,117,300,274,862,487,715,272,232,543,275,68,144,656,623,317,63,908,565,880,12,920,467,559,91,698}));

    }

    private static String sol_2487(int[] ints) {

        ListNode head = new ListNode(ints[0]);
        ListNode n = head;
        for (int i = 1; i < ints.length; i++) {
            n.next = new ListNode(ints[i]);
            n = n.next;
        }
        head = reverse(head);  // 1. 역순으로 만든다
        int max = head.val;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;  // 삭제
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }
        return reverse(head).toString();  // 2. 다시 뒤집어서 원래 순서로 복원

    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode n = this;
        StringBuffer sb = new StringBuffer();
        while (n != null) {
            sb.append(n.val).append(",");
            n = n.next;
        }
        return sb.toString();
    }
}
