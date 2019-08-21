import java.util.Scanner;

public class Solution
{
	static int N, M;
	static int arr[] ; 
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int t= 1; t<=T;t++)
		{
			N = sc.nextInt(); 
			M = sc.nextInt();
			arr = new int[N+1];
			for(int i=1; i <=N; i++)
			{
				arr[i] = i; // 자기 자신을 대입한다. 
			}
			int x, a, b; 
			System.out.print("#"+ t + " ");
			for(int i =0 ; i < M;i++)
			{
				x = sc.nextInt();
				a = sc.nextInt();
				b = sc.nextInt();
				if( x == 0)
				{
					union(a,b);
				}
				else if( x == 1)
				{
					if(find(a) == find(b))
					{
						System.out.print(1);
					}
					else
					{						
						System.out.print(0);
					}
				}
			}
			System.out.println();
			
		}		
	}
	static int find( int x)
	{
		if( arr[x] ==x )
		{
			return x; 
		}
		else
		{
			int parent = find(arr[x]);
			arr[x] = parent;
			return parent;
		}		
	}
	static void union( int a, int b)
	{
		int p1 = find (a);
		int p2 = find (b);
		
		if( p1 != p2)
		{
			arr[p2] =p1;	
		}
	}
}


