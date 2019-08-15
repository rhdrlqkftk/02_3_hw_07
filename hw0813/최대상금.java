import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution
{
    static int ans, K;
    static int array[]; 
    static int temp[]; 
    static void d_chk(int idx, int cnt)
    {
        if(cnt == K)
        {
            int g = MakeSum(array);
            if( g > ans)
            {
                ans = g; 
            }
            return ; 
        }
        for (int i = idx+1; i < array.length; i++) 
        {
            int tmp = array[i];
            array[i] = array[idx];
            array[idx] = tmp;
             
            d_chk(0, cnt+1);
             
            tmp = array[i];
            array[i] = array[idx];
            array[idx] = tmp;
             
        }
         
    }
    static int MakeSum( int arr[])
    {
        //swap후 더 해야함. 
        int sum =0;//1234
        for(int i =0 ;i < arr.length;i++)
        {
            sum *= 10;  
            sum +=arr[i];
        }
        return sum; 
    }
     
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        for(int T = 1; T<=Tc;T++)
        {
            String []str = br.readLine().split(" ");
            String N = str[0];
            ans = Integer.parseInt(N);
            K = Integer.parseInt(str[1]);
            array = new int[N.length()];
            for( int i = 0; i< array.length; i++)
            {
                array[i] = Integer.parseInt(N.charAt(i)+"");
            }
            for (int i = 0; i < array.length-1; i++) 
            {
                d_chk(i, 0);
            }
             
            System.out.println("#"+T+" "+ ans);
        }
    }
}
