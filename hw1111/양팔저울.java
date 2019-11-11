package ws1111;

import java.util.Scanner;
//left, right 나누고,
//순서 정해주고. 
//두개만하면되네. 
public class 양팔저울 {
	static Scanner sc=  new Scanner(System.in);	
	static int N,sum;
	static int R, L ,Count;
	static int Ch[];
	static int Num[];
	static boolean Chv[];
	public static void main(String[] args) {
		int T = sc.nextInt(); 
		for(int tc=1;tc<=T; tc++)
		{
			N = sc.nextInt(); 
			Count =0;
			Ch = new int[N];
			Chv= new boolean[N];
			Num = new int[N]; //넘버링 할 숫자.
			for(int i =0; i<N;i++)
			{
				Ch[i] = sc.nextInt(); 
				sum += Ch[i];
			}
			//Chv[0] = true;
			Order(0);
			System.out.println("#"+ tc + " "+Count);
		}
	}
	static void Order(int cnt)
	{
		if( cnt == N)
		{
			R =0; L=0;
			Order_LR(0);
			return; 
		}
		for(int i =0 ; i <N; i++)
		{
			if( Chv[i]==false)
			{
				Chv[i] = true;
				Num[cnt] = i;
				Order(cnt +1);
				Chv[i] = false;
			}
		}
	}
	static void Order_LR(int cnt)
	{
		if( cnt == N)
		{
			if( R <= L)
			{
				Count++;
			}
			return ;
		}
		
		L += Ch[Num[cnt]];
		Order_LR(cnt+1);
		L -= Ch[Num[cnt]];
		
		R += Ch[Num[cnt]];
		if( R > L)
		{
			R -= Ch[Num[cnt]];
			return;
		}
		Order_LR(cnt+1);
		R -= Ch[Num[cnt]];
		
		
	}
}

