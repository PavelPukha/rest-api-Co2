
public class EstimateRequestVehicle {
   private final String type;
   private double distanceValueByCar;

    public EstimateRequestVehicle(String type, double distance_value) {
        this.type = type;
        this.distanceValueByCar = distance_value;

    }

    public String getTypeOfCar() {
        return type;
    }

    public double getDistanceValueByCar() {
        return distanceValueByCar;
    }
}
