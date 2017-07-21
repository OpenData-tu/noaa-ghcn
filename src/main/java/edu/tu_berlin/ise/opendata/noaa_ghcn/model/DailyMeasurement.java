package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

import java.time.LocalDate;

/**
 * Created by aardila on 7/17/17.
 */
public class DailyMeasurement {
    private LocalDate date;
    private String stationId;
    private String measurand;
    private Integer value;
    private Character measurementFlag;
    private Character qualityFlag;
    private Character sourceFlag;

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

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

    public Integer getValue() { return value; }

    public void setValue(Integer value) { this.value = value; }

    public Character getMeasurementFlag() {
        return measurementFlag;
    }

    public void setMeasurementFlag(Character measurementFlag) {
        this.measurementFlag = measurementFlag;
    }

    public Character getQualityFlag() {
        return qualityFlag;
    }

    public void setQualityFlag(Character qualityFlag) {
        this.qualityFlag = qualityFlag;
    }

    public Character getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Character sourceFlag) {
        this.sourceFlag = sourceFlag;
    }
}
