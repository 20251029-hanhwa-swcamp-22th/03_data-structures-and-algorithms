package com.ohgiraffers.section04.dp;

/* 정수 삼각형 최대 합 경로
* - 삼각형 형태로 배치된 숫자들이 주어짐
* - 맨 위에서 시작하여 아래로 내려가면서 숫자 선택
* - 인접한 칸만 이동이 가능
* - 선택한 숫자들의 합이 최대가 되는 경로를 찾는다
* - 결과로 누적된 최대 가중치 구하기
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E_TriangleMaxSum {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        int n = Integer.parseInt(br.readLine());

        /* 그래프를 기록할 인접 행렬(2차원 배열) 생성 */
        int[][] t = new int[n+1][n+1];

        /* (1,1)부터 마지막 층 까지 내려오면서 가지는 최대 값을 기록할 배열 */
        int[][] dp = new int[n+1][n+1];

        /* DP: Bottom-Up(Tabulation) */
        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++) {
                t[i][j] = Integer.parseInt(st.nextToken());
            }
            /* 삼각형 값 세팅 확인하는 디버깅 코드 */
            System.out.println(Arrays.toString(t[i]));
        }

        System.out.println("--------------------------------------------------");
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                // 바로 윗층 두 경로 중 큰 값을 선택한 후
                // 현재 방문한 정수 t[i][j] 값을 더해서 dp에 입력
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + t[i][j];
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        int ans = 0;
        for (int i=1; i<=5; i++) {
            ans = Math.max(ans, dp[5][i]);
        }
        return ans;
    }


}
