package ws;

import java.util.List;

public class NewsTest {
	public static void main(String[] args) {
		NewsDao dao = NewsDao.getInstance(); 
		List<News> wes = dao.getNewsList();
		for (News w: wes) 
		{
			System.out.println(w);
		}
	}
	
}
