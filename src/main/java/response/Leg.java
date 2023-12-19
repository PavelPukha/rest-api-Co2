package response;

public class Leg {

    String departure_airport;
    String destination_airport;

    public String getDeparture_airport() {
        return departure_airport;
    }

    public String getDestination_airport() {
        return destination_airport;
    }

    public Leg(String departure_airport, String destination_airport) {
        this.departure_airport = departure_airport;
        this.destination_airport = destination_airport;
    }
}
