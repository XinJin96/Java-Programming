package hw1;
import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
public class FindLast {
	public static void main(String[]str) throws ParseException {

		SimpleDateFormat convertTool =   new SimpleDateFormat("HH:mm"); 
		java.util.Date nineolockstandard=convertTool.parse("9:30");
    	java.util.Date twelveolockstandard=convertTool.parse("12:00");
    	double a=nineolockstandard.getMinutes();
    	System.out.println((double)nineolockstandard.getMinutes()/60);
}}