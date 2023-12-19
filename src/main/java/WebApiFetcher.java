//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//
// class WebApiFetcher {
//
//
//     public static final String API_URL = "https://www.carboninterface.com/api/v1/estimates";
//     public static final String API_KEY = "T2zfr335K813jQDAOyQJw";
//
//
//
//
//
//     {
//         URL url = null;
//         try {
//             url = new URL(API_URL);
//         } catch (MalformedURLException ex) {
//             throw new RuntimeException(ex);
//         }
//         HttpURLConnection connection = null;
//         try {
//             connection = (HttpURLConnection) url.openConnection();
//         } catch (IOException ex) {
//             throw new RuntimeException(ex);
//         }
//
//
//         try {
//             connection.setRequestMethod("POST");
//         } catch (ProtocolException ex) {
//             throw new RuntimeException(ex);
//         }
//
//         connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
//         connection.setRequestProperty("Content-Type","application/json");
//
//         connection.setDoOutput(true);
//         OutputStream outStream = null;
//         try {
//             outStream = connection.getOutputStream();
//         } catch (IOException ex) {
//             throw new RuntimeException(ex);
//         }
//         OutputStreamWriter outStreamWriter = null;
//         try {
//             outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
//         } catch (UnsupportedEncodingException ex) {
//             throw new RuntimeException(ex);
//         }
//
//
//
////         outStreamWriter.write(estimateRequestAsString);
////                outStreamWriter.write(estimateResponseAsString);
//         try {
//             outStreamWriter.flush();
//         } catch (IOException ex) {
//             throw new RuntimeException(ex);
//         }
//         try {
//             outStreamWriter.close();
//         } catch (IOException ex) {
//             throw new RuntimeException(ex);
//         }
//         try {
//             outStream.close();
//         } catch (IOException ex) {
//             throw new RuntimeException(ex);
//         }
////
////            System.out.println(connection.getResponseCode());
////            System.out.println(connection.getResponseMessage());
////
////            InputStream json = connection.getInputStream();
//
//
//         int responseCode = 0;
//         try {
//             responseCode = connection.getResponseCode();
//         } catch (IOException ex) {
//             throw new RuntimeException(ex);
//         }
//
//         if (responseCode == HttpURLConnection.HTTP_CREATED) {
//
//             BufferedReader reader = null;
//             try {
//                 reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//             } catch (IOException ex) {
//                 throw new RuntimeException(ex);
//             }
//             StringBuilder response = new StringBuilder();
//
//             String line;
//             while (true) {
//                 try {
//                     if (!((line = reader.readLine()) != null)) break;
//                 } catch (IOException ex) {
//                     throw new RuntimeException(ex);
//                 }
//                 response.append(line).append(System.lineSeparator());
//             }
//
//             try {
//                 reader.close();
//             } catch (IOException ex) {
//                 throw new RuntimeException(ex);
//             }
//
//             String responseData = response.toString();
//             System.out.println("API Response:");
//             System.out.println(responseData);
//
//         } else {
//             System.out.println("HTTP Request Failed. Response Code: " + responseCode);
//         }
//
//
//
//         connection.disconnect();
//
//     }
//     }
//
//


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

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
                 OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8")) {

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
