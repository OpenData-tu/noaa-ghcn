package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

/**
 * Created by aardila on 7/14/17.
 */
public class DailyValue {
    /**
     * The actual value of the measurement/observation
     */
    public Integer value;

    /**
     * Measurement flag
     */
    public Character mFlag;
    /**
     * Quality flag
     */
    public Character qFlag;
    /**
     * Source flag
     */
    public Character sFlag;
}
