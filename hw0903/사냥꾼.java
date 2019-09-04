package aaaa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test {
	static int M, N;
	static long L;

	static class animal implements Comparable<animal> {
		int x;
		int y;

		animal(int x1, int y1) {
			x = x1;
			y = y1;
		}

		@Override
		public int compareTo(animal o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}

	static long gun[];
	static animal[] am;

	public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); 
        N = sc.nextInt();
        L = sc.nextLong();
        // 사대의 위치를 나타내는 M개의 x-좌표 값
        gun = new long[M]; 
        for(int i =0 ; i< M; i++)
        {
        	gun[i] = sc.nextInt();
        }
        Arrays.sort(gun);
        am = new animal [N];
        for(int i =0 ; i< N; i++)
        {
            int x1 = sc. nextInt(); 
            int y1 = sc. nextInt();
            am[i] =new animal(x1,y1);  
        }
        Arrays.sort(am);
       
        int cur =0; 
        int ans =0;
        for(int i =0 ; i < am.length ; i++)
        {
        	animal p = am[i]; 
        	if( p.y > L || p.x < gun[0]-L) continue; 
        	if( p.x > gun[M-1] +L )break;  
        	for(int j = cur ; j< M ;j++)
        	{
        		long dist = Math.abs(gun[j] - p.x) + p.y;
        		if( dist <=L)
        		{
        			ans++; 
        			cur= j; 
        			break;
        		}
        		if( p.x < gun[j]) break;  //
        	}
        }
        System.out.println(ans);
    }
}