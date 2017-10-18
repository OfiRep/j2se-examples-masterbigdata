package com.prebigdata.uma.master.main;

import com.prebigdata.uma.master.bl.TrafficDataBS;
import com.prebigdata.uma.master.domain.TrafficDataDTO;
import java.io.IOException;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws IOException {
         
    }
     
    public static void printTrafficDataFromSantanderCity() throws IOException {
        TrafficDataBS trafficDataBusinessLogic = new TrafficDataBS();
        List<TrafficDataDTO> trafficDataListFound;
 
        trafficDataListFound = trafficDataBusinessLogic.getCurrentDataTrafficFromSantanderCity();
         
        if (trafficDataListFound != null) {
            trafficDataListFound.stream().forEach((singleTrafficData) -> {
                System.out.println("Single Traffic Data (Santander City)");
                System.out.println("====================================");
                System.out.println("Sensor ID: " + singleTrafficData.sensorId);
                System.out.println("Wait Time Percentage Occupied By Vehicle: " + singleTrafficData.waitTimePercentageOccupiedByVehicle);
                System.out.println("Vehicles Per Hour: " + singleTrafficData.vehiclesPerHour);
                System.out.println("Traffic Load Average: " + singleTrafficData.trafficLoadAverage);
                System.out.println("");
            });
        } else {
             System.out.println("No Records Found!");
        }
    }
}
