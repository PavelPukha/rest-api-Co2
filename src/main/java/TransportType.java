import java.util.Arrays;
import java.util.List;

public class TransportType {


    static boolean isValidTransportType(String transportType) {

        List<String> validTransportTypes = Arrays.asList("flight", "vehicle");


        return validTransportTypes.contains(transportType);
    }
}
