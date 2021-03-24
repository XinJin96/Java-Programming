package hw3;
public class Counter 
{
	private int counter;
	public Counter(int a)
	{
		counter=a;
	}
	public void increment()
	{ 

		counter+=1;
	}
	public void decrement()
	{

			counter=counter-1;
	}
	public int getValue()
	{
		return counter;
	}

}
