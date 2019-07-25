package hw0725;

public class Refrigerator extends Product 
{
	private int year; 
	private int month;  

	public Refrigerator() {
		this("", "", 0 ,0, 0, 0);
	}

	public Refrigerator(String isbn, String title, int price,int amount, int year, int month) 
	{
		super(isbn, title, price, amount);
		this.year= year;
		this.month = month; 
	}	

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	@Override
	public String toString() {
		return "Refrigerator:  " + super.toString() + " "+ year + "."+ month;
	}
}
