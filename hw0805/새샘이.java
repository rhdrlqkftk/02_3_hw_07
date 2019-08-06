package solution;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
public class TestGGG
{
	static int arr[] = new int[7];
//	static PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	static HashSet<Integer> l = new HashSet<Integer>();
	static int sum = 0;
	static boolean visited[] = new boolean[7];
	static Scanner sc = new Scanner(System.in);

	static void dfs(int idx, int cnt) 
	{
		if (cnt == 3) {
			sum = 0;
			for (int i = 0; i < 7; i++) 
			{
				if (visited[i] == true) 
				{
					sum += arr[i];
					System.out.print(i+ " ");
				}
			}
			System.out.println();
			l.add(sum);
			return;
		}
		if (idx == 7)
			return;
		if (visited[idx] == true)
			return;
		visited[idx] = true;
		dfs(idx + 1, cnt + 1);
		visited[idx] = false;
		dfs(idx + 1, cnt);
	}
	public static void main(String[] args) {
		int Test = sc.nextInt();
		for (int t = 1; t <= Test; t++) {
			for (int i = 0; i < 7; i++)
			{
                visited[i] =false;
				arr[i] = sc.nextInt();
			}
			dfs(0, 0);
			
			List list = new ArrayList(l);
			Collections.sort(list); 
			Collections.reverse(list);
			System.out.println("#"+t +" "+ list.get(4));
			l.clear();
		}
	}
}