package stu_20250201;

import java.util.Arrays;
import java.util.Map;

public class 공원_산책 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol_(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));

    }

    private static int[] sol_(String[] park, String[] routes) {
        int x = 0, y = 0;
        int rows = park.length, cols = park[0].length();

        Map<String, int[]> directions = Map.of(
                "E", new int[]{0, 1}, "W", new int[]{0, -1},
                "S", new int[]{1, 0}, "N", new int[]{-1, 0}
        );

        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];
            int steps = Integer.parseInt(split[1]);

            int dx = directions.get(dir)[0];
            int dy = directions.get(dir)[1];

            int nx = x, ny = y;
            boolean valid = true;

            for (int k = 1; k <= steps; k++) {
                nx += dx;
                ny += dy;

                if (nx < 0 || ny < 0 || nx >= rows || ny >= cols || park[nx].charAt(ny) == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }


}
