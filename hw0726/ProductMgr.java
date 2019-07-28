package PRO;

public class ProductMgr {
	
	private static ProductMgr mg = new ProductMgr();
	public static ProductMgr getInstance()
	{
		return mg; 
	}
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
	
	public int eachProductofAmount( String pro)
	{
		int num=0; 
		if (pro.equalsIgnoreCase("TV")) {
			num = 0;
			for (int i = 0; i < index; i++) {
				if (!(prcts[i] instanceof TV)) {
					num += prcts[i].getAmount();
				}
			}
		}
		else if(pro.equalsIgnoreCase("Refrigerator")) {
	         num = 0;
	         for (int i = 0; i < index; i++) 
	         {
	            if (!(prcts[i] instanceof Refrigerator)) {
	               num+=prcts[i].getAmount();
	            }
	         }
		}
		else 
		{
			 num = 0;
	         for (int i = 0; i < index; i++) {
	            if (!(prcts[i] instanceof SmartPhone)) {
	               num+=prcts[i].getAmount();
	            }
	         }
	      }
		return num;
	}
	
	// TV인지 냉장고인지 스마트폰인지 전달바다 각제품의 재고금액을 리턴하시오. 
	public int eachProductofCost( String pro)
	{
		int num = 0;
		if (pro.equalsIgnoreCase("TV")) {
			num = 0;
			for (int i = 0; i < index; i++) {
				if (!(prcts[i] instanceof TV)) {
					num += prcts[i].getPrice();
				}
			}
		}
		else if(pro.equalsIgnoreCase("Refrigerator")) {
	         num = 0;
	         for (int i = 0; i < index; i++) 
	         {
	            if (!(prcts[i] instanceof Refrigerator)) {
	               num+=prcts[i].getPrice();
	            }
	         }
		}
		else 
		{
			 num = 0;
	         for (int i = 0; i < index; i++) {
	            if (!(prcts[i] instanceof SmartPhone)) {
	               num+=prcts[i].getPrice();
	            }
	         }
	      }
	      return num;

	}
	// 스마트폰의 재고수량의 합계 
	// 냉장고의 리터 합계를 리턴한다. 
	// TV재고의 평균 인치를 구하라. 
	public int AvgOfInch()
	{
		int T_count = 0; 
		int sum =0;
		for (int i = 0; i < index; i++) 
		{
			if( prcts[i] instanceof TV )
			{
				TV t = (TV) prcts[i];
				sum += t.getInch();
				T_count+= t.getAmount(); 
			}
		}
		int avg = sum /T_count;  
		return avg ;
	}
	public int SumofRefrigerator()
	{	
		int sum=0;
		for (int i = 0; i < index; i++) 
		{
			if ((prcts[i] instanceof Refrigerator)) {
				sum += ((Refrigerator)prcts[i]).getLiter();
			}
		}
		return sum;
	}
	public int SpareOfSmartPhone()
	{
		int S_count = 0;
		for (int i = 0; i < index; i++) 
		{
			
			if( prcts[i] instanceof SmartPhone)
			{
				 
				S_count +=((SmartPhone)prcts[i]).getAmount(); 
			}
		}
		return S_count;
	}
	public Product[] GoodsOfIofo( String title , int price)
	{
		Product a[] = new Product[index];
		int k=0;
		for (int i = 0; i < index; i++) 
		{
			if(prcts[i].getTitle().contains(title) && prcts[i].getPrice() < price)
			{
				a[k++] =prcts[i];
			}
		}
		return a;
	}
	
	
	public void print() {
		System.out.println("북매니저");
		System.out.println("0. 종료");
		System.out.println("1. 데이터입력");
		System.out.println("2. 데이터전체출력");		
		System.out.println("3. Tv재고의 평균인치를 구하시오.");
		System.out.println("4. 냉장고의 리터합계를 구하시오.");
		System.out.println("5. 스마트폰의 재고 수량의 합을 리턴하시오. ");
		System.out.println("6. 파라메터로 Tv인지 냉장고인지 스마트폰인지 전달받아 각제품의 재고금액 리턴");
		System.out.println("7. 파라메터로 Tv인지 냉장고인지 스마트폰인지 전달받아 각제품의 재고수량 리턴");	
		System.out.println("8. 상품명(부분문자열 가능)과 금액을 전달하면 전달된 상품명을 포함하는 상품 중에서 파라메터로 전달된 검액보다 작은 금액의 상품들의 정보를 리턴");
	
	}


}
