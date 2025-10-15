package stu_20251012;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_739_another {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_739_another(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    private static int[] sol_739_another(int[] temperatures) {
        temper[] tem = new temper[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            tem[i] = new temper(temperatures[i], i);
        }
        int[] res = new int[temperatures.length];
        Stack<temper> st = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (st.isEmpty()) {
                st.add(tem[i]);
            } else if (st.peek().val > tem[i].val) {
                st.add(tem[i]);
            } else {  // 맨위 보다 높은 온도를 가질경우.
                while (!st.isEmpty()) {
                    if (st.peek().val < tem[i].val) {
                        temper t = st.pop();
                        res[t.idx] = tem[i].idx - t.idx;
                    } else {
                        break;
                    }
                }
                st.add(tem[i]);
            }
        }

        while (!st.isEmpty()) {
            res[st.pop().idx] = 0;
        }
        return res;
    }
}


class temper {

    int val;
    int idx;        // 날짜 취급 가능.
    int count;

    public temper(int val, int idx) {
        this.val = val;
        this.idx = idx;
        this.count = 0;
    }
}