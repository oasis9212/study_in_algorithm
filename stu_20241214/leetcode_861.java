package stu_20241214;

public class leetcode_861 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 1}
                ,       {0, 1, 1, 1}
                ,       {0, 1, 1, 1}};
        System.out.println(leetcode_861_sol(grid));


    }

    private static int leetcode_861_sol(int[][] grid) {

        // 무조건 해당 [x][0] 의 크기를 최댓값을 잡아주고 시작한다.
        // 세로로 먼저  [x][0] 갯수를 파악한다.
        reverserTF(grid, 0);
        // 세로로 먼저  [x][0] 에서 0의 갯수가 더 크다면 뒤집는다.
        //  가로  [x][0] ==0 이라면  가로로 뒤집는다.
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                reverseing(grid, i, 'G');
            }
        }
        // 이후 다른 칸들의 갯수 파악한뒤 뒤집는다.  (세로로만 뒤집는다).  0번 이미 했으니 생략.
        for (int i = 1; i < grid[0].length; i++) {
            reverserTF(grid, i);
        }
        
        return sumAry(grid);
    }

    private static int sumAry(int[][] grid) {
        int sum=0;
        for (int i = 0; i < grid.length; i++) {
            int pow=(int)Math.pow(2, grid[0].length-1);
            for (int j = 0; j < grid[i].length; j++) {
                sum+=grid[i][j]*pow;
                pow/=2;
            }
        }
        return sum;
    }

    private static void reverserTF(int[][] grid, int i) {
        int onecount;
        int zerocount;
        onecount = 0;
        zerocount = 0;
        for (int j = 0; j < grid.length; j++) {
            if (grid[j][i] == 1) {
                onecount++;
            } else {
                zerocount++;
            }
        }
        if (onecount < zerocount) {
            reverseing(grid, i, 'S');
        }
    }

    private static void reverseing(int[][] grid, int loc, char SG) {
        if (SG == 'S') {
            for (int i = 0; i < grid.length; i++) {
                grid[i][loc] = grid[i][loc] == 1 ? 0 : 1;
            }
        } else {
            for (int i = 0; i < grid[0].length; i++) {
                grid[loc][i] = grid[loc][i] == 1 ? 0 : 1;
            }
        }


    }
}
