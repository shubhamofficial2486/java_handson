package hands_on_2;
import java.util.Scanner;

public class Booking {
	int checkInDate ;
	int checkOutDate;
	int noOfPerson ;
	int choice;
	Scanner scan = new Scanner(System.in);
	public Booking(){
		System.out.println("Enter the check in  date: ");
		this.checkInDate = scan.nextInt();
		System.out.println("Enter the check out  date: ");
		this.checkOutDate = scan.nextInt();
		System.out.println("Rooms required for: ");
		this.noOfPerson = scan.nextInt();
		System.out.println("1:AC       2:non AC");
		System.out.println("Enter your choice: ");
		this.choice = scan.nextInt(); 
		this.startBooking(this.choice);
		
	}
	public void startBooking(int ch){
		switch(ch){
		case 1:
			System.out.println("AC room booking ");
			break;
		case 2:
			System.out.println("non AC booking ");
			break;
		default:
			System.out.println(" you have entered wrong choice ");
			break;
		}
	}

}
