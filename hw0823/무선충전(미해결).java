// 무선 충전. 
package ww0816;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution4
{
	static int dx[] = { 0,-1, 0, 1, 0};
	static int dy[] = { 0, 0, 1, 0, -1};
	static class Battery
	{
		int x; 
		int y; 
		int c; 
		int p; 
		Battery( int x, int y, int c, int p)
		{
			this.x = x; 
			this.y = y; 
			this.c = c;
			this.p = p; 
		}
	}
	static int dis(int Ux , int Uy , int Bx, int By)
	{
		int D = Math.abs(Ux -Bx) + Math.abs(Uy-By);
		return D;
	}
	static int sum=0;
	static void Walk() // 하나씩 걸어보자. !!
	{
		int cnt_M = 0;
		while(cnt_M < M) //5
		{
			
			PriorityQueue<Integer> pp = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2-o1; //내림 차순. 
				}
			});
			int ta=0, tb=0;
			for(int i=0; i< BC;i++)
			{
				int d = dis(Uax, Uay, Btr.get(i).x, Btr.get(i).y);
				int d1 = dis(Ubx, Uby, Btr.get(i).x, Btr.get(i).y);
				if( d <= Btr.get(i).c || d1<= Btr.get(i).c)
				{
					
					if(d <= Btr.get(i).c && d1<= Btr.get(i).c)
					{
						if( Uax == Ubx && Uay == Uby) //같다면..
						{                
							pp.add(Btr.get(i).p);
						}
					}
					pp.add(Btr.get(i).p);
				}				
			}
			int cc=0;
			while(!pp.isEmpty())
			{
				if(cc <2)
				{
					sum += pp.poll();
				}
				else 
				{
					pp.poll();
				}
				cc++;
			}
			
			Uax = Uax+ dx[Am.get(cnt_M)];
			Uay = Uay+ dy[Am.get(cnt_M)];
			Ubx = Ubx+ dx[Bm.get(cnt_M)];
			Uby = Uby+ dy[Bm.get(cnt_M)];
			cnt_M++;
		}
		return;
	}
	static int Uax = 0, Uay = 0,Ubx = 0, Uby = 0;
	static int Asum=0, Bsum=0; 
	static int M, BC; 
	static Queue<Battery> q ;
	static List<Battery> Btr;
	static List<Integer> Am ;
	static List<Integer> Bm ;
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int T = Integer.parseInt(st.nextToken());
		for (int test = 1; test <= T; test++) 
		{
			sum =0;
			Uax = 1;
			Uay = 1; 
			Ubx =10; 
			Uby =10;
			Am = new ArrayList<Integer>();
			Bm = new ArrayList<Integer>();
			Btr= new LinkedList<Battery>();
			st = new StringTokenizer(br.readLine().trim());
			// 사용자 A,B의 이동 정보이다. 
			M = Integer.parseInt(st.nextToken()); // 총 이동 시간. 
			BC = Integer.parseInt(st.nextToken()); // 충전 갯수		
			for(int j =0 ;j <2;j++)
			{
				st = new StringTokenizer(br.readLine());
				for(int i =0 ; i < M;i++)
				{
					if( j == 0 )
					{
						Am.add(Integer.parseInt(st.nextToken()));						
					}
					else if( j == 1)
					{
						Bm.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			for(int i =0 ; i<BC;i++)
			{
				StringTokenizer st1 = new StringTokenizer(br.readLine().trim());
				int y= Integer.parseInt(st1.nextToken());
				int x= Integer.parseInt(st1.nextToken());
				int c= Integer.parseInt(st1.nextToken());
				int p= Integer.parseInt(st1.nextToken());
				Btr.add(new Battery( x, y, c, p));
			}
			Walk();
			System.out.println("#"+test + " " + sum);
		}
	}
}
/*
//AP 1의 정보 (4, 4), C1=1, P1=100
// AP 2의 정보 (7, 10), C2=3, P2=40
// AP 3의 정보 (6, 3), C3=2, P3=70
// 나머지는 sample_input.txt 참조

sample_input.txt
출력


5
40 2
0 3 0 3 3 2 2 1 0 4 1 3 3 3 0 3 4 1 1 3 2 2 2 2 2 0 2 3 2 2 3 4 4 3 3 3 2 0 4 4 
0 1 0 3 4 0 4 0 0 1 1 1 0 1 4 4 4 4 4 3 3 3 0 1 0 4 3 2 1 4 4 3 2 3 2 2 0 4 2 1 
5 2 4 140
8 3 3 490
60 4
0 3 3 3 0 1 2 2 2 1 2 2 3 3 4 4 0 3 0 1 1 2 2 3 2 2 3 2 2 0 3 0 1 1 1 4 1 2 3 3 3 3 3 1 1 4 3 2 0 4 4 4 3 4 0 3 3 0 3 4 
1 1 4 1 1 1 1 1 1 4 4 1 2 2 3 2 4 0 0 0 4 3 3 4 3 3 0 1 0 4 3 0 4 3 2 3 2 1 2 2 3 4 0 2 2 1 0 0 1 3 3 1 4 4 3 0 1 1 1 1 
6 9 1 180
9 3 4 260
1 4 1 500
1 3 1 230
80 7
2 2 2 2 2 2 0 2 2 0 4 0 2 3 3 2 3 3 0 3 3 3 4 3 3 2 1 1 1 0 4 4 4 1 0 2 2 2 1 1 4 1 2 3 4 4 3 0 1 1 0 3 4 0 1 2 2 2 1 1 3 4 4 4 4 4 4 3 2 1 4 4 4 4 3 3 3 0 3 3 
4 4 1 1 2 1 2 3 3 3 4 4 4 4 4 1 1 1 1 1 1 1 1 0 3 3 2 0 4 0 1 3 3 3 2 2 1 0 3 2 3 4 1 0 1 2 2 3 2 0 4 0 3 4 1 1 0 0 3 2 0 0 4 3 3 4 0 4 4 4 4 0 3 0 1 1 4 4 3 0 
4 3 1 170
10 1 3 240
10 5 3 360
10 9 3 350
9 6 2 10
5 1 4 350
1 8 2 450
100 8
2 2 3 2 0 2 0 3 3 1 2 2 2 2 3 3 0 4 4 3 2 3 4 3 3 2 3 4 4 4 2 2 2 0 2 2 4 4 4 4 1 1 1 2 2 2 4 3 0 2 3 3 4 0 0 1 1 4 1 1 1 1 2 2 1 1 3 3 3 0 3 2 3 3 0 1 3 3 0 1 1 3 3 4 0 4 1 1 2 2 4 0 4 1 1 2 2 1 1 1 
4 4 4 0 4 1 1 4 1 1 1 1 3 2 1 2 1 1 4 4 1 0 2 3 4 4 4 4 4 0 1 0 2 2 2 0 2 2 2 2 2 2 3 0 0 1 4 3 3 2 0 0 4 4 4 0 2 0 4 1 1 2 2 0 4 4 0 0 2 0 2 3 3 0 2 3 0 3 4 0 4 3 4 4 3 4 1 1 2 2 2 0 0 1 0 4 1 1 1 4 
3 4 2 340
10 1 1 430
3 10 4 10
6 3 4 400
7 4 1 80
4 5 1 420
4 1 2 350
8 4 4 300

*/