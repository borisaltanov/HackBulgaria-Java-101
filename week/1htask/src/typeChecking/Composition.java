package typeChecking;

import java.util.HashMap;

public class Composition {
	public HashMap<String, Function> functions = new HashMap<String, Function>();
	public String[] compositon;
	
	public Composition() {
	}
	
	public void makeCompositon(String comp) {
		compositon = comp.split(" . ");
	}
	
	public boolean checkComposition() {
		for (int i = compositon.length - 1; i > 0; i--) {
			Function func1 = functions.get(compositon[i]);
			Function func2 = functions.get(compositon[i - 1]);
			
			if (!func1.getReturnType().equals(func2.getArgumentType())) {
				return false;
			}
		}
		
		return true;
	}
	
	
	

}
