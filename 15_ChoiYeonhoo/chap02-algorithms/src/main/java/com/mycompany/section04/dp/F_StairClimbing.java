package com.mycompany.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/* [계단 오르기]
* - n개의 계단이 있고, 각 계단마다 점수가 있음
* - 계단을 올라가면서 밟은 계단의 점수를 합산
* - 최대 점수를 얻으면서, 마지막 계단에 도달하는 것이 목표
* - 반환할 결과 값 == 최대 점수
*
* ==== 제약 조건 ====
* - 1. 시작 지점은 무조건 지면 (0번 계단)
* - 2. 연속된 3개의 계단을 밝을 수 없다.
* - 3. 한번에 1개 또는 2개의 계단을 오를 수 있음
* - 4. 마지막 계단(n번째 계단)은 반드시 밟아야 함.
* */
public class F_StairClimbing {
  public static int solution (String input) throws IOException {

    BufferedReader br = new BufferedReader(new StringReader(input));

    int n = Integer.parseInt(br.readLine());  // 계단의 개수
    
    int[] scores = new int[n+1]; // 계단별 점수
    // i : 계단 번호, score[i] : 해당 계단 점수

    int[] dp = new int[n+1]; // 최적(최대) 값 누적

    /* 각 계단의 점수 입력 */
    for (int i = 1; i < n+1; i++) {
      scores[i] = Integer.parseInt(br.readLine());
    }

    /* Base Case */
    // n == 1 -> 계단이 1개인 경우 -> 도착이라서 무조건 밟아야 함.
    dp[1] = scores[1];

    if(n>=2){
      dp[2] = dp[1] + scores[2];
    }

    /* DP : Bottom - Up 
    * - 각 계단까지 도달하는데 얻을 수 있는 최대값을
    *   dp[] 요소에 기록
    * */
    for (int i = 3; i < n+1 ; i++){

      dp[i] = Math.max(dp[i-2], dp[i-3] + scores[i-1]) + scores[i] ;

       /* 현재 계단(i)에 도달 하는 경우의 수
       * 1. 두번째 전(i-2)에서 바로 오는 경우
       * 2. 세번째 전(i-3)에서 첫번째 이전(i-1)을 거쳐 오는 경우
       *
       * 1. dp[i] = dp[i-2] + score[i]
       * 2. dp[i] = dp[i-3] + score[i-1] + score[i]
       * 둘중에 큰 경우가 저장 됨
       *
       * 예시) 3번째 칸 최대값을 구하는 경우
       * dp[3] = ( dp[1] > dp[0] + score[2] ? dp[1] + score[3] : dp[0] + score[2] + score[3] )
       * */

    }

    return dp[n]; // n번째 계단 까지의 최대 정수

  }

}
