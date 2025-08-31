package stu_20250826;

public class leetcode_1669 {

    public static void main(String[] args) {


        System.out.println(sol_1669(new int[]{0,1,2,3,4,5,6},2, 5, new int[]{1000000,1000001,1000002,1000003,1000004}));
    }

    private static ListNode sol_1669(int[] ints, int a, int b, int[] ints2) {

        ListNode list1 = new ListNode(ints[0]);
        ListNode n = list1;
        for (int i = 1; i < ints.length; i++) {
            n.next = new ListNode(ints[i]);
            n = n.next;
        }

        ListNode list2 = new ListNode(ints2[0]);
        ListNode n2 = list2;
        for (int i = 1; i < ints2.length; i++) {
            n2.next = new ListNode(ints2[i]);
            n2 = n2.next;
        }

        return removeNode(list1,a,list2,b);
    }

    private static ListNode removeNode(ListNode head, int n, ListNode list2, int end) {
        if (head == null || n <= 0) return null;

        ListNode newHead = new ListNode(head.val); // 첫 노드 복사
        ListNode curNew = newHead;
        ListNode curOld = head.next;

        int count = 1;
        while (curOld != null && count < n) {
            curNew.next = new ListNode(curOld.val);
            curNew = curNew.next;
            curOld = curOld.next;
            count++;
        }
        while (list2!=null){
            curNew.next = new ListNode(list2.val);
            list2=list2.next;
            curNew = curNew.next;
        }

        while (count <= end){
            curOld = curOld.next;
            count++;
        }
        curNew.next=curOld;

        return newHead;
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

    /*@Override
    public String toString() {
        ListNode n = this;
        StringBuffer sb = new StringBuffer();
        while (n != null) {
            sb.append(n.val).append(",");
            n = n.next;
        }
        return sb.toString();
    }*/
}
