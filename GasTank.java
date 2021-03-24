package hw3;
public class GasTank {
 private double amount = 0;
 private double capacity;

 public GasTank(double i) 
 {
     capacity = i;
 }

    public void addGas(double i) 
      {
	amount += i;
	if(amount > capacity) amount = capacity;
	}
    public void useGas(double i) 
    { 
	amount=amount-i;
	if(amount<0)
	{
		amount=0;
	}
	}
    public boolean isEmpty() 
    { 
	return amount < 0.1 ? true : false;
	}
    public boolean isFull() 
    { 
	return amount > (capacity-0.1) ? true : false;
	}
    public double getGasLevel() 
    {
	return amount; 
	}
}