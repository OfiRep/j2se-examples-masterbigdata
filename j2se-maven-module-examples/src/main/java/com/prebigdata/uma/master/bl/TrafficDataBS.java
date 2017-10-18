package com.prebigdata.uma.master.bl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.prebigdata.uma.master.common.HttpConstants;
import com.prebigdata.uma.master.dao.TrafficDataDAO;
import com.prebigdata.uma.master.domain.HttpRequestDTO;
import com.prebigdata.uma.master.domain.HttpResponseDTO;
import com.prebigdata.uma.master.domain.TrafficDataDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TrafficDataBS {
    
    public List<TrafficDataDTO> getCurrentDataTrafficFromSantanderCity() throws IOException {
        HttpRequestDTO httpRequest;
        HttpResponseDTO httpResponse;
        TrafficDataDAO trafficDataDAO;
        Gson gson = new Gson();
        List<TrafficDataDTO> currentDataTrafficCollected;
        TrafficDataDTO singleTrafficData;
        
        try {
            httpRequest = new HttpRequestDTO();
            trafficDataDAO = new TrafficDataDAO();
            currentDataTrafficCollected = new ArrayList();
            
            httpRequest.protocol = HttpConstants.HTTP_UNSECURE_PROTOCOL;
            httpRequest.requestMethod = HttpConstants.GET_HTTP_METHOD;
            httpRequest.urlEndpoint = "http://datos.santander.es/api/rest/datasets/mediciones.json?items=2";
            

            httpResponse = trafficDataDAO.getCurrentDataTrafficFromSantanderCity(httpRequest);
                        
            JsonObject jsonObject = gson.fromJson(httpResponse.responseBody, JsonObject.class);
            
            JsonArray jsonArray = gson.fromJson(jsonObject.get("resources"), JsonArray.class);
            
            for (int i=0; i<jsonArray.size(); i++) {
                singleTrafficData = new TrafficDataDTO();
                
                singleTrafficData.waitTimePercentageOccupiedByVehicle = ((JsonObject) jsonArray.get(i)).get("ayto:ocupacion").getAsInt();
                singleTrafficData.sensorId = ((JsonObject) jsonArray.get(i)).get("ayto:medida").getAsInt();
                singleTrafficData.vehiclesPerHour = ((JsonObject) jsonArray.get(i)).get("ayto:intensidad").getAsInt();
                singleTrafficData.trafficLoadAverage = ((JsonObject) jsonArray.get(i)).get("ayto:carga").getAsInt();

                currentDataTrafficCollected.add(singleTrafficData);
            }
            
            if (currentDataTrafficCollected.isEmpty()) {
                currentDataTrafficCollected = null;
            }
            
            return currentDataTrafficCollected;
            
        } catch(IOException exception) {
            throw exception;
        }
    }
}
