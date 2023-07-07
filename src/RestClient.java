import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestClient {
    public static void main(String[] args) {
        try {
            // Creat a URL object with the API endpoint
            URL url = new URL("https://api.publicapis.org/entries");
            
            // Open     a connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            // Set the request method to GET
            conn.setRequestMethod("GET");
            
            // Read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Print the response
            System.out.println(response.toString());
            
            // Close the connection
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
