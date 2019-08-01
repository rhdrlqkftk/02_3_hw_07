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
	private ProductMgr()// 생성자를 private으로 만들어야한다. 
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
	public void add(Product p) // 상품 정보를 저장. 
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
	public Product search(String isbn) 
	{
		//
		return  findByISBN(isbn);
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
	public List<TV> searchOnlyTV() 
	{
		List<TV> nprcts = new ArrayList<>();
		for( Product pp : prcts )
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
	public int ChangeOfPrice(String isbn, int price) {
		//상품 번호와 가격을 입력 받아서 		
		int flag =0;
		for(Product pp : prcts)
		{
			if( pp.getIsbn().endsWith(isbn))
			{
				pp.setPrice(price);
				flag=1;
			}
		}
		return flag;
	}

	@Override
	public int DeleteofProduct(String isbn) 
	{
		int flag1 =0;
		for (int i = 0; i < prcts.size(); i++) 
		{
			if(prcts.get(i).getIsbn().equals(isbn))
			{
				flag1 =1;
				prcts.remove(i);
			}
		}
		return flag1;
	}

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
