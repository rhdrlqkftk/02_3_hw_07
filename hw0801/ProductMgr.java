package HWHW;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductMgr implements IProductMgr {

	private ArrayList<product> prcts = new ArrayList<product>();
	private static ProductMgr mgr = new ProductMgr(); 	
	private ProductMgr()
	{
		prcts.clear();
	}
	public static ProductMgr getInstance()
	{
		return mgr;
	}
	private product findByIsbn(String isbn)
	{
		product p = null; 
		for(product nl : prcts )
		{
			if( nl.getIsbn().equals(isbn))
			{	
				p = nl;
			}
		}
		return p;
	}

	@Override
	public void add(product d) throws DuplicateException 
	{
		product np = findByIsbn(d.getIsbn());
		if( np == null)
		{
			prcts.add(d);
		}
		else
		{
			throw new DuplicateException();
		}
		//이미 존재할 떄 DuplicateEx
	}

	@Override
	public product search(String isbn) throws CodeNotFoundException 
	{
		product np = findByIsbn(isbn);
		if( np != null)
		{
			return np;
		}
		else
		{
			throw new CodeNotFoundException();
		}
	}
	public List<product> search()
	{
		return prcts;
	}
	
	@Override
	public List<Refr> searchOnly400Refr() throws ProductNotFoundException {
		List <Refr> pn = new ArrayList<>();
		int flag=0;
		for( product bb : prcts)
		{
			
			if(bb instanceof TV)continue;
			if(((Refr)bb).getLiter() >=400)
			{
				flag =1; 
				pn.add((Refr)bb);
			}
		}
		if( flag == 1)
		{
			return pn;
		}
		else 
		{
			throw new ProductNotFoundException();
		}
	}

	@Override
	public List<product> searchOnly50Tv() throws ProductNotFoundException 
	{
		List <product> pn = new ArrayList<>();
		for( product bb : prcts)
		{
			if(bb instanceof Refr)continue;
			if(((TV)bb).getInch() >=50)
			{
			
				pn.add(bb);
			}
		}
		if( pn.size() != 0)
		{
			return pn;
		}
		else 
		{
			throw new ProductNotFoundException();
		}
	}

	@Override
	public void open() 
	{
		String fname = "product.dat";
		File fbook = new File(fname);
		if( !fbook.exists())
		{
			return;
		}
		prcts.clear(); 
		ObjectInputStream ois = null;  
		try {
			ois = new ObjectInputStream(new FileInputStream(fbook));
			int count = ois.readInt(); // 질문 
			for (int i = 0; i <count; i++) 
			{
				product bb = (product)ois.readObject();
				prcts.add(bb);
			}
			System.out.println("Open Successfully~~~~~~");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() 
	{
		String fname = "product.dat";
		File fbook = new File(fname);
		if( !fbook.exists())
		{
			try {
				fbook.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ObjectOutputStream oos = null;
	    try {
			oos = new ObjectOutputStream(new FileOutputStream(fbook,false));
			oos.writeInt(prcts.size());
			for(product bb: prcts)
			{
				oos.writeObject(bb);
				oos.flush();
			}
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	    	if( oos != null)
	    	{
	    		try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
			System.out.println("Close Successfully~~~~~~");
	    }

	}

}
