package HW;


public class TV extends Product 
{
	private int inch;
	public TV() {
		this("", "", 0 ,0, 0);
	}

	public TV(String isbn, String title, int price,int amount, int inch) 
	{
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
		return "TV:  " + super.toString() + " "+ inch ;
	}
}

