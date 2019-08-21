package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Hong {

	static int N, X;
	static long Mod = Long.MAX_VALUE; 
	public static void main(String[] args) throws Exception 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t= 1; t<=T;t++)
		{
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String g = st.nextToken();
			int sum=0;
			for(int i =0 ; i<g.length();i++)
			{
				sum += Integer.parseInt(g.charAt(i)+"") ;
			}
			sum %=(N-1);
//			System.out.println("k: "+ k +  ", X: " + X + " N-1 : "+ (N-1));
			System.out.println("#" + t+ " " + sum);
		}
	}
}