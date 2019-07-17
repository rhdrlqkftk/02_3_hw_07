
public class tatris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]tet; 
		tet = new int[][] {{1,1,1,0},{0,1,0,0},{0,1,0,0},{0,0,0,0}};
		int [][]temp= new int[4][4];
		
		//turn_right
		
		int N = tet.length;
		for (int i = 0; i <N; i++) 
		{
			for (int j = 0; j < N; j++) 
			{
				System.out.print( tet[i][j]);
			}
			System.out.println();
		}
		System.out.println("TURN_LEFT");
		for(int d =1; d<= N;d++)
		{
			for (int i = 0; i <N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					temp[i][j] = tet[j][N-i-1];
				}
			}
			System.out.println();
			System.out.println("-" +d* 90 +"도 회전");
			for (int i = 0; i <N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					System.out.print( temp[i][j]);
					tet[i][j] = temp[i][j];
				}
				System.out.println();
			}
		}
		System.out.println("TURN_RIGHT");
		for(int d =1; d<= N;d++)
		{
			for (int i = 0; i <N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					temp[i][j] = tet[N-j-1][i];
				}
			}
			System.out.println();
			System.out.println( d* 90 +"도 회전");
			for (int i = 0; i <N; i++) 
			{
				for (int j = 0; j < N; j++) 
				{
					System.out.print( temp[i][j]);
					tet[i][j] = temp[i][j];
				}
				System.out.println();
			}
		}
		
	}

}
