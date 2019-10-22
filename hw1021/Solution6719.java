package ws1022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;
// 성수의 프로그래밍 강좌 시청. 
// 2진법 원리를 적용하는 문제라고?
// (A+M)/2 로 실력이 변화한다. 
public class Solution6719 {
	static int N, K; 
	static int M[]; 
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}
	}); 
	public static void main(String[] args) {
		Scanner	sc= new Scanner(System.in);
		int T= sc.nextInt(); 
		for(int tc =1 ; tc<=T; tc++)
		{
			N = sc.nextInt(); 
			K = sc.nextInt();
			// 성수의 실력이 A라고 할때, 수준이 M인 강좌를 시청하고, 
		    // 성수의 실력은 (A+M)/2가 된다.
			
			 //K개를 적절한 순서로 선택해 한 번씩 시청. 
			for(int i =0; i < N; i++)
			{
				pq.add(sc.nextInt());
			}
			
			int time =K-1;
			M = new int[K];
			double A =0;
			while(time>= 0)
			{
				int ct = pq.poll();  
				M[time]=ct; 
				time--;
			}
			pq.clear();
			for(int i =0; i < K;i++)
			{
				A =  (M[i]+A)/2;
			}
			System.out.println("#"+tc+ " "+String.format("%.6f",A));

		}
	}

}
