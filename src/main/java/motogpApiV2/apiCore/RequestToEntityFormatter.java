package motogpApiV2.apiCore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestToEntityFormatter {

	
	public static String getJsonFromUrl(String url) throws IOException {

		URL uri = new URL(url);
		URLConnection yc = uri.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		
		String inputLine;
		
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);
		in.close();

		return response.toString();
	}
	
	public static <T> T getEntityFromAnApiCall(Class<T> classToReturn,String urlToSendApiRequest) throws JsonMappingException, JsonProcessingException, IOException {
		
		T entityReturnedByApiCall =  new ObjectMapper().readValue(getJsonFromUrl(urlToSendApiRequest), classToReturn);
		
		return entityReturnedByApiCall;
	}
	
}
