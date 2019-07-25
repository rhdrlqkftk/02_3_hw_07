package hw0725;
public class ProductMgr {
	private Product [] prcts;  
	private int index =0;  
	public ProductMgr() 
	{
		prcts = new Product[100]; // 객체 생성된거아니다. 자리 확보만 된거다.!
	}
	//제품추가
	public void addProduct( Product ppp)
	{
		if(index >= 0 && index <prcts.length)
		{
			prcts[index++]= ppp;
		}
		else
		{	
			index =0;
		}
	}
	// 전체 검색. 
	public void search()
	{
		for (int i = 0; i < index; i++) {
			System.out.println(prcts[i]);
		}
	}	
	// 상품 번호로 검색 
	public void isbnsearch(String isbn)
	{
		for (int i = 0; i < index; i++) 
		{
			if(prcts[i].isbn.equals(isbn))
			{
				System.out.println(prcts[i]);				
			}
		}
	}	
	// TV정보만,. 
	public void searchOnlyTV( )
	{
		for (int i = 0; i < index; i++) {
			if ((prcts[i] instanceof TV)) {
				System.out.println(prcts[i]);
			}
		}
	}
	// 냉장고 정보만 
	public void searchOnlyRefrizater( )
	{
		for (int i = 0; i < index; i++) {
			if ((prcts[i] instanceof Refrigerator)) {
				System.out.println(prcts[i]);
			}
		}
	}
	// 상품명 부분 검색. 
	
	public void searchByTitle( String title)
	{
		for (int i = 0; i < index; i++) 
		{
			if(prcts[i].getTitle().contains(title))
			{
				System.out.println(prcts[i]);
			}
		}
	}
	// 상품번호로 삭제
	public void Delate(String isbn )
	{
		for (int i = 0; i < index; i++) 
		{
			if( prcts[i].getIsbn().equals(isbn))
			{
				index--;
				prcts[i] = prcts[index];
				prcts[index] = null;	
			}
		}
	}

	// 저체 재고 상품 금액 구하기 . 
	public int Sum()
	{
		int sum =0;
		for (int i = 0; i < index; i++) {
			
			sum += prcts[i].price;
		}
		return sum;
	}
	public void print() {
		System.out.println("북매니저");
		System.out.println("0. 종료");
		System.out.println("1. 데이터입력");
		System.out.println("2. 데이터전체출력");
		System.out.println("3. 상품번호로 검색");
		System.out.println("4. 상품명검색(일부가능)");
		System.out.println("5. TV정보만 출력");
		System.out.println("6. 냉장고정보만 출력");
		System.out.println("7. 상품번호로 삭제");
		System.out.println("8. 가격 합계");
	
	}


}
