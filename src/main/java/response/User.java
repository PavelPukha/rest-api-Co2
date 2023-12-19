package response;
//
//public class User {
//    private String data;
////    private Name name;
////
////    private Name title;
////
////    private Login login;
////    private String nat;
////
////    private String email;
////
////    private Login username;
////    private Login password;
////
//
//
//    public User() {
//    }
//
//    public String getData() {
//        return data;
//    }
//
////
//
//
//
//
//
//}

import java.util.List;

public class User {

    private double carbon_kg;
    private double distance_value;
    private String type;
    private int passengers;
    private List<Leg> legs;

    public double getCarbon_kg() {
        return carbon_kg;
    }

    public double getDistance_value() {
        return distance_value;
    }

    public String getType() {
        return type;
    }

    public int getPassengers() {
        return passengers;
    }

    public List<Leg> getLegs() {
        return legs;
    }



    static class Leg {
        private String departure_airport;
        private String destination_airport;



        public String getDeparture_airport() {
            return departure_airport;
        }

        public String getDestination_airport() {
            return destination_airport;
        }
    }
}


