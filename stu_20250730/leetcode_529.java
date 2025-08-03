package stu_20250730;

import java.util.*;

public class leetcode_529 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(sol_529(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0})));
    }

    private static char[][] sol_529(char[][] board, int[] click) {
        int[][] dirs = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        int m = board.length, n = board[0].length;

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(click);

        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        while (!qu.isEmpty()) {
            int[] cur = qu.poll();
            int y = cur[0], x = cur[1];

            // 만약 이미 방문 처리되었으면 생략
            if (board[y][x] != 'E') continue;

            int mineCount = 0;
            List<int[]> nextSteps = new ArrayList<>();

            for (int[] d : dirs) {
                int ny = y + d[0], nx = x + d[1];
                if (ny >= 0 && ny < m && nx >= 0 && nx < n) {
                    if (board[ny][nx] == 'M') {
                        mineCount++;
                    } else if (board[ny][nx] == 'E') {
                        nextSteps.add(new int[]{ny, nx});
                    }
                }
            }

            if (mineCount > 0) {
                board[y][x] = (char) ('0' + mineCount);
            } else {
                board[y][x] = 'B';
                for (int[] next : nextSteps) {
                    qu.offer(next);  // 방문 표시하지 않고 큐에 넣기만
                }
            }
        }

        return board;
    }

}
