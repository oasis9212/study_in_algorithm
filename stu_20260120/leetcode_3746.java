    package stu_20260120;

    public class leetcode_3746 {
        public static void main(String[] args) {
            System.out.println(sol_3746("aaabb"));
        }

        private static int sol_3746(String s) {
            int a=0;
            int b=0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='a'){
                    a++;
                }else{
                    b++;
                }
            }
            return Math.abs(a-b);

        }
    }
