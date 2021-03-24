package hw3;
public class Value 
{
	private boolean modified=false;
	private int val;
	public Value(int i)
	{
		val=i;
	}
	public int getVal()
	{
		return val;
	}
	public void setVal(int i)
	{
		val=i;
		this.modified=true;
	}
	public boolean wasModified()
	{
		return modified;
	}
	
	

}
