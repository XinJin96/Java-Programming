package hw2;

import java.util.Scanner;

public class InitializeArrayUsingRecursion {

public static void intializeArrayWithValue(int[][] arr, int row, int col, int val) {

arr[row][col] = val; //initialize value
if (row == 0 && col == 0) {
return;
}
if (col == 0) {
intializeArrayWithValue(arr, row - 1, arr[0].length - 1, val); //make recursive call for prev row
} else {
intializeArrayWithValue(arr, row, col - 1, val); //initialize recursively all col value of row
}
}

public static void main(String[] args) {
int row, col;
Scanner s = new Scanner(System.in);
System.out.println("Enter no. of rows and cols: ");
row = s.nextInt();
col = s.nextInt();
int arr[][] = new int[row][col];
int init;
System.out.println("Enter no. with which you want to initialize array: ");
init = s.nextInt();
//initialize array recursively
intializeArrayWithValue(arr, row - 1, col - 1, init);
//print array
System.out.println("Initialized Array: ");
for (int i = 0; i < row; i++) {
for (int j = 0; j < col; j++) {
System.out.print(arr[i][j] + " ");
}
System.out.println("\n");
}
}
}