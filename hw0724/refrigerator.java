package com.HW;

public class refrigerator {

	private int number; 
	private String name; 
	private int price; 
	private int count; 
	private int amount;
	
	refrigerator(int num, String name, int price, int con, int amount)
	{
		this.number = num;
		this.name = name; 
		this.price = price; 
		this.count = con; 
		this.amount = amount; 
	}

	@Override
	public String toString() {
		return "refrigerator [number=" + number + ", name=" + name + ", price=" + price + ", count=" + count
				+ ", amount=" + amount + "]";
	}
	
}
