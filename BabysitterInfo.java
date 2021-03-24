package hw2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabysitterInfo {
	private String ID, name, address;
	private double NormalPay, LowerPay,ExtraPay;
	public BabysitterInfo(String ID, String name, String address, double NormalPay, double LowerPay,double ExtraPay)
	{
		this.ID=ID;
		this.name=name;
		this.address=address;
		this.NormalPay=NormalPay;
		this.LowerPay=LowerPay;
		this.ExtraPay=ExtraPay;
	}

	public BabysitterInfo(BabysitterInfo old)
	{
		this.ID=old.ID;
		this.name=old.name;
		this.address=old.address;
		this.NormalPay=old.NormalPay;
		this.LowerPay=old.LowerPay;
		this.ExtraPay=old.ExtraPay;
	}
	public BabysitterInfo(String iD2, int workingDays, Double normalHour, Double lowerPayHour, Double extraPayHour) {
		// TODO Auto-generated constructor stub
	}

	public String getName()
	{
		return name;
	}
	public String getID()
	{
		return ID;
	}
	public String getAddress() 
	{
		return address;
	}
	public double getNormalPay()
	{
		return NormalPay;
	}
	public double getLowerPay()
	{
		return LowerPay;
	}
	public double getExtraPay()
	{
		return ExtraPay;
	}
	public double[] rates()
	{
		double[] rate={NormalPay, LowerPay, ExtraPay};
		return rate;
	}
	public static BabysitterInfo read(Scanner scanner) {
        if (!scanner.hasNext()) 
            return null;
        String ID = scanner.next();
        String name=scanner.next()+" "+scanner.next();
        String address = scanner.next()+ scanner.next()+scanner.next()+"\n"+ scanner.next()+scanner.next()+scanner.next();
        Double NormalPay=scanner.nextDouble();
        Double LowerPay=scanner.nextDouble();
        Double ExtraPay=scanner.nextDouble();
        return new BabysitterInfo(ID,name,address, NormalPay,LowerPay,ExtraPay);
	}
		
		
	
}
