package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

import java.time.LocalDate;

/**
 * Created by aardila on 7/17/17.
 */
public class DailyMeasurement {
    LocalDate date;
    String stationId;
    String measurand;
    Value value;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getMeasurand() {
        return measurand;
    }

    public void setMeasurand(String measurand) {
        this.measurand = measurand;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
