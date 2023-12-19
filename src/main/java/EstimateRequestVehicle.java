
public class EstimateRequestVehicle {
   private String type;
   private Double distance_value;

    public EstimateRequestVehicle(String type, double distance_value) {
        this.type = type;
        this.distance_value = distance_value;

    }

    public String getType() {
        return type;
    }

    public double getDistanceValue() {
        return distance_value;
    }
}
