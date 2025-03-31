package stu_20250323;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_554 {

    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<>();
        int[][] a = {
                {1, 2, 2, 1},
                {3, 1, 2},
                {1, 3, 2},
                {2, 4},
                {3, 1, 2},
                {1, 3, 1, 1}
        };

            // 1, 3, 5
            // 1, 4
            // 2
            // 3, 4,
            // 1, 4, 5,

            // 1 의 갯수 3
            // 2 의 갯수 1
            // 3 의 갯수 3
            // 4 의 갯수 4
            // 5 의 갯수 2

            // 6 - (4의 갯수) = 2
        // 배열을 리스트로 변환
        for (int[] row : a) {
            wall.add(new ArrayList<>(Arrays.asList(Arrays.stream(row).boxed().toArray(Integer[]::new))));
        }

        System.out.println(sol_554(wall));
    }

    private static int sol_554(List<List<Integer>> wall) {

        HashMap<Integer,Integer> hs= new HashMap<>();       // 누적 합 사용

        for (int i = 0; i < wall.size(); i++) {
            List<Integer> w= wall.get(i);  // 벽돌 배열
            int count=0;        // 누적합을 위한 합산 수치
            for (int j = 0; j < w.size()-1; j++) {  // -1 한이유 부분합을 진행 하면서 맨마지막값은 해당 벽의 맨끝이기 때문에 제외한다.
                count+=w.get(j);
                hs.put(count, hs.getOrDefault(count,0)+1);  // 해당 중복되는 부분합 있는 부분 해쉬맵으로 처리진행 카운트를 넣는다

            }

        }
            int max=0;
            for (int val: hs.values()){
                max=Math.max(max,val);  // 키값중에서 가장 많은 갯수에서 전체벽 뺀값 계산
            }
            return wall.size()-max;
    }

}
