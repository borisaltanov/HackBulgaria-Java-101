package thursday;

public class Threads {
	
	
	private static class Task implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int counter = 100;
			while (counter > 0) {
				counter--;
				System.out.println("Running: " + counter);
			}
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done.");
		

	}

}
