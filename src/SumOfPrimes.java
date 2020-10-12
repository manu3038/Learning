import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 
 */

/**
 * @author Manohar
 * 
 * length of list with range
 * ex:
 * input
 * 2
 * 1 6
 * 1 13
 *
 * output
 * 10
 * 41
 * 
 * explanation:
 * 1 6
 * 2+3+5 = 10
 * 
 * 1 13
 * 2+3+5+7+11+13 = 41
 */
public class SumOfPrimes {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the length of List");
		int l = s.nextInt();
		ArrayList<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer>>();
		for (int i = 0; i < l; i++) {
			System.out.println("enter the " + i + "th value of list");
			HashMap<String, Integer> temp = new HashMap<>();
			System.out.println("enter the min of List of primes");
			int min = s.nextInt();
			System.out.println("enter the max of List of Primes");
			int max = s.nextInt();
			temp.put("min", min);
			temp.put("max", max);
			list.add(temp);
		}
		ArrayList<Set<Integer>> ansList = findPrimes(list);
		ArrayList<Integer> ans = new ArrayList<>();
		ansList.stream().forEach((e) -> {
			ans.add(e.stream().mapToInt(Integer::intValue).sum());// to find the sum of prime numbers
			System.out.println(e); // list of prime numbers for a given range
		});
		ans.stream().forEach((e) -> System.out.println("sum of list of primes are : " + e));
	}

	// returns array of sets for the range of numbers in the list
	public static ArrayList<Set<Integer>> findPrimes(ArrayList<HashMap<String, Integer>> list) {
		ArrayList<Set<Integer>> ansList = new ArrayList<>();
		for (HashMap<String, Integer> map : list) {
			HashSet<Integer> set = new HashSet<>();
			for (int i = map.get("min"); i < map.get("max");) {
				Integer ans = Integer.parseInt(BigInteger.valueOf(i).nextProbablePrime().toString());// find next prime
				if (ans > map.get("max")) {
					break;
				}
				i = ans;
				set.add(ans);
			}
			ansList.add(set);
		}
		return ansList;
	}
}
