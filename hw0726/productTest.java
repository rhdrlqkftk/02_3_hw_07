package PRO;

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
				mg.addProduct((new TV("123455", "LG그램", 100000, 2000, 2008)));
				mg.addProduct((new Refrigerator("438483", "삼성전자", 100000, 234,  12)));
				mg.addProduct((new Refrigerator("2345234", "도요타타", 40300, 500, 3)));
				mg.addProduct(new TV("1112355", "대우전자", 25040, 3, 7244));
				mg.addProduct(new TV("34432", "대우전자", 8540, 13,  363));
				mg.addProduct(new TV("115", "키뤼전자", 1040, 20,  855));
				mg.addProduct(new TV("55", "카멜라자", 240, 30,  42234));
				mg.addProduct((new Refrigerator("999", "삼성전자", 6000, 600,  2)));
				mg.addProduct((new Refrigerator("7774", "도요타타", 10300, 500, 3)));
				mg.addProduct((new Refrigerator("333", "삼자", 2300, 234,  12)));
				mg.addProduct((new Refrigerator("22224", "도리타라타", 1110, 900, 50)));
				mg.addProduct(new SmartPhone("8", "대자", 85, 1000,  3 , "화웨이"));
				mg.addProduct(new SmartPhone("10", "쉠성전자", 100, 7000, 140,"럭시"));
				mg.addProduct(new SmartPhone("15", "화웨이자", 851110, 16000,  3 , "화웨이"));
				mg.addProduct(new SmartPhone("11554", "노키아", 1060, 9000, 100,"삼성갤럭시"));
				
			case 2:
				mg.search();
				break;
			case 3:
				System.out.println("재고 인치의 평균은?");
				System.out.println(mg.AvgOfInch());
				break;
			
			case 4: //리터 합ㄱ계
				System.out.println("리터합계는?");
				System.out.println(mg.SumofRefrigerator());
				break;

			case 5: // Tv 
				System.out.println("스마트폰 재고 수량의 합께는?");
				System.out.println(mg.SpareOfSmartPhone());
				break;
			case 6:
				System.out.println("재고 수량 확인<입력 예시 ,Refrigerator, TV, SmartPhone>");
				sc.nextLine();
				String tt = sc.nextLine();
				System.out.println(mg.eachProductofAmount(tt));
				break;
			case 7: //
				System.out.println("재고 금액 확인<입력 예시 ,Refrigerator, TV, SmartPhone>");
				sc.nextLine();
				String tt1 = sc.nextLine();
				System.out.println(mg.eachProductofCost(tt1));
				break;
			case 8: // 삭제
				System.out.println(" 상품명과 금액을 입력하시오)");
				String num = sc.next();
				int price = sc.nextInt();
				Product[] kjw =mg.GoodsOfIofo(num, price);
				for (int i = 0; i < kjw.length; i++) {
					if( kjw[i] == null)continue;
					System.out.println(kjw[i]);
				}
				break;

			}
		}
	}
}
