package com.HW;

import com.ssafy.Book;
import com.ssafy.Magazine;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("*************************���� ���*************************");	
		refrigerator r1 = new refrigerator(21424, "���ϳ�", 15000 ,15000,100);
		refrigerator r2 = new refrigerator(35355, "�ҳ���",30000 ,10000, 10);		
		Tv T3 = new Tv(44444, "������", 7000, 2018, 7,"A"); 
		
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		System.out.println(T3.toString());
	}
}