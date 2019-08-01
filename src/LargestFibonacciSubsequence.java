import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LargestFibonacciSubsequence {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 List<Integer> arr = new ArrayList<Integer>();
		 System.out.println("enter the length of the sequence");
		 int sequenceLength = sc.nextInt();
		 System.out.println("enter the Sequence:");
		 for(int i=0;i<sequenceLength;i++) {
			arr.add(sc.nextInt());
		 }
		 FindFibonacciSequence(arr,sequenceLength);
	}

	private static void FindFibonacciSequence(List<Integer> arr, int sequenceLength) {
		int max = Collections.max(arr); // get the max value in the given array
		List<Integer> fibonacciSequence = GenerateFibonacciSequence(max);
		for (Integer integer : arr) {
			if(fibonacciSequence.contains(integer)) { // check if the values of array is present in fibonacci series
				System.out.println(integer);
			}
		}
	}

	private static List<Integer> GenerateFibonacciSequence(int max) {
		int a= 0;
		int b= 1;
		List<Integer> fibonacciSequence = new ArrayList<>();
		//generate fibonacci sequence as long as it reaches the max value of the given array & add to list to return
		while(true) {
			int sum = a + b;
			a = b;
			b = sum;
			fibonacciSequence.add(sum);
			if(sum>=max) { 
				break;
			}
		}
		return fibonacciSequence;
	}
}
