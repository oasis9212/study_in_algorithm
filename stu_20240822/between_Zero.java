package stu_20240822;

public class between_Zero {
    public static void main(String[] args) {

        int[] nums = {0, 3, 1, 0, 4, 5, 2, 0};

        ListNode head = createNode(nums);
        ListNode prev = new ListNode(nums[0]);

        int count = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                prev.val = count;
                count = 0;
                if (head.next != null) {
                    prev.next = new ListNode(0);
                    prev = prev.next;
                }

            } else {
                count += head.val;
            }
            head = head.next;

        }


    }

    static ListNode createNode(int[] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
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