package midtern;

import java.util.Stack;

public class trying {
	public static void main(String[]arg)
	{
	Stack<String> STACK = new Stack<String>();
	String a="ABLEELBA";
	int Length=a.length();
	for (int i=0;i<Length;i++)
	{
		STACK.push(String.valueOf(a.charAt(i)));
	}
	int count=0;
	for (int i=0;i<Length;i++)
	{
		String b=STACK.pop();
		System.out.println(b);
		if(b.contentEquals(String.valueOf(a.charAt(i))))
		{
			count++;
		}
	}
	if(count==Length)
	{
		System.out.println("reversed number set!");
	}
	else
	{
		System.out.println("no");
	}
	
	}
}
