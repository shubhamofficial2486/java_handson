import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

//import java.util.ArrayList;
public class GuestHouseBooking implements Booking, Guest {
	ArrayList<RGStatus> statusData = new ArrayList();
	String email;
	Date checkInDate ;
	Date checkOutDate;
	int noOfPerson ;
	long bookingCost;
	private static final long ONE_DAY_MILLI_SECONDS = 24 * 60 * 60 * 1000;
	

	public void Booking_s(Date ind, Date outd, int n, String email){
		this.checkInDate = ind;
		this.checkOutDate = outd;
		this.noOfPerson = n;
		this.email = email;
	}
	
	public void checkStatus(Date dt){
		    //System.out.println(statusData);
	        for(RGStatus r: statusData){
	        	if(r.date.equals(dt)){
	        		System.out.print("total ac rooms: "+r.totalAcRoom+" total non ac room: "+r.totalNonAcRoom+" date: "+r.date);
	        	}
	        }
	}
	
	public void checkStatus(Date dt, int hr){
		for(RGStatus r: statusData){
			if(r.date.equals(dt) && r.hour == hr){
				if(r.conferenceHall == 0) System.out.println("conference hall not available");
				else System.out.println("conference hall is available");			
			}
		}
	}
     // int costConHall = 50000;
   public boolean startBooking(int ch,int n, Date cin, Date cout){
		Date i = cin;
		do{ 
			RGStatus rgs = new RGStatus(n,ch,i,0);
			statusData.add(rgs);
			long nextDayMilliSeconds = i.getTime() + ONE_DAY_MILLI_SECONDS;
			i = new Date(nextDayMilliSeconds);
			//String nextDateStr = dateFormat.format(nextDate);
			
		}while(i.before(cout));
		if(statusData.isEmpty()) return false;
		else{ 
			if(ch==1) this.bookingCost = costAC*n*((cout.getTime()-cin.getTime()+ONE_DAY_MILLI_SECONDS)/ONE_DAY_MILLI_SECONDS ); 
			if(ch==2) this.bookingCost = costnonAC*n*((cout.getTime()-cin.getTime()+ONE_DAY_MILLI_SECONDS)/ONE_DAY_MILLI_SECONDS);
			//if(ch==3) this.bookingCost = costConHall*n*(cout-cin+1);
			return true;
		}
	}
   
   public boolean startBooking(int cin,int cout, Date date){
	   for(int i=cin;i<=cout;i++){
		   RGStatus rgss = new RGStatus(1,3,date,i);
		   statusData.add(rgss);
	   }
	   if(statusData.isEmpty()) return false;
	   else{
		   this.bookingCost = costConHall*(cout-cin+1);
		   return true;
	   }
   }
	
}
