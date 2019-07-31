package HW;

import java.util.List;

public interface ProductMgrImpl 
{
	void add(Product p); // #1 �߰� 
	List<Product> search();// #2 ��ǰ ��ü �˻�
	Product search(String isbn); // #3. ��ǰ  ��ȣ �˻�. 
	List<Product> searchByTitle(String title);  // #4. ��ǰ�� �Ϻ�  �˻�.
	List<Product> searchOnlyBooks(); // #5 TV������ �˻� 
	
	List<TV> searchOnlyTV(); //#6 Only Tv�� �˻�
	List<Refrigerator> searchOnlyRefrigerator( ); //#7 Only �����. 
	List<Refrigerator> searchByLiter(); //400L�̻��� Refrigerator�� �˻�. 
	List<TV> searchByTV(); //# 50inch�̻��� Tv�� �˻�.
	void ChangeOfPrice(String isbn, int price);
	void DeleteofProduct(String isbn);
	int sum();
}
