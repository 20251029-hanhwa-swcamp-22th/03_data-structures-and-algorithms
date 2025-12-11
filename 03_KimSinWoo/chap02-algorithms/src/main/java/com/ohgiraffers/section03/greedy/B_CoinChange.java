package com.ohgiraffers.section03.greedy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

/* 주어진 N개의 동전을 이용하여 K원을 만들기 위한 최소 동전의 개수 */
public class B_CoinChange {

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전의 개수
        int K = Integer.parseInt(st.nextToken()); // 목표 금액
        int count = 0; // 최소 동전의 개수

        // 동전 종류 리스트 세팅
        int[] coins = new int[N];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coins.length-1; i >= 0; i--) {
            if (K >= coins[i]) { // 50010
                count += K/coins[i];
                K %= coins[i];
            }
            if (K==0) break;
        }

        return count;
    }

}
