package hw4;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Scanner;
	
	public class PointApp 
	{
		public static void main(String[] args) throws FileNotFoundException
		{
			int []x1=new int[7];
			int []y1=new int[7];
			int []x2=new int[7];
			int []y2=new int[7];
			int counter=read(x1,y1,x2,y2);
			for(int a=0;a<counter;a++)
			{
				int Fquadrant1=quadrantTest(x1[a],y1[a]);
				int Fquadrant2=quadrantTest(x2[a],y2[a]);
				int x3=x1[a]+x2[a];
				int y3=y1[a]+y2[a];
			    int Fquadrant3=quadrantTest(x3,y3);
				System.out.println("p1: ("+x1[a]+", "+y1[a]+") (quadrant "+Fquadrant1+") / p2: ("+
				x2[a]+", "+y2[a]+") (quadrant "+Fquadrant2+")");
				System.out.println("p1+p2: ("+x3+", "+y3+") (quadrant "+Fquadrant3+")");
				double distanceToOrigin1,distanceToOrigin2;
				distanceToOrigin1=Math.sqrt((x1[a]*x1[a])+(y1[a]*y1[a]));
				distanceToOrigin2=Math.sqrt((x2[a]*x2[a])+(y2[a]*y2[a]));
				
				if(x1[a]==0&&x2[a]==0&&y1[a]==0&&y2[a]==0)
				{
					System.out.println("p1 and p2 are reflections across the x-axis");
				}
				else if((x1[a]==x2[a])&&(y1[a]!=y2[a])&&(Math.abs(y1[a])==Math.abs(y2[a])))
				{
					System.out.println("p1 and p2 are reflections across the x-axis");
				}
				else {}
				
				if(x1[a]==0&&x2[a]==0&&y1[a]==0&&y2[a]==0)
				{
					System.out.println("p1 and p2 are reflections across the y-axis");
				}
				else if((y1[a]==y2[a])&&(x1[a]!=x2[a])&&Math.abs(x1[a])==Math.abs(x2[a]))
				{
					System.out.println("p1 and p2 are reflections across the y-axis");
				}
				else {}
				
					
				if(x1[a]==0&&x2[a]==0&&y1[a]==0&&y2[a]==0)
				{
					System.out.println("p1 and p2 are reflections through the origin");
				}
				else if((x1[a]!=x2[a])&&(y1[a]!=y2[a])&&(Math.abs(x1[a])==Math.abs(x2[a]))&&(Math.abs(y1[a])==Math.abs(y2[a])))
				{
					System.out.println("p1 and p2 are reflections through the origin");
				}
				else {}
				
				
				
				if(x1[a]==0&&x2[a]==0&&y1[a]==0&&y2[a]==0)
				{
					System.out.println("p1 and p2 are equidistant from the origin");
				}
				else if(distanceToOrigin1==distanceToOrigin2)
				{
					System.out.println("p1 and p2 are equidistant from the origin");
				}
				else {}
				
				double distanceBetween2=0.0;
				
				if(x1[a]==x2[a]&&y1[a]==y2[a])
				{
					distanceBetween2=0.0;
				}
				else if(y1[a]==y2[a])
				{
					distanceBetween2=Math.abs(x1[a])+Math.abs(x2[a]);
				}
				else if(x1[a]==x2[a])
				{
					distanceBetween2=Math.abs(y1[a])+Math.abs(y2[a]);
				}
				else if(x2[a]>x1[a]&&y2[a]>y1[a])
				{
					distanceBetween2=Math.sqrt(Math.pow(y2[a]-y1[a], 2)+Math.pow(x2[a]-x1[a], 2));
				}
				else if(y1[a]!=y2[a]&&x1[a]!=x2[a])
				{
					
					distanceBetween2=Math.sqrt(Math.pow((Math.abs(x1[a])+Math.abs(x2[a])), 2)+Math.pow((Math.abs(y1[a])+Math.abs(y2[a])), 2));
				}

				System.out.println("The distance between ("+x1[a]+", "+y1[a]+") and ("+x2[a]+", "+y2[a]+") is "+distanceBetween2+"\n");
				}
		}
		public static int read(int[]x1,int[]y1,int[]x2,int[]y2) throws FileNotFoundException
		{
			Scanner sc = new Scanner(new File("D:\\Assignments File\\2020 spring bc\\csic\\week4\\points.txt"));
	        int counter = 0;
		    while (sc.hasNext()) 
		    {
	            x1[counter] = sc.nextInt();
	            y1[counter]=sc.nextInt();
	            x2[counter]=sc.nextInt();
	            y2[counter]=sc.nextInt();
	            counter++;
	        }
		    sc.close();;
		    return counter;
		}
		public static int quadrantTest(int x1,int y1)
		{
			if(x1==0&&y1>0)
			{
				return 0;
			}
			else if(x1>0&&y1==0)
			{
				return 4;
			}
			else if (x1>0&&y1>0)
			{
				return 1;
			}
			else if(x1>0&&y1<0)
			{
				return 4;
			}
			else if(x1<0&&y1>0)
			{
				return 2;
			}
			else if(x1<0&&y1<0)
			{
				return 3;
			}
			else if(x1==0&&y1==0)
			{
				return 0;
			}
			else
			{return 0;}
		}
	}
