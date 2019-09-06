import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, K;
	static int[][] land_n; // 각 땅의 양분 정보
	static ArrayList<Tree>[][] land_tree; // 각 땅에 심어진 나무 여러그루 정보
	static int[][] winter_info; // 겨울에 추가되는 양분 정보
	static int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(sc.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 땅에 양분 5씩 배분
		land_n = new int[N + 1][N + 1];
		for (int n = 1; n <= N; n++) {
			Arrays.fill(land_n[n], 5);
		}

		// 겨울에 줄 양분 정보
		winter_info = new int[N + 1][N + 1];
		for (int r = 1; r <= N; r++) {
			st = new StringTokenizer(sc.readLine());
			for (int c = 1; c <= N; c++) {
				winter_info[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// N x N 땅에 심겨지는 나무 정보
		land_tree = new ArrayList[N+1][N+1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(sc.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());

			land_tree[r][c] = new ArrayList<Tree>();
			land_tree[r][c].add(new Tree(age, true));
		}
		
		// K년 지남
		for(int k=0; k<K; k++) {
			spring();
			summer();
			fall();
			winter();
		}
		int result_tree=0;
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (land_tree[r][c] != null && land_tree[r][c].size()>0) { // r,c에 나무가 있다면
					result_tree += land_tree[r][c].size();
				}
			}
		}
		System.out.println(result_tree);
	}

	static void spring() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (land_tree[r][c] != null) { // r,c에 나무가 있다면
					Collections.sort(land_tree[r][c]); // 나이순 정렬
					for(Tree tree: land_tree[r][c]) {
						if(land_n[r][c] >= tree.age) { // 양분 있으면 먹고
							land_n[r][c] -= tree.age;
							tree.age++;
						}else { // 양분 부족하면 죽음.
							tree.alive = false;
						}
					}
				}
			}
		}

	}

	static void summer() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (land_tree[r][c] != null) { // r,c에 나무가 있다면
					ArrayList<Tree> deadTrees = new ArrayList<>();
					for (int i = 0; i < land_tree[r][c].size(); i++) {
						Tree tree = land_tree[r][c].get(i);
						if (!tree.alive) {
							land_n[r][c] += (tree.age / 2);
							deadTrees.add(tree);
						}
					}
					land_tree[r][c].removeAll(deadTrees);
				}
			}
		}
	}

	static void fall() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				if (land_tree[r][c] != null) { // r,c에 나무가 있다면
					for (Tree tree : land_tree[r][c]) {
						if (tree.age % 5 == 0) {
							for (int i = 0; i < 8; i++) {
								int addR = r + dir[i][0];
								int addC = c + dir[i][1];
								if (addR > 0 && addR <= N && addC > 0 && addC <= N) {
									if (land_tree[addR][addC] == null) {
										land_tree[addR][addC] = new ArrayList<>();
									}
									land_tree[addR][addC].add(new Tree(1, true));
								}
							}
						}
					}
				}
			}
		}
	}

	static void winter() {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				land_n[r][c] += winter_info[r][c];
			}
		}
	}

	static class Tree implements Comparable<Tree> {
		int age;
		boolean alive;

		Tree(int a, boolean al) {
			age = a;
			alive = al;
		}

		@Override
		public int compareTo(Tree o) {
			if (this.age < o.age)
				return -1;
			else if (this.age > o.age)
				return 1;
			return 0;
		}
	}
}