package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_CoinChange {
  public static int solution(String input) throws Exception {

    // 입력 문자열을 실제 입력처럼 처리
    BufferedReader br = new BufferedReader(new StringReader(input));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 동전 개수
    int K = Integer.parseInt(st.nextToken()); // 목표 금액

    int coins[] = new int[N];

    for(int i = 0; i < N; i++){
      coins[i] = Integer.parseInt(br.readLine());
    }


    int count = 0;

    // 큰 금액부터 사용
    for(int i = N - 1; i >= 0; i--){
      count += K / coins[i];  // 현재 동전 몇 개 사용 가능한지
      K %= coins[i];          // 남은 금액 갱신

      if(K == 0) break;       // 더 이상 남은 금액이 없다면 종료
    }

    return count;
  }
}
