package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

import java.time.LocalDate;

/**
 * Created by aardila on 7/17/17.
 */
public class Adapter {

    public static DailyMeasurement[] adapt(SourceFileLine sourceFileLine) {

        //sourceFileLine.dailyValues has more values than the corresponding month has days
        //use the number of days of that month instead of the length of the dailyValues array
        int lengthOfMonth = LocalDate.of(sourceFileLine.year, sourceFileLine.month, 1).lengthOfMonth();
        DailyMeasurement[] dailyMeasurements = new DailyMeasurement[lengthOfMonth];

        for (int i = 0; i < lengthOfMonth; i++) {
            DailyMeasurement dailyMeasurement = new DailyMeasurement();
            dailyMeasurement.setDate(LocalDate.of(sourceFileLine.year, sourceFileLine.month, i+1));
            dailyMeasurement.setStationId(sourceFileLine.stationId);
            dailyMeasurement.setMeasurand(sourceFileLine.element);
            dailyMeasurement.setValue(sourceFileLine.dailyValues[i].value);
            dailyMeasurement.setMeasurementFlag(sourceFileLine.dailyValues[i].mFlag);
            dailyMeasurement.setQualityFlag(sourceFileLine.dailyValues[i].qFlag);
            dailyMeasurement.setSourceFlag(sourceFileLine.dailyValues[i].sFlag);
            dailyMeasurements[i] = dailyMeasurement;
        }

        return dailyMeasurements;
    }
}
