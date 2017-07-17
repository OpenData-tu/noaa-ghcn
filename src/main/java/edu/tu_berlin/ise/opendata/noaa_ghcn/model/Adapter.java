package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

import java.time.LocalDate;

/**
 * Created by aardila on 7/17/17.
 */
public class Adapter {

    public static DailyMeasurement[] adapt(SourceFileLine sourceFileLine) {

        int lengthOfMonth = LocalDate.of(sourceFileLine.year, sourceFileLine.month, 1).lengthOfMonth();
        DailyMeasurement[] dailyMeasurements = new DailyMeasurement[lengthOfMonth];

        for (int i = 0; i < lengthOfMonth; i++) {
            dailyMeasurements[i] = new DailyMeasurement();
            dailyMeasurements[i].date = LocalDate.of(sourceFileLine.year, sourceFileLine.month, i+1);
            dailyMeasurements[i].stationId = sourceFileLine.stationId;
            dailyMeasurements[i].measurand = sourceFileLine.element;
            dailyMeasurements[i].value = sourceFileLine.dailyValues[i];
        }

        return dailyMeasurements;
    }
}
