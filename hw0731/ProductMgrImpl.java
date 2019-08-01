package HW;

import java.util.List;

public interface ProductMgrImpl 
{
	void add(Product p); // #1 �߰� 
	List<Product> search();// #2 ��ǰ ��ü �˻�
	Product search(String isbn); // #3. ��ǰ  ��ȣ �˻�. 
	List<Product> searchByTitle(String title);  // #4. ��ǰ�� �Ϻ�  �˻�.
	
	List<TV> searchOnlyTV(); //#5 Only Tv�� �˻�
	List<Refrigerator> searchOnlyRefrigerator( ); //#6 Only �����. 
	List<Refrigerator> searchByLiter(); //#7 400L�̻��� Refrigerator�� �˻�. 
	List<TV> searchByTV(); //#8 50inch�̻��� Tv�� �˻�.
	int ChangeOfPrice(String isbn, int price);
	int DeleteofProduct(String isbn);
	int sum();
}
