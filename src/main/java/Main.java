import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import response.Leg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AirportCodeMapper.loadMappingsFromFile();

        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------------------------");
        boolean continueProcessing = true;

        while (continueProcessing) {
            System.out.println("Enter the type of Transport");

            String requestType = scanner.next();

            System.out.println("Enter the number of passengers:");
            int numPassengers = scanner.nextInt();

            String departureAirportCode = null;
            while (departureAirportCode == null) {
                System.out.println("Enter the departure city:");
                String departureCity = scanner.next();
                departureAirportCode = AirportCodeMapper.getAirportCode(departureCity);
                if (departureAirportCode == null) {
                    System.out.println("City code not found. Do you want to enter the departure city again? (yes/no)");
                    String retryOption = scanner.next().toLowerCase();
                    if (!retryOption.equals("yes")) {
                        continueProcessing = false;
                        break;
                    }
                }
            }
            if (!continueProcessing) {
                break;
            }
            String destinationAirportCode = null;
            while (destinationAirportCode == null) {
                System.out.println("Enter the destination city:");
                String destinationCity = scanner.next();
                destinationAirportCode = AirportCodeMapper.getAirportCode(destinationCity);
                if (destinationAirportCode == null) {
                    System.out.println("City code not found. Do you want to enter the destination city again? (yes/no)");
                    String retryOption = scanner.next().toLowerCase();
                    if (!retryOption.equals("yes")) {
                        continueProcessing = false;
                        break;
                    }
                }
            }

            if (!continueProcessing) {
                break;
            }

            Leg leg = new Leg(departureAirportCode, destinationAirportCode);

            List<Leg> legs = new ArrayList<>();
            legs.add(leg);

            ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            EstimateRequest estimateRequest = new EstimateRequest(requestType, numPassengers, legs);

            try {
                String estimateRequestAsString = objectMapper.writeValueAsString(estimateRequest);

                String responseData = WebApiFetcher.makeApiRequest(estimateRequestAsString);

                if (responseData != null) {
                    EstimateResponse estimateResponse = objectMapper.readValue(responseData, EstimateResponse.class);

                    if (estimateResponse != null) {
                        System.out.println("Passengers number: " + estimateResponse.getData().getAttributes().getPassengers());
                        System.out.println("Distance value in km: " + estimateResponse.getData().getAttributes().getDistance_value());
                        System.out.println("Carbon in kg: " + estimateResponse.getData().getAttributes().getCarbon_kg());
                    }
                }
            } catch (JsonProcessingException e) {
                System.err.println("Error processing JSON: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("Do you want to continue? (yes/no)");
            String continueOption = scanner.next().toLowerCase();
            continueProcessing = continueOption.equals("yes");
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Maybe you want to see the average annual amount of Co2 generated by a single person in the EU? ");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choiceAmountOfCo2InEurope = scanner.nextInt();
        if (choiceAmountOfCo2InEurope == 1) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("In order to stop climate change, this is the maximum amount of Co2 that can be generated by a single person in a year --> 600 kg Co2");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("This is the average annual amount of Co2 generated by a single person in the EU --> 8400 kg Co2");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Thank you for using our program!");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        } else if (choiceAmountOfCo2InEurope == 2) {
            System.out.println("Thank you for using my program!");
        } else {
            System.out.println("Invalid input. Please enter either '1' or '2'.");
        }

        scanner.close();
    }

}
