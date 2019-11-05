import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {
	static int R, C; 
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0}; 
	static Scanner sc= new Scanner(System.in);
	static char Map[][]; 
	static int VMap[][]; 
	static Queue<pair> q= new LinkedList<>(); 
	static Queue<pair> st= new LinkedList<>(); 
	static class pair
	{
		int x; 
		int y; 
		pair( int x1, int y1)
		{
			x = x1; 
			y = y1; 
		}
	}
	static boolean boundary(int x, int y)
	{
		if( x <0 || y < 0 || x >= R || y >= C) 
		{
			return false; 
		}
		return true; 
	}
	public static void main(String[] args) 
	{
		R= sc.nextInt(); 
		C= sc.nextInt(); 
		int lx=0; 
		int ly=0;
		Map= new char[R][C];
		VMap= new int[R][C];
		char Map[][] = new char[R][C];
		for (int i = 0; i < R; i++) 
		{
			String s = sc.next(); 
			for (int j = 0; j < s.length(); j++) 
			{
				Map[i][j] = s.charAt(j);
				if(Map[i][j]== 'S') // 고슴도치가 start
				{
					st.add(new pair(i,j));
					Map[i][j]= '.';
					VMap[i][j]= 1;
				}
				if(Map[i][j]== '*' )
				{
					q.add(new pair(i,j));
				}
			}
		}
		boolean chk = false; 
		int time =1;
		label:
		while( true)
		{
			int size = q.size();
			for(int ti =0; ti<size;ti++)
			{
				pair p1 = q.poll();  
				for(int d=0; d<4; d++)
				{
					int nx = p1.x + dx[d]; 
					int ny = p1.y + dy[d];
					if(!boundary(nx,ny))continue; 
					if(Map[nx][ny] == '.')
					{
						Map[nx][ny] ='*';
						q.add(new pair( nx,ny));
					}
				}
			}
			//////// 이러면 물을 먼저 채워주었고.  
			int bsize = st.size();  
			for(int ti =0; ti<bsize;ti++)
			{
				pair p1 = st.poll();  
				for(int d=0; d<4; d++)
				{
					int nx = p1.x + dx[d]; 
					int ny = p1.y + dy[d];
					if(!boundary(nx,ny))continue; 
					if(Map[nx][ny] =='D' )
					{
						chk = true;
						break label;
					}
					if(VMap[nx][ny] == 0 && Map[nx][ny] =='.')
					{
						VMap[nx][ny] = time;
						st.add(new pair( nx,ny));
					}
				}
			}
			time++;
			if(st.isEmpty())
			{
				break;
			}
		}
		if( chk == false)
		{
			System.out.println("KAKTUS");
		}
		else 
		{
			System.out.println(time);
		}
		
	}
}
