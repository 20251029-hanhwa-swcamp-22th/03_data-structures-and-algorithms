package com.mycompany.section04.dp;


import java.util.Arrays;

/* 2XN 의 직사각형을
* 2X1, 1X2 짜리 타일로 채우는 방법의 수 구하기
* == 피보나치 수열 */
public class C_Tiling {
  
  public static int solution(int n){

    /* DP : Botton-Up 방식 활용 */
    int[] dp = new int[n+1];

    dp[0] = 1; // 2x0 채우는 방식 : 1 (아무것도 안넣는 것도 방법)
    dp[1] = 1; // 2x1 채우는 방식 : 1

    for(int i = 2; i< n+1; i++){
      dp[i] = dp[i-1]+dp[i-2];
    }
    return dp[n];
  }
}
