import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int H, W, N ,Max, ans;
	static int tmp[][]= new int[2][2];
	static boolean select[];
	static boolean select1[];
	static List<sticker> l = new LinkedList<>();
	static class sticker 
	{
		int x; 
		int y; 
		int size; 
		sticker(int x1, int y1, int size1)
		{
			x = x1; 
			y = y1; 
			size = size1;
		}
	}

	static void solve()
	{
		if( l.size() <2)
		{
			System.out.println( 0 );
			return; 
		}
		dfs(0,0);
		System.out.println(Max);
	}
	static  sticker [] s ;
	static void dfs( int idx, int cnt)
	{
		if( cnt == 2)
		{
			int x = tmp[0][0];
			int y = tmp[0][1];
			int x1 = tmp[1][0];
			int y1 = tmp[1][1];
			int size1 = (x*y) + (x1* y1);
			/// 
			if( x + x1 <= H)
			{
				int ty = Math.max( y, y1);
				if (ty <= W) 
				{
					if (Max < size1) {
						Max = size1;
					}
				}

			}
			if( y + y1 <= W)
			{
				int tx = Math.max( x, x1);
				if (tx <= H) 
				{
					if (Max < size1) {
						Max = size1;
					}
				}	
			}	
			return ; 
		}
		for(int i =idx ; i<l.size(); i++)
		{
			// 이미 쓴거라면 안써야지 
			if( select[i] == true || select1[l.get(i).size] ==true)
			{
				continue;
			}
			select[i] =true; 
			select1[l.get(i).size] = true; 
			tmp[cnt][0] = l.get(i).x;
			tmp[cnt][1] = l.get(i).y; 
			dfs( i, cnt+1);
			tmp[cnt][0] = 0;
			tmp[cnt][1] = 0;
			select[i] = false; 
			select1[l.get(i).size] = false; 
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			int nsize = nx * ny; 
			if( nsize > H * W )
			{
				continue;
			}	
			if( nx != ny)
			{
				l.add( new sticker( nx, ny , i));
				l.add( new sticker( ny, nx , i));
			}
			else
			{
				l.add( new sticker( ny, nx , i));
			}
		}
		Max =0;
		select = new boolean[201];
		select1 = new boolean[201];
		solve();
		
		bw.flush();
		bw.close();
	}

}

/*
10  
7 2 9   
1 1 7 1 
2 1 7 1
5 1 5 4
3 2 8 4 
4 3 14 1
3 4 3 3 
1 5 8 2 
3 5 100 1
5 5 1 1
*/
