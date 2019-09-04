import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int Map[][] ; 
	static boolean visit[][] ;
	static int N, M, Max , sum; 
	static int dx[] = {0,1,0,-1}; 
	static int dy[] = {1,0,-1,0};
	static List<Pair> l = new LinkedList<Pair>();
	static class Pair
	{
		int x; 
		int y; 
		Pair(int x1, int y1)
		{
			x = x1; 
			y = y1; 
		}
	}
	static boolean boundary(int x, int y)
	{
		if( x < 0 || y < 0|| x >= N || y >= M)
		{
			return false; 
		}
		return true; 
	}
	static void chkk()
	{
		sum =0;
		visit = new boolean[N][M];
		for(int i =0 ; i< l.size(); i++)
		{
			int x = l.get(i).x; 
			int y = l.get(i).y; 
			if( visit[x][y]== true)
			{
				continue; 
			}
			sum += dfs( x, y);
		}
		if( Max <sum)
		{
			Max = sum; 
		}
		return; 
	}
	static int dfs(int x , int y)  //모두 2개로 바꿈. 
	{
		
		int count =1;
		Queue<Pair> q = new LinkedList<>();
		q.add( new Pair( x, y));
		visit[x][y]= true;
		boolean chk =false;
		while(! q.isEmpty())
		{
			Pair p = q.poll();  
			for(int j =0 ; j <4; j++)
			{
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];
				if( !boundary(nx,ny)) // 경계넘으면 컨티뉴
				{
					continue;
				}
				if( visit[nx][ny] == true) // 방문한적있으면 컨티뉴
				{
					continue; 
				}
				if( Map[nx][ny] == 0)
				{
					chk = true;
				}
				else if( Map[nx][ny] == 2)
				{
					count++;
					visit[nx][ny] = true;
					q.add(new Pair( nx, ny));
				}
			}
		}
		if( chk== true)
		{
			count =0;
		} 
		return count;
	}
	static void bfs(int x, int y)
	{
		// 일단은 최적화 필요하다. idx라고 두고 나눠서하면 되겠지 뭐 씨불.  
		for(int i =0 ; i < N ;i++)
		{
			for(int j =0; j< M ; j++)
			{
				if( Map[i][j] ==0 )
				{
					Map[i][j] =1; 
					chkk(); 
					Map[i][j] =0;
				}
			}
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Max = 0;
		Map = new int[N][M];
		for(int i=0; i< N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j =0 ;j < M;j++)
			{
				Map[i][j] = Integer.parseInt(st.nextToken());
				if( Map[i][j] ==2)
				{
					l.add( new Pair( i,j));
				}
			}
		}
		for(int i =0 ; i < N ;i++)
		{
			for(int j =0; j< M ; j++)
			{
				if( Map[i][j] == 0)
				{
					Map[i][j] =1;
					bfs( i, j );
					Map[i][j] =0;
				}
			}
		}
		
		//1은 나의 돌, 2는 상대의 돌. 
		// 현재 판에서 돌 두개를 둔다고? 
		bw.write(Max+ "\n");
		bw.flush();
		bw.close();
	}

}
