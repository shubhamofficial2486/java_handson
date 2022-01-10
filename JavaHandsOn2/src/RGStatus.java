public class RGStatus {
	
	 public  int totalRoom =10;
	 public  int totalAcRoom= 5;
	 public  int totalNonAcRoom=5;
	 public  int conferenceHall = 1;
	 public int date;

	 public  RGStatus(int n, int ch, int dt){
		 switch(ch){
		  case (1):
			  if(totalAcRoom >= n){
		          totalAcRoom = totalAcRoom - n;
			      totalRoom = totalRoom - n;
			      this.date = dt;}
				  else{
					  System.out.println("not available");
				  }
		      break;
		  case (2):
			  if(totalNonAcRoom >= n){
	          totalNonAcRoom = totalNonAcRoom - n;
		      totalRoom = totalRoom - n;
		      this.date = dt;}
			  else{
				  System.out.println("not available");
			  }
		      break;
		  case(3):
			  if(conferenceHall >= n){
				  conferenceHall = conferenceHall - n;
				  this.date = dt;
			  }
			  else{
				  System.out.println("not available");
			  }break;
			  
		  default:
			  System.out.println("enter a valid choice");
			  break;
		}
	 }
}
