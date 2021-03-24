package hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayInfo {
	public static void main(String[]args) throws FileNotFoundException
	{
		File file= new File("D:\\java\\hw1\\q4\\numbers.txt");
		Scanner sc= new Scanner(file);
		int count=0;
		String str="";
		double []arrayList=new double[9];
		
		while(sc.hasNextDouble())
		{
			    
			    arrayList[count]=sc.nextDouble();
				count++;	
		}
		sc.close();
		for(int i=1;i<count;i++)
		{
			double num=arrayList[i];
			str=str+num+", ";
		}
		double max = 0;
		for(int i=1; i<count;i++) 
		{
			if (max<arrayList[i])
			{
				max=arrayList[i];
			}
		}
		int maxposition = 0;
		for(int i=1; i<count;i++) 
		{
			if(max==arrayList[i]) 
			{
				maxposition=(i-1);
				
			}
		}
		double min=100;
		for(int i=1; i<count;i++) 
		{
			if(min>arrayList[i])
			{
				min=arrayList[i];
			}	
		}
		int minposition = 0;
		for(int j=1; j<count;j++) 
		{
			if(min==arrayList[j]) 
			{
				minposition=(j-1);	
			}
		}
		str=str.substring(0,str.length()-2);
		System.out.println("The array: {"+str+"} contains "+(int)arrayList[0]+" elements");
		System.out.println("The first element of the array is "+arrayList[1]);
		System.out.println("The last element of the array is "+arrayList[count-1]+" and is at position "+(count-1));
		System.out.println("The middle element of the array is "+arrayList[(Math.round(count)/2)]+" and is at position "+(Math.round(count)/2-1));
		System.out.println("The largest element of the array is "+max+" and is at position "+maxposition);
		System.out.print("The smallest element of the array is "+min+" and is at position "+minposition);
		
	}
}
