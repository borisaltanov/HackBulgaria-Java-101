package typeChecking;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Composition c = new Composition();
		
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		s.nextLine();
		
		for (int i = 0; i < number; i++) {
			Function temp = new Function(s.nextLine());
			c.functions.put(temp.getName(), temp);		
		}
		s.nextLine();
		c.makeCompositon(s.nextLine());
		
/*		for (String name: c.functions.keySet()){
			System.out.println(name);
		}*/
		
		System.out.println(c.checkComposition());

	}

}
