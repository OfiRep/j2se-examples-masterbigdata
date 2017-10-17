package com.prebigdata.uma.master.main;

import com.prebigdata.uma.master.bl.DemographicStatisticsNewYorkCityBL;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
    }
    
    public static void printDemographicStatisticsFromCSVFile() throws Exception {
        String csvFilePath = "../demofiles/Demographic_Statistics_By_Zip_Code.csv";
        DemographicStatisticsNewYorkCityBL demographicStatisticsBusinessLogic
                        = new DemographicStatisticsNewYorkCityBL();
        
        demographicStatisticsBusinessLogic.getDemographicStatiticsFromCSVFile(csvFilePath)
                .stream().forEach((singleDemographicStatistic) -> {
                    System.out.println("Demographic statistics data row");
                    System.out.println("===============================");
                    System.out.println("Jurisdiction Name: " + singleDemographicStatistic.jurisdictionName);
                    System.out.println("Count Participants: " + singleDemographicStatistic.countParticipants);
                    System.out.println("Count Female: " + singleDemographicStatistic.countFemale);
                    System.out.println("Percent Female: " + singleDemographicStatistic.percentFemale);
                    System.out.println("Count Male: " + singleDemographicStatistic.countMale);
                    System.out.println("Percent Male: " + singleDemographicStatistic.percentMale);
                    System.out.println("");
                });
    }
}
