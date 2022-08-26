import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class Data {
	BufferedReader in;
	String url;
	String inputLine;
	StringBuffer response;

	Data() throws IOException {
		Random rand = new Random(47);
		url = "http://numbersapi.com/" + rand.nextInt(1000) + "/trivia";

		URL obj = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
		connection.setRequestMethod("GET");
		in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		response = new StringBuffer();
	}

	public String getText() throws IOException {
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();
		String text = response.toString();
		System.out.println("GET " + url);
		System.out.println(text);
		return text.replaceAll("\\W+", "");
	}
}
