package weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

import org.json.*;

public class URLReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String appid = "9ed81d9300f326bbd3f1ef06bb0f1207";
/*		Scanner sc = new Scanner(System.in);
		String cityName = sc.nextLine();*/
		String cityName = "Pavlikeni";
		
		URL weatherInfo = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + appid);
		BufferedReader buffer = new BufferedReader(
				new InputStreamReader(weatherInfo.openStream()));
		
		String json = "";
		String inputLine;
		while((inputLine = buffer.readLine()) != null) {
			json += inputLine;
		}
		buffer.close();
		
		JSONObject obj = new JSONObject(json);
		JSONObject main = obj.getJSONObject("main");
		String name = obj.getString("name");
		int temp = main.getInt("temp") - 273;
		
		
		Weather weather = new Weather(name, temp);
		System.out.println(weather);

	}

}
