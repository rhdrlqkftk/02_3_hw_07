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
				mg.addProduct((new TV("123455", "LG�׷�", 100000, 2000, 2008, 12)));
				mg.addProduct((new Refrigerator("438483", "�Ｚ����", 100000, 234, 2000, 12)));
				mg.addProduct((new Refrigerator("2345234", "����ŸŸ", 40300, 500, 2001, 3)));
				mg.addProduct(new TV("1112355", "�������", 25040, 345, 2019, 7));
				mg.addProduct(new Product("126", "�����ڵ���", 2500, 324));
				mg.addProduct(new Product("12326", "�̷��ڵ���", 51100, 234));
			case 2:
				mg.search();
				break;
			case 3:
				System.out.println("ISBN?");
				sc.nextLine();
				String isbn = sc.nextLine();
				mg.isbnsearch(isbn);
				break;
			case 4: // ��ǰ������ �˻�.
				System.out.println("��ǰ������ �˻�?");
				sc.nextLine();
				String tt = sc.nextLine();
				mg.searchByTitle(tt);
				break;
			case 5: // Tv ������
				System.out.println("TV?");
				mg.searchOnlyTV();
				break;
			case 6: // �����
				System.out.println("�����?");
				mg.searchOnlyRefrizater();
				break;

			case 7: // ����
				System.out.println("����? (��ǰ��ȣ �Է��Ͻÿ�)");
				sc.nextLine();
				String isb = sc.nextLine();
				mg.Delate(isb);

			case 8: // ����
				System.out.println("�հ�");
				System.out.println(mg.Sum());

			}
		}
	}
}
