	package hw5;
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.Arrays;
	import java.util.Scanner;
	
	public class hw5 {
		public static void main(String[] args) throws FileNotFoundException 
		{
			// read, print, and store them in appreciate arrays
			Scanner scan = new Scanner(new File("D:\\Assignments File\\2020 Summer BC\\Data Structure\\HW5\\DataFile.txt"));
			String sort10=scan.nextLine();
			System.out.println(sort10);
			sort10=sort10.substring(sort10.indexOf(":")+2,sort10.length());
			int counter10=10;
			int sort10Array[]=new int [counter10];
			for (int i=0;i<counter10;i++)
			{
				sort10Array[i]=Integer.parseInt(sort10.substring(3*i,3*i+2));
				
			}
			
			String random10=scan.nextLine();
			System.out.println(random10);
			random10=random10.substring(random10.indexOf(":")+2,random10.length());
			int random10Array[]=new int [counter10];
			for (int i=0;i<counter10;i++)
			{
				random10Array[i]=Integer.parseInt(random10.substring(3*i,3*i+2));
			}
			
			String reverse10=scan.nextLine();
			System.out.println(reverse10);
			reverse10=reverse10.substring(reverse10.indexOf(":")+2,reverse10.length());
			int reverse10Array[]=new int [counter10];
			for (int i=0;i<counter10;i++)
			{
				reverse10Array[i]=Integer.parseInt(reverse10.substring(3*i,3*i+2));
				
			}
			
			String sort30=scan.nextLine();
			System.out.println(sort30);
			sort30=sort30.substring(sort30.indexOf(":")+2,sort30.length());
			int counter30=30;
			int sort30Array[]=new int [counter30];
			for (int i=0;i<counter30;i++)
			{
				sort30Array[i]=Integer.parseInt(sort30.substring(3*i,3*i+2));
			}
			
			String random30=scan.nextLine();
			System.out.println(random30);
			random30=random30.substring(random30.indexOf(":")+2,random30.length());
			int random30Array[]=new int [counter30];
			for (int i=0;i<counter30;i++)
			{
				random30Array[i]=Integer.parseInt(random30.substring(3*i,3*i+2));
			}
			
			String reverse30=scan.nextLine();
			System.out.println(reverse30);
			reverse30=reverse30.substring(reverse30.indexOf(":")+2,reverse30.length());
			int reverse30Array[]=new int [counter30];
			for (int i=0;i<counter30;i++)
			{
				reverse30Array[i]=Integer.parseInt(reverse30.substring(3*i,3*i+2));
			}
			
			String sort50=scan.nextLine();
			System.out.println(sort50);
			sort50=sort50.substring(sort50.indexOf(":")+2,sort50.length());
			int counter50=50;
			int sort50Array[]=new int [counter50];
			for (int i=0;i<counter50;i++)
			{
				sort50Array[i]=Integer.parseInt(sort50.substring(3*i,3*i+2));
			}
			
			
			String random50=scan.nextLine();
			System.out.println(random50);
			random50=random50.substring(random50.indexOf(":")+2,random50.length());
			int random50Array[]=new int [counter50];
			for (int i=0;i<counter50;i++)
			{
				random50Array[i]=Integer.parseInt(random50.substring(3*i,3*i+2));
			}
			
			String reverse50=scan.nextLine();
			System.out.println(reverse50);
			reverse50=reverse50.substring(reverse50.indexOf(":")+2,reverse50.length());
			int reverse50Array[]=new int [counter50];
			for (int i=0;i<counter50;i++)
			{
				reverse50Array[i]=Integer.parseInt(reverse50.substring(3*i,3*i+2));
			}
			scan.close();
	
			//bubble sort for almost sorted 10 number
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("10 almost sorted numbers after bubble sort: "+bubblesortGetSorted(sort10Array));
			int BubbleSortsort10Time=bubblesortGetCount(sort10Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortsort10Time+ " steps.");
	        
	        //bubble sort for random sorted 10 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("10 random sorted numbers after bubble sort: "+bubblesortGetSorted(random10Array));
			int BubbleSortrandom10Time=bubblesortGetCount(random10Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortrandom10Time+ " steps.");
	        
	        //bubble sort for reverse sorted 10 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("10 reversed sorted numbers after bubble sort: "+bubblesortGetSorted(reverse10Array));
			int BubbleSortreverse10Time=bubblesortGetCount(reverse10Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortreverse10Time+ " steps.");
	       
	        //bubble sort for almost sorted 30 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("30 almost sorted numbers after bubble sort: "+bubblesortGetSorted(sort30Array));
			int BubbleSortsort30Time=bubblesortGetCount(sort30Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortsort30Time+ " steps.");
	        
	        //bubble sort for random sorted 30 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("30 random sorted numbers after bubble sort: "+bubblesortGetSorted(random30Array));
			int BubbleSortrandom30Time=bubblesortGetCount(random30Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortrandom30Time+ " steps.");
	        
	        //bubble sort for reverse sorted 30 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("30 reversed sorted numbers after bubble sort: "+bubblesortGetSorted(reverse30Array));
			int BubbleSortreverse30Time=bubblesortGetCount(reverse30Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortreverse30Time+ " steps.");
	        
	
	        //bubble sort for almost sorted 50 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("50 almost sorted numbers after bubble sort: "+bubblesortGetSorted(sort50Array));
			int BubbleSortsort50Time=bubblesortGetCount(sort50Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortsort50Time+ " steps.");
	        
	        //bubble sort for random sorted 50 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("50 random sorted numbers after bubble sort: "+bubblesortGetSorted(random50Array));
			int BubbleSortrandom50Time=bubblesortGetCount(random50Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortrandom50Time+ " steps.");
	        
	        //bubble sort for reverse sorted 50 number
	        System.out.println("-------------------------------------------------------------------------");
			System.out.println("50 reversed sorted numbers after bubble sort: "+bubblesortGetSorted(reverse50Array));
			int BubbleSortreverse50Time=bubblesortGetCount(reverse50Array);
	        System.out.println("Sorting sorted 10 number by using bubble sort took "+BubbleSortreverse50Time+ " steps.");
	        
	        //quick Sort for almost sorted 10 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortsort10Time=quickSortGetCount(sort10Array,0,9);
	        System.out.println("10 almost sorted numbers after quick sort: "+quickSort(sort10Array,0,9));
	        System.out.println("Sorting sorted 10 number by using quick sort took "+QuickSortsort10Time+ " steps.");
	        //quick Sort for random 10 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortrandom10Time=quickSortGetCount(random10Array,0,9);
	        System.out.println("10 random numbers after quick sort: "+quickSort(random10Array,0,9));
	        System.out.println("Sorting random 10 number by using quick sort took "+QuickSortrandom10Time+ " steps.");
	        //quick Sort for reverse sorted 10 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortreverse10Time=quickSortGetCount(reverse10Array,0,9);
	        System.out.println("10 reverse sorted numbers after quick sort: "+quickSort(reverse10Array,0,9));
	        System.out.println("Sorting reverse 10 number by using quick sort took "+QuickSortreverse10Time+ " steps.");
	        //quick Sort for almost sorted 30 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortsort30Time=quickSortGetCount(sort30Array,0,29);
	        System.out.println("30 almost sorted numbers after quick sort: "+quickSort(sort30Array,0,29));
	        System.out.println("Sorting sorted 30 number by using quick sort took "+QuickSortsort30Time+ " steps.");
	        //quick Sort for random 30 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortrandom30Time=quickSortGetCount(random30Array,0,29);
	        System.out.println("30 random numbers after quick sort: "+quickSort(random30Array,0,29));
	        System.out.println("Sorting random 30 number by using quick sort took "+QuickSortrandom30Time+ " steps.");
	        //quick Sort for reverse sorted 30 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortreverse30Time=quickSortGetCount(reverse30Array,0,29);
	        System.out.println("30 reverse sorted numbers after quick sort: "+quickSort(reverse30Array,0,29));
	        System.out.println("Sorting reverse 30 number by using quick sort took "+QuickSortreverse30Time+ " steps.");
	        //quick Sort for almost sorted50 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortsort50Time=quickSortGetCount(sort50Array,0,49);
	        System.out.println("50 almost sorted numbers after quick sort: "+quickSort(sort50Array,0,49));
	        System.out.println("Sorting almost sorted 50 number by using quick sort took "+QuickSortsort50Time+ " steps.");
	        //quick Sort for random 50 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortrandom50Time=quickSortGetCount(random50Array,0,49);
	        System.out.println("50 random sorted numbers after quick sort: "+quickSort(random50Array,0,49));
	        System.out.println("Sorting random sorted 50 number by using quick sort took "+QuickSortrandom50Time+ " steps.");
	        //quick Sort for reverse sorted 50 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int QuickSortreverse50Time=quickSortGetCount(reverse50Array,0,49);
	        System.out.println("50 reversed sorted numbers after quick sort: "+quickSort(reverse50Array,0,49));
	        System.out.println("Sorting reversed sorted 50 number by using quick sort took "+QuickSortreverse50Time+ " steps.");
	        
	        
	        
	        
	        //merge Sort for almost sorted 10 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortsort10Time=MergeSortGetTime(sort10Array,10);
	        System.out.println("10 almost sorted numbers after merge sort: "+mergeSort(sort10Array,10));
	        System.out.println("Sorting 10 almost sorted 10 number by using merge sort took "+MergeSortsort10Time+ " steps.");
	        //merge Sort for random 10 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortrandom10Time=MergeSortGetTime(random10Array,10);
	        System.out.println("10 random numbers after merge sort: "+mergeSort(random10Array,10));
	        System.out.println("Sorting 10 random number by using merge sort took "+MergeSortrandom10Time+ " steps.");
	        //merge Sort for reverse sorted 10 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortreverse10Time=MergeSortGetTime(reverse10Array,10);
	        System.out.println("10 reversed sorted numbers after merge sort: "+mergeSort(reverse10Array,10));
	        System.out.println("Sorting 10 reversed sorted number by using merge sort took "+MergeSortreverse10Time+ " steps.");
	        //merge Sort for almost sorted 30 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortsort30Time=MergeSortGetTime(sort30Array,30);
	        System.out.println("30 almost sorted numbers after merge sort: "+mergeSort(sort30Array,30));
	        System.out.println("Sorting 30 almost sorted number by using merge sort took "+MergeSortsort30Time+ " steps.");
	        //merge Sort for random 30 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortrandom30Time=MergeSortGetTime(random30Array,30);
	        System.out.println("30 random numbers after merge sort: "+mergeSort(random30Array,30));
	        System.out.println("Sorting 30 random number by using merge sort took "+MergeSortrandom30Time+ " steps.");
	        //merge Sort for reverse sorted 30 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortreverse30Time=MergeSortGetTime(reverse30Array,30);
	        System.out.println("30 reversed sorted numbers after merge sort: "+mergeSort(reverse30Array,30));
	        System.out.println("Sorting 30 reverse sorted number by using merge sort took "+MergeSortreverse30Time+ " steps.");
	        //merge Sort for almost sorted50 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortsort50Time=MergeSortGetTime(sort50Array,50);
	        System.out.println("50 almost sorted numbers after merge sort: "+mergeSort(sort50Array,50));
	        System.out.println("Sorting 50 almost sorted number by using merge sort took "+MergeSortsort50Time+ " steps.");
	        //merge Sort for random 50 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortrandom50Time=MergeSortGetTime(random50Array,50);
	        System.out.println("50 random numbers after merge sort: "+mergeSort(random50Array,50));
	        System.out.println("Sorting 50 random number by using merge sort took "+MergeSortrandom50Time+ " steps.");
	        //merge Sort for reverse sorted 50 numbers
	        System.out.println("-------------------------------------------------------------------------");
	        int MergeSortreverse50Time=MergeSortGetTime(reverse50Array,50);
	        System.out.println("50 reverse sorted numbers after merge sort: "+mergeSort(reverse50Array,50));
	        System.out.println("Sorting 50 reverse sorted number by using merge sort took "+MergeSortreverse50Time+ " steps.");
	        System.out.println("-------------------------------------------------------------------------");
	        
	        //comparing
	        System.out.println("comparing three sorting method with 10 almost sort number:"+compareTo(BubbleSortsort10Time,QuickSortsort10Time,MergeSortsort10Time));
	        System.out.println("comparing three sorting method with 10 random number:"+compareTo(BubbleSortrandom10Time,QuickSortrandom10Time,MergeSortrandom10Time));
	        System.out.println("comparing three sorting method with 10 reverse sort number:"+compareTo(BubbleSortreverse10Time,QuickSortreverse10Time,MergeSortreverse10Time));
	        System.out.println("comparing three sorting method with 30 almost sort number:"+compareTo(BubbleSortsort30Time,QuickSortsort30Time,MergeSortsort30Time));
	        System.out.println("comparing three sorting method with 30 random number:"+compareTo(BubbleSortrandom30Time,QuickSortrandom30Time,MergeSortrandom30Time));
	        System.out.println("comparing three sorting method with 30 reverse sort number:"+compareTo(BubbleSortreverse30Time,QuickSortreverse30Time,MergeSortreverse30Time));
	        System.out.println("comparing three sorting method with 50 almost sort number:"+compareTo(BubbleSortsort50Time,QuickSortsort50Time,MergeSortsort50Time));
	        System.out.println("comparing three sorting method with 50 random numbers:"+compareTo(BubbleSortrandom50Time,QuickSortrandom50Time,MergeSortrandom50Time));
	        System.out.println("comparing three sorting method with 50 reverse numbers:"+compareTo(BubbleSortreverse50Time,QuickSortreverse50Time,MergeSortreverse50Time));
		}
		public static String compareTo(int bubble, int quick, int merge)
		{
			if (bubble>quick&&bubble>merge&&quick>merge)
			{
				return "bubble sort is less efficient than quick sort and merge sort";
			}
			else if(bubble>merge&&quick<merge&&bubble>quick)
			{
				return "bubble sort is less efficient than quick sort and merge sort,merge sort is more efficient than quick sort";
			}
			else if(bubble>quick&&quick==merge)
			{
				return "bubble sort is less effient than quick sort and merge sort, merge sort and quick sort are about same efficient.";
			}
			return null;
		
		}
	
		public static int bubblesortGetCount(int[]data)
		{
			int times=0;
			int n=data.length;
			for (int i = 0; i < n-1; i++) 
	        {
	            for (int j = 0; j < n-i-1; j++) 
	            {
	           	    times++;
	                if (data[j] > data[j+1]) 
	                { 
	                    int temp = data[j]; 
	                    data[j] = data[j+1]; 
	                    data[j+1] = temp; 
	                } 
	            }
	        }
			return times;
		
		}
		public static String bubblesortGetSorted(int[]data)
		{
			int n=data.length;
			for (int i = 0; i < n-1; i++) 
	        {
	            for (int j = 0; j < n-i-1; j++) 
	            {
	                if (data[j] > data[j+1]) 
	                { 
	                    int temp = data[j]; 
	                    data[j] = data[j+1]; 
	                    data[j+1] = temp; 
	                } 
	            }
	        }
			return Arrays.toString(data);
		}
		public static String quickSort(int[] arr, int low, int high) {
			if (arr == null || arr.length == 0)
				return Arrays.toString(arr);
	 
			if (low >= high)
				return Arrays.toString(arr);
	 
			// pick the pivot
			int middle = low + (high - low) / 2;
			int pivot = arr[middle];
	 
			// make left < pivot and right > pivot
			int i = low, j = high;
			while (i <= j) {
				while (arr[i] < pivot) {
					i++;
				}
	 
				while (arr[j] > pivot) {
					j--;
				}
	 
				if (i <= j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
			}
	 
			// recursively sort two sub parts
			if (low < j)
				quickSort(arr, low, j);
			if (high > i)
				quickSort(arr, i, high);
			return Arrays.toString(arr);
		}
		public static int quickSortGetCount(int[] arr, int low, int high) {
			int count=0;
			if (arr == null || arr.length == 0)
				return count;
	 
			if (low >= high)
				return count;
	 
			// pick the pivot
			int middle = low + (high - low) / 2;
			int pivot = arr[middle];
	 
			// make left < pivot and right > pivot
			int i = low, j = high;
			while (i <= j) {
				while (arr[i] < pivot) {
					i++;
					count++;
				}
	 
				while (arr[j] > pivot) {
					j--;
					count++;
				}
	 
				if (i <= j) {
					count++;
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
			}
	 
			// recursively sort two sub parts
			if (low < j)
				quickSortGetCount(arr, low, j);
			if (high > i)
				
				quickSortGetCount(arr, i, high);
			return count;
		}
		public static String mergeSort(int[] a, int n) {
		    if (n < 2) {
		        return Arrays.toString(a);
		    }
		    int mid = n / 2;
		    int[] l = new int[mid];
		    int[] r = new int[n - mid];
		 
		    for (int i = 0; i < mid; i++) {
		        l[i] = a[i];
		    }
		    for (int i = mid; i < n; i++) {
		        r[i - mid] = a[i];
		    }
		    mergeSort(l, mid);
		    mergeSort(r, n - mid);
		    int i = 0, j = 0, k = 0;
		    while (i < mid && j < (n-mid)) {
		        if (l[i] <= r[j]) {
		            a[k++] = l[i++];
		        }
		        else {
		            a[k++] = r[j++];
		        }
		    }
		    while (i < mid) {
		        a[k++] = l[i++];
		    }
		    while (j < (n-mid)) {
		        a[k++] = r[j++];
		    }
		    return Arrays.toString(a);
		 
		}
		
		public static int MergeSortGetTime(int[] a, int n) {
			int count=0;
		    if (n < 2) {
		        return count;
		    }
		    int mid = n / 2;
		    int[] l = new int[mid];
		    int[] r = new int[n - mid];
		 
		    for (int i = 0; i < mid; i++) {
		        l[i] = a[i];
		    }
		    for (int i = mid; i < n; i++) {
		        r[i - mid] = a[i];
		    }
		    MergeSortGetTime(l, mid);
		    MergeSortGetTime(r, n - mid);
		    int i = 0, j = 0, k = 0;
		    while (i < mid && j < (n-mid)) {
		        if (l[i] <= r[j]) {
		        	count++;
		            a[k++] = l[i++];
		        }
		        else {
		        	count++;
		            a[k++] = r[j++];
		        }
		    }
		    while (i < mid) {
		    	count++;
		        a[k++] = l[i++];
		    }
		    while (j < (n-mid)) {
		    	count++;
		        a[k++] = r[j++];
		    }
		    return count;
		}
	}
