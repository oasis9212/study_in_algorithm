package stu_20240715;

public class skyline807 {
    public static void main(String[] args) {
        int[][] grid={{3,0,8,4}
                     ,{2,4,5,7}
                     ,{9,2,6,3}
                     ,{0,3,1,0}
        };
        // 1. 원래 위치 숫자보다 크면 변환을 시킨다.
        // 2. 이후 다른 숫자랑 비교한 뒤 다른 숫자가 작을경우 변경한다.
        // 3. 원래 숫자랑 비교해서 작다면 무시.
        int count=0;

        // 3. 원래 숫자랑 비교해서 작다면 무시.
        // 변경됬다면 true 변환.
        boolean changed[][]=new boolean[grid.length][grid[0].length];

        int[][] change=new int[grid.length][grid[0].length];
        for(int i=0;i<change.length;i++){
            System.arraycopy(grid[i],0,change[i],0, change[i].length);
        }
       // 배열 값 복사 (깊은 복사 참고)

        for(int i=0;i<changed.length;i++){
            for(int k=0;k<changed[i].length;k++){

            }
        }




    }
}
