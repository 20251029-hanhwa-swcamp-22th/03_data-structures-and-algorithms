package com.beyond.section04.dp;

/* 2XN 직사각형을
* 2X1, 1X2 짜리 타일로 채우는 방법의 수 구하기
* == 피보나치 수열*/

public class C_Tiling {

  public static int solution(int N) {

    /* DP : Bottom-Up 방식 활용 */
    int[] dp = new int[N + 1];


    dp[0] = 1; // 2X0을 채우는 방법 - 0가지
    dp[1] = 1; // 2X1을 채우는 방법 - 1가지

    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[N];
  }
}
