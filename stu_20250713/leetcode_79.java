package stu_20250713;

public class leetcode_79 {
    public static void main(String[] args) {

        System.out.println(sol_79(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        System.out.println(sol_79(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"SEE"));
        System.out.println(sol_79(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
    }

    private static boolean sol_79(char[][] board, String word) {

        boolean[][] used=new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(word.charAt(0)==board[i][j] && dfs_79(board,i,j,used,0,word)){
                    return true;
                }else{
                    used=new boolean[board.length][board[0].length];
                }


            }
        }


        return false;
    }

    private static boolean dfs_79(char[][] board, int selo, int galo, boolean[][] used,int idx,String word) {
        idx++;
        if(idx==word.length()) return true;
        used[selo][galo]=true;
        int[][] location=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < location.length; i++) {
            int changeselo=selo+location[i][0];
            int changegalo=galo+location[i][1];
            if(changeselo>=0 && changeselo<board.length  &&  changegalo>=0 && changegalo<board[0].length && board[changeselo][changegalo]==word.charAt(idx)
            && !used[changeselo][changegalo] && dfs_79(board,changeselo,changegalo,used,idx,word)){
                return true;
            }
        }
        used[selo][galo] = false;
        return false;
    }
}
