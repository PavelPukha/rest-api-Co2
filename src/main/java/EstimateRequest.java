

import response.Leg;

import java.util.List;

public class EstimateRequest {

    String type;
    int  passengers;

    List<Leg> legs;


    public EstimateRequest(String type, int passengers, List<Leg> legs) {
        this.type = type;
        this.passengers = passengers;
        this.legs = legs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }


}

