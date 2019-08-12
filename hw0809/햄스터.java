import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1_1 {
	
	public static int max;
	public static String result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer line;
		
		try {
			int TC = Integer.parseInt(br.readLine());
			for(int t = 1 ; t <= TC ; t++) {
				max = -1;
				result = null;
				line = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(line.nextToken());
				int X = Integer.parseInt(line.nextToken());
				int M = Integer.parseInt(line.nextToken());
				int[][] range = new int[M][3];
				int[] G = new int[N];
				
				for(int i = 0 ; i < M ; i++) {
					line = new StringTokenizer(br.readLine());
					range[i][0] = Integer.parseInt(line.nextToken())-1;
					range[i][1] = Integer.parseInt(line.nextToken())-1;
					range[i][2] = Integer.parseInt(line.nextToken());
				}
				
				DFS(G,range,M,0,X);
				if(result == null) result = "-1";
				bw.write("#"+t+" "+result);
				bw.newLine();
			}
			bw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void DFS(int[] G, int[][] range, int M, int idx, int X) {
		
		if(idx == G.length) return;
		
		for(int i = 0 ; i < X+1 ; i++) {
			if(idx == G.length-1) {
				chk(range,G,M);
			}
			
			DFS(G,range,M,idx+1,X);
			G[idx]++;
			
		}
		G[idx] = 0;
		
	}
	
	public static void chk(int[][] range, int[] G, int M) {
		for(int i = 0 ; i < M ; i++) {
			int sum = 0;
			for(int j = range[i][0] ; j <= range[i][1] ; j++) {
				sum += G[j];
			}
			if(sum != range[i][2]) return;
		}
		
		int sum = 0;
		for(int i = 0 ; i < G.length ; i++) {
			sum += G[i];
		}
		
		if(sum > max) {
			max = sum;
			result = arrToString(G);
		} else if(sum == max && compare(arrToString(G), result) < 0) {
			result = arrToString(G);
		}
		
	}
	
	public static String arrToString(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < arr.length ; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		return sb.toString();
	}
	
	public static int compare(String o1, String o2) {
		StringTokenizer o1_st = new StringTokenizer(o1);
		StringTokenizer o2_st = new StringTokenizer(o2);
		while(o2_st.hasMoreTokens()) {
			int num1 = Integer.parseInt(o1_st.nextToken());
			int num2 = Integer.parseInt(o2_st.nextToken());
			
			if(num1 < num2) return -1;
			else if (num1 > num2) return 1;
		}
		
		return 0;
	}
	


}