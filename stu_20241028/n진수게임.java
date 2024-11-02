package stu_20241028;

public class n진수게임 {
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;

        int num = 0;
        StringBuilder st = new StringBuilder();

        while (st.length() < t * m) {
            st.append(Integer.toString(num, n));
            num++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < t; i++) {
            ans.append(st.charAt((p - 1) + (i * m)));
        }

        System.out.println(ans.toString().toUpperCase());


    }
}


/*
* 스트 12 〉	통과 (0.23ms, 84.7MB)
테스트 13 〉	통과 (0.25ms, 75.3MB)
테스트 14 〉	통과 (8.18ms, 78.2MB)
테스트 15 〉	통과 (9.91ms, 85.2MB)
테스트 16 〉	통과 (10.35ms, 83.4MB)
테스트 17 〉	통과 (1.27ms, 76.3MB)
테스트 18 〉	통과 (1.52ms, 74.3MB)
테스트 19 〉	통과 (0.34ms, 74.1MB)
테스트 20 〉	통과 (1.28ms, 68.1MB)
테스트 21 〉	통과 (2.45ms, 74.1MB)
테스트 22 〉	통과 (1.59ms, 72.8MB)
테스트 23 〉	통과 (6.61ms, 74.1MB)
테스트 24 〉	통과 (4.10ms, 78.9MB)
테스트 25 〉	통과 (4.87ms, 75.2MB)
테스트 26 〉	통과 (1.76ms, 77MB)
* */