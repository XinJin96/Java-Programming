package hw1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList; 
import java.util.List; 
import java.util.Map; 
import java.util.Scanner;
import java.util.TreeMap;
//  The comments tell you which methods you should implement.
// Do not delete the code I've written. 
// I'm avaiable via email for questions about instructions that you find unclear, etc. 
// You may write toString methods and other additional methods if you wish. 


public class YourFirstNameYourLastName_FinalExam {  
	// You don't have to write a main method. If you wish, you can use it to 
	// test your classes and methods.   
	public static void main(String[] args) {   
		List<Object> list = new ArrayList<>(); 
		list.add("21212");
        list.add("sasa"); 
        list.add("dasda"); 
        int n=2;
        printList(list,n);

	}      
	
	// This method:    
	//  - Is given a List (which can be an ArrayList or a Linkedist, since both   
	//    are classes that implement the List interface); the list contains   
	//    any type of object. It is also given an int, n, indicating how many    
	//    elements of the list should be printed.  
	//  - The method should print the first n elements of the list using recursion;   
	//    you must use recursion in this method in order to get credit for this method.   
	//  - Here is the idea: if there are no elements to print, then exit the method.   
	//    Otherwise, we want to print n elements; do this by printing the last  
    //    one of those n elements, and then recursively printing the remaining 

    //    n - 1 elements. 
	public static void printList(List<?> list, int n) 
	{
		if(n==0)
		{
			System.out.println("done printing");
		}
		System.out.println(list.get(n));
		if(n>1)
		{
			printList(list,n-1);
		}
    }       
	// This method:   
	//  - Is given a List (which can be an ArrayList or a Linkedist, since both  
    //    are classes that implement the List interface) containing elements of   
	//    type E, where E must extend Comparable<E>.    
	//  - Should return a Pair<E, E>, where the first element of the pair is the     
	//    maximum element of the list, and the second element of the pair is the     
	//    minimum element of the list. 
	public static <E extends Comparable<E>> Pair<E, E> maxAndMin(List<E> list) 
	{
		
		List<E> comparelist=new ArrayList<>(list);
		E max=comparelist.get(0);
		E min=comparelist.get(0);
		for (int i = 1; i < list.size(); i++) {
            if (comparelist.get(i).compareTo(max) > 0) 
            {
                max = comparelist.get(i);
            }
        }
		for (int i = 1; i < list.size(); i++) {
            if (comparelist.get(i).compareTo(min) < 0) 
            {
                min = comparelist.get(i);
            }
        }
		return new Pair(max, min);
    } 
}
class College {  
	private Map<Identification, Student> students;  
	// - Sets the students field to be a new TreeMap.  
	// - Creates a Scanner to read from the file whose name is provided as the    
	//   argument to this method.   
	// - Reads in data for Students from the file, doing this repeatedly for all     
	//   the studets in the file. For each student, it should put the student     
	//   into the TreeMap, using the Identification of the Student as the key.    
	public College(String filename) throws FileNotFoundException 
	{
		
		students = new TreeMap<Identification, Student>();
        Scanner scanner = new Scanner(new File("studentfile"));
        while (scanner != null) {
            Student info=Student.read(scanner);
            students.put(info.getID(),info);
        }
    }      
	
	// - If a Student with the given Identification cannot be found in the TreeMap, 
    //   return null.  
	// - Otherwise, return a copy of the Student who has the given Identification.   
	public Student lookup(Identification id) 
	{
		if(students.get(id)==null)
		{
			return null;
		}
		else
		{
			return new Student(students.get(id));
		}
    } 
	}

/***************** Student ****************************************************/

class Student extends Person implements Comparable<Student> { 
	private Identification id;   
	private LinkedList<Course> currentCourses;   
	private ArrayList<Course> previousCourses;     
	// Assigns the appropriate values to the fields. (Make sure to only assign     
	// a *copy* of a parameter to a field.) Also initializes currentCourses and    
	// previousCourses to be empty lists.  
	public Student(Name name, Address address, String email, Identification id) 
	{ 
		super(name, address, email);
		this.id=new Identification(id);
		LinkedList<Course> currentCourses=new LinkedList<>();
		ArrayList<Course> previousCourses=new ArrayList<>();
    }       
	// This constructor is like the previous one, except that this one is    
	// intended to be used when a student joins the college upon transferring    
    // from another school. The Student comes with some transfer courses,   
    // which are stored in the transferCourses array.     
	// This constructor should first call the other constructor o this class.    
	// Then, instead of leaving previousCourses as the empty list, it should    
	// rather add all the Courses in transferCourses to the previousCourses list.    
	// (currentCourses should remain empty, though.)   
	public Student(Name name, Address address, String email, Identification id, Course[] transferCourses) 
	{ 
		this(name,address,email, id);
		Collections.addAll(previousCourses, transferCourses);
    }        
	// Fill in this copy constructor   
	public Student(Student old) 
	{
		super(old);
		this.id=old.id;
    }        
	// Adds a Course to the currentCourses list. But don't directly add the    
	// parameter to the list; instead, add a *copy* of the parameter to the list.    
	public void addCourse(Course course) 
	{
		Course copy=course;
		currentCourses.add(copy);
    }        
	// For the purposes of this method, if we have two Students, A and B:   
	//  - A is considered to be greater than B if A has completed more credits than B has;     
	//  - A is considered to be less than B if A has completed fewer credits than B has; and   
	//  - A is considered to be equal to B if they have each completed the same number of credits.    
	@Override    
	public int compareTo(Student other) 
	{
		if(this.getTotalCreditsCompleted()>other.getTotalCreditsCompleted())
		{
			return 1;
		}
		else if(this.getTotalCreditsCompleted()<other.getTotalCreditsCompleted())
		{
			return -1;
		}
		else
		{
			return 0;
		}
    }        
	// Two Student objects are considered equal if their Names, Addresses,     
	// emails, and IDs are equal. You do NOT need to check if they have the same     
	// previousCourses and the same currentCourses.    
	@Override    
	public boolean equals(Object obj) {
		if(obj instanceof Student)
		{
			Student other=(Student)obj;
			return super.equals(other)&&this.id.equals(other.id);
		}
		else 
		{
			return false;
		}
    }    


	// Returns a copy of the id field.   
	public Identification getID()
	{ 
		return id;
    }       
	// Returns the total number of credits that this Student has already completed    
	// (note that a course may obviously be worth more than one credit, so don't    
	// just count the number of completed courses). Do not count the credits for     
	// the courses the Student is currently taking; only consider the credits for    
	// those courses that are over.   
	public int getTotalCreditsCompleted() 
	{
		int total=0;
		for(int i=0; i<previousCourses.size();i++)
		{
			total+=(previousCourses.get(i).getNumCredits());
		}
		return total;
    }    
    // This method is designed to be called after the semster is over and grades    
	// have been submitted. Here's what this method should do:     
	//  - it should remove each of the courses in currentCourses, one at a time;    
	//  - for each of those courses, if the grade of the course is not equal to     
	//    "F", add the course to previous courses.    
	public void postSemesterProcess() 
	{
		for(int i=0; i<currentCourses.size();i++)
		{
			Course done=currentCourses.get(i);
			if(done.getGrade()!="F")
			{
				previousCourses.add(done);
			}
			currentCourses.remove(i);
		}
    }        
	// Here is what this method should do:    
	// - If there is nothing more to be read in from the Scanner, simply return null.    
	// - Otherwise, start a try block (we'll see why soon). Inside the try block:    
	//     - Create the following based on information read in from the Scanner     
	//       (in this order): a Name object, an Addresss object, and an email    
	//       (which is a String).     
	//     - Next, read in a header, which you should assume will be a nonnegative    
	//       int, representing the number of previous courses the student has taken. 
    //     - If the header is not 0, read in as many courses as specified by the     
	//       header and store the the Course objects in an array.    
	//     - Next, read in a Identification. The creation of the Identification     
	//       object might cause an exception, in case what's read in from the file    
	//       for the Identification isn't in the proper format(see the Identification   
	//       class). There should be a catch block to deal with the exception; see below.    
	//     - If the header that was already read in was 0, meaning the student     
	//       isn't entering with previous courses, call the first constructor and     
	//       return the new Student.    
	//     - Otherwise, call the second constructor and return the new Student.   
	// - The catch block should handle an IllegalIdentificationException, if     
	//   necessary. Here's what it should do:    
	//     - Read in and discard a line from the Scanner (i.e., by calling the     
	//       nextLine() method and just not doing anything with the line.    
	//     - Return null.    
	public static Student read(Scanner sc) {    
		if (!sc.hasNext()) 
            return null;
		try
		{
			Name name=Name.read(sc);
			Address address=Address.read(sc);
			String mail=sc.next();
			int header=sc.nextInt();
			if(header!=0)
			{
				Course[]transferCourse = null;
			    for (int i = 0; i < header; i++) 
			    {
			    	transferCourse[i]=Course.read(sc);
			    }
			    Identification id=Identification.read(sc);
			    return new Student(name,address,mail,id,transferCourse);
			}	
			if(header==0)
			{
				Identification id=Identification.read(sc);
				return new Student(name,address, mail,id);
			}
		}
		catch(IllegalIdentificationException e)
		{
			sc.nextLine();
			return null;
		}
	} 
	}
/***************** Identification *********************************************/

class Identification implements Comparable<Identification> {  
	private String id;       
	public Identification(String id) throws IllegalIdentificationException {       
		setID(id);   
		}       
	public Identification(Identification old) {  
		this.id = old.id; 
    }       
	// Before setting the id field to the String provided in the parameter, this     
	// method first must check to make sure that it's a legal ID. In order to be    
	// legal, it it must be exactly 8 characters long and only contain digits     
	// (0, 1, 2, ... or  9). If the String is illegal, throw an     
	// IllegalIdentificationException. Otherwise, assign the provided String (the     
	// parameter) to the id field.     
	// Hint: there's a static boolean method called isDigit in the Character class.    
	// The isDigit method takes a character (not a String) and returns true if it's     
	// a digit and false if it isn't.   
	public void setID(String id) throws IllegalIdentificationException {       
		
	}      
	public String getID() {  
		return id;   
		}        
	@Override  
	public boolean equals(Object obj) {  
		if (obj instanceof Identification)  
			return this.id.equals(((Identification)obj).id);   
		else      
			return false;  
   }
    @Override 
    public int compareTo(Identification other) { 
    	return this.id.compareTo(other.id); 
    	} 
    public static Identification read(Scanner sc) throws IllegalIdentificationException {  
    	if (!sc.hasNext())    
    		return null;    
    	return new Identification(sc.next());  
    	} 
    }
/***************** IllegalIdentificationException *****************************/

class IllegalIdentificationException extends Exception { 
	public IllegalIdentificationException(String message) { 
		super(message);  
		} 
	}
/***************** Person *****************************************************/

class Person {  
	private Name name;  
	private Address address; 
	private String email;    
	public Person(Name name, Address address, String email) {   
		this.name = new Name(name);    
		this.address = new Address(address);       
		this.email = email;   
		}       
	public Person(Person old) {    
		this.name = new Name(old.name); 
        this.address = new Address(old.address);    
        this.email = old.email;    }      
	public boolean equals(Object obj) {    
		if (obj instanceof Person) {        
			Person other = (Person)obj;     
			return this.name.equals(other.name) && this.address.equals(other.address) &&
					this.email.equals(other.email);    
			} else {     
				return false;     
				}   
		} 
	}



/***************** Course *****************************************************/

class Course {  
	private int numCredits; 
	private String title, grade; // assume the title is just one string, like "CISC3115"     
	public Course(String title, int numCredits) {  
		this.title = title;      
		this.numCredits = numCredits;    
		this.grade = "In progress";  
		}      
	public Course(Course old) {    
		this.title = old.title;    
		this.numCredits = old.numCredits; 
        this.grade = old.grade; 

    }      
	public int getNumCredits() { return numCredits; }  
	
	public String getGrade() { return grade; }    
	
	public void setGrade(String grade) { this.grade = grade; }
	
    public static Course read(Scanner sc) {   
    	if (!sc.hasNext())         
    		return null;    
    	String title = sc.next();     
    	int numCredits = sc.nextInt();
    	return new Course(title, numCredits); 
    	} 
    }

/******************************* Address **************************************/

class Address {  
   private String number, street, apt, city, state, zip, country;     
   public Address(String number, String street, String apt, String city, String state, String zip, String country) {     
	   this.number = number;     
	   this.street = street;      
	   this.apt = apt;      
	   this.city = city;      
	   this.state = state;      
	   this.zip = zip;     
	   this.country = country; 
    }       
   public Address(Address old) {  
     this.number = old.number;   
     this.street = old.street;   
     this.apt = old.apt;      
     this.city = old.city;      
     this.state = old.state;    
     this.zip = old.zip;      
     this.country = old.country;   
     }      
   @Override   
   public boolean equals(Object obj) {  
	   if (obj instanceof Address) {  
		   Address other = (Address)obj;     
		   return this.number.equals(other.number) && this.street.equals(other.street) &&  
				   this.apt.equals(other.apt) && this.city.equals(other.city) &&    
				   this.state.equals(other.state) && this.zip.equals(other.zip) &&          
				   this.country.equals(other.country); 
		   }      
	   else         
		   return false;   
	   }       
   public static Address read(Scanner sc) {  
	   if (!sc.hasNext())       
		   return null;       
	   String number = sc.next(), street = sc.next(), apt = sc.next(),      
			   city = sc.next(), state = sc.next(), zip = sc.next(), country = sc.next();   
	   return new Address(number, street, apt, city, state, zip, country); 

    } 
   }

/*********************** Name *************************************************/

class Name {   
	private String first, last;  
    public Name(String first, String last) {    
    	this.first = first;       
    	this.last = last;   
    	}       
    public Name(Name old) {   
    	this.first = old.first;  
    	this.last = old.last;  
    	}      
    public String getFirst() { return first; }  
    
    public String getLast() { return last; }  
    
    @Override  
    public boolean equals(Object obj) {   
    	if (obj instanceof Name) {       
    		Name other = (Name)obj;    
    		return this.first.equals(other.first) && this.last.equals(other.last);  
    		} else {   
    			return false;    
    			}   
    	} 
        @Override   
        public String toString() { return first + " " + last; } 
        
        public static Name read(Scanner sc) {   
        	if (!sc.hasNext())        
        		return null;     
        	String first = sc.next();   
        	String last = sc.next();    
        	return new Name(first, last);  
        	} 
        }
/***************** Pair *******************************************************/

class Pair<S, T> {    
	private S first;   
	private T second;   
	
	public Pair(S first, T second) {   
		this.first = first;      
		this.second = second;  
		}      
	public S getFirst() { return first; }    
	public T getSecond() { return second; }
	}

