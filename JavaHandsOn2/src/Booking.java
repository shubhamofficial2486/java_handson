import java.util.ArrayList;

interface Booking {
	int costAC = 1000;
	int costnonAC = 750;
	int costConHall = 50000;
	
	//public void booking_s();
	public void Booking_s(int ind, int outd, int n, String email);
	//public void checkStatus();
	public void checkStatus(int dt);
	//public boolean startBooking();
	public boolean startBooking(int ch,int n, int cin, int cout);
}