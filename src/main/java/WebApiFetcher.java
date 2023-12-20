

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class WebApiFetcher {

    public static final String API_URL = "https://www.carboninterface.com/api/v1/estimates";
    public static final String API_KEY = "T2zfr335K813jQDAOyQJw";

    public static String makeApiRequest(String payload) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");

            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setDoOutput(true);
            try (OutputStream outStream = connection.getOutputStream();
                 OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, StandardCharsets.UTF_8)) {

                outStreamWriter.write(payload);
                outStreamWriter.flush();
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_CREATED) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line).append(System.lineSeparator());
                    }

                    return response.toString();
                }
            } else {
                System.out.println("HTTP Request Failed. Response Code: " + responseCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
