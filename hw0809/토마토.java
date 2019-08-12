import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] arr;
	static boolean[][][] visited;
	static int zeroCnt;//���� ���� �丶�� ����
	static int[] dx = {1,-1,0,0,0,0};//��������, ���Ʒ� ��ȸ
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static Queue<int[]> q;
	static int maxCnt;
	
	public static void bfs(int z, int x, int y) {
		if(!visited[z][x][y]) {
			visited[z][x][y] = true;
			for(int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if(!visited[nz][nx][ny] && arr[nz][nx][ny] == 0) {//���� �湮���� ���� �� ���� �丶��
					//visited[nz][nx][ny] = true;
					arr[nz][nx][ny] = arr[z][x][y] + 1;
					zeroCnt--;
					maxCnt = arr[nz][nx][ny];
					int[] temp = {nz, nx, ny};
					q.add(temp);
				}
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		arr = new int[H + 2][M + 2][N + 2];
		visited = new boolean[H + 2][M + 2][N + 2];
		q = new LinkedList<>();
		
		for(int h = 1; h < H + 1; h++) {
			for(int row = 1; row < M + 1; row++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int col = 1; col < N + 1; col++) {
					arr[h][row][col] = Integer.parseInt(st.nextToken());
					if(arr[h][row][col] == 0)
						zeroCnt++;
					else if(arr[h][row][col] == 1) {
						int[] temp = {h, row, col};
						q.add(temp);//�ʱ� �� ���� �丶�� ��ġ ����
					}
				}
			}
		}
		
		//padding
		for(int h = 0; h < H + 2; h++) {
			for(int row = 0; row < M + 2; row++) {
				for(int col = 0; col < N + 2; col++) {
					arr[0][row][col] = -1;
					arr[H + 1][row][col] = -1;
					arr[h][0][col] = -1;
					arr[h][M + 1][col] = -1;
					arr[h][row][0] = -1;
					arr[h][row][N + 1] = -1;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			bfs(temp[0], temp[1], temp[2]);
		}
		
		if(zeroCnt > 0)//�丶�䰡 ��� ���� ���ϴ� ���
			System.out.println(-1);
		else if(maxCnt == 0)//��� �丶�䰡 �̹� �� ���� ���	
			System.out.println(maxCnt);
		else
			System.out.println(maxCnt - 1);
		
	}

}
