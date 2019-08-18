import java.util.Scanner;

public class Main{
	static Scanner sc = new Scanner(System.in);
	static int N ;
	static int M ;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,-1,0,1};
	static int Map[][];
	static void for4(int x, int y, int N_size, int M_size)
	{			
		int prev = Map[x][y]; 
		int next  =0;
		int Kx = x;
		int Ky = y;
		for( int i = 1; i <N_size; i++)
		{
			Kx = Kx-1;
			next = Map[Kx][Ky]; 
			Map[Kx][Ky] = prev; 
			prev = next;
		}
		// 왼쪽으로 
		for( int i = 1; i <M_size; i++)
		{
			Ky= Ky-1;
			next = Map[Kx][Ky]; 
			Map[Kx][Ky] = prev; 
			prev = next;
		}
	
		// 아래로 
		for( int i = 1; i <N_size; i++)
		{
			Kx =Kx +1;
			next = Map[Kx][Ky]; 
			Map[Kx][Ky] = prev; 
			prev = next;
		}
			
		for( int i = 1; i <M_size; i++)
		{
			Ky = Ky +1; 
			next = Map[Kx][Ky]; 
			Map[Kx][Ky]= prev; 
			prev = next;
		}

	}
	static void rotation(int C)
	{
		int gg = C; 
		for(int f =0 ; f <gg; f++)
		{
			int cnt =0; 
			if( N> M )
			{
				cnt = M/2; 
			}
			else
			{
				cnt = N/2; 
			}	
			for(int i =0; i <cnt;i++)
			{
				for4( N-i, M-i, N -(2*i), M-(2*i));
			}			
		}

	}
	public static void main(String[] args) 
	{
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		Map = new int[N+1][M+1];
		for (int i = 1; i <=N; i++) 
		{
			for (int j = 1; j <=M; j++) 
			{
				Map[i][j] =sc.nextInt();
			}
		}
		rotation(R);
		for (int i = 1; i <=N; i++) 
		{
			for (int j = 1; j <=M; j++) 
			{
				System.out.print(Map[i][j] +" " );
			}
			System.out.println();
		}
	}	
}