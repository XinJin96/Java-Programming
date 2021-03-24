package HW3;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.LinkedList;

public class WidgetStore {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner read = new Scanner(new File("D:\\Assignments File\\2020 Summer BC\\Data Structure\\HW3\\XYZWidgetStore.txt"));
		LinkedList<String> RList=new LinkedList<>(); 
		LinkedList<Double> PList=new LinkedList<>(); 
		while(read.hasNext())
		{
			
			String a =read.next();
			if(a.contentEquals("R"))
			{
				int amount=read.nextInt();
				double price=Double.parseDouble(read.next().substring(1));
				String add=amount+","+price;
				RList.add(add);;
				System.out.println("Receive: "+amount+ " Widget at price $"+price);
				System.out.println("--------------------------------------------------");
				
			}
			else if(a.contentEquals("S"))
			{
				String combine=RList.getFirst();
				int importAmount=Integer.parseInt(combine.substring(0, combine.indexOf(",")));
				double importPrice=Double.parseDouble(combine.substring(combine.indexOf(",")+1,combine.length()));
				int sold=read.nextInt();
				double total = 0;
				
				
				if(importAmount>sold)
				{
					int reminding=importAmount-sold;
					RList.removeFirst();
					RList.addFirst(reminding+","+importPrice);
					System.out.println(sold+" Widgets sold ");
					total=(importPrice*1.3)*sold;
					System.out.println(sold+" at "+importPrice*1.3+" each Sales: $"+total);
					System.out.println("         Total Sale:    "+total);
					System.out.println("-----------------------------------------------");
		
				}
				else if(sold>importAmount)
				{
					
					total=total+(importAmount*1.3)*importPrice;
					System.out.println(sold+" Widgets sold ");
					System.out.println(importAmount+" at "+importPrice*1.3+" each Sales: $"+(importAmount*1.3)*importPrice);
					sold=sold-importAmount;
					RList.removeFirst();
					if(RList.size()==0)
					{
						
						System.out.println("       Total Sales:  $ "+total);
						System.out.println("Remainder   of  "+(sold)+"   Widgets not available");
						System.out.println("----------------------------------------");
					}
					
					
					while(RList.size()!=0&&sold!=0)
					{
						combine=RList.getFirst();
						importAmount=Integer.parseInt(combine.substring(0, combine.indexOf(",")));
						importPrice=Double.parseDouble(combine.substring(combine.indexOf(",")+1,combine.length()));
						if(sold<=importAmount)
						{
							DecimalFormat df = new DecimalFormat("0.00");
							int reminding=importAmount-sold;
							RList.removeFirst();
							RList.addFirst((reminding+","+importPrice));
							System.out.println(sold+" at "+df.format((importPrice*1.3))+" each Sales: $"+sold*importPrice);
							total=total+sold*(importPrice*1.3);
							System.out.println("       Total Sales:  $ "+total);
							System.out.println("-----------------------------------------------");
							sold=0;
						}
						else if(sold>importAmount&&RList.size()==1)
						{
							System.out.println(importAmount+" at "+importPrice*1.3+" each Sales: $"+importAmount*importPrice);
							sold=sold-importAmount;
							total=total+importAmount*importPrice*1.3;
							RList.removeFirst();
							if(RList.size()==0)
							{
								
								System.out.println("       Total Sales:  $ "+total);
								System.out.println("Remainder   of  "+(sold)+"   Widgets not available");
								System.out.println("----------------------------------------");
							}
						}
						
					}
					
					
				}
				else if(importAmount==sold)
				{
					RList.removeFirst();
					System.out.println(sold+" Widgets sold ");
					total=importPrice*sold*1.3;
					System.out.println(sold+" at "+importPrice*1.3+" each Sales: $"+total);
					System.out.println("-----------------------------------------------");
					
				}
				
			}
			else if(a.contentEquals("P"))
			{
				String value=read.next().substring(0,2);
				double percent=Double.parseDouble(value)/100;
				PList.add(percent);
				System.out.println("Next Two Customers receives: "+value+"% discount!");
			    int i=2;
			    
			    while(i!=0)
			    {
			    	a =read.next();
			    	if(a.contentEquals("S"))
					{
						String combine=RList.getFirst();
						int importAmount=Integer.parseInt(combine.substring(0, combine.indexOf(",")));
						double importPrice=Double.parseDouble(combine.substring(combine.indexOf(",")+1,combine.length()));
						int sold=read.nextInt();
						
						double total = 0;
						if(importAmount>sold)
						{
							int reminding=importAmount-sold;
							RList.removeFirst();
							RList.addFirst(reminding+","+importPrice);
							System.out.println(sold+" Widgets sold");
							total=((importPrice*1.3)*(1-percent))*sold;
							System.out.println(sold+" at "+(importPrice*1.3)*(1-percent)+" each Sales: $"+((importPrice*1.3)*(1-percent))*sold);
							System.out.println("         Total Sale:    "+total);
							System.out.println("-----------------------------------------------");
							i--;
				
						}
						else if(importAmount<sold&&RList.size()!=0)
						{		
							System.out.println(sold+" Widgets sold ");
							while(RList.size()!=0&&sold!=0)
							{
								DecimalFormat df = new DecimalFormat("0.00");
								combine=RList.getFirst();
								importAmount=Integer.parseInt(combine.substring(0, combine.indexOf(",")));
								importPrice=Double.parseDouble(combine.substring(combine.indexOf(",")+1,combine.length()));
								if(sold<=importAmount)
								{
									int reminding=importAmount-sold;
									RList.removeFirst();
									RList.addFirst((reminding+","+importPrice));
									System.out.println(sold+" at "+importPrice*1.3*(1-percent)+" each Sales: $"+(sold*(importPrice*1.3))*(1-percent));
								
									total=total+(sold*(importPrice*1.3))*(1-percent);
									System.out.println("       Total Sales: $ "+total);
									System.out.println("-----------------------------------------------");
									sold=0;
									i--;
								}
								else if(sold>importAmount)
								{
									System.out.println(importAmount+" at "+df.format((importPrice*1.3)*(1-percent))+" each Sales: $"+df.format(((importAmount*(importPrice*1.3))*(1-percent))));
									sold=sold-importAmount;
									total=total+(importAmount*(importPrice*1.3))*(1-percent);
									RList.removeFirst();
									if(RList.size()==0)
									{
										System.out.println("       Total Sales:  $ "+total);
										System.out.println("Remainder   of  "+(sold)+"   Widgets not available");
										
									}
								}	
							}
						}
						else if(importAmount==sold)
						{
							DecimalFormat df = new DecimalFormat("0.00");
							RList.removeFirst();
							System.out.println(sold+" Widgets sold ");
							total=(((importPrice*1.3)*(1-percent))*sold);
							System.out.println(sold+" at "+df.format(importPrice*1.3*(1-percent))+" each Sales: $"+df.format(total));
							System.out.println("       Total Sales:  $ "+df.format(total));
							System.out.println("-------------------------------------------------");
							i--;
						}
			    }
			    	
			}
		}
	}	
		int left=0;
		while(RList.size()!=0)
		{
			String totalLeft=RList.getFirst();
			left=left+Integer.parseInt(totalLeft.substring(0, totalLeft.indexOf(",")));
			RList.removeFirst();
		
		}
		System.out.println("Total left widgets are:  "+    left);
	}
}
