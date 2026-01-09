package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 회의실 배정 문제
* - 하나의 회의실에서 최대한 많은(Greedy) 회의가 진행될 수 있도록 스케줄을 배정하는 문제
* - 각 회의는 시작 시간과 종료 시간이 주어진다.
* - 결과는 배정된 회의의 개수를 반환
* - 회의실 개수 1개
* - N = 회의 개수
* - 각 회의는 [시작 시간, 종료 시간] 정보를 갖는다
*
* === 그리디 전략 ===
* - 종료 시간이 가장 빠른 회의부터 선택한다
* [왜?]
* - 회의가 빨리 끝나면 이후에 회의를 선택할 수 있는 남은 시간이 많아진다.
*
*  */
public class C_MeetingRoomScheduler {
  public static int solution(String input) throws IOException{
    BufferedReader br = new BufferedReader(new StringReader(input));

    // 첫 번째 줄 (회의의 개수) 읽어와서 저장
    int N = Integer.parseInt(br.readLine());

    // 회의 정보(시작, 종료) 기록
    //new int[2]; // 0: 시작 기록 , 1: 종료 시간 기록 1개만 하면 1개만 저장됨 .. 회의가 1개가 아니라 여러개 있으니까 2차원 배열로 해야함
    int[][] times  = new int[N][2];

    /* input에서 각 회의의 시작, 종료 시간을 읽어와 times 에 입력 */
    StringTokenizer st;
    for(int i = 0; i<N; i++){ // 회의 개수 만큼만 가져오기
      st = new StringTokenizer(br.readLine());
      times[i][0] = Integer.parseInt(st.nextToken());
      times[i][1] = Integer.parseInt(st.nextToken());
    }

    /* <<핵심>> 종료 시간 오름차순 정렬 */
    Arrays.sort(times, (t1, t2 ) -> {

      // 종료시간이 같을 경우 ?
      // 비는 시간 최대한 없이 효율적으로 쓰기
      // [1,3] , [2,3] , [3,5] 이렇게 생각했다고 치면
      // [2,3] [3,5]
      if(t1[1] == t2[1]) { // 종료 시간이 같을 경우
        // 1. 코드 일관성 (예측 가능성 향상)
        // 2. 정렬 안정성 떄문에 같은 시간 일때는 오름차순


        return t1[0] -t2[0]; // 시작 시간 빠른 순서로 정렬
      }


      return t1[1] - t2[1]; // 종료 시간 빠른 순서로 정렬

    }); // 1차원되는거아냐? 2차원도 왜 들어감? object는 모든 타입인거니까 여기서는 object는 int 배열인거임 // 람다식 적기 가능
    // 개수 반환이니까 count 반환
    int count = 0; // 배정된 회의 개수
    int endTime = 0; // 직전 회의의 종료 시간을 저장

    for(int i = 0; i<N; i++){ // N까지 모든 회의 탐색
      /* 현재 회의의 시작 시간이 이전 회의의 종료 시간 이후인지 확인하는 작업 진행
      - 맞을 경우 = 회의 배정 가능 상태
      -> 배정된 회의 개수 증가
       + 이전 회의 종료 시간 현재 종료 시간으로 갱신
      *  */

      if( times[i][0] >= endTime ){
        count++;
        endTime = times[i][1];
        System.out.printf("선택: [%d, %d] \n", times[i][0], times[i][1]);
      }
    }


    return count;
  }
}
