import java.util.Scanner;

public class FourMagicSquare {

	// ���.
	private int[][] magic;
	private int n;

	public FourMagicSquare(int n) {
		magic = new int[n][n];
		this.n = n; // this.�� ����� �ǹ��Ѵ�.
	}

	public FourMagicSquare() 
	{
		this(4); // ������ �����ε�.
		// f3�� ������ ���� �˷��ش�.
	}
	public void print() {
	    System.out.println( n +"is magic ?" + isCheck());
	  //System.out.printf( "%d is magic?",n, isCheck());
		for (int i = 0; i < magic.length; i++) {// magic.length = n �� �ǹ�
			for (int j = 0; j < magic.length; j++) {
				System.out.printf("%d\t", magic[i][j]);
				// string s = String.format("%d\t",magic[i][j]);
				// System.out.printf(s);
			}
			System.out.println();
		}
	}
	public void make() 
	{
		makeR();
		makeA();
	}
	private void makeA() 
	{
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] = i*n +j +1; 
				
			}
		}	
			
	}
	private void makeR() 
	{
		for (int i = 0; i < n; i++) 
		{
			for (int j = 0; j < n; j++) 
			{
				if((i >=0 && i <n/4)||(i >= n/4 *3 && i<n)) 
				{
					if( j >= n/4 && j <n /4 *3)
					{
						magic[i][j] = n*n- (i*n +j);
					}
				}
				else
				{
					if((j >=0 && j <n/4)||(j >= n/4 *3 && j<n))
					{
						magic[i][j] = n*n- (i*n +j);
					}
				}
			}
		}			
	}	
	public boolean isCheck() 
	{
		boolean isC = true; 
		int[] mg = new int[2*n +2];
		for (int i = 0; i < n; i++) {
			mg[i] = sumRow(i);
			mg[i+n] = sumCol(i);
		}
		mg[2*n] = sumDia(); 
		mg[2*n+1] = sumAntDia();
		for (int i = 0; i < mg.length; i++) 
		{
			if(mg[0] !=mg[i])
			{
				isC =false; break; 
			}
		}
		return isC; 
	}
	public int sumRow(int row)
	{
		int tot =0; 
		for (int i = 0; i < magic.length; i++) {
			tot += magic[row][i];
		}
		return tot; 
	}
	public int sumCol(int col)
	{
		int tot =0; 
		for (int i = 0; i < magic.length; i++) {
			tot += magic[i][col];
		}
		return tot; 

	}
	public int sumDia()
	{
		int tot =0 ; 
		for (int i = 0; i < n; i++) {
			tot +=magic[i][i];
		}
		return tot;
	}
	public int sumAntDia()
	{
		int tot =0 ; 
		for (int i = 0; i < n; i++) {
			tot +=magic[i][n-1-i];
		}
		return tot;
	}
	// is, has, contains
	// Java��  True�� 1�� ���� ����.
	public static void main(String[] args) {
		// static�� ��ü�� �Ⱦ��� ���� ���̴�.
		// nonstatic�ΰ� ȣ�� ���Ѵ�.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		FourMagicSquare odd = new FourMagicSquare(n);
		odd.make(); 
		odd.print();
	}
}
