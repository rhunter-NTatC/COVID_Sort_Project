package COVID_Sort;

import java.util.ArrayList;
import java.util.Scanner;

public class COVIDRunner {

	public static void main(String[] args) {
		
		//create JSONData object
		JSON_COVID_Data jsonData = new JSON_COVID_Data();
		
		menu(jsonData);
		
		System.out.println("\n      Goodbye!");
		
	}
	
	public static void menu(JSON_COVID_Data jsonData) {
		
		//get the ArrayList created by JSON_COVID_Data
		ArrayList<CountryCOVID> data = jsonData.getList();
		
		Scanner inKey = new Scanner(System.in);
		
		int input = 0;
		while (input != 9) {
			printMenu();
			input = inKey.nextInt();
			System.out.println("\n");
			
			switch (input) {
			case 1:
				bubbleSort(data);
				printList(jsonData);
				break;
			case 2:
				selectionSort(data);
				printList(jsonData);
				break;
			case 3:
				insertionSort(data);
				printList(jsonData);
				break;
			case 4:
				quickSort(data, 0, data.size() - 1);
				printList(jsonData);
				break;
			case 5:
				mergeSortNew(data, 0, data.size() - 1);
				printList(jsonData);
				break;
			case 6:
				mergeSortTotal(data, 0, data.size() - 1);
				printList(jsonData);
				break;
			case 7:
				if (checkSortConfirmed(data)) {
					System.out.print("\n\n      Enter the bottom of the range: ");
					int bottom = inKey.nextInt();
					System.out.print("      Enter the top of the range: ");
					int top = inKey.nextInt();
					findRangeConfirmed(data, jsonData, bottom, top);
				}
				else {
					System.out.println("\n\n      Error: Must sort by Total Confirmed Cases 1st\n\n");
				}
				break;
			case 8:
				if (checkSortDeaths(data)) {
					System.out.print("\n\n      Enter the bottom of the range: ");
					int bottom = inKey.nextInt();
					System.out.print("      Enter the top of the range: ");
					int top = inKey.nextInt();
					findRangeDeaths(data, jsonData, bottom, top);
				}
				else {
					System.out.println("\n\n      Error: Must sort by Total Deaths 1st\n\n");
				}
				break;
			case 9:
				break;
			default:
				System.out.println("\n\n      Not a Valid Input");
			}
			
		}
		
		inKey.close();
	}
	
	public static void printList(JSON_COVID_Data jsonData) {
		System.out.println(jsonData);
	}
	
	public static void printMenu() {
		System.out.println("\n\n        How would you like the data sorted?");
		System.out.println("===================================================");
		System.out.println("      1: Confirmed Cases:  New");
		System.out.println("      2: Confirmed Cases:  Total");
		System.out.println("      3: Recovered:        New");
		System.out.println("      4: Recovered:        Total");
		System.out.println("      5: Deaths:           New");
		System.out.println("      6: Deaths:           Total");
		System.out.println("      7: Print Range:      Total Confirmed Cases");
		System.out.println("      8: Print Range:      Total Deaths");	
		System.out.println("      9: Exit");
		System.out.print("\n      Enter Choice: ");
	}
	
	
	//swaps the values of the list at the given indexes
	public static void swap(ArrayList<CountryCOVID> data, int index1, int index2) {
		//TODO
		CountryCOVID temp = data.get(index1);
		data.set(index1, data.get(index2));
		data.set(index2, temp);
	}
	
	
	
	
	
	
	
	
	
	// MARK : ************* SORT FUNCTIONS *************

	/*
	 * BUBBLE SORT
	 * sorts the new confirmed cases
	 */
	public static void bubbleSort(ArrayList<CountryCOVID> data) {
		// TODO		
		
		
		
	}
	
	
	/*
	 * SELECTION SORT
	 * sorts total confirmed cases using a Selection Sort algorithm
	 */
	public static void selectionSort(ArrayList<CountryCOVID> data) {
		// TODO
	}
	
	
	
	/*
	 * INSERTION SORT
	 * sorts the new recovered using an Insertion Sort algorithm
	 */
	public static void insertionSort(ArrayList<CountryCOVID> data) {
		// TODO
	}
	
	
	
	/*
	 * MERGE SORT
	 * sorts the new deaths using a Merge Sort algorithm
	 */
	public static void mergeSortNew(ArrayList<CountryCOVID> data, int front, int back) {
		// TODO
	}
	
	public static void mergeNew(ArrayList<CountryCOVID> data, int front, int mid, int back) {
		// TODO
		
	}
	
	/*
	 * MERGE SORT
	 * Same as the above EXCEPT!!! it sorts the total deaths
	 */
	public static void mergeSortTotal(ArrayList<CountryCOVID> data, int front, int back) {
		// TODO
	}
	
	public static void mergeNewTotal(ArrayList<CountryCOVID> data, int front, int mid, int back) {
		// TODO
		
	}
	
	
	
	
	
	/*
	 * QUICK SORT
	 * Sorts the total recovered using a Quick Sort algorithm
	 */
	public static void quickSort(ArrayList<CountryCOVID> data, int low, int high) {
		// TODO
	}
	public static int partition(ArrayList<CountryCOVID> data, int low, int high) {
		// TODO
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	// MARK : ************* SEARCH FUNCTIONS *************
	
	/*
	 * Returns true if list is sorted by Total Confirmed Cases
	 */
	public static boolean checkSortConfirmed(ArrayList<CountryCOVID> data) {
		
		// TODO
		
		return false;
	}
	
	
	/*
	 * Returns true if list is sorted by Total Deaths
	 */
	public static boolean checkSortDeaths(ArrayList<CountryCOVID> data) {
		
		// TODO
		
		return false;
	}
	
	/*
	 * Create TWO binary search algorithms
	 * 
	 * 		First = finds the location of the FIRST occurrence of the bottom value
	 * 				if it doesn't exist, find the next value above it 
	 * 
	 * 		Second = finds the location of the LAST occurrence of the top value
	 * 				if it doesn't exist, find the next value below it 
	 * 
	 * Parameters:
	 * 		bottom: the lowest value in the desired range
	 * 		top: 	the highest value in the desired range
	 * 		data: 	the list of objects
	 * 		jsonData: the JSON_COVID_Data from the main method
	 * 
	 * variables
	 * 		low and high store the LOCATION of the bottom and top values
	 */
	public static void findRangeConfirmed(ArrayList<CountryCOVID> data, JSON_COVID_Data jsonData, int bottom, int top) {
		int low = 0;				//stores index of lowest in range
		int high = data.size() - 1;	//stores index of highest in range
		
		// TODO
		
		
		
		//prints range
		System.out.println(jsonData.printRange(low, high));
	}
	
	/*
	 * Same as findRangeConfirmed(), 
	 * except it looks at the totalDeaths parameter
	 * 
	 * You can pretty much cut and past the above method and change the "get" methods
	 * 
	 */
	public static void findRangeDeaths(ArrayList<CountryCOVID> data, JSON_COVID_Data jsonData, int bottom, int top) {
		int low = 0;				//stores index of lowest in range
		int high = data.size() - 1;	//stores index of highest in range
		
		// TODO
		
		
		
		//prints range
		System.out.println(jsonData.printRange(low, high));
	}
	
	
	
	
	
	
}
