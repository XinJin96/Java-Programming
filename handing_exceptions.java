package self_learning1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class handing_exceptions {
	public static void main(String[]args)
	{
		int number;
		try
		{
			File file=new File("D:\\Number.txt");
			Scanner inputFile=new Scanner(file);
			while(inputFile.hasNext())
				{
				number =inputFile.nextInt();
				System.out.println(number);
				}
			inputFile.close();
			
		}
		catch(FileNotFoundException| InputMismatchException ex)
		{
			System.out.print("error!");
		}
	}

}
