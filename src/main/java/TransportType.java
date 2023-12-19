import java.util.Arrays;
import java.util.List;

public class TransportType {

    static boolean isValidTransportType(String transportType) {
        // Define a list of valid transport types
        List<String> validTransportTypes = Arrays.asList("flight", "vehicle");

        // Check if the input transport type is in the list of valid types
        return validTransportTypes.contains(transportType);
    }
}
