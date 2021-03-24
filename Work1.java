package ExtraCreditWorks;
import java.util.Scanner;

public class Work1 
{
	   public static String[][] Recursion(int row, int column, String[][]arr)
	   {
		     if(row==0 && column==0)
	         {
		    	 arr[0][0]="$ ";
		    	 return arr;
	         }
	         else if(column==0){
	        	 arr[row][column]="$ "; 
	        	 int a =arr[row-1].length; 
	        	 return Recursion(row-1,a-1,arr); 
	         }
	         else{
	        	 arr[row][column]="$ ";
	        	 return Recursion(row,column-1,arr);
	         }   
	   }
	   public static void main(String[]str)
	   {
		   Scanner sc=new Scanner(System.in);
		   System.out.println("-----------Two Dimensional Array Builder-------------");
		   System.out.println("how many rows and columns? r,c");
		   String answer=sc.next();
		   int row=Character.getNumericValue(answer.charAt(0));
		   int column=Character.getNumericValue(answer.charAt(2));
		   String [][] TwoDArr=new String [row][column];
		   Recursion(row-1, column-1,TwoDArr);
		   for (int i=0; i<row;i++)
		   {
			   for(int j=0;j<column;j++)
			   {
				   System.out.print(TwoDArr[i][j]);
			   }
			   System.out.println();
		   }
	   }
}
