package HW3;

import java.util.Scanner;

import hw2.BabysitterInfo;

public class LinkedList {
		private static int amount;
		private static double price;
		public LinkedList(int amount, double price)
		{
			this.amount=amount;
			this.price=price;
		}
		public LinkedList(LinkedList other)
		{
			this.amount=other.amount;
			this.price=other.price;
		}
		public int getAmount()
		{
			return amount;
		}
		
		public double getPrice()
		{
			return price;
		}
		public static LinkedList read(Scanner scanner) {
	        if (!scanner.hasNext()) 
	            return null;
	        while(scanner.hasNext())
	        {
	        	if(scanner.next()=="R")
		        {
		        int amount = scanner.nextInt();
		        double price=scanner.nextDouble();
		        return new LinkedList(amount,price);
		        }
	        }
	        return null;
	        
		}

}
