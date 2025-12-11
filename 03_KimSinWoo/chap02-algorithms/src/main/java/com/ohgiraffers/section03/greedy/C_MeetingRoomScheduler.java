package com.ohgiraffers.section03.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 회의실 배정 문제
*   - 하나의 회의실에서 최대한 많은 회의가 진행될 수 있도록 스케쥴을 배정하는 문제
*   - 각 회의는 시작, 종료 시간이 주어진다
*   - 결과는 배정된 회의의 개수를 반환
*
*   - 회의실 개수 1개
*   - N = 회의 개수
*   - 각 회의는 [시작 시간, 종료 시간] 정보를 갖는다
*
* === 그리디 전략 ===
* - 종료시간이 가장 빠른 회의부터 선택한다!
* [왜?]
* - 회의가 빨리 끝나면 이후에 회의를 선택할 수 있는 남은 시간이 늘어난다.
* -
* */
public class C_MeetingRoomScheduler {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));

        /* 회의의 수 */
        int N = Integer.parseInt(br.readLine());

        /* [N][0]: 시작, [N][1]: 종료 */
        int[][] times = new int[N][2];

        /* input에서 각 회의의 시작, 종료 시간을 읽어와 times에 입력 */
        StringTokenizer st;
        for (int i = 0; i < times.length; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        /* <핵심> 종료 시간 오름차순 정렬 */
        Arrays.sort(times, (t1, t2) -> {
            if (t1[1] == t2[1]) { // 종료 시간이 같을 경우
                // 1. 코드 일관성
                // 2. 정렬 안전성
                return t1[0] - t2[0]; // 시작 시간 빠른 순서로 정렬
            }
            return t1[1] - t2[1]; // 종료 시간 빠른 순서로 정렬
        });

        int count = 1; // 배정된 회의의 개수
        int endtime = times[0][1]; // 직전 회의의 종료 시간을 저장

        for (int i=1; i<N; i++) {
            /* 현재 회의의 시작 시간이 이전 회의의 종료 시간 이후인지 확인
            *   - 맞을 경우 == 회의 배정 가능!
            *       -> 배정된 회의 개수 증가 + 이전 회의 종료시간 현재 종료 시간으로 갱신
            * */
            if (times[i][0] >= endtime) {
                count++;
                endtime = times[i][1];
                System.out.printf("선택: [%d, %d]\n", times[i][0], times[i][1]);
            }

        }

        return count;
    }
}
