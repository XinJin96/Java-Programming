package hw3;
public class WeatherForecast 
{
	private String skies="";
	private int high=0;
	private int low=0;
	public void setSkies(String theSkies)
	{
		skies=theSkies;
	}
	public void setHigh(int theHigh )
	{
		high=theHigh;
	}
	public void setLow(int theLow)
	{
		low=theLow;
	}
	public String getSkies()
	{
	return skies;	
	}
	public int getHigh()
	{
		return high;
	}
	public int getLow()
	{
		return low;
	}
	

}
