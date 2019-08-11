#include<iostream> 
using namespace std; 
int Map[50][50];
bool visited[101];
int dx[4] = {1,1,-1,-1};
int dy[4] = {1,-1,-1,1};
int N; 
int Kx, Ky;
int Max=-1;
bool boundary( int x, int y)
{
    if( x < 0 || y < 0 || x >= N || y >= N)
    {
        return false; 
    }
    return true; 
}
// int dir[0] = ++, dir[1], dir[2], dir[3]
int progress[4] = {0,};
void dfs(int x, int y, int idx, int cnt)
{
    for( int i =idx; i <= idx+1; i++)
    {
        if( i != 0 && progress[i-1]==0) continue;
        if( i == 4) return; 
        int nx =  x + dx[i]; 
        int ny =  y + dy[i];
        if( i ==3 && Kx ==nx && Ky == ny ) 
        {
            if( cnt > Max)
            {
                Max = cnt; 
            }
            return; 
        }
        if(!boundary(nx,ny))continue;
        if(visited[Map[nx][ny]] == false) 
        {
            progress[i]++;
            visited[Map[nx][ny]] = true;
            dfs( nx, ny, i, cnt+1);
            visited[Map[nx][ny]] = false;
            progress[i]--;
        }
    }
    return;
}
int main()
{
    int T; 
    cin >> T;
    for(int test= 1; test<=T;test++)
    {
        cin >> N ;  
        for( int i=0 ; i< N;i++)
        {
            for(int j =0; j<N;j++)
            {
                cin >> Map[i][j];
            }
        }
        for( int d =0 ; d <101;d++)
        {    
            visited[d] = false; 
        }
        for( int i= 0; i < 4; i++)
        {
            progress[i]=0;
        }
        Max =-1;
        for( int i=0 ; i< N-1;i++)
        {
            for(int j =1; j<N-1;j++)
            {
                Kx =i;
                Ky =j;
                visited[Map[i][j]] = true;
                dfs( i, j, 0, 1);
                visited[Map[i][j]] = false;
            }
        }
        cout<< '#'<<test<<' '<< Max<< endl; 
    }
}