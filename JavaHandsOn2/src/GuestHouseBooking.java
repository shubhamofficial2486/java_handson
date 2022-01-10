import java.util.ArrayList;

//import java.util.ArrayList;
public class GuestHouseBooking implements Booking, Guest {
	ArrayList<RGStatus> statusData = new ArrayList();
	String email;
	int checkInDate ;
	int checkOutDate;
	int noOfPerson ;
	int bookingCost;
	

	public void Booking_s(int ind, int outd, int n, String email){
		this.checkInDate = ind;
		this.checkOutDate = outd;
		this.noOfPerson = n;
		this.email = email;
	}
	
	public void checkStatus(int dt){
		    System.out.println(statusData);
	        for(RGStatus r: statusData){
	        	if(r.date == dt){
	        		System.out.print("total ac rooms: "+r.totalAcRoom+" total non ac room: "+r.totalNonAcRoom+" date: "+r.date+" conference Room is :");
	                if(r.conferenceHall == 0)
	                	System.out.println("not available");
	                else System.out.println("available");
	        	}
	        }
	}



	
	// int costConHall = 50000;
   public boolean startBooking(int ch,int n, int cin, int cout){
		
		for(int i=cin;i<=cout;i++){
			RGStatus rgs = new RGStatus(n,ch,i);
			statusData.add(rgs);
			
		}
		if(statusData.isEmpty()) return false;
		else{ 
			if(ch==1) this.bookingCost = costAC*n*(cout-cin+1); 
			if(ch==2) this.bookingCost = costnonAC*n*(cout-cin+1);
			if(ch==3) this.bookingCost = costConHall*n*(cout-cin+1);
			return true;
		}
	}
	
}
