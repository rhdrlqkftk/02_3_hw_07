package ssafy1015;

import java.util.Scanner;

public class 경비원 {
	static int N,M; 
	static int sum =0;
	static int calcu( int a, int b)
	{
		int k=0;
		if( a ==1) // 북이라고 하면, 
		{
			k = b;
		}
		else if(a == 2)
		{
			k = N+M+(N-b); 
		}
		else if( a==3)
		{
			k= 2*N+ M +(M-b);
		}
		else if(a==4)//동
		{
			k = N + b; 
		}
		return k;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N = sc.nextInt(); // 가로
		M = sc.nextInt(); // 세로
		int len = 2*(N+M);
		
		int Num =sc.nextInt(); // 상점의 갯수 
		int arr[] = new int[Num];
		sum =0;
		int a, b; 
		for(int i=0; i< Num; i++)
		{
			a= sc.nextInt(); 
			b= sc.nextInt(); 
			arr[i] = calcu(a,b);
//			System.out.println(arr[i]);
		}
		a=  sc.nextInt(); 
		b=  sc.nextInt();
		int my_y = calcu(a,b);
		int sum =0;
		for(int i=0; i<arr.length; i++)
		{
			int g = Math.abs(my_y-arr[i]);
			int g1 = len-g;
			if( g>g1)
			{
				sum += g1; 
			}
			else 
			{
				sum += g;
			}
		}
		System.out.println(sum);
	}
}
