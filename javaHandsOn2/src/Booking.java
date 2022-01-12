import java.util.ArrayList;
import java.util.Date;

interface Booking {
	int costAC = 1000;
	int costnonAC = 750;
	int costConHall = 50000;
	
	//public void booking_s();
	public void Booking_s(Date ind, Date outd, int n, String email);
	//public void checkStatus();
	public void checkStatus(Date dt);
	//public boolean startBooking();
	public boolean startBooking(int ch,int n, Date cin, Date cout);
}