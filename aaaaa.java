package midtern;
import java.io.*; 
  
class GFG  
{ 
    static double diff(double n,double mid) 
    { 
        if (n > (mid*mid*mid)) 
            return (n-(mid*mid*mid)); 
        else
            return ((mid*mid*mid) - n); 
    } 
    static double cubicRoot(double n) 
    { 
        double start = 0, end = n; 
        double e = 0.0000001; 
   
        while (true) 
        { 
            double mid = (start + end)/2; 
            double error = diff(n, mid); 
            if (error <= e) 
                return mid; 
            if ((mid*mid*mid) > n) 
                end = mid; 
            else
                start = mid; 
        } 
    } 
    public static void main (String[] args)  
    { 
        double n = 3; 
        System.out.println("Cube root of "+n+" is "+cubicRoot(n)); 
    } 
} 