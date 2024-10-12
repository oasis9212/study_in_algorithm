package stu_20241006;

public class leetcode_2087 {
    public static void main(String[] args) {
        int[] startPos={1,0};
        int[] homePos ={2,3};
        int[] rowCosts ={5,4,3};
        int[] colCosts ={8,2,6,7};

//  0 0 0 0
//  0 0 0 4*1
//  0 0 0 x
// 최소 비용== 거리 고려 해볼때.
        int answer=0;
        while(startPos[0]!=homePos[0]){

            if(startPos[0]> homePos[0]){
                startPos[0]--;

            }else {
                startPos[0]++;
            }
            answer+=rowCosts[startPos[0]];
        }
        while (startPos[1]!=homePos[1]){
            if(startPos[1]> homePos[1]){
                startPos[1]--;

            }else {
                startPos[1]++;
            }
            answer+=colCosts[startPos[1]];
        }
        System.out.println(answer);



    }
}
