package com.prebigdata.uma.master.bl;

import com.prebigdata.uma.master.dao.DemographicStatisticsNewYorkCityDAO;
import com.prebigdata.uma.master.domain.DemographicStatisticsNewYorkCityDTO;
import java.io.IOException;
import java.util.List;


public class DemographicStatisticsNewYorkCityBL {
    
    public List<DemographicStatisticsNewYorkCityDTO> getDemographicStatiticsFromExcelFile(String excelFilePath) throws IOException {
        DemographicStatisticsNewYorkCityDAO demographicDataDAO;
        
            try {
                demographicDataDAO = new DemographicStatisticsNewYorkCityDAO();
 
                return demographicDataDAO.getDemographicStatiticsFromExcelFile(excelFilePath);
            } catch(IOException exception) {
                throw exception;
            }
        }
}
