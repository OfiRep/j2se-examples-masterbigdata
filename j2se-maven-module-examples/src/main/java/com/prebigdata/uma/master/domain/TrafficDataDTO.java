package com.prebigdata.uma.master.domain;


public class TrafficDataDTO {
    public Integer sensorId;
    public Integer waitTimePercentageOccupiedByVehicle;
    public Integer vehiclesPerHour;
    public Integer trafficLoadAverage;
    
    public TrafficDataDTO () {
        this.sensorId = null;
        this.waitTimePercentageOccupiedByVehicle = null;
        this.vehiclesPerHour = null;
        this.trafficLoadAverage = null;
    }
}
