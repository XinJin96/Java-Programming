package hw3;

import java.util.LinkedList;

public class Acc2 
{
	public static void main(String[]str)
	{
		LinkedList<Double> List=new LinkedList<>();
		List.add(0,0.0);
		List.add(1,1.1);
		List.removeFirst();
		System.out.println(List.getFirst());
	}

}
