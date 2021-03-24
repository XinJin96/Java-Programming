package hw2;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BabysitterWorkingHour {
	private String ID;
	private int WorkingDay;
	private double NormalHour,LowerPayHour,ExtraPayHour;
	public BabysitterWorkingHour(String ID, int WorkingDay,double NormalHour, double LowerPayHour, double ExtraPayHour)
	{
		this.ID=ID;
		this.WorkingDay=WorkingDay;
		this.NormalHour=NormalHour;
		this.LowerPayHour=LowerPayHour;
		this.ExtraPayHour=ExtraPayHour;
	}
	public BabysitterWorkingHour( BabysitterWorkingHour old)
	{
		this.ID=old.ID;
		this.WorkingDay=old.WorkingDay;
		this.NormalHour=old.NormalHour;
		this.LowerPayHour=old.LowerPayHour;
		this.ExtraPayHour=old.ExtraPayHour;
	}
	public String getID()
	{
		return ID;
	}
	public int getWorkingDay()
	{
		return WorkingDay;
	}
	public double getNormalHour()
	{
		return NormalHour;
	}
	public double getLowerPayHour()
	{
		return LowerPayHour;
	}
	public double getExtraPayHour()
	{
		return ExtraPayHour;
	}
	public double[] getHours()
	{
		double hours[]= {NormalHour,LowerPayHour, ExtraPayHour};
		return hours;
	}
	public static BabysitterWorkingHour read(Scanner scanner) throws ParseException {
        if (!scanner.hasNext()) 
            return null;
        String ID = scanner.next();
        int WorkingDays=scanner.nextInt();
        SimpleDateFormat convertTool =   new SimpleDateFormat("HH:mm"); 
        Double NormalHour=0.0;
        Double LowerPayHour=0.0;
        Double ExtraPayHour=0.0;
        for (int i=0;i<WorkingDays;i++)
        {
        	java.util.Date nineolockstandard=convertTool.parse("9:00");
        	java.util.Date twelveolockstandard=convertTool.parse("12:00");
        	java.util.Date startingHour=convertTool.parse(scanner.next());
        	java.util.Date EndingHour= convertTool.parse(scanner.next());
        	if(startingHour.compareTo(nineolockstandard)<0&&startingHour.getHours()>=6)
        	{
        		
        			 if(EndingHour.compareTo(nineolockstandard)<0&&EndingHour.getHours()>6)
        			{
        				if(EndingHour.getMinutes()==0&&startingHour.getMinutes()==0)
        				{
        				NormalHour=NormalHour+(double)(EndingHour.getHours()-startingHour.getHours());
        				LowerPayHour=LowerPayHour+0.0;
        				ExtraPayHour=ExtraPayHour+0.0;
        				}
        				else if(EndingHour.getMinutes()!=0&&startingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+(double)(EndingHour.getHours()-startingHour.getHours())+(double)((double)EndingHour.getMinutes()/60);
            				LowerPayHour=LowerPayHour+0.0;
            				ExtraPayHour=ExtraPayHour+0.0;
        				}	
        				else if(EndingHour.getMinutes()==0&&startingHour.getMinutes()!=0)
        				{
        					NormalHour=NormalHour+(double)(((EndingHour.getHours()-1)-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        				}
        				else if(EndingHour.getMinutes()!=0&&startingHour.getMinutes()!=0)
        				{
        					if(startingHour.getMinutes()==EndingHour.getMinutes())
        					{
        						NormalHour=NormalHour+(double)(EndingHour.getHours()-startingHour.getHours());
        						LowerPayHour=LowerPayHour+0.0;
                				ExtraPayHour=ExtraPayHour+0.0;
        					}
        					else if(startingHour.getMinutes()>EndingHour.getMinutes())
        					{
        						NormalHour=NormalHour+(double)(((EndingHour.getHours()-1)-startingHour.getHours())+(((60-startingHour.getMinutes())+(double)EndingHour.getMinutes())/60));
        						LowerPayHour=LowerPayHour+0.0;
                				ExtraPayHour=ExtraPayHour+0.0;
        					}
        					else if(startingHour.getMinutes()<EndingHour.getMinutes())
        					{
        						NormalHour=NormalHour+(double)((EndingHour.getHours()-startingHour.getHours())+((EndingHour.getMinutes()-(double)startingHour.getMinutes())/60));
        						LowerPayHour=LowerPayHour+0.0;
                				ExtraPayHour=ExtraPayHour+0.0;
        					}
        				}
        			}
        			else if(EndingHour.getHours()>9)
        			{
        				if(startingHour.getMinutes()==0&&EndingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+(9-startingHour.getHours());
        					LowerPayHour=LowerPayHour+(EndingHour.getHours()-9);
        					ExtraPayHour=ExtraPayHour+0.0;
        				}
        				else if(startingHour.getMinutes()!=0&&EndingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+((8-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        					LowerPayHour=LowerPayHour+(EndingHour.getHours()-9);
        					ExtraPayHour=ExtraPayHour+0.0;
        				}
        				else if(startingHour.getMinutes()==0&&EndingHour.getMinutes()!=0)
        				{
        					NormalHour=NormalHour+(9-startingHour.getHours());
        					LowerPayHour=LowerPayHour+((EndingHour.getHours()-9)+((double)EndingHour.getMinutes()/60));
        					ExtraPayHour=ExtraPayHour+0.0;
        				}
        				else if(startingHour.getMinutes()!=0&&EndingHour.getMinutes()!=0)
        				{
        					NormalHour=NormalHour+((8-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        					LowerPayHour=LowerPayHour+((EndingHour.getHours()-9)+((double)EndingHour.getMinutes()/60));
        					ExtraPayHour=ExtraPayHour+0.0;
        				}
        			}
        			else if(EndingHour.compareTo(nineolockstandard)==0)
        			{
        				if(startingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+(9-startingHour.getHours());
        				}
        				else if(startingHour.getMinutes()!=0)
        				{
        					NormalHour=NormalHour+((8-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        				}
        			}
        			else if(EndingHour.compareTo(twelveolockstandard)==0)
        			{
        				if(startingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+(9-(double)startingHour.getHours());
        					LowerPayHour=LowerPayHour+3;	
        					ExtraPayHour=ExtraPayHour+0.0;
        				}
        				else if(startingHour.getMinutes()!=0)
        				{
        					NormalHour=NormalHour+(((nineolockstandard.getHours()-1)-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        					LowerPayHour=LowerPayHour+3;	
        					ExtraPayHour=ExtraPayHour+0.0;
        				}
        				
        			}
        			else if(EndingHour.getHours()<=6)
        			{
        				if(EndingHour.getMinutes()==0&&startingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+(9-startingHour.getHours());
        					LowerPayHour=LowerPayHour+3;
        					ExtraPayHour=ExtraPayHour+(EndingHour.getHours());
        					
        				}
        				else if(EndingHour.getMinutes()!=0&&startingHour.getMinutes()!=0)
        				{
        				    NormalHour=NormalHour+(((nineolockstandard.getHours()-1)-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        				    LowerPayHour=LowerPayHour+3;
        				    ExtraPayHour=ExtraPayHour+(EndingHour.getHours()+(EndingHour.getMinutes()/60));
        				}
        				else if(EndingHour.getMinutes()!=0&&startingHour.getMinutes()==0)
        				{
        					NormalHour=NormalHour+(9-startingHour.getHours());
        					LowerPayHour=LowerPayHour+3;
        					ExtraPayHour=ExtraPayHour+(EndingHour.getHours()+((double)EndingHour.getMinutes()/60));
        				}
        				else if(EndingHour.getMinutes()==0&&startingHour.getMinutes()!=0)
        				{
        					NormalHour=NormalHour+(((nineolockstandard.getHours()-1)-startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
        					LowerPayHour=LowerPayHour+3;
        					ExtraPayHour=ExtraPayHour+(EndingHour.getHours());	
        				}
        			}
        	}
        	else if(startingHour.compareTo(nineolockstandard)==0)
        	{
    			if(EndingHour.compareTo(twelveolockstandard)==0)
    			{
    					NormalHour=NormalHour+0;
    					LowerPayHour=LowerPayHour+3;	
    					ExtraPayHour=ExtraPayHour+0.0;
    			}
    			else if(EndingHour.compareTo(twelveolockstandard)<0&&EndingHour.getHours()>6)
    			{
    				NormalHour=NormalHour+0;
					LowerPayHour=LowerPayHour+((EndingHour.getHours()-9)+((double)EndingHour.getMinutes()/60));	
					ExtraPayHour=ExtraPayHour+0;
    			}
    			else if(EndingHour.getHours()<=6)
    			{
    				if(EndingHour.getMinutes()==0)
    				{
    					NormalHour=NormalHour+0;
    					LowerPayHour=LowerPayHour+3;
    					ExtraPayHour=ExtraPayHour+(EndingHour.getHours());
    					
    				}
    				else if(EndingHour.getMinutes()!=0)
    				{
    				    NormalHour=NormalHour+0;
    				    LowerPayHour=LowerPayHour+3;
    				    ExtraPayHour=ExtraPayHour+(EndingHour.getHours()+((double)EndingHour.getMinutes()/60));
    				}	
    			}
        	}	
        	else if(startingHour.compareTo(nineolockstandard)>0)
        	{
        		if(EndingHour.compareTo(twelveolockstandard)==0)
    			{
        			if(startingHour.getMinutes()==0)
        			{
        				NormalHour=NormalHour+0;
    				    LowerPayHour=LowerPayHour+(EndingHour.getHours()-startingHour.getHours());
    				    ExtraPayHour=ExtraPayHour+0;
        			}
        			else if(startingHour.getMinutes()!=0)
        			{
        				NormalHour=NormalHour+0;
    				    LowerPayHour=LowerPayHour+(((EndingHour.getHours()-1)-startingHour.getHours()+((60-(double)startingHour.getMinutes())/60)));
    				    ExtraPayHour=ExtraPayHour+0;
        			}
    			}
    			else if(EndingHour.getHours()<=6)
    			{
    				if(startingHour.getMinutes()==0&&EndingHour.getMinutes()==0)
    				{
    					NormalHour=NormalHour+0;
    					LowerPayHour=LowerPayHour+(12-(double)startingHour.getHours());
    					ExtraPayHour=ExtraPayHour+(EndingHour.getHours());
    				}
    				else if(EndingHour.getMinutes()!=0&&startingHour.getMinutes()==0)
    				{
    				    NormalHour=NormalHour+0;
    				    LowerPayHour=LowerPayHour+(12-(double)startingHour.getHours());
    				    ExtraPayHour=ExtraPayHour+(EndingHour.getHours()+((double)EndingHour.getMinutes()/60));
    				}	
    				else if(EndingHour.getMinutes()==0&&startingHour.getMinutes()!=0)
    				{
    					NormalHour=NormalHour+0;
    					LowerPayHour=LowerPayHour+((11-(double)startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
    					ExtraPayHour=ExtraPayHour+(EndingHour.getHours());
    				}
    				else if(EndingHour.getMinutes()!=0&&startingHour.getMinutes()!=0)
    				{
    					NormalHour=NormalHour+0;
    					LowerPayHour=LowerPayHour+((11-(double)startingHour.getHours())+((60-(double)startingHour.getMinutes())/60));
    					ExtraPayHour=ExtraPayHour+(EndingHour.getHours()+((double)EndingHour.getMinutes()/60));
    				}
    			}
        	}
        	else if(startingHour.getHours()<6||startingHour.getHours()==12)
        	{
        		NormalHour=NormalHour+0;
        		LowerPayHour=LowerPayHour+0;
        		if(startingHour.getMinutes()==0&&EndingHour.getMinutes()==0)
        		{
        			ExtraPayHour=ExtraPayHour+((EndingHour.getHours()-startingHour.getHours()));
        		}
        		else if(startingHour.getMinutes()==0&&EndingHour.getMinutes()!=0)
        		{
        			ExtraPayHour=ExtraPayHour+((EndingHour.getHours()-startingHour.getHours())+(((double)EndingHour.getMinutes()/60)));
        		}
        		else if(startingHour.getMinutes()!=0&&EndingHour.getMinutes()==0)
        		{
        			ExtraPayHour=ExtraPayHour+(((EndingHour.getHours()-1)-startingHour.getHours())+((60-((double)EndingHour.getMinutes())/60)));
        		}
        		else if((startingHour.getMinutes()!=0&&EndingHour.getMinutes()!=0))
        		{
        			if(EndingHour.getMinutes()>startingHour.getMinutes())
        			{
        				ExtraPayHour=ExtraPayHour+((EndingHour.getHours()-startingHour.getHours())+(((double)EndingHour.getMinutes()-(double)startingHour.getMinutes())/60));
        			}
        			else if(EndingHour.getMinutes()<startingHour.getMinutes())
        			{
        				ExtraPayHour=ExtraPayHour+(((EndingHour.getHours()-1)-startingHour.getHours())+(((60-(double)startingHour.getMinutes())+(double)EndingHour.getMinutes())/60));
        			}
        			else if(EndingHour.getMinutes()==startingHour.getMinutes())
        			{
        				ExtraPayHour=ExtraPayHour+(EndingHour.getHours()-startingHour.getHours());
        			}
        		}
        	}
        }
        return new BabysitterWorkingHour(ID,WorkingDays, NormalHour,LowerPayHour,ExtraPayHour);
    }

}
