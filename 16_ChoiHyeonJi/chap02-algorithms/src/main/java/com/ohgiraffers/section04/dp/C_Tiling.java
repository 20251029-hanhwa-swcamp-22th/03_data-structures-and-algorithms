package com.ohgiraffers.section04.dp;

/* 2 X N 직사각형을
 * 2X1, 1X2 짜리 타일로 채우는 방법의 수 구하기
 * == 피보나치 수열
 */

public class C_Tiling {

  public static int solution(int n){

    /* DP : Bottom-up 방식 활용 */
    // 일단 값을 기록해놓을 타뷸레이션 (테이블)이 나와야함
    int[] dp = new int[n+1]; // 0번 인덱스는 안쓴다는 가정하에

    // 피보나치는 두 칸 고정
    dp[0] = 1; // 2x0을 채우는 방법 -> 1 가지 // 아무것도 안 넣는 것도 방법임.
    dp[1] = 1; // 2x1을 채우는 방법 -> 1 가지

    for(int i = 2; i<= n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
  }
}
