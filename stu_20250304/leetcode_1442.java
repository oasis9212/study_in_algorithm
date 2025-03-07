package stu_20250304;

public class leetcode_1442 {
    public static void main(String[] args) {
        System.out.println(sol_1442(new int[]{2, 3, 1, 6, 7}));

    }

    private static int sol_1442(int[] arr) {
        int n = arr.length;
        int[] xorAry = new int[arr.length + 1];


        for (int i = 1; i < xorAry.length; i++) {
            xorAry[i] = xorAry[i - 1] ^ arr[i - 1];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int k = i + 1; k < n; k++) {
                if (xorAry[i] == xorAry[k + 1]) {
                    count += (k - i);
                }
            }
        }


        return count;
    }
}
