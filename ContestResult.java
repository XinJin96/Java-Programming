package hw3;
public class ContestResult 
{
	private String winner="";
	private String secondPlace="";
	private String thirdPlace="";
	public void setWinner(String Winner)
	{
       winner=Winner;
	}
	public void setSecondPlace(String SecondPlace)
	{
		secondPlace=SecondPlace;
	}
	public void setThirdPlace(String ThirdPlace)
	{
	    thirdPlace=ThirdPlace;
	}
	public String getWinner()
	{
		return winner;
	}
	public String getSecondPlace()
	{
		return secondPlace;
	}
	public String getThirdPlace()
	{
		return thirdPlace;
	}


}
