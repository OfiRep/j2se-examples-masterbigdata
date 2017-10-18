package com.prebigdata.uma.master.dao;

import com.prebigdata.uma.master.domain.DemographicStatisticsNewYorkCityDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DemographicStatisticsNewYorkCityDAO {
    
    public List<DemographicStatisticsNewYorkCityDTO> getDemographicStatiticsFromExcelFile(String excelFilePath) throws IOException {
        FileInputStream file;
        XSSFWorkbook workbook;
        Integer currentLine;
        DemographicStatisticsNewYorkCityDTO singleDemographicData;
        List<DemographicStatisticsNewYorkCityDTO> demographicDataList;
        
        try {
            currentLine = 0;
            demographicDataList = new ArrayList();
            
            file = new FileInputStream(new File(excelFilePath));
            
            //Create Workbook instance holding reference to .xlsx file
            workbook = new XSSFWorkbook(file);
            
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                
                if (currentLine > 0) {
                    singleDemographicData = new DemographicStatisticsNewYorkCityDTO();
                    
                    while (cellIterator.hasNext()) 
                    {
                        Cell cell = cellIterator.next();
  
                        switch (cell.getColumnIndex()) {
                            case 0:
                                 singleDemographicData.jurisdictionName = (new Double(cell.getNumericCellValue())).intValue();
                                break;
                            
                            case 1:
                                singleDemographicData.countParticipants = (new Double(cell.getNumericCellValue())).intValue();
                                break;
                                
                            case 2:
                                singleDemographicData.countFemale = (new Double(cell.getNumericCellValue())).intValue();
                                break;
                                
                            case 3:
                                singleDemographicData.percentFemale = cell.getNumericCellValue();
                                break;
                                
                            case 4:
                                singleDemographicData.countMale = (new Double(cell.getNumericCellValue())).intValue();
                                break;
                            
                            case 5:
                                singleDemographicData.percentMale = cell.getNumericCellValue();
                        }
                                        
                    }
                    
                    demographicDataList.add(singleDemographicData);
                }
                currentLine++;
            }
            
            if (demographicDataList.isEmpty()) {
                demographicDataList = null;
            }
            
            return demographicDataList;
        } catch(IOException exception) {
            throw exception;
        }
    }
}
