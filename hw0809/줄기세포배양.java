#include<iostream>
#include<queue>
using namespace std;
int N, M, K;
int res = 0;
int Map[800][800];
bool visited[800][800];
int dx[4] = { 0,-1,0,1 };
int dy[4] = { 1,0,-1,0 };
 
struct Point
{
    int x;
    int y;
    int size;
    int alive;
    Point(int x, int y, int size, int alive) {
        this->x = x;
        this->y = y;
        this->size = size;
        this->alive = alive; //활성화. 
    }
};
struct comp {
    bool operator()(const Point x, const Point y)
    {
        return x.size < y.size; 
    }
}; 
void init() {
    for (int i = 0; i < 800; i++) {
        for (int j = 0; j < 800; j++) {
            res = 0;
            Map[i][j] = 0;
            visited[i][j] = false;
        }
    }
}
int main()
{
    int T;
    cin >> T;
    for (int test = 1; test <= T; test++)
    {
        cin >> N >> M >> K;
        init();
         
        queue <Point> q;
        priority_queue <Point, vector<Point> , comp > t;
        for (int i = 400; i < 400 + N; i++) 
        {
            for (int j = 400; j < 400 + M; j++) 
            {
                cin >> Map[i][j];
                if (Map[i][j] != 0) 
                {   
                    q.push(Point( i, j, Map[i][j] , 2));
                    visited[i][j] = true;
                }
            }
        }
        while (K--) 
        {
            int tt = q.size(); 
            while (tt--) 
            {   
                Point p = q.front();
                q.pop();
                // 3 = 2
                if (p.size + 2 == p.alive) // 전이가 일어남.
                {
                    t.push(Point(p.x, p.y, p.size, p.alive ));
                }
                if (p.size * 2 >= p.alive)
                {
                    q.push(Point(p.x, p.y, p.size, p.alive + 1));
                }
            }
            while (!t.empty())
            {
                Point p = t.top();
                t.pop();
                for (int i = 0; i < 4; i++)
                {
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if (visited[nx][ny] == true) continue;
                    if (Map[nx][ny] != 0) continue;
                    visited[nx][ny] = true;
                    Map[nx][ny] = Map[p.x][p.y];
                    q.push(Point(nx, ny, Map[p.x][p.y], 2));
                }
            }
        }
        res = q.size();
         
 
    /*  while (!q.empty())
        {
            Point s = q.top();
            q.pop();
            cout << test<<" : "<< Map[s.x][s.y] << endl;  
        }
        */
         
        cout << "#" << test << " " << res << endl;
    }
}