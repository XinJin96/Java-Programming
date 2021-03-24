package hw3;
public class ParkingMeter 
{
	private int timeLeft=0;
	private int maxTime;
	public ParkingMeter(int a)
	{
		maxTime=a;
	}
	public boolean add(int num)
	{
		if(num==25&&timeLeft<maxTime)
		{
			timeLeft+=30;
			return true;
		}
		else
		{
			return false;
		}
	}
	public void tick()
	{
		if(timeLeft>0)
		{
		timeLeft=timeLeft-1;
		}
	}
	public boolean isExpired()
	{
		if(timeLeft==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
