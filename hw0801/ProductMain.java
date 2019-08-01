package HWHW;
import java.awt.geom.Area;
import java.util.List;
import java.util.Scanner;
import WS.Book;
public class ProductMain {
	static ProductMgr mgr = ProductMgr.getInstance();
	static Scanner  sc = new Scanner(System.in);
	public static void main(String[] args) {
		ProductMain m = new ProductMain();  
		int num =0; 
		while( true)
		{
			num = m.menu(); 
			if( num ==0)break;  
			switch (num)
			{
				case 1:
					m.TVadd(); 
					break; 
				case 2:
					m.Refradd();
					break;
				case 3: 
					m.print();
					break;  
				case 4 : 
					m.Goods();
					break;
				case 5 : 
					m.Re40();
					break;
				case 6 : 
					m.Tv50();
					break;
				case 7 : 
					m.close();
					break;
				case 8 : 
					m.open();	
					break;					
			}
		}
	}
	public  int menu() 
	{
		int result = 0;
		System.out.println("==================================");
		System.out.println("==========제품 정보 출력 ===========");
		System.out.println("==================================");
		System.out.println("1. TV 제품 추가하기 (isbn, title, price, amount ,inch ) ");
		System.out.println("2. 냉장고 제품 추가하기(isbn, title, price, amount , liter ) ");
		System.out.println("3. 제품 출력하기 ");
		System.out.println("4. 상품 번호로 제품 검색하기");
		System.out.println("5. 400L 이상의 Refri 검색");
		System.out.println("6. 50 inch 이상의 TV 검색");
		System.out.println("7. 파일에 상품정보를 저장");
		System.out.println("8. 파일로 부터 상품정보를 읽어옴");
		System.out.println("0. 종료 ");
		// ...

		result = sc.nextInt();
		return result;
	}
	public void TVadd() 
	{
		System.out.println("TV 제품 추가하기 (isbn, title, price, amount ,inch )");
		sc.nextLine();
		String ss = sc.nextLine();
		String[] sss = ss.split(",");// 007, 泥좎닔�빞 ���옄, 12000, 20
		try {
			mgr.add(new TV(sss[0].trim(), sss[1].trim(), Integer.parseInt(sss[2].trim()),
					Integer.parseInt(sss[3].trim()), Integer.parseInt(sss[4].trim())));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Refradd()
	{
		System.out.println("Refr 제품 추가하기 (isbn, title, price, amount ,inch )");
		sc.nextLine();
		String ss = sc.nextLine();
		String[] sss = ss.split(",");// 007, 泥좎닔�빞 ���옄, 12000, 20
		try {
			mgr.add(new Refr(sss[0].trim(), sss[1].trim(), Integer.parseInt(sss[2].trim()),
					Integer.parseInt(sss[3].trim()), Integer.parseInt(sss[4].trim())));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (DuplicateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void print() //제품 출력.
	{
		List<product> dd = mgr.search();
		for( product d : dd)
		{
			System.out.println(d);
		}
	}
	public void open() //제품 출력.
	{
		mgr.open();
	}
	public void close() //제품 출력.
	{
		mgr.close();
	}
	public void Re40 ()
	{
		try {
			List<Refr> ng = mgr.searchOnly400Refr();
			for( Refr d : ng)
			{
				System.out.println(d);
			}
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Tv50()
	{
		try {
			List<product> ng = mgr.searchOnly50Tv();
			for( product d : ng)
			{
				System.out.println(d);
			}
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Goods()
	{
		System.out.println("상품번호를 입력하세요!");
		String sd =sc.next();
		try {
			product d = mgr.search(sd);
			System.out.println(d);
		} catch (CodeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
