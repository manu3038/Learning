import java.util.Scanner;
//find the Closest Palindrome number for the entered number
public class ClosestPalindrome {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the number to find the closest palindrome");
		long number = sc.nextInt();
		int length = String.valueOf(number).length()-1;
		char[] numberArray = String.valueOf(number).toCharArray();
		if(number <= 10) {
			number--;//reduce the number by 1
		}else {
			//
			while(palindrome(numberArray,length) == 0 ) {
				numberArray = String.valueOf(number-1).toCharArray();//reduce the number and convert to char array
				number--;//reduce the number by 1
			}
		}
		System.out.println("the closest plaindrome number is "+ number);
	}
	
	//function to check if the number is Palindrome
	private static int palindrome(char[] numberArray,int length) {
		for(int k=0,i=length;i>=length/2;i--,k++) {
			if(numberArray[k]!=numberArray[i]) {
				return 0;//if the number is not a palindrome				
			}
		}
		return -1;//if the number is palindrome
	}

}
