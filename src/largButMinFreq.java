/*
 * print the largest element with minimum frequency(times repeated) in an array of Integers
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class largButMinFreq {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the length of the sequence");
		int sequenceLength = sc.nextInt();
		System.out.println("enter the Sequence:");
		int arr[] = new int[sequenceLength];
		for (int i = 0; i < sequenceLength; i++) {
			arr[i] = (sc.nextInt());
		}
		System.out.println(LargButMinFreq(arr,sequenceLength));
	}
	// Function to find largest number with minimum frequency
    public static Integer LargButMinFreq(int[] arr, int n)
    {
    	List<Integer> arrList = Arrays.stream(arr)        // IntStream
                .boxed()          // Stream<Integer>
                .collect(Collectors.toList());
    	HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
    	arrList.stream().forEach(e -> {
        	if(!temp.containsKey(e)) {
        		temp.put(e, 1);
        	} else {
        		temp.put(e, temp.get(e).intValue()+1);
        	}
        });
        Integer maxKey = Collections.max(temp.keySet());
        Integer minValue = temp.get(Collections.min(temp.keySet()));
        if(temp.get(maxKey) == minValue) {
        	return maxKey;
        } else {
        	List<Integer> tempList = new ArrayList<Integer>();
            tempList.addAll(temp.keySet());
            Collections.sort(tempList);
        	tempList.stream().filter(e->(temp.get(e) == minValue));
        	return tempList.get(0);
        }
    }

}
