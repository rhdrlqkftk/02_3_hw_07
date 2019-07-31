package HW;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductMgr implements ProductMgrImpl {
	
	private ArrayList<Product> prcts = new ArrayList<>();
	private static ProductMgr prdmgr = new ProductMgr();
	public static ProductMgr getInstance()
	{
		return prdmgr;
	}
	private ProductMgr()// �����ڸ� private���� �������Ѵ�. 
	{
		prcts.clear();
	}
	private Product findByISBN(String isbn)
	{
		Product p = null; 
		
		for(Product pp : prcts )
		{
			if(pp.getIsbn().equals(isbn))
			{
				p = pp;
			}
		}
		return p;
	}

	@Override
	public void add(Product p) // ��ǰ ������ ����. 
	{		
		Product pp = findByISBN(p.getIsbn());
		if( pp== null)
		{
			prcts.add(p);
		}
	}
	@Override
	public List<Product> search() 
	{
		
		return prcts;
	}

	@Override
	public Product search(String isbn) {
		return findByISBN(isbn);
	}

	@Override
	public List<Product> searchByTitle(String title) 
	{
		List<Product> nprcts = new ArrayList<>();
		for(Product pp : prcts)
		{
			if(pp.getTitle().contains(title))
			{
				nprcts.add(pp);
			}
		}
		return nprcts;
	}
	@Override
	public List<Product> searchOnlyBooks() 
	{
		List<Product> nprcts = new ArrayList<>();
		for( Product pp : prcts)
		{	
			if( !(pp instanceof TV)&& !(pp instanceof Refrigerator))
			{
				nprcts.add(pp); 
			}
		}
		return nprcts;
	}
	@Override
	public List<TV> searchOnlyTV() 
	{
		List<TV> nprcts = new ArrayList<>();
		for( Product pp : prcts)
		{
			if(pp instanceof TV) 
			{
				nprcts.add((TV)pp);
			}
		}
		return nprcts;
	}

	@Override
	public List<Refrigerator> searchOnlyRefrigerator() 
	{
		List<Refrigerator> nprcts = new ArrayList<>();
		for( Product pp : prcts)
		{
			if(pp instanceof Refrigerator) 
			{
				nprcts.add((Refrigerator)pp);
			}
		}
		return nprcts;
	}

	@Override
	public List<Refrigerator> searchByLiter() 
	{
		List<Refrigerator> nprcts = new ArrayList<>();
		int flag=0;
		for(Product pp : prcts )
		{
			if(pp instanceof TV)continue;
			if(((Refrigerator)pp).getLiter() >= 400 )
			{
				nprcts.add((Refrigerator)pp);
				flag=1;
			}
		}
		if( flag == 0) return null;
		return nprcts;
	}
	@Override
	public List<TV> searchByTV() 
	{
		List<TV> nprcts = new ArrayList<>();
		for(Product pp : prcts)
		{
			if(pp instanceof Refrigerator)continue;
			if(((TV)pp).getInch() >=50 )
			{
				nprcts.add((TV)pp);
			}
		}
		return nprcts;
	}
	@Override
	public void ChangeOfPrice(String isbn, int price) {
		//��ǰ ��ȣ�� ������ �Է� �޾Ƽ� 		
		for(Product pp : prcts)
		{
			if( pp.getIsbn().endsWith(isbn))
			{
				pp.setPrice(price);
	//			System.out.println("�ٲ� �� : " + pp);
			}
		}
	}

	@Override
	public void DeleteofProduct(String isbn) 
	{
		for (int i = 0; i < prcts.size(); i++) 
		{
			if(prcts.get(i).getIsbn().equals(isbn))
			{
				prcts.remove(i);
			}
		}
	}
	/*
	if(pp.getIsbn().equals(isbn))
	{}
	*/

	@Override
	public int sum()
	{	
		int sum =0;
		for(Product pp: prcts)
		{
			sum += pp.getPrice();
		}
		return sum;
	}
}
