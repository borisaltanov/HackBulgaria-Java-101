package Thursday;

import java.util.Vector;

public class Function {
	public String functionName;
	public String argumentName;
	public String functionBody;
	
	public Function(String in) {
		String[] functionParts = in.split(" \\= ");
		String[] nameAndArgument = functionParts[0].split(" ");
		this.functionName = nameAndArgument[0];
		this.argumentName = nameAndArgument[1];
		this.functionBody = functionParts[1];
	}
	
	public boolean isOperator(String bodyPart) {
		return bodyPart.contains("+") || bodyPart.contains("-");
	}
	
	public boolean isInteger(String bodyPart) {
		for(int i = 0; i < bodyPart.length(); i++) {
			if (bodyPart.charAt(i) < '0' || bodyPart.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFunction(String bodyPart) {
		return bodyPart.matches("[a-z]+\\(\\w+\\)");
		
	}
	
	public int functionCall(String bodyPart, int x) {
		String[] functionParts = bodyPart.split("\\(");
		String functionName = functionParts[0];
		String argumentName = functionParts[1].substring(0, functionParts[0].length() - 1);
		int tempX = 0;
		if (isInteger(argumentName)) {
			tempX = Integer.parseInt(argumentName);
		}
		else if (argumentName.equals(Main.functionsHash.get(functionName).argumentName)){
			tempX = x;
		}
		return Main.functionsHash.get(functionName).evaluate(tempX);
	}
	
	public int evaluate(int x) {
		String[] bodyParts = this.functionBody.split(" ");
		Vector<Integer> elements = new Vector<Integer>();
		Vector<String> opers = new Vector<String>();
		for(String bodyPart: bodyParts) {
			if (isInteger(bodyPart)) {
				elements.add(Integer.parseInt(bodyPart));
			}
			if (bodyPart.equals(this.argumentName)); {
				elements.add(x);
			}
			if (isOperator(bodyPart)) {
				opers.add(bodyPart);			
			}
			if (isFunction(bodyPart)) {
				elements.add(functionCall(bodyPart, x));
			}
		}
		
		int result = elements.elementAt(0);
		for (int j = 0; j < opers.size(); j++) {
			String sign = opers.elementAt(j);
			switch(sign) {
				case "+": result += elements.elementAt(j + 1);
				break;
				case "-": result -= elements.elementAt(j + 1);
				break;
			}
			
		}
		
		
		
		return result;
	}

}
