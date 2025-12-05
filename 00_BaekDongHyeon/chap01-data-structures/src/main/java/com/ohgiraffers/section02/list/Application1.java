package com.ohgiraffers.section02.list;

public class Application1 {
  public static void main(String[] args) {
    /* MyArrayList 테스트 */
    MyArrayList<Integer> myArrayList = new MyArrayList<>(3);
    myArrayList.add(10);
    myArrayList.add(20);
    myArrayList.add(30);
    myArrayList.add(40); // 용량 증가 확인

    /* 중간 삽입 확인 */
    myArrayList.add(2,999);



    /* get(), size() 확인 */
    for(int i=0 ; i< myArrayList.size() ; i++){
      System.out.println("get("+i+") = " + myArrayList.get(i));
    }


    System.out.println("==== 종료 ====");
  }
}
