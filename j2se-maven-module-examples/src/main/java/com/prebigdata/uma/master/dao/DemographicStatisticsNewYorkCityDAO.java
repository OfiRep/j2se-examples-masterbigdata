package com.prebigdata.uma.master.dao;

import com.prebigdata.uma.master.domain.DemographicStatisticsNewYorkCityDTO;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;



public class DemographicStatisticsNewYorkCityDAO {
    
    public List<DemographicStatisticsNewYorkCityDTO> getDemographicStatiticsFromCSVFile(String csvFilePath) throws Exception {
        List<DemographicStatisticsNewYorkCityDTO> demographicDataList;
        DemographicStatisticsNewYorkCityDTO singleDemographicData;
        File csvFile;        
        Reader reader;
        CSVFormat format;
        CSVParser csvParser;
        
        try {
            demographicDataList = new ArrayList();

            csvFile = new File(csvFilePath);
            reader = new FileReader(csvFile);
            format = CSVFormat.DEFAULT;
            
            csvParser = CSVParser.parse(csvFile,Charset.defaultCharset(), format.withFirstRecordAsHeader());

            for(CSVRecord singleRecord: csvParser) {
                singleDemographicData = new DemographicStatisticsNewYorkCityDTO();
                
                singleDemographicData.jurisdictionName = Integer.parseInt(singleRecord.get(0));
                singleDemographicData.countParticipants = Integer.parseInt(singleRecord.get(1));
                singleDemographicData.countFemale = Integer.parseInt(singleRecord.get(2));
                singleDemographicData.percentFemale = Double.parseDouble(singleRecord.get(3));
                singleDemographicData.countMale = Integer.parseInt(singleRecord.get(4));
                singleDemographicData.percentMale = Double.parseDouble(singleRecord.get(5));

                demographicDataList.add(singleDemographicData);
            }            
            
            return demographicDataList;
        } catch(IOException | NumberFormatException exception) {
            throw exception;
        }
    }  
}
