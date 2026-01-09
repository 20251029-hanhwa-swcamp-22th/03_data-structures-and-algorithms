package com.hyeonji.question1209;

import java.util.Scanner;

public class Application2 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int count = 0;
    int sum = 0;
    int max = 0;

    while(true){
      System.out.print("이름 입력: ");
      String name = sc.nextLine();

      if(name.equals("quit")) break;

      System.out.print("점수 입력: ");
      int score = sc.nextInt();
      sc.nextLine();

      count++;
      sum += score;
      if(score > max) max = score;
    }

    System.out.println("총 학생 수: " + count);
    System.out.println("평균 점수: " + (sum / (double)count));
    System.out.println("최고 점수: " + max);

  }

}

