/*Example:
Input:
2
13
john johnny jackie johnny john jackie jamie jamie john johnny jamie johnny john
3
andy blake clark

Output:
john 4
andy 1

Explanation:
Testcase1: john has 4 votes casted for him, but so does johny. john is lexicographically smaller, so we print john and the votes he received.
Testcase2: All the candidates get 1 votes each. We print andy as it is lexicographically smaller.*/


//Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;
public class ElectionWinner {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            new Election().winner(arr, n);
            
            System.out.println();
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Election
{
    static void winner(String arr[], int n)
    {
        Arrays.sort(arr);
        TreeMap<String, Integer> counting = new TreeMap<>();
        //for loop to add the elements to map from array
        for ( String candidate : arr ) {
        	if(counting.containsKey(candidate)) {
        		counting.put(candidate, (counting.get(candidate)+1));
        	}else {
        		counting.put(candidate, 1);
        	}
        }
        
        Integer max = counting.values().stream().max(Integer::compare).get();
        String name = null;    
        //iterate map to get the first max value's key
        for(Map.Entry<String, Integer> entry: counting.entrySet()) {
        	if(counting.size()>1) {
	        	if(max.equals(entry.getValue())) {
	        		name = entry.getKey();
	        		break;
	        	}
        	}else {
        		name =entry.getKey();
        	}
        }
        System.out.println("winner : "+ name+ "-" + max);
        
    }
}

