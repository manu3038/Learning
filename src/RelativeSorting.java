import java.util.*;

public class RelativeSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> arr1 = new ArrayList<Integer>();
		List<Integer> arr2 = new ArrayList<Integer>();
		 System.out.println("enter the length of the sequences");
		 int A1 = sc.nextInt();
		 int A2 = sc.nextInt();
		 System.out.println("enter the Sequences:");
		 for(int i=0;i<A1;i++) {
			arr1.add(sc.nextInt());
		 }
		 System.out.println("Enter the next sequence");
		 for(int i=0;i<A2;i++) {
				arr2.add(sc.nextInt());
		}
		sortRelative(A1,A2,arr1,arr2);
	}

	private static void sortRelative(int a1, int a2, List<Integer> arr1, List<Integer> arr2) {
		TreeMap<Integer, Integer> tmap= new TreeMap<>();
		for (int j = 0; j < arr2.size(); j++) {
			if(tmap.containsKey(arr2.get(j))) {
				tmap.put(arr2.get(j),(tmap.get(arr2.get(j)).intValue()+1));
			}else
			{
				tmap.put(arr2.get(j), 1);
			}
		}
		for (int i = 0; i < arr1.size()	; i++) {
			if (tmap.containsKey(arr1.get(i)));
		}
		
	}

}
