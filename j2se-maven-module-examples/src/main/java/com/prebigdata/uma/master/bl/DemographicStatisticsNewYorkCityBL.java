package com.prebigdata.uma.master.bl;

import com.prebigdata.uma.master.dao.DemographicStatisticsNewYorkCityDAO;
import com.prebigdata.uma.master.domain.DemographicStatisticsNewYorkCityDTO;
import java.util.List;

public class DemographicStatisticsNewYorkCityBL {
        
      public List<DemographicStatisticsNewYorkCityDTO> getDemographicStatiticsFromCSVFile(String csvFilePath) throws Exception {
         DemographicStatisticsNewYorkCityDAO demographicDataDAO;
         
         try {
             demographicDataDAO = new DemographicStatisticsNewYorkCityDAO();
             
             return demographicDataDAO.getDemographicStatiticsFromCSVFile(csvFilePath);
             
         } catch(Exception exception) {
             throw exception;
         }
     }
}
