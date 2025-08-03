package stu_20250422;

public class leetcode_1306 {

    public static void main(String[] args) {
        System.out.println(sol_1306(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
        System.out.println(sol_1306(new int[]{3, 0, 2, 1, 2}, 2));
        System.out.println(sol_1306(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));

    }

    private static boolean sol_1306(int[] arr, int start) {
        // 이미 방문한 곳인데 0 이 아닌곳
        // 순환 된다고 판단하여 0값 갈수 없다 판단이 가능하다.

        boolean[] Tf = new boolean[arr.length];  // 이미 방문한
        return goBFS(Tf, arr, start);
    }

    private static boolean goBFS(boolean[] tf, int[] arr, int idx) {

        if (idx < 0 || idx >= arr.length) {  // 점프하는데 배열을 초과할경우
            return false;
        }
        if (tf[idx] && arr[idx] != 0) { // 점프했는데 이미간곳인데 0 값도 아닌곳이면
            return false;
        } else {
            tf[idx] = true;
        }
        if (arr[idx] == 0) {
            return true;
        }
        int val = arr[idx];  // 점프 해야하는 벨류값

        return goBFS(tf, arr, idx - val) || goBFS(tf, arr, idx + val);
        // 음수로 점프를 하던  양수로 점프를 하던 해당 되는 값이 0 만 찾으면 되기 때문에 or 로 진행

    }
}
