package hw3;
public class PlayListEntry 
{
	private String title=new String ("");
	private String artist =new String("");
	private int playCount=0;
	
	public void setTitle(String Title)
	{
		title=Title;	
	}
	public void setArtist(String Artist)
	{
		artist=Artist;
	}
	public void setPlayCount(int PlayCount)
	{
		playCount=PlayCount;
	}
	public String getTitle()
	{
		return title;
	}
	public String getArtist()
	{
		return artist;
	}
	public int getPlayCount()
	{
		return playCount;
	}
	

}
