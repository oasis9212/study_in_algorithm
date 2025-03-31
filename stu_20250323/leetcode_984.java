package stu_20250323;

public class leetcode_984 {
    public static void main(String[] args) {

        //   System.out.println(sol_984(1,2));
        System.out.println(sol_984(4, 1));
    }

    private static String sol_984(int a, int b) {
        StringBuffer sb = new StringBuffer();

        int len = a + b;


        for (int i = 0; i < len; i++) {
            // 첫글자와 두번째 글짜는 비교할게 확인할방법이 없어서
            // a, b 갯수에 따라 많은쪽을 붙여줍니다.
            if (i == 0 || i == 1) {
                if (a >= b) {
                    sb.append('a');
                    a--;
                } else {
                    sb.append('b');
                    b--;
                }
            } else {
                // 현재 붙일 글자의 이전 전전 글자가 동일할경우 다른 글짜를 붙입니다.
                char c = sb.charAt(i - 1);
                if (c == sb.charAt(i - 2)) {
                    if (c == 'a') {
                        sb.append('b');
                        b--;
                    } else {
                        sb.append('a');
                        a--;
                    }
                } else {
                    // 글자가 다르다면 값이 많은쪽을 가져와서 붙입니다.
                    if (a >= b) {
                        sb.append('a');
                        a--;
                    } else {
                        sb.append('b');
                        b--;
                    }
                }


            }


        }


        return sb.toString();
    }

}
