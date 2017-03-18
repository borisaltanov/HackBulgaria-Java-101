package primefactorials;

public class FactorialsTask implements Runnable{
	private int number;
	private String name;
	
	public FactorialsTask(int number, String name) {
		// TODO Auto-generated constructor stub
		this.number = number;
		this.name = name;
	}

	@Override
	public void run() {
		int i = 2;
		while(this.number > 1) {
			Thread.currentThread().setName(this.name);
			if (this.number % i == 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				this.number /= i;
			} else {
				i++;
			}
		}
		System.out.println();
	}

}
