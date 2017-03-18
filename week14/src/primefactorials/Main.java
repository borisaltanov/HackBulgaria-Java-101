package primefactorials;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactorialsTask ft1 = new FactorialsTask(6435438, "first");
		FactorialsTask ft2 = new FactorialsTask(3325436, "second");
		FactorialsTask ft3 = new FactorialsTask(4394543, "third");
		FactorialsTask ft4 = new FactorialsTask(432564, "forth");
/*		Thread t1 = new Thread(ft1);
		Thread t2 = new Thread(ft2);
 		t1.start();
 		t2.start();*/
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(ft1);
		executor.execute(ft2);
		executor.execute(ft3);
		executor.execute(ft4);
		
		executor.shutdown();
	}

}
