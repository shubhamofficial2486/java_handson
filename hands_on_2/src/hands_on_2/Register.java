package hands_on_2;
import java.util.Scanner;

public class Register {
	Scanner scan = new Scanner(System.in);
	String coustomerName;
	int dateOfBirth;
	String emailId;
	int contactNo;
	public Register(){
		System.out.println("Enter your name : ");
        this.coustomerName = scan.next();
		System.out.println("Enter the date of birth 'dd-mm-yyyy' : ");
        this.dateOfBirth = scan.nextInt();
		System.out.println("Enter contact number : ");
        this.contactNo = scan.nextInt();
		System.out.println("Enter your email address : ");
        this.emailId = scan.next();
        if(this.checkEmail(emailId)){
        	// this is to check email
        	System.out.println(" ..email already exists.. ");
        }
        
	}
	
	public boolean checkEmail(String email){
		// checking for email existence
		return true;
	}
	
	
}
