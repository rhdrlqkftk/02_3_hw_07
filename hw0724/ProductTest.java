package com.HW;

import com.ssafy.Book;
import com.ssafy.Magazine;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*************************도서 목록*************************");	
		refrigerator r1 = new refrigerator(21424, "김하나", 15000 ,15000,100);
		refrigerator r2 = new refrigerator(35355, "소나무",30000 ,10000, 10);		
		Tv T3 = new Tv(44444, "김정원", 7000, 2018, 7,"A"); 
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(T3.toString());
	}
}