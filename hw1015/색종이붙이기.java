package ws1016;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 색종이붙이기 {
	static int min;
	static int Map[][]= new int [10][10];
	static boolean boundary( int x, int y )
	{
		if( x <0 || y < 0 || x >=10 || y >= 10)
		{
			return false; 
		}
		return true;
	}
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		
		int cnt =0;
		for(int i =0;i<10; i++)
		{
			for(int j =0 ; j< 10;j++)
			{
				Map[i][j] = sc.nextInt();
				if( Map[i][j] == 1) 
				{
					cnt++;
				}
			}
		}
		if( cnt ==0)
		{
			System.out.println(0);
		}
		else
		{
			int arr[] ={0,0,0,0,0,0};
			min = Integer.MAX_VALUE;
			solve(arr);
			if( min == Integer.MAX_VALUE)
			{
				System.out.println(-1);
			}
			else 
			{
				System.out.println(min);
			}
		}	
	}
	static void solve(int ar[])
	{
		//여기안에서 다해결하는 느낌이군. 
		for(int i=0; i < 10; i++)
		{
			for(int j =0 ; j< 10;j++)
			{
				if( Map[i][j]==1)
				{
					for(int k=5;k>=1;k--)
					{
						if(ar[k]<5)
						{
							boolean flag = true; 
							loop: 
                            for (int x = i; x < i + k; x++) 
                            {
                                for (int y = j; y < j + k; y++)
                                {
                                    if (!boundary(x, y) || Map[x][y] != 1)  
                                    {
                                        flag = false;
                                        break loop;
                                    }
                                }
                            }
							if( flag)
							{
								for (int x = i; x < i + k; x++) 
	                            {
	                                for (int y = j; y < j + k; y++)
	                                {
	                                	Map[x][y] = 0;
	                                }
	                            }
								ar[k]++;
								solve( ar);
								ar[k]--;
								for (int x = i; x < i + k; x++) 
	                            {
	                                for (int y = j; y < j + k; y++)
	                                {
	                                	Map[x][y] = 1;
	                                }
	                            }
								
							}
						}
					}
					return;
				}
			}
		}
		int sum=0;
		for(int g =1; g<= 5;g++)
		{
			sum += ar[g];
		}
		min = min > sum ? sum : min;
		return;
	}
	
}
