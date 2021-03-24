package hw5;

public class Sorts
{
	private static int times;
	private int[] data;
	private int[]sortArray;
	public Sorts(int[]array)
	{
		this.data=array;
	}
	public int getTime()
	{
		return times;
	}
	public int[] getSortedArray()
	{
		return sortArray;
	}
	public static Sorts bubbleSort(int[]data)
	{
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
	}
	public static void quickSort(int[] arr, int start, int end){
		 
        int partition = partition(arr, start, end);
 
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
 
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
 
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
 
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
 
        return start;
    }
    
	
	
	
}
