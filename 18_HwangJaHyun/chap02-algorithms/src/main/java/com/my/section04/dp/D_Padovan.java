package com.my.section04.dp;

/* 파도반수열(Padovan Sequence)
* 이탈리아 건축가 "리차드 파도반"이 발견한 수열
* 정삼각형을 나선형으로 배치할 때 나타나는 수열
* 피보나치와 비슷하지만 3항 관계식 사용
*
* 수열 정의
* P(1) = 1
* P(2) = 1
* P(3) = 1
* P(4) = 2
* P(5) = 2
* P(6) = 3
* P(n) = P(n-2) + P(n-3) *n>=4
* */

public class D_Padovan {
  /* DP : Top-Down 방식(Memoization + 재귀 호출)  */
  /* DP : Bottom-UP 방식(Tabulation + 반복문)  */

  static Integer[] dp = new Integer[101];

  public static int solution(int n){

    // Base Case 초기 설정
    dp[1] = dp[2] = dp[3] = 1;

    // Top-Down 재귀함수 호출
    // return Padovan(n);
    return Padovan2(n);
  }

  /**
   * Top-Down 방식의 재귀 함수
   * @param n
   * @return
   */
  private static int Padovan(int n){
    // dp[n] == null == 계산되지 않은 값, 계산 필요
    // dp[n] != null == 계산된 값, 반환
    if(dp[n] == null){
      dp[n] = Padovan(n - 2) + Padovan(n - 3);
    }
    return dp[n];
  }

  private static int Padovan2(int n){
    for(int i = 4; i <= n; i++) dp[i] = dp[i - 2] + dp[i - 3];
    return dp[n];
  }

  private static int Padovan3(int n){
    // Bottom-Up 방식 -> tabulation 사용
    // table의 각 인덱스 == 순서
    // table[i] == i 순서까지 연산한 결과 값
    int[] table = new int[n+1]; // 0번 인덱스 사용 X

    table[1] = table[2] = table[3] = 1;

    for(int i = 4; i < n; i++) table[i] = table[i - 2] + table[i - 3];

    return table[n];
  }
}
