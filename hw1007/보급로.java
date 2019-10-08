﻿package ssafy1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보급로 {
	static int N;
	static int Map[][];
	static int Memo[][];
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	static int Min;

	static boolean boundary(int x, int y) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}
		return true;
	}

	static class pair {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

	static Queue<pair> q = new LinkedList<pair>();

	static void bfs() {
		q.add(new pair(0, 0));
		while (!q.isEmpty()) {
			pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (!boundary(nx, ny))
					continue;
				int cost = Map[nx][ny] + Memo[p.x][p.y];
				if (Memo[nx][ny] > cost) {
					Memo[nx][ny] = cost;
					q.add(new pair(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			Map = new int[N][N];
			Memo = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				Arrays.fill(Memo[i], Integer.MAX_VALUE);
				for (int j = 0; j < N; j++) 
				{
					Map[i][j] = s.charAt(j) -'0';
				}
			}
			Memo[0][0] = 0;
			bfs();

			System.out.println("#" + tc + " " + Memo[N - 1][N - 1]);
		}
	}
}
/*
 * #1 2 #2 2 #3 8 #4 57 #5 151 #6 257 #7 18 #8 160 #9 414 #10 395
 */
