package com.hyeonji.section6;

public class Book {

  String title;
  static int price;

  Book[] book = new Book[3];

  Book(String title, int price){
    this.title = title;
    this.price = price;
  }


  public static void main(String[] args) {


    Book arr[] = {
        new Book("홍길동전", 10000),
        new Book("강아지똥",8000),
        new Book("누룽지",15000)
    };

    for(Book B: arr){
        if (price >= 10000){
          System.out.println();
        }

    }
  }

  void getInfo(){
    System.out.println("제목 : " + title +"가격 : " +price );
  }
}
