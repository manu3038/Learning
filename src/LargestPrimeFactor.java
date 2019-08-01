import java.util.*;

public class LargestPrimeFactor {

	public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> factors = new ArrayList<>();
        for(int i=0; i<n; i++){
            numbers.add(s.nextInt());
        }
        // System.out.println("Hi, " + name + ".");    
        for(int a=0; a<numbers.size(); a++){
           factors = primeFactors(numbers.get(a));
            System.out.println(Collections.max(factors));
        }
    }
     public static List<Integer> primeFactors(int number) {
          int n = number;
          List<Integer> primeFactors = new ArrayList<Integer>();
          for (int i = 2; i <= n; i++) {
           while (n % i == 0) {
            primeFactors.add(i);
            n /= i;
           }
          }
          return primeFactors;
         }
}
