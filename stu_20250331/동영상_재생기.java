package stu_20250331;

import java.util.Arrays;

public class 동영상_재생기 {

    public static void main(String[] args) {

        //   System.out.println(sol_동영상("34:33","13:00","00:55","02:55",new String[]{"next", "prev"}));
        // System.out.println(sol_동영상("10:00","00:03","00:00","00:05",new String[]{"prev", "next"}));
        System.out.println(sol_동영상("30:00", "00:20", "00:18", "00:35", new String[]{"prev"}));

    }

    private static String sol_동영상(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int video_len_time = changetime(video_len);  //
        int pos_time = changetime(pos);     // 20 초  -10 초
        int op_start_time = changetime(op_start); // 18
        int op_end_time = changetime(op_end);  // 35 초
        // 이전

        for (int i = 0; i < commands.length; i++) {

            if (commands[i].equals("next")) {
                if (pos_time + 10 >= video_len_time) {
                    pos_time = video_len_time;
                } else if (pos_time >= op_start_time && pos_time <= op_end_time) { //  포지션 오프닝 구간
                    pos_time = op_end_time + 10; // 오프닝 앤딩 + 10;
                } else if (pos_time + 10 >= op_start_time && pos_time + 10 <= op_end_time) {  // 10 더했는데 알고보니 오프닝
                    pos_time = op_end_time;
                } else {
                    pos_time += 10;
                }

            } else {
                // 포지션 오프닝 구간
                if (pos_time - 10 >= op_start_time && pos_time - 10 <= op_end_time) {  // 10을뺏는데 알고보니 오프닝
                    pos_time = op_end_time;  // 10초
                } else {
                    pos_time = Math.max(pos_time - 10, 0);
                }
            }
        }
        int minutes = pos_time / 60;
        int seconds = pos_time % 60;
        String formattedTime = String.format("%02d:%02d", minutes, seconds);


        return formattedTime;
    }

    private static int changetime(String time) {
        int[] timeInts = Arrays.stream(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return timeInts[0] * 60 + timeInts[1];
    }

}
