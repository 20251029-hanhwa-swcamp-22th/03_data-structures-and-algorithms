package com.ohgiraffers.section04.dp;

public class C_Tiling {

    /*2 X N 직사각형을
    * 2X1, 1X2 짜리 타일로 채울 수 있는 경우의 수 구하기.
    * == 피보나치 수열
    * */
    public static int solution(int n) {
        /* DP: Bottom-Up 방식 활용 */
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
