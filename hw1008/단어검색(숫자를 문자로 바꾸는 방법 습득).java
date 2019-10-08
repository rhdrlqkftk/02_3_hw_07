package ws1008;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//핵심 아이디어: 문자열. 
//가장 많이 사용된 알파벳을 대문자로 출력한다. 
public class 단어공부1 {
	static int alpabet[] = new int[26];
	static char c[] = {'A', 'B','C','D','E',
			          'F','G','H','I','J',
			          'K','L','M','N','O',
			          'P','Q','R','S','T',
			          'U','V','W','X','Y','Z'};
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s  = new String(); 
		s = br.readLine(); 
		s = s.toLowerCase();
		for(int i =0 ; i< s.length(); i++)
		{
			int k = s.charAt(i)-'a';
			alpabet[k]++; 
			// 리스트로 받는다면? 
		}
		int max = Integer.MIN_VALUE;
		//String ans = new String(); 
		char ans=' ';
		for( int i=0; i <26; i++)
		{
			if( max < alpabet[i])
			{
				max = alpabet[i];
				ans = (char)( i+'A');
			}
			else if( max == alpabet[i])
			{
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
// 숫자에서 문자를 바꾸는 방법 
// (char)( i+'A')
