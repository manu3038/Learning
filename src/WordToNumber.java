import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * convert the given word to smallest number such that the number doesn't start with 0
 * 
 * ex:
 * java
 * 1020
 * 
 * manohar
 * 1023405
 * 
 */

/**
 * @author pc
 *
 */
public class WordToNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String word = s.nextLine();
		System.out.println(convert(word.toLowerCase()));
	}

	public static String convert(String word) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] a = word.toCharArray();
		int[] num = new int[word.length()];
		System.out.println(word);
		map.put(a[0], 1);
		map.put(' ', -1);
		for (int i = 1, temp = 1; i < a.length; i++, temp++) {
			char c = a[i];
			if (i == 1 && !map.containsKey(c)) {
				map.put(c, 0);
			} else {
				if (!map.containsKey(c)) {
					map.put(c, temp);
				} else {
					temp--;
				}
			}
		}
//		Map<Object, Object> temp = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//		System.out.println("map -> " + temp.toString());
		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			num[i] = map.get(c); 
		}
		StringBuilder strNum = new StringBuilder();
		for (int nums : num) {
			if(nums == -1) {
				strNum.append(" ");
			}else {
				strNum.append(nums);
			}
		}
		return strNum.toString();
	}
}
