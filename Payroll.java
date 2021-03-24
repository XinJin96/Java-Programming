package hw2;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Payroll {
	public static void main(String[] args)  throws FileNotFoundException, ParseException{
		Scanner employeeInfo = new Scanner(new File("D:\\Assignments File\\2020 Summer BC\\Data Structure\\HW2\\Personnel file Data.txt"));
		Scanner WorkingHour = new Scanner(new File("D:\\Assignments File\\2020 Summer BC\\Data Structure\\HW2\\Payroll file Data.txt"));
		
		
		HashMap<String, double[]>employee=new HashMap<>();
		HashMap<String, double[]>Working=new HashMap<>();
		Map<String, String>IDwName=new LinkedHashMap<>();
		
		BabysitterInfo babysitterInfo;
		BabysitterWorkingHour hour ;
		while(employeeInfo.hasNext())
		{
			babysitterInfo=BabysitterInfo.read(employeeInfo);
			employee.put(babysitterInfo.getID(), babysitterInfo.rates());
			IDwName.put(babysitterInfo.getName(), babysitterInfo.getID());
		}
		while(WorkingHour.hasNext())
		{
			hour=BabysitterWorkingHour.read(WorkingHour);
			Working.put(hour.getID(), hour.getHours());
		}
		SortedMap<String,String> sort=new TreeMap<String,String>(IDwName);
		for(Entry<String, String> e: sort.entrySet()) 
		{
			if(employee.containsKey(e.getValue())&&Working.containsKey(e.getValue()))
			{
				double[] newRate=employee.get(e.getValue());
				double[] newHour=Working.get(e.getValue());
				double total = 0;
				for(int i=0;i<3;i++)
				{
					
					total=total+newRate[i]*newHour[i];
					
				}
				System.out.println(e.getKey()+"'s Pay is "+ total+ "$");
			}


        }

	}
}
