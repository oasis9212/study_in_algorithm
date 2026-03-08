package stu_20260303;

public class leetcode_19 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));


        ListNode res = sol_19(head, 2);

    }
    private static ListNode sol_19(ListNode head, int n) {

        ListNode memory= new ListNode(0);
        memory.next=head;

        ListNode fast = memory;
        ListNode slow = memory;

        for (int i = 0; i <= n; i++) {
            fast=fast.next;
        }

        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;
        return memory.next;

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
}