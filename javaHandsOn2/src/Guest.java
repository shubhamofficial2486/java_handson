import java.util.Date;

interface Guest {
  public boolean startBooking(int cin, int cout, Date date);
  
  public void checkStatus(Date date, int time);
}
