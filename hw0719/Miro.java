package com.ssafy.edu;

import java.util.Scanner;

public class Mirozz {
	static int N;
	static int sx, sy, jc, flag =0;
	static int dx[] = new int[] { -1,0,1, 0 };
	static int dy[] = new int[]{ 0,1,0 ,-1 };
	static int map[][] = new int[][] {};
	static boolean boundary(int x, int y) {
		if (x <= 0 || y <= 0 || x > N || y > N || (map[x][y] ==2)) {
			return false;
		}
		return true;
	}

	static void make(int dir, int move)
	{
		int c = 0;
		while (c < move) // 5¶o¸e,.
		{
			sx = sx + dx[dir - 1];
			sy = sy + dy[dir - 1];
			if (boundary(sx, sy) == false)
			{
				sx = 0;
				sy = 0;
				flag = 1;
				break;
			}
			c++;
		}
	}	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 주관식 문제. (대문자)
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int jc = sc.nextInt();
			for (int i = 1; i <= N; i++)
			{
				for (int j = 1; j <= N; j++)
				{
					map[i][j] = 0;
				}
			}
			int r, c; 
			for (int i = 0; i < jc; i++)
			{

				r = sc.nextInt();
				c = sc.nextInt();
				map[r][c] = 2;
			}

			int dir_move; 
			int d, m; 
			flag = 0;
			dir_move = sc.nextInt();
			for (int i = 0; i < dir_move; i++)
			{
				d = sc.nextInt();
				m = sc.nextInt();
				if (flag == 1)break;
				make(d, m);
			}
			System.out.println("#" + t + " " + sx+ " "+sy);
		}
	}
}
