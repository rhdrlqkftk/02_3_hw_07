package ws0729;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_2 {
	static int N ,ans;
	static int arr[];
	static String s; 
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
	
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			s = sc.next(); 
			arr = new int[4];
			Arrays.fill(arr, 1000);
			ans=0;
			for (int i = 0; i < s.length(); i++) 
			{
				char a= s.charAt(i);
				if( a == '[')
				{
					arr[0]++;
				}	
				else if( a == ']')
				{
					arr[0]--;
				}
				else if ( a == '(')
				{
					arr[1]++;
				}
				else if( a == ')')
				{
					arr[1]--;
				}
				else if( a == '{')
				{
					arr[2]++;
				}
				else if( a== '}')
				{
					arr[2]--;
				}
				else if (a == '<')
				{
					arr[3]++;
				}
				else if( a == '>')
				{
					arr[3]--;	
				}
			}
			for( int i =0 ;i <4; i++)
			{
				if(arr[i] != 1000)
				{
					ans = 0;
					break;
				}
				else  ans =1;
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}