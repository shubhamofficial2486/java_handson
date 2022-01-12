import java.util.Scanner;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class MainMenu {
	//ArrayList<Register> regData = new ArrayList();
	
	public static void main(String[] args) throws SQLException,ParseException{
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/race_garden","root","qwerty");
		System.out.println("Connected..");

		ArrayList<Register> regData = new ArrayList();
		ArrayList<GuestHouseBooking> bookData = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
			123456
			shub@123
			tara
			654321
			tara@123
			
			*/
			for(int i=0; i<2; i++){
			System.out.println("Registration");
		    System.out.println("Enter your name : ");
	        String customerName = scan.next();
			System.out.println("Enter the date of birth (dd/MM/yyyy) :: ");
	        String date6 = scan.next();
	        Date dateOfBirth = sdf.parse(date6);
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
				System.out.print("1:For AC rooms");
				System.out.println("2:For non AC rooms");
				System.out.println("3: For conference Hall");
				System.out.println("enter your choice ");
				int choice = scan.nextInt();
				if(choice==3){
					System.out.print("enter the date (dd/MM/yyyy)  :");
					String date1 = scan.next();
					//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					Date dt = sdf.parse(date1);
					System.out.println("enter the start time in hours (00:23):");
					int cin = scan.nextInt();
					System.out.print("enter the ending time in hours (00:23) :");
					int cout = scan.nextInt();
					if(book.startBooking(cin,cout,dt)){
						bookData.add(book);
						for(GuestHouseBooking b: bookData){
						System.out.println(" your booking cost is : "+b.bookingCost);
					}}
					else{
						System.out.print("Booking unsuccessfull!!");
						mm.quit();
					}
				}
				else{
				System.out.println("enter the checkin date (dd/MM/yyyy) :");
				String date2 = scan.next();
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date cin = sdf.parse(date2);
				System.out.println("enter the checkout date");
				String date3 = scan.next();
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date cout = sdf.parse(date3);
				System.out.println("Number of room ");
				int nroom = scan.nextInt();
				book.Booking_s(cin,cout,nroom,email);
				
				if(book.startBooking(ch,nroom,cin,cout)){
					bookData.add(book);
					for(GuestHouseBooking b: bookData){
					System.out.println(" your booking cost is : "+b.bookingCost);
				}}
				else{
					System.out.print("Booking unsuccessfull!!");
					mm.quit();
				}
				}
		}break;
		case(3):
		
			System.out.println("Check status");
		    System.out.println("1: for rooms\n"+"2: for coference hall");
		    int choice = scan.nextInt();
		    if(choice==1){
		        System.out.println("enter the date ");
		        String date4 = scan.next();
		        Date dt = sdf.parse(date4);
		        book.checkStatus(dt);
		    }
		    if(choice == 2){
		    	System.out.println("enter the date (dd/MM/yyyy) ::");
		    	String date5 = scan.next();
		        Date dat = sdf.parse(date5);
		        System.out.println("enter the time in hours (00:23) :");
		        int tm = scan.nextInt();
		        book.checkStatus(dat, tm);}
		    break;
		case(4):
			System.out.println("Change email address");
		    System.out.println("enter your name :");
		    String name1 = scan.next();
		    System.out.println("enter the contact number :");
		    int cont = scan.nextInt();
		    System.out.println("enter current email");
		    String email1 = scan.next();
		    System.out.println("enter new email");
		    String email2 = scan.next();
		    boolean flag = false;
		    for(Register r: regData){
		    	UpdateEmail upd = new UpdateEmail();
		    	flag = upd.checkEmail(name1,email1,cont,r);
		    	if(flag==true){
		    		r.emailId = email2;
		    		break;
		    	}
		    }
		    if(flag == false) System.out.println("wrong data entered");
		    break;
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
