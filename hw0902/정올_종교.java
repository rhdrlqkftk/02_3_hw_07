import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 0234872
public class Solution5 {
	//내림 차순 또는 오름 차순으로 정렬이 된다. 
	// 정렬에 필요한 최소 
	static int N, M; 
	static int arr[]; 
	static int find(int x)
	{
		if( arr[x] ==x)
		{
			return x; 
		}
		arr[x] = find(arr[x]);
		return arr[x];
	}
	static void union(int x, int y)
	{
		int p1 = find(x);
		int p2 = find(y);
		if( p1!=p2)
		{
			arr[p2]=p1;
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr =  new int[N+1];
		for(int i =1; i <= N ; i++)
		{
			arr[i] = i;
		}
		for(int i=0 ; i< M; i++)
		{	
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}
		int cnt=0;
		for(int i =1; i <= N ; i++)
		{
			if( arr[i]== i)
			{
				cnt++;
			}
		}
		bw.write( cnt +"\n"); 
		bw.flush();
		bw.close();
	}
}

