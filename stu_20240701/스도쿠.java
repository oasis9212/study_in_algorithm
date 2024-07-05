package stu_20240701;

import java.util.HashSet;
import java.util.Set;

public class 스도쿠 {

    public static void main(String[] args) {
        char[][] board= {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        boolean TF= isValidSudoku(board);
        System.out.println(TF);
    }

    private static boolean isValidSudoku(char[][] board) {
        int x=0;
        int y=0;
        Boolean result= ValidCheck(board,x,y);
        return result;
    }

    private static Boolean ValidCheck(char[][] board,int x,int y) {
        if(x==0 && y ==9){
            return true;
        }

        if(x==9){
          return   ValidCheck(board,0,++y);
        }


        if(board[y][x]=='.'){
            Set<Character> checking=new HashSet<>();
            for(int i=0;i<9;i++){  // x (가로) 좌표 체크.
                if(board[y][i]=='.'){
                    continue;
                }
                if(!checking.add(board[y][i])){
                    return false;
                };
            }
            checking=new HashSet<>(); // 초기화
            for(int i=0;i<9;i++){  // y (세로) 좌표 체크.
                if(board[i][x]=='.'){
                    continue;
                }
                if(!checking.add(board[i][x])){
                    return false;
                };
            }
            checking=new HashSet<>();
            int sqarelocX=(x/3)*3;
            int sqarelocY=(y/3)*3;

            for(int i=sqarelocY;i<sqarelocY+3;i++){  // 3*3 박스 체크.
                for(int k=sqarelocX;k<sqarelocX+3;k++){
                    if(board[i][k]=='.'){
                        continue;
                    }
                    if(!checking.add(board[i][k])){
                        return false;
                    };
                }
            }

        }

        return  ValidCheck(board,++x,y);
    }
}
