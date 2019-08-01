import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//Print the count of the words which are repeated twice in the string.
public class TwiceCounter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> arr = new ArrayList<String>();
		System.out.println("enter the no of words in array: ");
		int noOfPackets = sc.nextInt();
		System.out.println("enter the array: ");
		int count = 0 ;
		for(int i=0;i<noOfPackets;i++) {
			arr.add(sc.next());
		}
		HashMap<String, Integer> map = new HashMap<>();
		//add the elements of ArrayList to HashMap
		for (String word : arr) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word).intValue()+1);
			}else {
				map.put(word, 1);
			}
		}
		//Iterate the map to find the no of keys with value 2
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(map.size()>1) {
				if(entry.getValue()==2) {
					count++; // increment count if found 
				}
			}
		}
		System.out.println("the number of words repeated only twice are : "+ count);
		
	}

}
