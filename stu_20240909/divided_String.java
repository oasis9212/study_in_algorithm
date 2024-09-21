package stu_20240909;

public class divided_String {
    public static void main(String[] args) {
        String s ="abcd";
        int k=2;
        StringBuilder str=new StringBuilder();
        int idx=0;
        char kcount=0;
        int sum=0;
        while (idx<s.length()){
            sum+=s.charAt(idx)-'a';
            kcount++;
            if(kcount==k){
                int val=sum%26;
                str.append((char) (val+97));
                sum=0;
                kcount=0;
            }
            idx++;

        }

        System.out.println(str.toString());

    }
}
