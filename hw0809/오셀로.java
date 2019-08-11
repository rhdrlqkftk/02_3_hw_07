import java.util.Scanner;
 
public class Solution {
 
    static Scanner sc = new Scanner(System.in);
    static int N;
    static int M;
    static int dx[] = { 0, -1, 0, 1,  -1, -1, 1,  1 };
    static int dy[] = { -1, 0, 1, 0,  -1,  1, 1, -1 };
    static int Map[][];
    static int chk = 0;
 
    static boolean boundary(int x, int y) 
    {
        if (x <= 0 || y <= 0 || x > N || y > N) {
            return false;
        }
        return true;
    }
 
    static void Map_change(int x, int y, int dir, int cor) 
    {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (true) 
        {
            if(Map[nx][ny] == cor) return;
             
            Map[nx][ny] = cor;
            nx += dx[dir];
            ny += dy[dir];
        }
    }
 
    static int rechk(int x, int y, int dir, int cor) 
    {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (boundary(nx, ny)) 
        {
            if (Map[nx][ny] == cor) 
            {
                return 1;
            }
            if(Map[nx][ny] == 0)
            {
                return 0;
            }
            nx +=  dx[dir];
            ny +=  dy[dir];
        }
        return 0;
         
    }
 
    public static void main(String[] args) 
    {
        int Test = sc.nextInt();
        for (int T = 1; T <= Test; T++) {
            N = sc.nextInt();
            M = sc.nextInt();
            // 1 : black, 2: white
            // 처음 위치 배치
            Map = new int[N + 1][N + 1];
            Map[(N / 2)][(N / 2)] = 2; // 화이트
            Map[(N / 2) + 1][(N / 2) + 1] = 2;
            Map[(N / 2)][(N / 2)+ 1] = 1; // 블랙 
            Map[(N / 2)+ 1][(N / 2)] = 1;
 
            for (int i = 0; i < M; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                int color = sc.nextInt();
                //if( Map[x][y] !=0 ) continue;
                Map[x][y] = color;
                for (int j = 0; j < 8; j++) 
                {
                    int g = rechk(x, y, j, color);
                    //System.out.println(g);
                    if (g == 1) 
                    {
                        Map_change(x, y, j, color);
                    }           
                }   
            }
             
            int black = 0;
            int white = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (Map[i][j] == 1) {
                        black++;
                    }
                    else if (Map[i][j] == 2) {
                        white++;
                    }
                }
            }
            System.out.println("#"+T+ " " + black + " " + white);
        }
    }
}