

import java.util.List;


public class EstimateResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public static class Data {
        private String id;
        private String type;
        private Attributes attributes;

        public String getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public static class Attributes {
            private int passengers;
            private List<Leg> legs;
            private String estimated_at;
            private int carbon_g;
            private int carbon_lb;
            private int carbon_kg;
            private int carbon_mt;
            private String distance_unit;
            private double distance_value;

            public int getPassengers() {
                return passengers;
            }

            public List<Leg> getLegs() {
                return legs;
            }

            public String getEstimated_at() {
                return estimated_at;
            }

            public int getCarbon_g() {
                return carbon_g;
            }

            public int getCarbon_lb() {
                return carbon_lb;
            }

            public int getCarbon_kg() {
                return carbon_kg;
            }

            public int getCarbon_mt() {
                return carbon_mt;
            }

            public String getDistance_unit() {
                return distance_unit;
            }

            public double getDistance_value() {
                return distance_value;
            }

            public static class Leg {
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
    }
}