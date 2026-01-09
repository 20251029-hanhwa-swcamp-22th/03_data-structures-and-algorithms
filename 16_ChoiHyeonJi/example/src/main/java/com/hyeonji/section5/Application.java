package com.hyeonji.section5;

public class Application {
  public static void main(String[] args) {

    int a = 5;
    int b = 2;

    System.out.println(a / b);
    System.out.println((double) a / b);
    System.out.println(a % b);
    System.out.println(++a + b--);


    for (int i = 1; i <= 100; i++) {
      if (i % 3 == 0) {
        System.out.println(i + "는 3의 배수입니다.");
      }
    }


    int[] arr = {3, 6, 1, 9, 4};
    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }

    System.out.println("최댓값: " + max);



    int arr1[] = {5};




  }




}

