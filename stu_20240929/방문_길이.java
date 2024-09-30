package stu_20240929;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 방문_길이 {
    public static void main(String[] args) {
        String dirs="ULURRDLLU";
        Set<String> path= new HashSet<>();
        // 4자리인데  1000(x) ,100(y) 자리 내 위치 / 10(x) 1(y) 자리 가는 경로
        // 4자리인데  1000(x) ,100(y) 자리 가는 경로 / 10(x) 1(y) 내 위치 이방 법은 안된다.
        //int history=oriloc[0]*1000+oriloc[1]*100+loc[0]*10+loc[1]*1;
        //int history2=loc[0]*1000+loc[1]*100+oriloc[0]*10+oriloc[1]*1;
        int[] loc= {0,0};
        String curloc="00";
        String berloc="00";
        int answer = 0;
        for (int i = 0; i < dirs.length(); i++) {
            int[] oriloc=new int[]{loc[0],loc[1]};
            if(!gopath(dirs, i, loc)){
                continue;
            }
            berloc=curloc;
            curloc=loc[0]+""+loc[1];
            if(!path.contains(berloc+curloc)) {
                path.add(berloc+curloc);
                path.add(curloc+berloc);
                answer++;
            }
        }
        System.out.println(answer);


    }

    private static boolean gopath(String dirs, int i, int[] loc) {
        switch (dirs.charAt(i)) {
            case 'U':
                if (loc[1] == 5) {
                    return false;
                }
                loc[1] += 1;
                break;
            case 'D':
                if (loc[1] == -5) {
                    return false;
                }
                loc[1] -= 1;
                break;
            case 'R':
                if (loc[0] == 5) {
                    return false;
                }
                loc[0] += 1;
                break;
            case 'L':
                if (loc[0] == -5) {
                    return false;
                }
                loc[0] -= 1;
                break;
            default:
                return false;

        }
        return true;
    }
}

