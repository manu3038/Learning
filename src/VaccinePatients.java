import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VaccinePatients {

	public static void main(String[] args) {
		 /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
*/
        //Scanner
        Scanner s = new Scanner(System.in);
        int noOfVaccines = s.nextInt();   
        List<Integer> vaccineCount = new ArrayList<>();
        List<Integer> patientCount = new ArrayList<>();
        for( int i=0 ; i<noOfVaccines;i++){
            vaccineCount.add(s.nextInt());
        }
        for( int j=0 ; j<noOfVaccines;j++){
            patientCount.add(s.nextInt());
        }
        boolean match = false;
        for(int k=0; k<noOfVaccines;k++){
            if(vaccineCount.contains(patientCount.get(k))){
                match=true;
                break;
            }else{
                continue;
            }
        }
        if(match){System.out.println("Yes");}else{System.out.println("No");}



	}

}
