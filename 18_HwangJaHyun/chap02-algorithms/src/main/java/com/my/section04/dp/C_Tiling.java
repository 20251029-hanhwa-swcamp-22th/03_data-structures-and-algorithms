package com.my.section04.dp;

public class C_Tiling {
  
  /* 2 X N 직사각형을 
  *  2X1, 1X2짜리 타일로 채우는 방법의 수 구하기
  *  == 피보나치 수열 */
  public static int solution(int n) {

    /* DP : Bottom-Up 방식 활용 */
    int[] dp = new int[n+1];

    dp[0] = 1; // 2X0을 채우는 방법 -> 1가지(아무것도 안넣기)
    dp[1] = 1; // 2X1을 채우는 방법 -> 1가지

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] +  dp[i-2];
    }

    return dp[n];
  }
}
