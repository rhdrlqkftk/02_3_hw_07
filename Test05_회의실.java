package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Test05_회의실 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		new PriorityQueue<>(new MeetingComprator());
		int N = sc.nextInt(); // 전체 회의의 갯수
		
//		Meeting[] meets = new Meeting[N];
		ArrayList<Meeting> meets = new ArrayList<>();
		for(int n=0; n<N; n++) {
			meets[n] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		Collections.sort(meets );
		meets.sort(new Comparator<Meeting>() {

			@Override
			public int compare(Meeting o1, Meeting o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		
//		Arrays.sort(meets);
		
		int endT = meets[0].et; // 끝나는 시간이 가장 빠른 회의의 끝나는 시간을 기준으로 잡아놓고
		int count = 1; // 회의 1개 진행함.
		for(int i=1; i<N; i++) {
			if(endT<=meets[i].st) { // 현재 선택한 회의가 끝나고 시작하는 다음으로 빨리 끝나는 회의를 선택하기.
				count++;
				endT = meets[i].et;
			}
		}
		
		System.out.println(count);
	}
	
	static class Meeting{
		int st, et;
		
		Meeting(int s, int e){
			st = s;
			et = e;
		}

//		@Override
//		public int compareTo(Meeting o) {
//			if(this.et == o.et) // 끝나는 시간이 같은 회의는 먼저 시작한 순서로 정렬해 놓겠다 ! 
//				return this.st-o.st;
//			return this.et - o.et;
//		}
	}
	
//	static class MeetComparator implements Comparator<Meeting>{
//
//		@Override
//		public int compare(Meeting o1, Meeting o2) {
//			return o1.st - o2.st;
//		}
//		
//	}
}





