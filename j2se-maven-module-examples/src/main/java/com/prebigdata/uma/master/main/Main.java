package com.prebigdata.uma.master.main;

import com.prebigdata.uma.master.dao.DemographicStatisticsNewYorkCityDAO;
import com.prebigdata.uma.master.domain.DemographicStatisticsNewYorkCityDTO;
import java.io.IOException;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws IOException {
        
    }
    
    public static void printDemographicStatisticsFromExcelFile() throws IOException {
        DemographicStatisticsNewYorkCityDAO lDAO = new DemographicStatisticsNewYorkCityDAO();
        List<DemographicStatisticsNewYorkCityDTO> demographicDataListFound;
        
        String excelFilePath = "../demofiles/Demographic_Statistics_By_Zip_Code.xlsx";
        
        demographicDataListFound = lDAO.getDemographicStatiticsFromExcelFile(excelFilePath);
        
        if (demographicDataListFound != null) {
            demographicDataListFound.stream().forEach((singleDemographicStatistic) -> {
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
        } else {
            System.out.println("No Records Found!");
        }
    }
}
