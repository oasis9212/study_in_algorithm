package stu_20251109;

public class leetcode_583 {
    public static void main(String[] args) {
         System.out.println(sol_583("sea","eat"));
        //System.out.println(sol_583("a", "a"));
    }

    //  eat , sea     ea가 공통된문자 이니깐
    //   (eat + sea) -ea * 2  값
    //    3+ 3  - (2 * 2) = 2
    // 각각 문자의 길이 값을 더하는 문제
    //
    private static int sol_583(String word1, String word2) {
        // 풀이
        // 0. dp를 담을 배열을 생성 dp[word1][word2] 기준으로 생성
        // 1. word1 의 한글자와 word2 문자를 동일 비교
        // 2. word1 의 동일한 word2 에 나온다면 해당 열에 하나를 더한다.
        // 3. 다를시 이전항 dp[이전][word2] , dp[word1][이전] 값과 비교하여 가장 큰값을 가져온다.
        // 4. dp 맨마지막 것을 가져와 양쪽문자열을 길이를 더한뒤 dp*2 한 값을 뺀다.
        //   0 s e a
        // 0 0 0 0 0
        // e 0 0 1 0
        // a 0 0 1 2
        // t 0 0 1 2
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;  // 대각선
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);  // 이전항 선택
                }
            }
        }
        return word1.length() + word2.length() - dp[word1.length()][word2.length()] * 2;
    }
}
