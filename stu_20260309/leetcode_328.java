package stu_20260309;

public class leetcode_328 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));


        System.out.println(sol_328(head));
    }

    private static ListNode sol_328(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        odd.next=evenhead;

        return head;

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