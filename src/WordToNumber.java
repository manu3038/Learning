import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 
 */

/**
 * @author pc
 *
 */
public class WordToNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.next();
		System.out.println(convert(word.toLowerCase()));
	}

	public static long convert(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] a = word.toCharArray();
		int[] num = new int[word.length()];
		map.put(a[0], 1);
		for (int i = 1; i < a.length; i++) {
			char c = a[i];
			if (i == 1 && !map.containsKey(c)) {
				map.put(c, 0);
			} else {
				if (!map.containsKey(c)) {
					map.put(c, i);
				}
			}
		}
		System.out.println("map -> " + map.toString());
		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			num[i] = map.get(c);
		}
		System.out.println("num -> " + num.toString());
		StringBuilder strNum = new StringBuilder();
		for (int nums : num) 
		{
		     strNum.append(nums);
		}
		long finalLong = Long.parseLong(strNum.toString());
		return finalLong;
	}
}
