package stu_20250323;

public class 택배상자 {
    public static void main(String[] args) {

        System.out.println(sol_택배(13, 3, 6));

    }

    private static int sol_택배(int n, int w, int num) {

        int selow = n / w;  // 세로줄의 몇줄. 나머지는 생각 안함


        int numselo = num / w; // num 어느줄에 속하는지 파악  (세로)
        numselo += num % w != 0 ? 1 : 0;


        int count = selow - numselo + 1;

        int curloc = (selow - numselo) * w + num;

        if(curloc++<=n){
            count++;
        }


        return count;
    }
}
