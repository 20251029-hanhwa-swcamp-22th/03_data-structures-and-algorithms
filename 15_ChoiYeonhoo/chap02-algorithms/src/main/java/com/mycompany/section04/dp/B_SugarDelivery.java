package com.mycompany.section04.dp;


import java.util.Arrays;

/* ===== 문제 =====
 * - N kg 의 설탕을 배달해야 한다.
 * - 설탕 봉지는 3kg, 5kg 존재
 * - 최대한 적은 봉지를 들고 가려고 함
 * - 정확하게 N kgㅇ을 만들 수 없다면 -1을 반환
* */
public class B_SugarDelivery {

  // 불가능한 경우를 나타내는 큰 값
  static final int INF = 9999;

  /**
   * 배달할 설탕 봉지 수 계산
   * @param N 요구하는 설탕의 Kg
   * @return 최소 봉지 수, (불가능 : -1)
   */
  public static int solution(int N){

    // Tabulation
    // dp 배열의 인덱스 == 해당 kg의 봉지 수
    int[] dp = new int[N+1];
    // dp[i] == i kg을 만드는데 필요한 최소 봉지 수

    // 배열 모든 요소를 INF로 초기화
    // INF == 아직 계산 X 또는 불가능
    Arrays.fill(dp, INF);

    /* Base Case 설정
    * n으로 전달되는 숫자가 작으면 인덱스 범위를 벗어날 수 있기 때문에
    * 초기 값 설정 시 확인하고 이후 반복문 수행
    * */
    if(N >= 3); dp[3] = 1; // 3kg 요청 -> 3kg 설탕 1봉지
    if(N >= 5); dp[5] = 1;

    int baggage1 = 3;
    int baggage2 = 5;

    /* Bottom-Up Dp */
    for(int i = 6; i <= N; i++){
      dp[i] = Math.min(dp[i-baggage1],dp[i-baggage2]) + 1;
    }

    // 결과 반환
    return dp[N] >= INF ? -1 : dp[N];
  }
}
