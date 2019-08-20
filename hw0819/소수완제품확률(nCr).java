//[ 1266_소수 완제품 확률 ]
// A 또는 B가 소수개의 제품을 완성할 확률. 
// => 1 - ( A,B 소수개가 아닐 확률 ) 
// => 1 - ( (1- A가 소수개일 확률 )  * (1 -B가 소수개일 확률) )
// => 1 - ( (1- A가 2,3,5.. 소수개를 성공시킬 확률의 합 ~~)) 
package afternoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution5 {
	static int[] primeNum = {2,3,5,7,11,13,17};  

	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		// trim 써야하는가 ? 
		for(int t =1 ;t<=T; t++)
		{
			st = new StringTokenizer(br.readLine());
			double p1 = Double.parseDouble(st.nextToken())/100.0; 
			double p2 = Double.parseDouble(st.nextToken())/100.0;
			
			int n = 18;  // 18C2, 18C3 , 18C5, 18C7 , 18C11, 18C13, 18C17
			double primeA  =0 ; 
			double primeB  =0 ;
			for (int i = 0; i < primeNum.length; i++) 
			{
				int r = primeNum[i];
				primeA += nCr(n,r,1)*Math.pow(p1, r)* Math.pow((1-p1),(n-r)); // 2,3,5 소수개가 성공 시킬 확률 
				primeB += nCr(n,r,1)*Math.pow(p2, r)* Math.pow((1-p2),(n-r)); // 2,3,5 소수개가 성공 시킬 확률 
			}
			double result = 1 -((1- primeA)* (1-primeB)); 
			
			System.out.printf("#%d %6f\n", t, result );
		}
	}
	//와 개지리는 코드다. 
	static double nCr(int n, int r, double result)
	{
		if( r == 1)
		{
			return result *n;
		}
		result *= n; 
		result /= r; 
		return nCr(n-1, r-1, result);
	}
}
