import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
* problem: https://www.hackerrank.com/challenges/between-two-sets/problem
*
* Examples:
* A: [2 4] B: [16 32 96]; Ans = 3
* A: [1 2 3] B: [6 12 18]; Ans = 3
* A: [3 5] B: [10 20 30]; Ans = 0
* A: [2 4 6 8 10] B: [40 80 120 160 200]; Ans = 5
* A: [5 5 5] B: [25 25 25]; Ans = 1
* A: [15, 30, 45, 60, 75, 90] B: [180, 360, 540, 720, 900]; ANS = 4
* A: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12] B: [120, 240, 360, 480, 600, 720]; Ans = 12
* A: [15, 30, 45, 60, 75, 90] B: [180, 360, 540, 720, 900]; Ans = 4
* */
public class BetweenSets {

    // Function to calculate GCD
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM
    public static int lcm(int a, int b) {
        return (a * (b / gcd(a, b)));
    }

    // Function to calculate LCM of a List
    public static int lcmOfList(List<Integer> list) {
        int lcm = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            lcm = lcm(lcm, list.get(i));
        }
        return lcm;
    }

    // Function to calculate GCD of a List
    public static int gcdOfList(List<Integer> list) {
        int gcd = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            gcd = gcd(gcd, list.get(i));
        }
        return gcd;
    }

    // Main function to get the total numbers between the sets
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcmA = lcmOfList(a);
        int gcdB = gcdOfList(b);

        int count = 0;
        for (int i = lcmA; i <= gcdB; i += lcmA) {
            if (gcdB % i == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the sizes of the lists
        System.out.print("Enter the number of elements in the first array and second array (n m): ");
        String[] firstMultiple = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstMultiple[0]);
        int m = Integer.parseInt(firstMultiple[1]);

        // Read the first list
        List<Integer> a = new ArrayList<>();
        System.out.print("Enter the elements of the first array (space-separated): ");
        String[] aItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(aItems[i]));
        }

        // Read the second list
        List<Integer> b = new ArrayList<>();
        System.out.print("Enter the elements of the second array (space-separated): ");
        String[] bItems = scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            b.add(Integer.parseInt(bItems[i]));
        }

        // Get the total numbers between the sets
        int total = getTotalX(a, b);
        System.out.println("The number of integers between the sets is: " + total);

        scanner.close();
    }
}
