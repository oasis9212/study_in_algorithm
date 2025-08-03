package stu_20250730;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 컨테이너 {
    public static void main(String[] args) {
        System.out.println(sol_컨테이너(new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[]{"A", "BB", "A"}));
    }

    private static int sol_컨테이너(String[] storage, String[] requests) {

        // 2크래인을 썼다 해당 알파벳은 다썻다고 판단.
        // 1번을썻다 뚤려있는곳만 확인하면 되지안나 결론 나오네.

        // 1번째 케이스일 경우 큐를 사용
        // 다른글자면 다시 넣으면 되고 같으면 빼고 상하좌우를 넣고
        // while 대신에 큐의 사이즈만큼만 돌리고

        char[][] storageC = new char[storage.length + 2][storage[0].length() + 2];
        Queue<Integer> blankLoc = new LinkedList<>();  // i  * 100  + j *1  지나갈수 있는 곳
        Set<Integer> blankSet = new HashSet<>(); // 이미 간곳

        for (int i = 0; i < storageC.length; i++) {
            for (int j = 0; j < storageC[0].length; j++) {
                storageC[i][j] = '0';
                if(i==0 || j==0 || i==storageC.length-1 || j== storageC.length-1){
                    blankSet.add(i*100+j);
                }
            }
        }


        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[0].length(); j++) {

                if(i==0 || j==0 || i==storage.length-1 || j== storage.length){
                    blankLoc.add((i+1)*100+j+1);
                }
                storageC[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        // 기초 공사
        int totalcount = 0;
        Set<Character> Crain = new HashSet<>(); // 크레인 사용

        for (
                String request : requests) {
            char req = request.charAt(0);
            if (Crain.contains(req)) continue;  // 크레인으로 이미 사용한 알파벳은 다없으니 생략


            if (request.length() > 1) {  // 크래인 사용한경우
                Crain.add(req);
                totalcount += useCrain(storageC, blankLoc, request.charAt(0), blankSet);
            } else {  // 지게차 사용
                int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                int size = blankLoc.size();

                for (int i = 0; i < size; i++) {
                    int loc = blankLoc.poll();
                    int y = loc / 100, x = loc % 100;
                    if (storageC[y][x] == req) {
                        totalcount++;
                        storageC[y][x] = '0';
                        blankSet.add(loc);
                        for (int[] d : dir) {
                            int ny = y + d[0], nx = x + d[1];

                            if ((ny >= 0 && nx >= 0 && ny < storageC.length && nx < storageC[0].length)) {
                                int nextCode = ny * 100 + nx;
                                if (blankSet.add(nextCode)) {
                                    blankLoc.add(nextCode);
                                }
                            }

                        }

                    } else if (storageC[y][x] != '0') {  // 이미간곳은 뺀다.  크레인으로 뺀곳일경우 여기에서 빠짐. 그래도.
                        blankLoc.add(loc);
                    }

                }

            }
        }


        return storage.length * storage[0].

                length() - totalcount;
    }

    private static int useCrain(char[][] storageC, Queue<Integer> blankLoc, char box, Set<Integer> blankSet) {
        int total = 0;

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < storageC.length; i++) {
            for (int j = 0; j < storageC[0].length; j++) {
                if (storageC[i][j] == box) {

                    for (int[] l : dir) {
                        int ny = i + l[0];
                        int nx = j + l[1];
                        if ((ny > 0 && nx > 0 && ny < storageC.length - 1 && nx < storageC[0].length - 1)) {
                            // 이미 셋에있으면 굳이 안넣도되고.
                            // 없는데 가야하는경우
                            // 없는데 못갈경우.
                            if (!blankSet.contains(ny * 100 + nx)) {
                                for (int[] d : dir) {
                                    int nyy = ny + d[0];
                                    int nxx = nx + d[1];
                                    if ((nyy > 0 && nxx > 0 && nyy < storageC.length - 1 && nxx < storageC[0].length - 1) && storageC[nyy][nxx] == '0') {
                                        blankLoc.add(nyy * 100 + nxx);
                                        break;
                                    }
                                }
                            }

                        }
                    }

                    storageC[i][j] = '0';
                    total++;
                    blankSet.add(i * 100 + j);
                }
            }
        }

        return total;
    }
}



