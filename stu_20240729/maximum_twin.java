package stu_20240729;

public class maximum_twin {
    public static void main(String[] args) {
        int[] nums = {1,100000};
        ListNode head = createNode(nums);

        // 1. 길이는 알수 없다.

        int maxPairSum = pairSum(head);
        System.out.println(maxPairSum);

    }

    static int pairSum(ListNode head) {

        ListNode left=head;
        ListNode right=head;


        StringBuffer leftStr= new StringBuffer();  // 일종의 저장 장치 List 만들기 싫어서.
        // 해당 리크드 리스트의 절반 을 찾기.
        // A B가 있다면 B를 2배빨리건너 뛰어서 끝에 도달하면 A는 절반 도착하게 된상태.
        while(right!=null && right.next!=null  ){
            leftStr.append(left.val).append(",");
            left = left.next;
            right= right.next.next;
        }
        StringBuffer rightStr= new StringBuffer();
        while (left!=null){
            rightStr.append(left.val).append(",");
            left = left.next;
        }

        int[] leftNum=toIntAry(leftStr);
        int[] rightNum=toIntAry(rightStr);

        int max=0;

        for (int i=0;i<leftNum.length;i++){
            max=Math.max(max,leftNum[i]+rightNum[leftNum.length-i-1]);
        }

        return max;
    }

    private static int[] toIntAry(StringBuffer str) {

        String[] s= str.toString().split(",");
        int[] ary= new int[s.length];
        for(int i=0;i<s.length;i++){
            ary[i]=Integer.parseInt(s[i]);
        }
        return ary;
    }

    // List 노드를 만들기 위한 과정 무시 해도된다.
    private static ListNode createNode(int[] nums) {

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
