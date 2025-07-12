package stu_20250706;

public class leetcode_1980 {
    public static void main(String[] args) {
        System.out.println(sol_1980(new String[]{"111","000","001"}));

    }

    private static String sol_1980(String[] nums) {

        int len =(int)Math.pow(2,nums.length);

        boolean[] Exist=new boolean[len];

        for (String s: nums){
            Exist[Integer.parseInt(s,2)]=true;
        }
        int val=0;
        for (int i=0;i<Exist.length;i++){
            if(!Exist[i]){
                val=i;
                break;
            }
        }
        String format="%"+nums.length+"s";
        return String.format(format,Integer.toBinaryString(val)).replace(' ', '0');
    }
}
