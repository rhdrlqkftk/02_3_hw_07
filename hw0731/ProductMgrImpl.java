package HW;

import java.util.List;

public interface ProductMgrImpl 
{
	void add(Product p); // #1 추가 
	List<Product> search();// #2 상품 전체 검색
	Product search(String isbn); // #3. 상품  번호 검색. 
	List<Product> searchByTitle(String title);  // #4. 상품명 일부  검색.
	
	List<TV> searchOnlyTV(); //#5 Only Tv만 검색
	List<Refrigerator> searchOnlyRefrigerator( ); //#6 Only 냉장고만. 
	List<Refrigerator> searchByLiter(); //#7 400L이상의 Refrigerator만 검색. 
	List<TV> searchByTV(); //#8 50inch이상의 Tv만 검색.
	int ChangeOfPrice(String isbn, int price);
	int DeleteofProduct(String isbn);
	int sum();
}
