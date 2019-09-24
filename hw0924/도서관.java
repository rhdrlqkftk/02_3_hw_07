import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//회의실 배정
// 도서관  
// 둘다 풀어보기 좋은 문제 인거 같다. 
public class Solution4 {
	static int N; 
	static int Map[]; 
	static class Point implements Comparable<Point>
	{
		int x; 
		int y; 
		Point( int x, int y)
		{
			this.x =x; 
			this.y =y; 
		//	this.size = size; 
		}
		@Override
		public int compareTo(Point o) {
			if( o.x == this.x)
			{
				return this.y -o.y ; 
			}
			return this.x - o.x;
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		PriorityQueue<Point> q = new PriorityQueue<Point>();

		for(int i =0 ; i< N ;i++)
		{		
			int start = sc.nextInt(); 
			int end   = sc.nextInt(); 
			q.add(new Point( start, end));
		}
		int OnePersonLongTime =0; 
		int WithOutPeopleTime =0;
		int maxOnePer =0; 
		int NoOnePer =0; 
		Point p = q.poll(); 
		int sx = p.x;
		int sy = p.y;
		while(!q.isEmpty())
		{
			maxOnePer =0; 
			NoOnePer =0; 
			Point p1 = q.poll();
//			System.out.println(p1.x + " , "+ p1.y);

			int fx = p1.x; 
			int fy = p1.y; 
	//		System.out.println(fx+ " " + fy);
			if( fx <= sy)
			{
				if( fy >= sy)
				{
					maxOnePer =fy-sx; 					
					sy = fy;
				}
				else if( fy< sy)
				{
					maxOnePer =sy-sx; 
				}
			}
			else if( fx > sy)//범위를 벗어났을 때, 
			{
				if( fy-fx > sy-sx)
				{
					maxOnePer  = fy-fx ;
					
				}
				else if(fy-fx < sy-sx )
				{
					maxOnePer  = sy-sx ;
				}
				NoOnePer  =fx-sy; // 한명도 안머물렀던 시간. 
				sx = fx; 
				sy = fy;
			}
	//		System.out.println("--------------------");
			if( maxOnePer > OnePersonLongTime )
			{
	//			System.out.println("maxOnePer: "+ maxOnePer);
				OnePersonLongTime = maxOnePer;
			}
			if(NoOnePer > WithOutPeopleTime)
			{
	//			System.out.println("NoOnePer: "+NoOnePer);
				WithOutPeopleTime = NoOnePer;
			}
		}
		System.out.println(OnePersonLongTime+ " "+ WithOutPeopleTime);
	}
}
