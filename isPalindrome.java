package hw2;
public class isPalindrome 
{
	public static void main(String[]args)
	{
		int [] a = new int[] {2,2};
		int m = 0;
		int n = 1;
		boolean result = false;

		result = isPalindrome(a, m, n);
		System.out.print(result);
	}
	
	private static boolean isPalindrome(int[] a, int m, int n) {

		if(a.length==0)
		{
			return true;
		}
		else if(a.length==1)
		{
			return true;
		}
		else
		{
			if(a[m]==a[n])
			{
				isPalindrome(a, m+1, n-1);
			}
			else
			{
				return false;
			}
		}
		return false;
	}

}
