import java.util.Arrays;
import java.util.Scanner;

public class Test7 {

	static int arr[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {

			int N = sc.nextInt();
			int Q = sc.nextInt();
			arr = new int[N];
			Arrays.fill(arr, 0);
			for (int i = 1; i <= Q; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				for (int j = L - 1; j < R; j++) {
					arr[j] = i;
				}
			}

			System.out.println("#" + t + " ");
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}
