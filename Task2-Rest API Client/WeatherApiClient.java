import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiClient {

    public static void main(String[] args) {

        try {
            // Open-Meteo Weather API (Delhi coordinates)
            String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=28.61&longitude=77.20&current_weather=true";
            URL url = new URL(apiUrl);

            // Create HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read API response
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Display raw JSON response (for understanding)
            System.out.println("Raw Weather Data:");
            System.out.println(response.toString());

            // JSON PARSING 
            String json = response.toString();

            // Extract only the "current_weather" section
            String weatherSection = json
                    .split("\"current_weather\":\\{")[1]
                    .split("}")[0];

            String temperature = weatherSection
                    .split("\"temperature\":")[1]
                    .split(",")[0];

            String windSpeed = weatherSection
                    .split("\"windspeed\":")[1]
                    .split(",")[0];

            String weatherCode = weatherSection
                    .split("\"weathercode\":")[1]
                    .split(",")[0];

            // Display structured weather data
            System.out.println("\nCurrent Weather Report (Delhi):");
            System.out.println("Temperature : " + temperature + " °C");
            System.out.println("Wind Speed  : " + windSpeed + " km/h");
            System.out.println("Weather Code: " + weatherCode);

        } catch (Exception e) {
            System.out.println("Error fetching weather data.");
            e.printStackTrace();
        }
    }
}
