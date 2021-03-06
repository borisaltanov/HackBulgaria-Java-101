package Thursday;

/*import java.util.Iterator;*/
import java.util.Vector;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	public static Vector<Function> functions = new Vector<Function>();
	public static HashMap<String, Function> functionsHash= new HashMap<String, Function>();
	public static Stack<Function> composition = new Stack<Function>();

	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
		LinkedList<Integer> l = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}
		
		System.out.println(l);
		
		Vector<Integer> v = new Vector<>();
		for (int i = 0; i < 10; i++) {
			v.add(i);
		}
		
		for (Ingeter i: v) {
			System.out.println(i);
		}*/
/*		Scanner scanner = new Scanner(System.in);

	    String input = scanner.nextLine();
	    int x = scanner.nextInt();
	    scanner.close();

		System.out.println(FunctionCalls.composition(input, x));*/

		

		Scanner scanner= new Scanner(System.in);
		int numOfFunctions = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < numOfFunctions; i++) {
			String line = scanner.nextLine();
			Function function = new Function(line);
			Main.functions.add(function);
			Main.functionsHash.put(function.functionName, function);

		}
		
		String composition = scanner.nextLine();
		int x = scanner.nextInt();
		scanner.close();
		
		String[] functions = composition.split(" . ");
		for(String func: functions) {
			Main.composition.push(Main.functionsHash.get(func));
		}
		
		while(!Main.composition.isEmpty()) {
			Function func = Main.composition.pop();
			System.out.println("Eval: " + func.functionName + " " + x);
			x = func.evaluate(x);
		}
		System.out.println(x);

		
		
		
		
		
		
		
		
	}

}
