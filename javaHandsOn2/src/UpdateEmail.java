
public class UpdateEmail {
	public String name;
	public String email;
	public int contact;
	
    public boolean	checkEmail(String name, String email, int contact, Register reg){
    	
    	if(name.equals(reg.coustomerName) && contact == reg.contactNo && email.equals(reg.emailId)){
    		return true;
    	}
    	else return false;
    }

}
