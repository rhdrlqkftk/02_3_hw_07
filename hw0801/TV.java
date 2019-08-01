package HWHW;

import java.io.Serializable;

public class TV extends product implements Serializable {
	private int inch; 
	public TV() 
	{
		this("", "", 0 ,0, 0);
		// TODO Auto-generated constructor stub
	}
	public TV(String isbn, String title, int price, int amount, int inch) {
		super(isbn, title, price, amount);
		this.inch = inch; 
	}
	
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	@Override
	public String toString() {
		return "TV :  isbn = " + isbn + ", title=" + title + ", price=" + price + ", amount=" + amount + "inch = " + inch ;
	}
}
