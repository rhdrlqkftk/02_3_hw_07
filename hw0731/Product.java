package HW;

public class Product {

	protected String isbn; 
	protected String title; 
	protected int price; 
	protected int amount;
//	protected int deleted;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String isbn, String title, int price, int amount) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.amount = amount;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return " isbn=" + isbn + ", title=" + title + ", price=" + price + ", amount=" + amount ;
	}
	
}
