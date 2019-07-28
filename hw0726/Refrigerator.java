package PRO;

public class Refrigerator extends Product 
{
 
	private int Liter;
	public Refrigerator() {
		this("", "", 0 ,0, 0);
	}

	public Refrigerator(String isbn, String title, int price,int amount, int Liter) 
	{
		super(isbn, title, price, amount);
		this.Liter = Liter; 
	}	

	
	public int getLiter() {
		return Liter;
	}

	public void setLiter(int liter) {
		Liter = liter;
	}

	@Override
	public String toString() {
		return "Refrigerator:  " + super.toString() + " "+ Liter;
	}
}
