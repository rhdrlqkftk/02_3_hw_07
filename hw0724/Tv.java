package com.HW;

public class Tv 
{
	private int number; 
	private String name; 
	private int price; 
	private int count; 
	private int inch;
	private String type;
	
	Tv(int num, String name, int price, int con, int inch, String type)
	{
		this.number = num;
		this.name = name; 
		this.price = price; 
		this.count = con; 
		this.inch = inch;  
		this.type = type; 
	}

	@Override
	public String toString() {
		return "Tv [number=" + number + ", name=" + name + ", price=" + price + ", count=" + count + ", inch=" + inch
				+ ", type=" + type + "]";
	}
	
}

/*
 * TV�� ����(��ǰ ��ȣ, ��ǰ �̸�, ����, ����, ��ġ, ���÷��� Ÿ
��)�� ǥ�� �ϱ� ���� Ŭ����
-Constructor, Encapsulation, toString() ����

 */