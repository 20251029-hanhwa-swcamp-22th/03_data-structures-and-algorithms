package com.ohgiraffers.section04.dp;

public class D_Padovan {

/* Padovan Sequence
*   - 이탈리아 건축가 "리차드 파도반"이 발견한 수열
*   - 정삼각형을 나선형으로 배치할 때 나타나는 수열
*   - 피보나치와 비슷하지만 3항 관계식 사용
*
* 수열 정의
* P(1) = 1
* P(2) = 1
* P(3) = 1
* P(4) = 2
* P(5) = 2
* P(n) = P(n-2) + P(n-3) (N >= 4)
* */
    static Integer[] dp = new Integer[101];

    /* Top-Down DP (Memoization + 재귀호출) */
    public static int solution(int n) {

        // Base case 설정
//        dp[1] = dp[2] = dp[3] = 1;

        // Top-Down 재귀 함수 호출
//        return padovan(n);
        return padovan2(n);
    }

    /**
     * Top_Down 방식의 재귀 함수
     * @param n
     * @return
     */
    private static int padovan(int n) {
        // dp[n] == null -> 계산되지 않은 값 -> 계산이 필요하다
        // dp[n] != null -> 계산된 값 -> 계산 불필요 -> 반환
        if (dp[n] == null) {
            dp[n] = padovan(n-2) + padovan(n-3);
        }
        return dp[n];
    }

    private static int padovan2(int n) {
        int[] dp2 = new int[n + 1];
        dp2[1] = dp2[2] = dp2[3] = 1;

        for (int i = 4; i < dp2.length; i++) {
            dp2[i] = dp2[i - 2] + dp2[i - 3];
        }

        return dp2[n];
    }
}
