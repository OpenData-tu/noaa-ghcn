package edu.tu_berlin.ise.opendata.noaa_ghcn;

import edu.tu_berlin.ise.opendata.FtpSource;
import edu.tu_berlin.ise.opendata.noaa_ghcn.model.Measurement;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aardila on 7/14/17.
 */
public class DailyImporter {
    private final static String HOST = "ftp.ncdc.noaa.gov";
    private final static String FILE = "/pub/data/ghcn/daily/all/USW00023183.dly";

    public static void main(String[] args) throws IOException {

        if (args[0] == null) {
            throw new IllegalArgumentException("A station ID is expected as the first argument to this program");
        }

        final String stationId = args[0];
        final String filename = String.format("/pub/data/ghcn/daily/all/%s.dly", stationId);

        FtpSource ftpSource = new FtpSource(HOST);
        List<Measurement> measurements =
                ftpSource.getStream(filename, "US-ASCII")
                         .map(Measurement::deserialize)
                         .collect(Collectors.toList());
    }

}
