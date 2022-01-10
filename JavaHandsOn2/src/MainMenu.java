import java.util.Scanner;
import java.util.ArrayList;
public class MainMenu {
	//ArrayList<Register> regData = new ArrayList();
	
	public static void main(String[] args){
		ArrayList<Register> regData = new ArrayList();
		ArrayList<GuestHouseBooking> bookData = new ArrayList();
		GuestHouseBooking book = new GuestHouseBooking();
		Scanner scan = new Scanner(System.in);
		int ch=1;
		int regCount = 0;
		while(ch<6){
		System.out.println("1: Register new user");
		System.out.println("2: Booking ");
		System.out.println("3: Check Status ");
		System.out.println("4: Change your Email");
		System.out.println("5: Display all the registered user");
		System.out.println("Enter your choice");
		ch = scan.nextInt();
		
		MainMenu mm = new MainMenu();
		
			
		switch(ch){
		case(1):
			/*
			shubham
			14111997
			7979016
			shub
			tara
			14121997
			797988
			tara
			
			*/
			for(int i=0; i<2; i++){
			System.out.println("Registration");
		    System.out.println("Enter your name : ");
	        String customerName = scan.next();
			System.out.println("Enter the date of birth 'dd-mm-yyyy' : ");
	        int dateOfBirth = scan.nextInt();
			System.out.println("Enter contact number : ");
	        int contactNo = scan.nextInt();
			System.out.println("Enter your email address : ");
	        String emailId = scan.next();
		    Register reg = new Register(customerName, dateOfBirth, contactNo, emailId);
			regData.add(reg);
			regCount++;
			}
		System.out.println(regCount);
		    break;
		case(2):
			System.out.println("Booking");
		    System.out.println("enter your email");
		    String email = scan.next();
		    //System.out.print(regData);
		    int c=0;
		    //System.out.println(c);
		    for(Register s: regData){
		    	if(s.emailId.equals(email)){	
		    		//System.out.println(s.emailId);
		    		c++;}
				}
		    //System.out.println(c);
			if(c==0){
				System.out.println("you are not registered");
			    mm.quit();
			}
			else{
				System.out.println("enter the checkin date");
				int cin = scan.nextInt();
				System.out.println("enter the checkout date");
				int cout = scan.nextInt();
				System.out.println("Number of room ");
				int nroom = scan.nextInt();
				book.Booking_s(cin,cout,nroom,email);
				System.out.print("1:For AC rooms");
				System.out.println("2:For non AC rooms");
				System.out.println("3: For conference Hall");
				System.out.println("enter your choice ");
				if(book.startBooking(scan.nextInt(),nroom,cin,cout)){
					bookData.add(book);
					for(GuestHouseBooking b: bookData){
					System.out.println(" your booking cost is : "+b.bookingCost);
				}}
				else{
					System.out.print("Booking unsuccessfull!!");
					mm.quit();
				}
			
		}break;
		case(3):
			System.out.println("Check status");
		    System.out.println("enter the date ");
		    int dt = scan.nextInt();
		    book.checkStatus(dt);
		    break;
		case(4):
			System.out.println("Change email address");
		    System.out.println("enter current email");
		    String email1 = scan.next();
		    System.out.println("enter new email");
		    String email2 = scan.next();
		    for(Register r: regData){
		    	if(email1.contentEquals(r.emailId)){
		    		r.emailId = email2;
		    	}
		    }break;
		case(5):
			System.out.println("Display all customers details");
		    for(Register r: regData){
		    	System.out.println(" customer name :"+r.coustomerName+" contact no :"+r.contactNo+" date of birth :"+r.dateOfBirth+" email :"+r.emailId);
		    }break;
		}	
	}
	}
	public void quit(){
		System.out.print("i m quitting");
		return;
	}

}
