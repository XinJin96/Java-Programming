package hw3;
public class Averager 
{
	private int sum=0;
	private int count=0;
	public int getSum()
	{
		return sum;
	}
	public void add(int number)
	{
		sum=number+sum;
		count++;
	}
	public int getCount()
	{
		return count;
	}
	public double getAverage()
	{
		return (double)sum/count;
	}
	

}
