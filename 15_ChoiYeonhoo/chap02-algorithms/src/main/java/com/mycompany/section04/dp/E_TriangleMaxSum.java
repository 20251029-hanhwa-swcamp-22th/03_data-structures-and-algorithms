package com.mycompany.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 정수 삼각형 최대 합 경로
* - 삼각형 형태로 배치된 숫자들이 주어짐
* - 맨 위에서 시작하여, 아래로 내려가면서 숫자 선택
* - 인접한 칸만 이동 가능
* - 선택한 숫자들의 합이 최대가 되는 경로 찾기
* - 결과로 누적된 최대 가중치 구하기
*
* */
public class E_TriangleMaxSum {

  public static int solution (String input) throws IOException{
    BufferedReader br = new BufferedReader(new StringReader(input));

    int n = Integer.parseInt(br.readLine());

    /* 그래프를 기록할 인접 행렬(2차원 배열) 생성 */
    int[][] t = new int[n+1][n+1];

    /* (1.1) 부터 마지막 층까지 내려오면서 가지는 최대값을 기록할 배열 */
    int[][] dp = new int[n+1][n+1];

    StringTokenizer st;
    /* DP : Bottom-Up (Tabulation + 반복문) */
    for (int i = 1; i<n+1; i++){ // 총 반복
      st = new StringTokenizer(br.readLine());
      for(int j = 1; j < i+1; j++){ // 각 층의 정수 반복
        // 삼각형 데이터 입력
          t[i][j] = Integer.parseInt(st.nextToken());
      }
      /* 삼각형 값 세팅 확인 (디버깅용) */
      System.out.println(Arrays.toString(t[i]));
    }
    System.out.println("==========================================");
    for (int i = 1; i<n+1; i++){
      for(int j = 1; j < i+1; j++){
        // 바로 위층 두 경로 중 누적 값이 큰 값을 선택
        // 현재 방문한 정수 t[i][j] 값을 더해서 dp에 입력
        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + t[i][j];
      }
      // 누적된 가중치 확인 (디버깅)
      System.out.println(Arrays.toString(dp[i]));
    }
    
    // 가중치가 기록된 dp[][]에서 마지막줄 중 가장 큰 값 찾기


    int maxSum = 0;
    for (int i = 0; i < n+1; i++) {
      if (dp[n][i] > maxSum) maxSum = dp[n][i];
    }
    
    int max = Arrays.stream(dp[n]).max().orElse(Integer.MIN_VALUE); // Stream으로 하는 방법

    return maxSum;
  }
}
