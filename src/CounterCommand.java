
public class CounterCommand implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			for(int i = 0; i < 10; i++){
				System.out.println(i);
				Thread.sleep(new java.util.Random().nextInt(1000));
			}
		}
		catch(InterruptedException e){
			System.err.println(e);
		}
	}
}
