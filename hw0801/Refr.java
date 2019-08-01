package HWHW;

import java.io.Serializable;

public class Refr extends product implements Serializable {
	private int liter;

	public Refr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getLiter() {
		return liter;
	}
	public void setLiter(int liter) {
		this.liter = liter;
	}
	public Refr(String isbn, String title, int price, int amount,int liter) {
		super(isbn, title, price, amount);
		this.liter = liter;
	}
	@Override
	public String toString() {
		return "Refr :  " + "isbn=" + isbn + ", title=" + title + ", price= " + price + ", amount= " + amount + " liter=" + liter;
	}	
}
