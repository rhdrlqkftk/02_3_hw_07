package HW;
import java.util.List;
import java.util.Scanner;


public class ProductTest {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		ProductMgr mg =ProductMgr.getInstance();
		while (true) {
			int userInput = sc.nextInt();
			switch (userInput) {
			case 0:
				System.exit(0);
				break;
			case 1:
				mg.add((new TV("123455", "LG그램", 100000, 2000, 2008)));
				mg.add((new Refrigerator("438483", "삼성전자", 100000, 234,  12)));
				mg.add((new Refrigerator("2345234", "도요타타", 40300, 500, 598)));
				mg.add(new TV("1112355", "대우전자", 25040, 3, 7244));
				mg.add(new TV("34432", "대우전자", 8540, 13,  363));
				mg.add(new TV("115", "키뤼전자", 1040, 20,  855));
				mg.add(new TV("55", "카멜라자", 240, 30,  42234));
				mg.add((new Refrigerator("999", "삼성전자", 6000, 600,  2)));
				mg.add((new Refrigerator("7774", "도요타타", 10300, 500, 3)));
				mg.add((new Refrigerator("333", "삼자", 2300, 234,  12)));
				mg.add((new Refrigerator("22224", "도리타라타", 1110, 900, 50)));
			case 2: //# 상품전체 검색. 
				List<Product> bs = mg.search();
				print(bs);
				break;
			case 3: // 상품번호로 검색
				System.out.println("ISBN?");
				String isn = sc.next();
				System.out.println(mg.search(isn).toString());
				break;
			case 4: // #4. 상품명 일부  검색.
				System.out.println("Title?");
				String tt = sc.next();
				List<Product> gs = mg.searchByTitle(tt);
				print(gs);
				break;
			case 5: // #5 TV정보만 검색 
				List<TV> gg = mg.searchOnlyTV();
				printm(gg);
				break; 
			case 6: // #6 Only 냉장고 정보만
				List<Refrigerator> gj = mg.searchOnlyRefrigerator();
				printmg(gj);
				break; 
			case 7: //400L이상의 Refrigerator만 검색. 
				List<Refrigerator> gz = mg.searchByLiter();
				printmg(gz);
				break; 
			case 8: 
				List<TV> gy = mg.searchByTV();
				printm(gy);
				break; 
			case 9: 
				System.out.println("수정할 상품번호와 가격 입력");
				String ddd = sc.next();
				int pp = sc.nextInt();
				mg.ChangeOfPrice(ddd, pp);
				break; 
			case 10: 
				System.out.println("상품 삭제?(번호입력)");
				String dd = sc.next();
				mg.DeleteofProduct(dd); 			
				break; 
			case 11: 
				System.out.print("가격 평균 구하기");
				System.out.println( mg.sum());
				break; 
			}
		}
		
	}

	public static void print(List<Product> bs) {
		System.out.println(" ====================== ");
		for (Product b : bs) 
		{
			System.out.println(b);
		}
	}
	public static void printm(List<TV> bs) {
		System.out.println(" ====================== ");
		for (TV b : bs) 
		{
			System.out.println(b);
		}
	}
	public static void printmg(List<Refrigerator> ds) {
		System.out.println(" ====================== ");
		for (Refrigerator b : ds) 
		{
			System.out.println(b);
		}
	}
}
	
//		void add(Product p); // #1 추가 
//		List<Product> search();// #2 상품 전체 검색
//		Product search(String isbn); // #3. 상품  번호 검색. 
//		List<Product> searchByTitle(String title);  // #4. 상품명 일부  검색.
//		List<Product> searchOnlyBooks(); // #5 TV정보만 검색 
		
//		List<TV> searchOnlyTV(); //#6 Only Tv만 검색
//		List<Refrigerator> searchOnlyRefrigerator(); //#7 Only 냉장고만. 
//		List<Refrigerator> searchByLiter(); //400L이상의 Refrigerator만 검색. 
//		List<TV> searchByTV(int inch); //# 50inch이상의 Tv만 검색.
//		void ChangeOfPrice(String isbn, int price);
//		void DeleteofProduct(String isbn);
//		int sum();