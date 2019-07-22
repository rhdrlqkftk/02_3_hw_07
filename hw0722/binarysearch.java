import java.util.Arrays;

//����Ž��
public class Test3 {	
	static int  binarySearch(int []data, int key )
	{
		int idx = -1;
		int l = 0; 
		int r = data.length -1;
		
		while( l <= r)
		{
			int m = (l+r)/2;  // �߰� ���� ã�� .  
			if( data[m] == key)
			{	 
				int k = m; 
				for( int i =m; i>0;i--)
				{
					if( data[i]==key)
					{
						k = i;
					}		
				}	
				return k;
			}
			else if( data[m] >= key ) // s�� �۴ٸ�
			{
				r = m -1;
			}
			else
			{
				l =  m +1; 
			}
		}
		return idx;
	}
	public static void main(String[] args) 
	{
		
		int nums[]= {1,45,87,51,1,84,21,54,4,2,12,12};
	
		// array ��������. 
		// 
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println(" ");
		System.out.println(binarySearch(nums, 99));
		System.out.println(binarySearch(nums, 4 ));
		System.out.println(binarySearch(nums, 12));		
	}
}