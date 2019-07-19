package com.ssafy.edu;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.Scanner;

import java.util.StringTokenizer;

 

public class Robot {

 

	static int N, cnt;

	static int Max;

	static int[] dx = new int[] { 0, 1, 0, -1 };

	static int[] dy = new int[] { 1, 0, -1, 0 };

	static char[][] Map;

 

	static boolean boundary(int x, int y) {

		if (x < 0 || y < 0 || x >= N || y >= N) {

			return false;

		}

		return true;

	}

 

	static void dir_ch(char c, int x, int y) {

		if (c == 'A') {

			while (boundary(x, y)) {

				x = x + dx[0];

				y = y + dy[0];

				if (boundary(x, y) == true && Map[x][y] == 'S') {

					cnt++;

				} else {

					break;

				}

			}

		} else if (c == 'B') {

			for (int i = 0; i < 2; i++) {

				i = i * 2;

				int nx = x;

				int ny = y;

				while (boundary(nx, ny)) {

					nx = nx + dx[i];

					ny = ny + dy[i];

					if (boundary(nx, ny) == true && Map[nx][ny] == 'S') {

						cnt++;

					} else {

						break;

					}

				}

			}

		} else if (c == 'C')// 벽이거나

		{

			for (int i = 0; i < 4; i++) {

				int nx = x;

				int ny = y;

				while (boundary(nx, ny)) {

					nx = nx + dx[i];

					ny = ny + dy[i];

					if (boundary(nx, ny) == true && Map[nx][ny] == 'S') {

						cnt++;

					} else {

						break;

					}

				}

			}

		}

	}

 

	public static void main(String[] args) throws Exception {

	

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 주관식 문제. (대문자)

		for (int t = 1; t <= T; t++) {

			Map = new char[21][21];

			cnt=0;

			N = sc.nextInt();

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					Map[i][j] = sc.next().charAt(0);

				}

			}

			for (int i = 0; i < N; i++) {

				for (int j = 0; j < N; j++) {

					if (Map[i][j] != 'S' && Map[i][j] != 'W') {

						dir_ch(Map[i][j], i, j);

					}

				}

			}

			System.out.println("#" + t + " " + cnt);

		}

	}

 

}