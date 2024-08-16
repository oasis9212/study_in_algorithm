package stu_20240810;

public class 부대복귀_망함 {

    static int max;

    public static void main(String[] args) {
        int n = 5;
        int[][] roads = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources = {1, 3, 5};
        int destination = 5;

        int[] answer = sol_answer(n, roads, sources, destination);

    }

    private static int[] sol_answer(int n, int[][] roads, int[] sources, int destination) {
        int[][] connect = new int[n][n];  // 연결 된 지역.

        for (int[] road : roads) {
            int s = road[0] - 1;
            int e = road[1] - 1;
            connect[s][e] = 1;
            connect[e][s] = 1;
        }

        // destination  -> sources 뜻 ==  sources-> destination
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            max = 99999;
            int[][] roadGo = connect;
            int dest = destination - 1;

            goLoc(dest, sources[i] - 1, roadGo, 0);
            answer[i] = max == 99999 ? -1 : max;
        }


        return answer;
    }

    // dest 출발 위치 , source 도착해야할 장소  count  왔다갔다한 횟수.
    private static void goLoc(int dest, int source, int[][] roadGo, int count) {
        if (dest == source) {
            max = Math.min(count, max);
        } else {
            for (int i = 0; i < roadGo.length; i++) {
                roadGo[i][dest] = 0;  // 한번 간곳은 아예 가지않는다.
            }
            for (int i = 0; i < roadGo[dest].length; i++) {
                if (roadGo[dest][i] == 1) {
                    goLoc(i, source, roadGo, ++count);
                }
            }

        }
    }
}
