import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.*;


/*
 * print the box inside a box as for the number of inputs given
 * 
 * Example:
 * 1-> length of Inputs
 * 
 * 3-> no of nested boxes to be printed

**********
*        *
* ****** *
* *    * *
* * ** * *
* * ** * *
* *    * *
* ****** *
*        *
**********


 */
public class PatternPrinting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer totalInputs = sc.nextInt();
		ArrayList<Integer> noOfInputs = new ArrayList<Integer>();
		IntStream.range(0, totalInputs).forEach(e -> {
			noOfInputs.add(sc.nextInt());
		});
		noOfInputs.stream().forEach(e -> {
			printHollowBoxes(e);
		});
	}

	public static void printHollowBoxes(Integer size) {
		List<Integer> columnSizeList = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			if (0 == i) {
				columnSizeList.add(2);
			} else {
				columnSizeList.add(columnSizeList.get(i - 1) + 4);
			}
		}
		Collections.sort(columnSizeList);
		Collections.reverse(columnSizeList);
		Integer maxLength = columnSizeList.get(0);
		Integer midPoint = maxLength / 2;
		for (int i = 1; i <= columnSizeList.get(0); i++) {
			for (int j = 1; j <= columnSizeList.get(0); j++) {
				if ((i == 1 || i == columnSizeList.get(0) || j == 1 || j == columnSizeList.get(0))) {
					System.out.print("*");
				} else if ((i < midPoint && i % 2 != 0) && (j >= i && j <= maxLength - i + 1)
						|| (j < midPoint && j % 2 != 0) && (j <= i && j <= maxLength - i + 1)) {
					System.out.print("*");
				} else if ((i == midPoint && j <= midPoint + 1 && j >= i)
						|| (i == midPoint + 1 && j <= midPoint + 1 && j >= midPoint)) { // center section
					System.out.print("*");
				} else if ((i > midPoint + 1 && i % 2 == 0 && j <= i && j >= maxLength - i + 1)
						|| (j > midPoint + 1 && j % 2 == 0) && (i <= j && j >= maxLength - i + 1)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}
}
