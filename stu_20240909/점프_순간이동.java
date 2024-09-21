package stu_20240909;

public class 점프_순간이동 {
    public static void main(String[] args) {
        int n =5;
        int count =0;

        while(n!=1) {
            if(n%2==1) {
                count++;
            }
            n=n/2;
        }
        count++;
        System.out.println(count );
    }
}
