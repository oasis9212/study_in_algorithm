package stu_20250414;

public class 공원 {

    public static void main(String[] args) {

        System.out.println(공원_sol(new int[]{5, 3, 2}
                , new String[][]{{"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                        {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}}));

    }

    private static int 공원_sol(int[] mats, String[][] park) {
        int answer = -1;

        int len =0;

        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length;j++){
                for(int k=park.length;k>0;k--){
                    if(checkR(park,i,j,k)){
                        len=Math.max(len,k);
                    }
                }
            }
        }

        for(int mat :mats){
            if(len>=mat){
                answer=Math.max(answer,mat);
            }
        }

        return answer;
    }

    public static boolean checkR(String[][] park, int x, int y, int len){

        for(int i=y;i<=park.length-len;i++){
            for(int j=x;j<=park[0].length-len;j++){
                ///
                boolean flag =true;
                loop :          for(int k=0;k<len;k++){
                    for(int r = 0;r<len;r++){
                        if(!park[i+k][j+r].equals("-1")){
                            flag= false;
                            break loop;
                        }
                    }
                }
                if(flag){
                    return true;
                }
            }
        }

        return false;
    }
}
