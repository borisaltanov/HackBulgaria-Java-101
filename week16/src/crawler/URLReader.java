package crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class URLReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		String url = "http://www.technopolis.bg/bg//%D0%9C%D0%BE%D0%B1%D0%B8%D0%BB%D0%BD%D0%B8-%D1%82%D0%B5%D0%BB%D0%B5%D1%84%D0%BE%D0%BD%D0%B8-%D0%B8-%D0%A2%D0%B0%D0%B1%D0%BB%D0%B5%D1%82%D0%B8/%D0%A2%D0%B0%D0%B1%D0%BB%D0%B5%D1%82%D0%B8/c/P11010701";
		URL crawlerInfo = new URL(url);
		BufferedReader buffer = new BufferedReader(
				new InputStreamReader(crawlerInfo.openStream()));
		
		String data = "";
		String inputLine;
		while((inputLine = buffer.readLine()) != null) {
			data += inputLine;
		}
		buffer.close();
		
		Document doc = Jsoup.parse(data);
		Elements el = doc.select("a[href^=/bg/Tablets/]");
		
		List<String> links = new ArrayList<>();
		
		for (Element element : el) {
			links.add("http://www.technopolis.bg" + element.attr("href"));
		}
		
		for (String string : links) {
			System.out.println(string);
		}
		
//		System.out.println(json);
	}

}
