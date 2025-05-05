package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributePath)
            throws IllegalArgumentException, IOException {
        String json = getJsonFromApi(urlString);
        return extractAttribute(json, attributePath);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractAttribute(String json, String attributePath) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            String[] keys = attributePath.split("\\.");
            Object current = jsonObject;

            for (String key : keys) {
                if (!(current instanceof JSONObject)) {
                    throw new IllegalArgumentException("Intermediate value is not a JSON object: " + key);
                }
                current = ((JSONObject) current).get(key);
                if (current == null) {
                    throw new IllegalArgumentException("Attribute not found: " + key);
                }
            }

            return current.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to extract attribute: " + attributePath, e);
        }
    }
}