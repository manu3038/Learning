/*Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
1. Each student gets one packet.
2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChocolateDistribution {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 List<Integer> arr = new ArrayList<Integer>();
		 List<Integer> difference = new ArrayList<Integer>();
		 System.out.println("enter the no of chocolate packets:");
		 int noOfPackets = sc.nextInt();
		 System.out.println("enter the packets:");
		 for(int i=0;i<noOfPackets;i++) {
			arr.add(sc.nextInt());
		 }
		 System.out.println("enter the number of students");
		 int noOfStudents = sc.nextInt();
		 Collections.sort(arr); //sort the array in ascending order
		 for(int i=0;i<noOfPackets;i++) {
			 int j = i+(noOfStudents-1);//find the last element in sorted array to subtract
			 int temp;
			 if(j < noOfPackets) {					// if the last element is not greater than the array length
				 temp = arr.get(j).intValue()-arr.get(i).intValue();
				 difference.add(temp);//add the differences to an other list
			 	}
			 }
		 Collections.sort(difference); // sort the differences array to get the least value first to print
		 System.out.println("the minimum difference value is :"+ difference.get(0));
	}
}
