import java.util.Date;

public class Register {
	//Scanner scan = new Scanner(System.in);
	String coustomerName;
	Date dateOfBirth;
	String emailId;
	int contactNo;
	public Register(String name, Date dob, int cn,String email){
		
        if(this.checkEmail(emailId)){
        	// this is to check email
        	System.out.println(" ..email already exists.. ");
        }
        else {
        	this.coustomerName = name;
        	this.dateOfBirth = dob;
        	this.contactNo = cn;
        	this.emailId = email;
        	
        }
	}
	
	public boolean checkEmail(String email){
		// checking for email existence
		return false;
	}
	
	
}
