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
				mg.add((new TV("123455", "LG�׷�", 100000, 2000, 2008)));
				mg.add((new Refrigerator("438483", "�Ｚ����", 100000, 234,  12)));
				mg.add((new Refrigerator("2345234", "����ŸŸ", 40300, 500, 598)));
				mg.add(new TV("1112355", "�������", 25040, 3, 7244));
				mg.add(new TV("34432", "�������", 8540, 13,  363));
				mg.add(new TV("115", "Ű������", 1040, 20,  855));
				mg.add(new TV("55", "ī�����", 240, 30,  42234));
				mg.add((new Refrigerator("999", "�Ｚ����", 6000, 600,  2)));
				mg.add((new Refrigerator("7774", "����ŸŸ", 10300, 500, 3)));
				mg.add((new Refrigerator("333", "����", 2300, 234,  12)));
				mg.add((new Refrigerator("22224", "����Ÿ��Ÿ", 1110, 900, 50)));
			case 2: //# ��ǰ��ü �˻�. 
				List<Product> bs = mg.search();
				print(bs);
				break;
			case 3: // ��ǰ��ȣ�� �˻�
				System.out.println("ISBN?");
				String isn = sc.next();
				System.out.println(mg.search(isn).toString());
				break;
			case 4: // #4. ��ǰ�� �Ϻ�  �˻�.
				System.out.println("Title?");
				String tt = sc.next();
				List<Product> gs = mg.searchByTitle(tt);
				print(gs);
				break;
			case 5: // #5 TV������ �˻� 
				List<TV> gg = mg.searchOnlyTV();
				printm(gg);
				break; 
			case 6: // #6 Only ����� ������
				List<Refrigerator> gj = mg.searchOnlyRefrigerator();
				printmg(gj);
				break; 
			case 7: //400L�̻��� Refrigerator�� �˻�. 
				List<Refrigerator> gz = mg.searchByLiter();
				printmg(gz);
				break; 
			case 8: 
				List<TV> gy = mg.searchByTV();
				printm(gy);
				break; 
			case 9: 
				System.out.println("������ ��ǰ��ȣ�� ���� �Է�");
				String ddd = sc.next();
				int pp = sc.nextInt();
				mg.ChangeOfPrice(ddd, pp);
				break; 
			case 10: 
				System.out.println("��ǰ ����?(��ȣ�Է�)");
				String dd = sc.next();
				mg.DeleteofProduct(dd); 			
				break; 
			case 11: 
				System.out.print("���� ��� ���ϱ�");
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
	
//		void add(Product p); // #1 �߰� 
//		List<Product> search();// #2 ��ǰ ��ü �˻�
//		Product search(String isbn); // #3. ��ǰ  ��ȣ �˻�. 
//		List<Product> searchByTitle(String title);  // #4. ��ǰ�� �Ϻ�  �˻�.
//		List<Product> searchOnlyBooks(); // #5 TV������ �˻� 
		
//		List<TV> searchOnlyTV(); //#6 Only Tv�� �˻�
//		List<Refrigerator> searchOnlyRefrigerator(); //#7 Only �����. 
//		List<Refrigerator> searchByLiter(); //400L�̻��� Refrigerator�� �˻�. 
//		List<TV> searchByTV(int inch); //# 50inch�̻��� Tv�� �˻�.
//		void ChangeOfPrice(String isbn, int price);
//		void DeleteofProduct(String isbn);
//		int sum();