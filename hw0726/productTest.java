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
				mg.addProduct((new TV("123455", "LG�׷�", 100000, 2000, 2008)));
				mg.addProduct((new Refrigerator("438483", "�Ｚ����", 100000, 234,  12)));
				mg.addProduct((new Refrigerator("2345234", "����ŸŸ", 40300, 500, 3)));
				mg.addProduct(new TV("1112355", "�������", 25040, 3, 7244));
				mg.addProduct(new TV("34432", "�������", 8540, 13,  363));
				mg.addProduct(new TV("115", "Ű������", 1040, 20,  855));
				mg.addProduct(new TV("55", "ī�����", 240, 30,  42234));
				mg.addProduct((new Refrigerator("999", "�Ｚ����", 6000, 600,  2)));
				mg.addProduct((new Refrigerator("7774", "����ŸŸ", 10300, 500, 3)));
				mg.addProduct((new Refrigerator("333", "����", 2300, 234,  12)));
				mg.addProduct((new Refrigerator("22224", "����Ÿ��Ÿ", 1110, 900, 50)));
				mg.addProduct(new SmartPhone("8", "����", 85, 1000,  3 , "ȭ����"));
				mg.addProduct(new SmartPhone("10", "��������", 100, 7000, 140,"����"));
				mg.addProduct(new SmartPhone("15", "ȭ������", 851110, 16000,  3 , "ȭ����"));
				mg.addProduct(new SmartPhone("11554", "��Ű��", 1060, 9000, 100,"�Ｚ������"));
				
			case 2:
				mg.search();
				break;
			case 3:
				System.out.println("��� ��ġ�� �����?");
				System.out.println(mg.AvgOfInch());
				break;
			
			case 4: //���� �դ���
				System.out.println("�����հ��?");
				System.out.println(mg.SumofRefrigerator());
				break;

			case 5: // Tv 
				System.out.println("����Ʈ�� ��� ������ �ղ���?");
				System.out.println(mg.SpareOfSmartPhone());
				break;
			case 6:
				System.out.println("��� ���� Ȯ��<�Է� ���� ,Refrigerator, TV, SmartPhone>");
				sc.nextLine();
				String tt = sc.nextLine();
				System.out.println(mg.eachProductofAmount(tt));
				break;
			case 7: //
				System.out.println("��� �ݾ� Ȯ��<�Է� ���� ,Refrigerator, TV, SmartPhone>");
				sc.nextLine();
				String tt1 = sc.nextLine();
				System.out.println(mg.eachProductofCost(tt1));
				break;
			case 8: // ����
				System.out.println(" ��ǰ��� �ݾ��� �Է��Ͻÿ�)");
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
