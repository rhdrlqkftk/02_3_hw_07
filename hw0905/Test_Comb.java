

import java.util.Arrays;

public class Test_Comb {
	static int[] arr = { 1, 2, 3, 4, 5, 6 };
	static int[] visit = new int[arr.length];
	static int[][] result = new int[arr.length/2][2];
	
	public static void main(String[] args) {
		Arrays.fill(visit, -1);
		comb(0);
		System.out.println(cnt);
	}
static int cnt=0;
	static void comb(int d) {
		if(d==arr.length/2) {
			cnt++;
			System.out.println(Arrays.deepToString(result));
			return;
		}
		
		
		for(int i=0; i<arr.length; i++) {
			if(visit[i]==-1) {
				result[d][0] = arr[i];
				visit[i] = d;
				for(int j=i+1; j<arr.length; j++) {
					if(visit[j]==-1) {
						result[d][1] = arr[j];
						visit[j] = d;
						comb(d+1);
						visit[j] = -1;
					}
				}
				visit[i]=-1;
			}
		}
	}
}
