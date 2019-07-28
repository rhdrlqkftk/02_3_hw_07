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
		prcts = new Product[100]; // ��ü �����Ȱžƴϴ�. �ڸ� Ȯ���� �ȰŴ�.!
	}
	
	//��ǰ�߰�
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
	// ��ü �˻�. 
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
	
	// TV���� ��������� ����Ʈ������ ���޹ٴ� ����ǰ�� ���ݾ��� �����Ͻÿ�. 
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
	// ����Ʈ���� �������� �հ� 
	// ������� ���� �հ踦 �����Ѵ�. 
	// TV����� ��� ��ġ�� ���϶�. 
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
		System.out.println("�ϸŴ���");
		System.out.println("0. ����");
		System.out.println("1. �������Է�");
		System.out.println("2. ��������ü���");		
		System.out.println("3. Tv����� �����ġ�� ���Ͻÿ�.");
		System.out.println("4. ������� �����հ踦 ���Ͻÿ�.");
		System.out.println("5. ����Ʈ���� ��� ������ ���� �����Ͻÿ�. ");
		System.out.println("6. �Ķ���ͷ� Tv���� ��������� ����Ʈ������ ���޹޾� ����ǰ�� ���ݾ� ����");
		System.out.println("7. �Ķ���ͷ� Tv���� ��������� ����Ʈ������ ���޹޾� ����ǰ�� ������ ����");	
		System.out.println("8. ��ǰ��(�κй��ڿ� ����)�� �ݾ��� �����ϸ� ���޵� ��ǰ���� �����ϴ� ��ǰ �߿��� �Ķ���ͷ� ���޵� �˾׺��� ���� �ݾ��� ��ǰ���� ������ ����");
	
	}


}
