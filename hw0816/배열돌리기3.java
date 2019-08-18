import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int M;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };
	static int Map[][];
	static int temp[][];

	static void rotation(int R, int C) {

		if (C == 1) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					temp[i][j] = Map[N - i + 1][j];
				}
			}
		} else if (C == 2) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					temp[i][j] = Map[i][M - j + 1];
				}
			}
		} else if (C == 3) // 오른쪽으로 90도 회전.
		{
			int te = N;
			N = M;
			M = te;
			for (int i = 1; i <= N; i++) // 4
			{
				for (int j = 1; j <= M; j++) // 3
				{
					temp[i][j] = Map[M - j + 1][i];
				}
			}
		} else if (C == 4) // 왼쪽으로 90도 회전.
		{
			int te = N;
			N = M;
			M = te;
			for (int i = 1; i <= N; i++) // 4
			{
				for (int j = 1; j <= M; j++) // 3
				{
					temp[i][j] = Map[j][N + 1 - i];
				}
			}
		} else if (C == 5) // 이건 뭐지 . .
		{
			// 1 2 => 3 1
			// 3 4 4 2
			int prev[][] = new int[(N / 2) + 1][(M / 2) + 1];
			int next[][] = new int[(N / 2) + 1][(M / 2) + 1];
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					prev[i][j] = Map[i][j]; // 1
				}
			}

			// 1 = 3
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[i][j] = Map[(N / 2) + i][j];
				}
			}
			// 3 = 4
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[(N / 2) + i][j] = Map[(N / 2) + i][(M / 2) + j];
				}
			}
			// 4 = 2
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[(N / 2) + i][(M / 2) + j] = Map[i][(M / 2) + j];
				}
			}
			// 2 = 1
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[i][(M / 2) + j] = prev[i][j];
				}
			}
		} else if (C == 6) {
			// 1 2 => 2 3
			// 4 3 1 4
			int prev[][] = new int[(N / 2) + 1][(M / 2) + 1];
			int next[][] = new int[(N / 2) + 1][(M / 2) + 1];
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					prev[i][j] = Map[i][j]; // 1
				}
			}

			// 1 = 2
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[i][j] = Map[i][(M / 2) + j];
				}
			}
			// 2 = 3
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[i][(M / 2) + j] = Map[(N / 2) + i][(M / 2) + j];
				}
			}
			// 3 = 4
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[(N / 2) + i][(M / 2) + j] = Map[(N / 2) + i][j];
				}
			}
			// 4 = 1
			for (int i = 1; i <= N / 2; i++) {
				for (int j = 1; j <= M / 2; j++) {
					Map[(N / 2) + i][j] = prev[i][j];
				}
			}
		}
		if (C != 5 && C != 6) {

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					Map[i][j] = temp[i][j];
				}
			}
		}
	}

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		Map = new int[101][101];
		temp = new int[101][101];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				Map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < R; i++) {
			int C = sc.nextInt();
			rotation(R, C);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.print(Map[i][j] + " ");
			}
			System.out.println();
		}
	}
}