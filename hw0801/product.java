package HWHW;
import java.io.Serializable;
public class product implements Serializable
{
	protected String isbn; 
	protected String title; 
	protected int price; 
	protected int amount;
	//상속을 받아야하기 때문에 ..! 
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(String isbn, String title, int price, int amount) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "isbn=" + isbn + ", title=" + title + ", price=" + price + ", amount=" + amount ;
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
	
	
}

// 파일 IO
// 예외
// 정렬
	