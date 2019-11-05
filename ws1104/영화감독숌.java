package ws1104;

import java.util.Scanner;

public class 영화감독숌 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int N = sc.nextInt()-1; 
		int num = 666;
		while( 0 < N )
		{
			num++; 
			if( Integer.toString(num).contains("666"))
			{
				N--;
			}
		}
		System.out.println(num);
	}
}
