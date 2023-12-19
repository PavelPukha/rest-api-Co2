import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import response.User;
//
import java.io.IOException;

 // Documentation https://docs.carboninterface.com/#/
//public class UserFetcher {
//
//    // in order to ignore some fields in the json response, here is how to configure the object mapper
//    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//    private final WebApiFetcher webApiFetcher = new WebApiFetcher();
//
//
//
//}


//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import response.User;

import java.io.IOException;





// Documentation https://docs.carboninterface.com/#/
public class UserFetcher {

    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public String getUserData() {
       String payload = "{\"type\": \"flight\", \"passengers\": 53, \"legs\": [{\"departure_airport\": \"sfo\", \"destination_airport\": \"yyz\"}, {\"departure_airport\": \"yyz\", \"destination_airport\": \"sfo\"}]}";
       return WebApiFetcher.makeApiRequest(payload);
    }

    public User mapResponseToUser(String responseData) {
        try {
            return objectMapper.readValue(responseData, User.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




        public EstimateResponse mapResponseToEstimate(String responseData) {
            try {
                return objectMapper.readValue(responseData, EstimateResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


    }
