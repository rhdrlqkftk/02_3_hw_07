package PRO;

public class SmartPhone extends Product {

	private int bender; 
	private String Model; 
	
	public SmartPhone() 
	{
		this("", "", 0 ,0, 0, "");
	}
	public SmartPhone(String isbn, String title, int price, int amount, int bender, String Model) 
	{
		super(isbn, title, price, amount);
		this.bender = bender; 
		this.Model = Model; 
	}
	public int getBender() {
		return bender;
	}
	public void setBender(int bender) {
		this.bender = bender;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	@Override
	public String toString() {
		return "SmartPhone : "+ super.toString() + bender + " " + Model ;
	}
}
