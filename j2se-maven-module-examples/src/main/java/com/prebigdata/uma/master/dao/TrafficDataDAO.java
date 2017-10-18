package com.prebigdata.uma.master.dao;

import com.prebigdata.uma.master.bl.HttpBS;
import com.prebigdata.uma.master.domain.HttpRequestDTO;
import com.prebigdata.uma.master.domain.HttpResponseDTO;
import java.io.IOException;

public class TrafficDataDAO {
    
    public HttpResponseDTO getCurrentDataTrafficFromSantanderCity(HttpRequestDTO httpRequest) throws IOException {
        
        try {
            return HttpBS.request(httpRequest);
            
        } catch(IOException exception) {
            throw exception;
        }
    }
}
