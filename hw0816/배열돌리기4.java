import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main 
{
	static int Minn;
	static int N , M, K; 
	static int Map[][];
	static Point[] user;
	static ArrayList<Point> L = new ArrayList<>();
	static int temp[][];
	static class Point
	{
		int x; 
		int y; 
		int size; 
		Point( int x, int y, int size)
		{
			this.x = x; 
			this.y = y;
			this.size = size; 
		}
	}
	static boolean boundary(int x, int y)
	{
		if( x <=0 || y <=0 || x >N || y >M)
		{
			return false; 
		}
		return true; 
	}
	
	static void dfs(int cnt)
	{
		if( cnt == K)
		{	
			
			for (int i = 0; i < user.length; i++) 
			{
				rotation(user[i].x, user[i].y, user[i].size);
			}
			int sum =0;
			for(int i=1;i<=N;i++)
			{
				sum =0;
				for(int j =1; j <=M;j++)
				{
					sum += Map[i][j]; 
				}
				if( Minn > sum)
				{
					Minn =sum;
				}
			}
			for(int d=1;d<=N;d++)
			{
				for(int j =1; j <=M;j++)
				{
					Map[d][j] = temp[d][j]; 
				}
			}
			return; 
		}
		int g = L.size();
		for(int i =0 ; i< g;i++)
		{		
			user[cnt] = L.remove(i);
			dfs(cnt+1);						
			L.add(i, user[cnt]);
		}
	}	
	static void rotation( int x, int y , int size)
	{
		for(int i =1; i<= size;i++)
		{
			int nx  = x + i; 
			int ny  = y + i; 
			if( boundary(nx,ny)==false)return;
			int prev = Map[nx][ny];
			int next = 0; 

			// 왼쪽으로 
			for(int j =1;j<(2*i+1);j++)	
			{
				ny = ny-1;
				next = Map[nx][ny];
				Map[nx][ny] = prev; 
				prev= next; 
			}

			// 위로 
			for(int j =1;j<(2*i+1);j++ )
			{
				nx = nx-1;
				next = Map[nx][ny];
				Map[nx][ny] = prev; 
				prev = next;
			}
			
			// 오쪽으로. 
			for(int j =1;j<(2*i+1);j++)	
			{
				ny = ny +1;
				next = Map[nx][ny];
				Map[nx][ny] = prev; 
				prev = next;	
			}
			
			// 아래로
			for(int j =1;j<(2*i+1);j++)	
			{
				nx = nx +1;
				next = Map[nx][ny];
				Map[nx][ny] = prev; 
				prev =next; 
			}
		}
	}
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Minn = Integer.MAX_VALUE;
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		user = new Point[K];
		Map = new int [N+1][M+1];  
		temp = new int[N+1][M+1];
		for(int i=1;i<=N;i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j =1; j <=M;j++)
			{
				Map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = Map[i][j];
 			}
		}	
		for(int i =0 ; i < K;i++)  // 연산의 갯수를 의미한다. 
		{
			int x,y,size;
			st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()); 
			y = Integer.parseInt(st.nextToken());
			size= Integer.parseInt(st.nextToken());
			L.add(new Point(x,y,size));
		}
		dfs(0);
		System.out.println(Minn);
	}
}