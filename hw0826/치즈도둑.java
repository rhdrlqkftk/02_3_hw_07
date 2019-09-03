import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {
	static int N, Max, K; 
	static int Map[][] ;
	static boolean visit[][] ;
	static int Count[];
	static int dx[] = {0,-1,0,1}; 
	static int dy[] = {-1,0,1,0};
	static Queue<pair> qu = new LinkedList<pair>();
	static class pair
	{
		int x; 
		int y; 
		pair(int x1, int y1)
		{
			x =x1; 
			y =y1; 
		}
	}
	static boolean boundary(int x, int y)
	{
		if( x < 0 || y< 0 || x >= N || y >= N)
		{
			return false;
		}
		return true;
	}
	static void bfs(int x, int y, int time)
	{
		qu.add(new pair( x,y));
		while( !qu.isEmpty())
		{
			pair p = qu.poll();
			for (int i = 0; i < 4; i++) 
			{
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (!boundary(nx, ny))
				{
					continue;
				}
				if (visit[nx][ny] == false) 
				{
					if( Map[nx][ny]>time ) 
					{
						visit[nx][ny] = true;
						qu.add( new pair( nx,ny));
					}
					
				}
			}
		}
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int t =1;t <=T; t++)
		{
			N = sc.nextInt();
			Map = new int[N][N];
			for(int i =0 ; i<N; i++)
			{
				for(int j =0 ; j< N;j++)
				{
					Map[i][j] = sc.nextInt();
				}
			}
			int Max =1;
			int time =1;
			while( true)
			{
				if( time >100 )
				{
					break;
				}
				int cnt1=0;
				visit = new boolean[N][N];
				for(int i =0 ; i<N; i++)
				{
					for(int j =0 ; j< N;j++)
					{
						if(Map[i][j] > time && visit[i][j]== false)
						{
							cnt1++;
							bfs(i,j,time);
						}
					}
				}
				if ( Max < cnt1)
				{
					Max = cnt1; 
				}
				time++;
			}
			System.out.println("#"+t+ " "+ Max);
		}
	}
	
}
