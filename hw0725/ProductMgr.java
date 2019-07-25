package hw0725;
public class ProductMgr {
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
	// ��ǰ ��ȣ�� �˻� 
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
	// TV������,. 
	public void searchOnlyTV( )
	{
		for (int i = 0; i < index; i++) {
			if ((prcts[i] instanceof TV)) {
				System.out.println(prcts[i]);
			}
		}
	}
	// ����� ������ 
	public void searchOnlyRefrizater( )
	{
		for (int i = 0; i < index; i++) {
			if ((prcts[i] instanceof Refrigerator)) {
				System.out.println(prcts[i]);
			}
		}
	}
	// ��ǰ�� �κ� �˻�. 
	
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
	// ��ǰ��ȣ�� ����
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

	// ��ü ��� ��ǰ �ݾ� ���ϱ� . 
	public int Sum()
	{
		int sum =0;
		for (int i = 0; i < index; i++) {
			
			sum += prcts[i].price;
		}
		return sum;
	}
	public void print() {
		System.out.println("�ϸŴ���");
		System.out.println("0. ����");
		System.out.println("1. �������Է�");
		System.out.println("2. ��������ü���");
		System.out.println("3. ��ǰ��ȣ�� �˻�");
		System.out.println("4. ��ǰ��˻�(�Ϻΰ���)");
		System.out.println("5. TV������ ���");
		System.out.println("6. ����������� ���");
		System.out.println("7. ��ǰ��ȣ�� ����");
		System.out.println("8. ���� �հ�");
	
	}


}
