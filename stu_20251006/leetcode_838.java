package stu_20251006;

public class leetcode_838 {

    public static void main(String[] args) {
        //3    78  11
        System.out.println(sol_838(".L.R...LR..L.."));
        System.out.println(sol_838(".L.R."));
    }

    private static String sol_838(String dominoes) {

        dominoes = "L" + dominoes + "R";
        char[] arr = dominoes.toCharArray();

        int prev = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '.') continue;
            char left = arr[prev];
            char right = arr[i];

            // case 1: L ... L → 모두 L
            if (left == 'L' && right == 'L') {
                for (int k = prev + 1; k < i; k++) arr[k] = 'L';
            }

            // case 2: R ... R → 모두 R
            else if (left == 'R' && right == 'R') {
                for (int k = prev + 1; k < i; k++) arr[k] = 'R';
            }

            // case 3: R ... L → 가운데 처리
            else if (left == 'R' && right == 'L') {
                int l = prev + 1, r = i - 1;
                while (l < r) {
                    arr[l++] = 'R';
                    arr[r--] = 'L';
                }
            }

            prev = i;

        }

        return new String(arr, 1, arr.length - 2);

    }
}