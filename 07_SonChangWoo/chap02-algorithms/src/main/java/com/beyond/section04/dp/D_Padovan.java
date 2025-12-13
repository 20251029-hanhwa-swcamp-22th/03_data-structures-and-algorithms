package com.beyond.section04.dp;

/* 파도반 수열 (Padovan Sequence)
 * - 이탈리아 건축가 "리차드 파도반"이 발견한 수열
 * - 정삼각형을 나선형으로 배치할 때 나타나는 수열
 * - 피보나치와 비슷하지만 3항 관계식 사용
 *
 * - 수열 정의
 * P(1) = 1
 * P(2) = 1
 * P(3) = 1
 * P(4) = 2
 * P(5) = 2
 * P(6) = 3
 * P(n) = P(n-3) + P(n-2)
 *
 * */

public class D_Padovan {

  /* DP : Top-Down 방식 (Memoization + 재귀 호출) */

  static Integer[] dp = new Integer[101];

  public static int solution(int N) {

    // Base Case 초기 설정
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;

    // Top-Down + 재귀 함수 호출
    // return padovan(N);

    // Bottom-Up + 반목문 함수 호출
    return padovan2(N);
  }

  /**
   * Top-Down 방식의 재귀 함수
   * @param N
   * @return
   */
  private static int padovan(int N) {

    // dp[N] == null == 계산되지 않은 값 ==> 계산 필요
    // dp[N] != null == 계산된 값 ==> 더 이상 계산 X ==> 반환
    if (dp[N] == null) {
      dp[N] = padovan(N-3) + padovan(N-2);
    }

    return dp[N];
  }

  /* DP : Bottom-Up 방식 (Tabulation + 반복문) */
  /**
   * Bottom-Up
   * @param N
   * @return
   */
  private static int padovan2(int N) {
    int[] dp2 = new int[N+1]; // 0번 인덱스 사용 X
    // dp2의 각 인덱스 == 순서
    // dp2[i] == i 순서까지 연산한 결과 값 == 삼각형 변의 길이

    dp2[1] = 1;
    dp2[2] = 1;
    dp2[3] = 1;

    for (int i = 4; i <= N; i++) {
      dp2[i] = dp2[i-2] + dp2[i-3];
    }

    return dp2[N];
  }
}