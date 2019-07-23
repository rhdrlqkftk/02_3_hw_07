import java.util.Scanner;

public class Test5pm {

	static int N;
	static int K;
	static int arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int cnt = 0;

			for (int i = 0; i < (1 << N); i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & (1 << j)) != 0) {
						sum += arr[j];
					}
				}
				if (sum == K) 
				{
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}
}
