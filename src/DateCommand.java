import java.util.Date;

public class DateCommand implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Date datum = new Date();
		try{
		for(int i = 0; i < 10; i++){
			System.out.println(datum.toString());
			Thread.sleep(new java.util.Random().nextInt(1000));
		}
		}
		catch(InterruptedException e){
			System.err.println(e);
		}
	}
}
