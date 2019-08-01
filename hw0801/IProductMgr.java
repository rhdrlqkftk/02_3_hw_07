package HWHW;

import java.util.List;

import WS.Book;
import WS.ISBNNotFoundException;
import WS.QuantityException;

public interface IProductMgr 
{
 // 상품 정보를 저장. ( 이미 존재하는 경우 Duplication발생 ) 
 //1
	void add(product d)throws DuplicateException;	
	product search(String isbn)throws CodeNotFoundException; 
	List<Refr> searchOnly400Refr( )throws ProductNotFoundException; 
	List<product> searchOnly50Tv()throws ProductNotFoundException;  
	List<product> search();

	void open();
	void close();
}
