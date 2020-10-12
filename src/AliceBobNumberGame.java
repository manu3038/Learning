import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 
 */

/**
 * @author Manohar
 * Problem statement: 
 *         This time Alice and Bob have devised a new game of numbers to decide
 *         who is the better player among the two. Each time they are given n
 *         positive integers and they perform an operation on these integers in
 *         each turn. In a particular operation a player can choose any 1 of the
 *         numbers and divide it with 1 or more prime numbers either once or
 *         more than one times. Sample Input (Plaintext Link) 4 1 2 3 4
 * 
 *         Sample Output (Plaintext Link) ALICE
 * 
 *         Explanation
 * 
 *         On factorizing and 4 we have- 1 cannot be divided further.
 * 
 *         In first turn Alice picks 4 and divides it by 2 twice. Which reduces
 *         it to 1. It is discarded now.
 * 
 *         In second turn Bob picks either 2 or 3 and divides it by number
 *         itself. It reduces to 1.
 * 
 *         Now Alice has just 1 option left either (2 or 3) .
 * 
 *         Now all the numbers are reduced to 1 and BOB has no possible
 *         operation to perform. Hence he loses.
 */
public class AliceBobNumberGame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int l = s.nextInt();
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < l; i++) {
			arr.add(s.nextInt());
		}
		// get list of prime numbers till the max element of the list
		ArrayList<Integer> primes = new ArrayList<>();
		for (int i = 1; i < Collections.max(arr);) {
			Integer ans = Integer.parseInt(BigInteger.valueOf(i).nextProbablePrime().toString());// find next prime
			if (ans > Collections.max(arr)) {
				break;
			}
			i = ans;
			primes.add(ans);
		}
		arr = arr.stream().map(i -> {
			int a = 0;
			if (primes.contains(i)) { // if element is present in prime numbers mark it as one.
				a = 1;
			} else {
				List<Integer> temp = primes;
				temp = temp.stream().filter(b -> (b < i && i % b == 0)).collect(Collectors.toList()); // find prime divisors for the element.
				System.out.println("prime divisors " + temp + " of element " + i);
				if (temp.size() > 0) {
					a = 1;
				}
			}
			return a;
		}).collect(Collectors.toList());
		if (arr.size() % 2 == 0) { // all numbers are visible by itself or anyother prime number hence if the list of the ones is odd then alice wins else bob wins.
			System.out.println("Bob Wins");
		} else {
			System.out.println("Alice Wins");
		}

	}

}
