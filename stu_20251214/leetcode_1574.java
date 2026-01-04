package stu_20251214;

public class leetcode_1574 {
    public static void main(String[] args) {
        System.out.println(sol_1574(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
        //  System.out.println(sol_1574(new int[]{5,4,3,2,1}));
    }

    private static int sol_1574(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[left] <= arr[i]) {
                left = i;
            } else {
                break;
            }
        }
        if (left == arr.length - 1) {
            return 0;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[right] >= arr[i]) {
                right = i;
            } else {
                break;
            }
        }
        int i = 0;
        int j = right;
        int result = Math.min(arr.length - left - 1, right);  // 왼쪽만 남겨 지운 갯수 4 ,  오른쪽만 남겨 지운 갯수 5

        while (i <= left && j < arr.length) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result ,  j-i-1);
                i++;
            } else {
                j++;
            }

        }
        return result;
    }
}
