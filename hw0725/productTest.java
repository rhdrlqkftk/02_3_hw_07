package hw0725;

import java.util.Scanner;
public class productTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ProductMgr mg = new ProductMgr();
		while (true) {

			mg.print();
			int userInput = sc.nextInt();
			switch (userInput) {
			case 0:
				System.exit(0);
				break;
			case 1:
				mg.addProduct((new TV("123455", "LG그램", 100000, 2000, 2008, 12)));
				mg.addProduct((new Refrigerator("438483", "삼성전자", 100000, 234, 2000, 12)));
				mg.addProduct((new Refrigerator("2345234", "도요타타", 40300, 500, 2001, 3)));
				mg.addProduct(new TV("1112355", "대우전자", 25040, 345, 2019, 7));
				mg.addProduct(new Product("126", "현대자동차", 2500, 324));
				mg.addProduct(new Product("12326", "미래자동차", 51100, 234));
			case 2:
				mg.search();
				break;
			case 3:
				System.out.println("ISBN?");
				sc.nextLine();
				String isbn = sc.nextLine();
				mg.isbnsearch(isbn);
				break;
			case 4: // 상품명으로 검색.
				System.out.println("상품명으로 검색?");
				sc.nextLine();
				String tt = sc.nextLine();
				mg.searchByTitle(tt);
				break;
			case 5: // Tv 정보만
				System.out.println("TV?");
				mg.searchOnlyTV();
				break;
			case 6: // 냉장고만
				System.out.println("냉장고?");
				mg.searchOnlyRefrizater();
				break;

			case 7: // 삭제
				System.out.println("삭제? (상품번호 입력하시오)");
				sc.nextLine();
				String isb = sc.nextLine();
				mg.Delate(isb);

			case 8: // 가격
				System.out.println("합계");
				System.out.println(mg.Sum());

			}
		}
	}
}
