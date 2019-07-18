import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class Snail {	
	static int N; 
	static int M;
	static int Dir;
	static int Count;
	static int []dx =new int[] {0,1,0,-1};
	static int []dy =new int[] {-1,0,1,0};	
	static int [][]Map;  
	public Snail()
	{
		this(5,5);
	}
	public Snail(int M, int N) 
	{
		Map = new int[M][N];
	}
	public void init()
	{
		for( int i=0; i < N; i++)
		{
			for( int j=0 ;j <M;j++)
			{
				Map[i][j] = 0; 
			}
		}	
	}
	public void make(int x, int y)
	{	
		while( Count <N *M)
		{
			while( x >= 0 && y >= 0 && x <N && y <M)
			{
				Map[x][y] =Count;
				x += dx[Dir];
				y += dy[Dir];
				if((x < 0|| y < 0 || x >=  N || y >= M)|| Map[x][y] != 0 )
				{
					break;
				}
				Count++;
			}
			x -= dx[Dir];
			y -= dy[Dir];
			Dir = (Dir + 1) % 4;
		}
	}
	public void print()
	{
		for( int i=0; i < N; i++)
		{
			for( int j=0 ;j <M;j++)
			{
				System.out.print(" "+ Map[i][j]+" ");
			}
			System.out.println();
		}	
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);	
		N = sc.nextInt();
		M = sc.nextInt();
		Dir =0;
		Count =1;
		Snail lt = new Snail();		
		lt.init(); 
		lt.make(0,0); 
		lt.print();
	}

}
