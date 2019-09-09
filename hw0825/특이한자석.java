mport java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
// 숫자 만들기 
public class Solution{
    // 1,2,4,8 (  배수로 증가한다 )
    // 시계 방향으로 회전은 1 , 반대는 -1 
    // N = 0 , S = 1
    static int K; 
    static int WATCH[][] ;
    static boolean visited[];
    static void rotate(int x, int dir)
    {
        if( dir == 1) // 시계
        {
            int prv = WATCH[x][7] ;
            int nxt=0;
            for(int i =0; i < 8; i++)
            {
                nxt = WATCH[x][i]; 
                WATCH[x][i] = prv;
                prv = nxt; 
            }
             
        }
        else if( dir == -1) // 반시계 방향으로 회전. 
        {
            int prv = WATCH[x][0];
            int nxt=0;
            for(int i =7; i >= 0; i--)
            {
                nxt = WATCH[x][i]; 
                WATCH[x][i] = prv;
                prv = nxt; 
            }
        }
 
 
    }
    static void rotation ( int x, int dir)
    {
        boolean chk = false; 
        visited[x] = true; 
        if( x == 1)
        {
            if( visited[2] ==false)
            {
                if( WATCH[1][2]!= WATCH[2][6])
                {
                    chk = true;
                    rotation( 2, -dir);
                }
            }
        }
        else if( x == 2)
        {
            if( visited[1] ==false)
            {
                if( WATCH[1][2]!= WATCH[2][6])
                {
                    rotation( 1, -dir);
                }
            }
            if( visited[3] ==false)
            {
                if( WATCH[2][2]!= WATCH[3][6])
                {
                    rotation( 3, -dir);
                }
            }   
        }
        else if( x == 3)
        {
            if( visited[2] ==false)
            {
                if( WATCH[2][2]!= WATCH[3][6])
                {
                    rotation( 2, -dir);
                }
            }
            if( visited[4] ==false)
            {
                if( WATCH[3][2]!= WATCH[4][6])
                {
                    rotation( 4, -dir);
                }
            }   
        }
        else if( x == 4)
        {
            if( visited[3] ==false)
            {
                if( WATCH[3][2]!= WATCH[4][6])
                {
                    rotation( 3, -dir);
                }
            }
        }
        rotate( x, dir);
        return;
        // 회전 해준다. 
                 
    }
    public static void main(String[] args) throws Exception, IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t= 1; t<= T;t++)
        {
            K = Integer.parseInt(br.readLine());
            WATCH = new int[5][8];
            for(int i =1 ; i <=4; i++)
            {
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j =0 ; j <8; j++)
                {
                    WATCH[i][j] =Integer.parseInt(st.nextToken());
                }
            }
            int idx, dir;
            for(int i =0 ; i <K; i++)
            {
                StringTokenizer st= new StringTokenizer(br.readLine());
                idx = Integer.parseInt(st.nextToken());
                dir = Integer.parseInt(st.nextToken());
                visited = new boolean[5];
                rotation( idx, dir); 
            }
            int ts=0;
            for(int i =1 ; i <= 4; i++)
            {
                ts = ts + WATCH[i][0]*(1<<(i-1));
            }
            bw.write("#"+ t + " "+ ts+"\n");
        }
         
        bw.flush();
        bw.close();
    }
}