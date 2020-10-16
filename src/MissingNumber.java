import java.util.*;
import java.util.stream.Collectors;

/**
 * Finding the missing numbers in the given input array.
 */

/**
 * @author Manohar N G
 *
 */
public class MissingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Enter the Length of the array:");
		Scanner sc = new Scanner(System.in);
		int arrLength = sc.nextInt();
		System.out.print("Enter the array:");
		List<Integer> inputArr = new ArrayList<>();
		for (int i = 0; i < arrLength; i++) {
			inputArr.add(sc.nextInt());
		}
		List<Integer> missingNumList = findMissingNumber(inputArr);
		System.out.println("Missing Numbers are:");
		for (Integer element : missingNumList) {
			System.out.print(element + ", ");
		}
	}

//	function to find the missing numbers in the given array
	static List<Integer> findMissingNumber(List<Integer> inputArr) {
		List<Integer> correctArr = new ArrayList<>();
		Collections.sort(inputArr); // sort the list to get the max value in the list
		for (int i = 1; i < inputArr.get(inputArr.size()-1); i++) {
			correctArr.add(i);
		}
//		correctArr = inputArr.stream().sorted().collect(Collectors.toList());
		correctArr.removeAll(inputArr);
		return correctArr;
	}

}
