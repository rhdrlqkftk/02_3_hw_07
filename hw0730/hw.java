package ws0730;

import java.util.Scanner;
import java.util.Stack;
class tog
{
	int num;
	int val;
	public tog(int num, int val) {
		super();
		this.num = num;
		this.val = val;
	}
}
public class Test1111 
{
	static int arr[]; 
	static int N; 
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt() ;  
		int temp [] = new int[N+1];
		Stack <tog> st = new Stack<>();
		for(int i = 0 ; i< N;i++)
		{
			int current =sc.nextInt();
			if( st.isEmpty()) // 비어 있다면. 
			{
				temp[i] = 0;
			}
			else
			{
				while( !st.isEmpty() )// 비어질 때까지.
				{
					if( st.peek().val < current)
					{
						st.pop();
						if( st.isEmpty()) temp[i] =0;
					}
					else // 높거나 같으면 st 값을 넣어줘.  
					{
						temp[i] = st.peek().num;
						break;
					}
				}
			}
			st.push(new tog(i+1, current));
		}
		for(int i =0 ; i<N;i++)
		{
			System.out.print(temp[i] + " ");
		}
	}
}
