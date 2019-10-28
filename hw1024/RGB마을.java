package ws1028;

import java.util.Scanner;

public class RGB마을 {
	static int N; 	
	static int Map[][];
	static int Map1[][];
	// R G B는 해당 집에 빨, 녹, 파 를 칠했을 때 비용을 말함. 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //집의 갯수. 
		Map = new int [N][3];
		Map1 = new int [N][3];
		for(int i=0; i <N; i++)
		{
			for(int j=0;j<3;j++) // 3개중에 하나 색깔. 
			{
				Map[i][j] = sc.nextInt();
			}
		}
		for( int i =0; i < 3; i++ )
		{
			// 처음 값 어떻게 해줄래?
			dfs(0, i, Map[0][i]);
		}
		int min = Integer.MAX_VALUE;
		for(int i =0; i <3; i++)
		{
			if (Map1[N-1][i] == 0 ) continue; 
			if( min > Map1[N-1][i])
			{
				min = Map1[N-1][i];
			}
		}
		System.out.println(min);
	}
	static void dfs(int height, int idx, int sum) 
	{
		//어떻게 하면 좋을까나.. 
		
		if( Map1[height][idx] !=0 )
		{
			if( Map1[height][idx] >sum )
			{
				Map1[height][idx] = sum; 
			}
			else
			{
				return ; 
			}
		}
		else 
		{
			Map1[height][idx] = sum;
		}
		if( height >= N-1) return;
		if( idx == 0)
		{
			dfs( height+1, 1, sum + Map[height+1][1]);
			dfs( height+1, 2, sum + Map[height+1][2]);
		}
		else if( idx == 1)
		{
			dfs( height+1, 0, sum + Map[height+1][0]);
			dfs( height+1, 2, sum + Map[height+1][2]);
		}
		else if( idx == 2)
		{
			dfs(  height+1, 0,sum + Map[height+1][0]);
			dfs(  height+1, 1,sum + Map[height+1][1]);
		}
	}
}
/*
3
1 100 100
100 100 100
1 100 100
*/