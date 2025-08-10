package stu_20250804;


public class 미로탈출 {
    public static void main(String[] args) {
        System.out.println(미로탈출_sol(3, 4, 2, 3, 3, 1, 5));
        System.out.println(미로탈출_sol(3, 3, 1, 2, 3, 3, 4));
        System.out.println(미로탈출_sol(2, 2, 1, 1, 2, 2, 2));
    }

    private static String 미로탈출_sol(int n, int m, int x, int y, int r, int c, int k) {
        // 아래 : d , 왼 : l , 오: r , 위 : u ,
        //  아래하고 위의 갯수
        // 왼쪽하고 오른쪽의 갯수 확정?

        //   1  + 2   짝수가 남는다.
        //   2  + 1
        int selo = Math.abs(r - x);  // 2   필수 행동
        int galo = Math.abs(c - y);  //  1   필수 행동


        if (k - (selo + galo) < 0 || (k - (selo + galo)) % 2 == 1) {  //  k -  필수 행동의 값  홀수거나 음수라면 불가능하다.
            return "impossible";
        }
        int xdis = x - r;       // 세로
        int ydis = c - y;      // 가로
        int[] dircount = new int[4];  // 0 d   || 1 l  || 2 r || 3 u
        if (xdis > 0) {
            dircount[3] = xdis;
        } else {
            dircount[0] = Math.abs(xdis);
        }
        if (ydis > 0) {
            dircount[2] = ydis;
        } else {
            dircount[1] = Math.abs(ydis);
        }
        // 최소거리로 가는 방향은 꼭있어야함.
        // m 가로  n 세로  y 가로 x 세로
        StringBuffer sb = new StringBuffer();
        int remain = k - (selo + galo);  // 남겨진뻘짓 행동 가능
        // d     l      r   u
        int[][] loc = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        while (remain > 0) {

            for (int i = 0; i < loc.length; i++) {
                int nx = x + loc[i][0];
                int my = y + loc[i][1];

                if (nx > 0 && nx <= n && my > 0 && my <= m) {
                    boolean useremain = false;
                    x = nx;
                    y = my;
                    if (dircount[i] > 0) {
                        dircount[i]--;
                    } else {
                        useremain = true;
                        remain -= 2;
                    }
                    switch (i) {
                        case 0:
                            sb.append('d');
                            if (useremain) {
                                dircount[3]++;
                            }
                            break;
                        case 1:
                            sb.append('l');
                            if (useremain) {
                                dircount[2]++;
                            }
                            break;
                        case 2:
                            sb.append('r');
                            if (useremain) {
                                dircount[1]++;
                            }
                            break;
                        default:
                            sb.append('u');
                            if (useremain) {
                                dircount[0]++;
                            }
                            break;
                    }
                    break;
                }

            }
        }
        for (int i = 0; i < dircount.length; i++) {
            if (dircount[i] > 0) {
                switch (i) {
                    case 0:
                        sb.append("d".repeat(dircount[i]));
                        break;
                    case 1:
                        sb.append("l".repeat(dircount[i]));
                        break;
                    case 2:
                        sb.append("r".repeat(dircount[i]));
                        break;
                    default:
                        sb.append("u".repeat(dircount[i]));
                        break;
                }
            }
        }


        return sb.toString();
    }
}
