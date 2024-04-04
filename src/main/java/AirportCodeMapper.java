import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AirportCodeMapper {
    private static final Map<String, String> cityToCodeMapping = new HashMap<>();


    public static void loadMappingsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/cities.txt"))) {


            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
              //  System.out.println(Arrays.toString(parts));
                if (parts.length == 2) {
                    String city = parts[1].trim();

                    String code = parts[0].trim();

                    System.out.println("City: " + city + ", Code: " + code);
                    cityToCodeMapping.put(city.toLowerCase(), code.toUpperCase());
                }

            }


          cityToCodeMapping.forEach((city, code) -> System.out.println(city + " -> " + code));

        } catch (IOException e) {
            System.err.println("Error loading mappings from file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static String getAirportCode(String code) {

        return cityToCodeMapping.getOrDefault(code.toLowerCase(), null);

//        String airportCode = cityToCodeMapping.getOrDefault(code.toLowerCase(), null);
//        return (airportCode != null) ? "\"" + airportCode + "\"" : "Code not found";


    }
}






