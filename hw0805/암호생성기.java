import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
     
    public static void main(String[] args) {
        Queue<Integer> q= new LinkedList<Integer>(); 
        Scanner sc = new Scanner(System.in);
        //
        for( int test= 1; test<=10;test++)
        {
            int T = sc.nextInt();
            for( int i =0 ; i<8;i++)
            {
                int N = sc.nextInt(); 
                q.add(N);
            }
            int flag =1;
            while(flag ==1)
            {
                for( int i=1 ; i<=5;i++)
                {
                    int t = q.poll();
                    if( t - i <= 0)
                    {
                        q.add(0); 
                        flag =0;
                        break; 
                    }
                    else
                    {
                        q.add( t-i);
                    }
                }
            }
            System.out.print("#"+ test+" ");
            while(!q.isEmpty())
            {
                System.out.print(q.poll() + " ");
            }
            System.out.println();
        }
    }
}