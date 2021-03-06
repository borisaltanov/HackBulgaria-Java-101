package typeChecking;

public class Function {
	private String name;
	private String argumentType;
	private String returnType;
	
	public Function(String function) {
		String[] func = getBodyDetails(function);
		this.name = func[0];
		this.argumentType = func[1];
		this.returnType = func[2];
	}
	
	private String [] getBodyDetails(String function) {
		String[] result = new String[3];
		String[] functionBody = function.split(" :: ");
		result[0] = functionBody[0];
		String[] funcTypes = functionBody[1].split(" -> ");
		result[1] = funcTypes[0];
		result[2] = funcTypes[1];
		
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArgumentType() {
		return argumentType;
	}

	public void setArgumentType(String argumentType) {
		this.argumentType = argumentType;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	
	

}
