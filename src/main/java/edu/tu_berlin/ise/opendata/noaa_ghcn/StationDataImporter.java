package edu.tu_berlin.ise.opendata.noaa_ghcn;

import edu.tu_berlin.ise.opendata.FtpSource;
import edu.tu_berlin.ise.opendata.noaa_ghcn.model.Adapter;
import edu.tu_berlin.ise.opendata.noaa_ghcn.model.DailyMeasurement;
import edu.tu_berlin.ise.opendata.noaa_ghcn.model.SourceFileLine;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by aardila on 7/14/17.
 */
class StationDataImporter {
    private final static String HOST = "ftp.ncdc.noaa.gov";
    //private final static String FILE = "/pub/data/ghcn/daily/all/USW00023183.dly";

    public static void main(String[] args) throws IOException {

        if (args[0] == null) {
            throw new IllegalArgumentException("A station ID is expected as the first argument to this program");
        }

        final String stationId = args[0];
        final String filename = String.format("/pub/data/ghcn/daily/all/%s.dly", stationId);

        FtpSource ftpSource = new FtpSource(HOST);
        Map<LocalDate, List<DailyMeasurement>> dailyMeasurements =
                ftpSource.getStream(filename, "US-ASCII")
                         .map(SourceFileLine::parse)
                         .map(Adapter::adapt)
                         .flatMap(Arrays::stream)
                         .collect(Collectors.groupingBy(DailyMeasurement::getDate));

        for (Map.Entry<LocalDate, List<DailyMeasurement>> kvp : dailyMeasurements.entrySet()) {
            for (DailyMeasurement m : kvp.getValue()) {
                System.out.println(kvp.getKey().toString() + ": " + m.getMeasurand() + " " + m.getValue());
            }
        }

    }

}
