package hw3;
public class Accumulator 
{
	private int sum;
	public Accumulator(int a)
	{
		sum=a;
	}
	public int getSum()
	{
		return sum;
	}
	public void add(int number)
	{
		sum+=number;
	}
	

}
