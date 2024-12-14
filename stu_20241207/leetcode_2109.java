package stu_20241207;

public class leetcode_2109 {
    public static void main(String[] args) {
        System.out.println(sol_leetcode_2109("LeetcodeHelpsMeLearn",new int[]{8,13,15}));

    }

    private static String  sol_leetcode_2109(String s, int[] spaces ) {

        StringBuffer sb=new StringBuffer();
        int idx=0;

        for (int i = 0; i < spaces.length; i++) {
            sb.append(s, idx, spaces[i]);
            sb.append(' ');
            idx=spaces[i];
        }
        sb.append(s,idx,s.length());

        return sb.toString();
    }


}

