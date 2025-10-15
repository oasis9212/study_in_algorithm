package stu_20251012;

import java.util.Arrays;

public class leetcode_1861 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sol_1861(new char[][]{{'#', '.', '#'}})));
        System.out.println(Arrays.deepToString(sol_1861(new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}})));
    }

    private static char[][] sol_1861(char[][] boxGrid) {
        for (int i = 0; i < boxGrid.length; i++) {
            int shapeCount=0;
            for (int j = 0; j < boxGrid[i].length; j++) {
                if(boxGrid[i][j]=='#'){
                    boxGrid[i][j]='.';
                    shapeCount++;
                }else if(boxGrid[i][j]=='*'){
                    while (shapeCount>0){
                        boxGrid[i][j-shapeCount]='#';
                        shapeCount--;
                    }
                }
            }
            int xlen=boxGrid[i].length-1;
            while (shapeCount>0){
                boxGrid[i][xlen]='#';
                xlen--;
                shapeCount--;
            }
        }
        char[][] res= new char[boxGrid[0].length][boxGrid.length];
        int x= boxGrid.length-1;
        for (int i = 0; i < boxGrid.length; i++) {
            for (int j = 0; j < boxGrid[i].length; j++) {
                res[j][x-i]=boxGrid[i][j];
            }
        }
        
        
        return res;
    }
}
