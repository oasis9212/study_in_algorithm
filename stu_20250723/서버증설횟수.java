package stu_20250723;

public class 서버증설횟수 {

    public static void main(String[] args) {

        System.out.println(sol_server(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5));

    }

    private static int sol_server(int[] players, int m, int k) {

        int[] server = new int[players.length + k + 1]; // 아예 k 시간까지 있다고 가정.  +1 한 이유 기간 지난 서버 갯수를 빼기 위해서
        int[] serverInstallTime = new int[players.length + k + 1]; // 해당 서버 증설 시간 체크 위한 배열
        int serverPlus = 0;
        int pluscount = 0;
        for (int i = k + 1; i < server.length; i++) {
            server[i] = server[i - 1];  // 이전 서버 갯수 가져오기
            server[i] =Math.max(server[i]-serverInstallTime[i - k],0) ;  // 기간 지난 서버는 빼기 .

            pluscount = players[i - k - 1] / m;

            if (server[i] < pluscount) {
                serverPlus+=pluscount-server[i];
                serverInstallTime[i]=pluscount-server[i];
                server[i]=pluscount;
            }


        }

        return serverPlus;
    }

}
