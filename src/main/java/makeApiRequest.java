//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//    public class makeApiRequest {
//        private static void makeApiRequest() throws IOException {
//            URL url = new URL(WebApiFetcher.API_URL);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("POST");
//
//            connection.setRequestProperty("Authorization", "Bearer " + WebApiFetcher.API_KEY);
//            connection.setRequestProperty("Content-Type", "application/json");
//
//            connection.setDoOutput(true);
//            OutputStream outStream = connection.getOutputStream();
//            OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
//
//            // Replace this with your actual JSON payload
////            String estimateRequestAsString = "{\"type\": \"flight\", \"passengers\": 2, \"legs\": [{\"departure_airport\": \"sfo\", \"destination_airport\": \"yyz\"}, {\"departure_airport\": \"yyz\", \"destination_airport\": \"sfo\"}]}";
////            outStreamWriter.write(estimateRequestAsString);
//            outStreamWriter.flush();
//            outStreamWriter.close();
//            outStream.close();
//
//            int responseCode = connection.getResponseCode();
//
//            if (responseCode == HttpURLConnection.HTTP_CREATED) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                StringBuilder response = new StringBuilder();
//
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line).append(System.lineSeparator());
//                }
//
//                reader.close();
//
//                String responseData = response.toString();
//                System.out.println("API Response:");
//                System.out.println(responseData);
//
//            } else {
//                System.out.println("HTTP Request Failed. Response Code: " + responseCode);
//            }
//
//            connection.disconnect();
//        }
//    }