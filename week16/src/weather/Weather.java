package weather;

public class Weather {
	private String name;
	private int temp;
	
	public Weather(String name, int temp) {
		this.name = name;
		this.temp = temp;
	}
	
	
	public String toString() {
		String res = "";
		res += "It is " + this.temp + "°C in " + this.name + ".";
		
		return res;
	}

}
