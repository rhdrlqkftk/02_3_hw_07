package ws1022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;
// ������ ���α׷��� ���� ��û. 
// 2���� ������ �����ϴ� �������?
// (A+M)/2 �� �Ƿ��� ��ȭ�Ѵ�. 
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
			// ������ �Ƿ��� A��� �Ҷ�, ������ M�� ���¸� ��û�ϰ�, 
		    // ������ �Ƿ��� (A+M)/2�� �ȴ�.
			
			 //K���� ������ ������ ������ �� ���� ��û. 
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
