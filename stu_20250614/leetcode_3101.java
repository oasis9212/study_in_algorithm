package stu_20250614;

public class leetcode_3101 {
    public static void main(String[] args) {

        System.out.println(sol_3101(new int[]{0, 1, 1, 1}));
        System.out.println(sol_3101(new int[]{1,0,1,0}));
    }

    private static long sol_3101(int[] nums) {
        long count = 0; // 결과값
        long breakpoint = 0;  // 안겹치는 숫자가 몇번째 배열에 있는지 확인할려는 숫자.

        for (int i = 0; i < nums.length; i++) {

            if (i == breakpoint) {  // 중복된 인덱스 값동일시할경우
                breakpoint = setbreakpoint(nums, i);  // 다시 겹치지않는 값을 구하는
            }
            count+= breakpoint-i;
        }

        return count;
    }

    private static long setbreakpoint(int[] nums, int i) {

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                return j;  //
            }
        }
        return nums.length;  // 아예 중복되않는 숫자일경우
    }
}
