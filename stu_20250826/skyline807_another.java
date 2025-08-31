package stu_20250826;

public class skyline807_another {
    public static void main(String[] args) {

        int[][] grid={{3,0,8,4}
                     ,{2,4,5,7}
                     ,{9,2,6,3}
                     ,{0,3,1,0}
        };

        int count=0;
        int y;
        int x;
        for(y=0;y<grid.length;y++){
            for(x=0;x<grid[y].length;x++){
                count+=plusval(y,x,grid);
            }
        }
        System.out.println(count);



    }

    private static int plusval(int y, int x, int[][] grid) {
        int xmax=0;
        int ymax=0;

        for(int i=0;i<grid[y].length;i++){
            xmax=Math.max(xmax,grid[y][i]);
        }
        for(int i=0;i<grid.length;i++){
            ymax=Math.max(ymax,grid[i][x]);
        }

        return Math.min(ymax,xmax)-grid[y][x];

    }
}
