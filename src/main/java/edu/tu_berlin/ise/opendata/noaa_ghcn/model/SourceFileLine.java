package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

/**
 * Created by aardila on 7/14/17.
 */
public class SourceFileLine {
    public String stationId;
    public int year;
    public int month;
    public String element;
    //public ElementTypes element;
    public DailyValue[] dailyValues;

    public static SourceFileLine parse(final String input) {
        //TODO after Java 7 String.substring() is O(n). Perhaps reading the underlying byte buffer in order and parsing the tokens of known size would be more efficient than repeated calling of substring, which creates a new copy of the string on every call
        SourceFileLine line = new SourceFileLine();
        line.stationId = input.substring(0,11);
        line.year = Integer.parseInt(input.substring(11,15));
        line.month = Integer.parseInt(input.substring(15,17));
        line.element = input.substring(17,21);
        //measurement.element = ElementTypes.valueOf(input.substring(17,21));

        final int valuesStartIndex = 21;
        final int valueLength = 8;
        final int lengthOfValues = input.length() - valuesStartIndex;
        if (lengthOfValues % valueLength != 0) {
            return null;
        }
        final int numValues = lengthOfValues / valueLength;
        line.dailyValues = new DailyValue[numValues];

        for (int i = 0; i < numValues; i++) {
            int offset = valuesStartIndex + (valueLength * i);
            DailyValue dailyValue = new DailyValue();
            String valueAsString = input.substring(offset, offset+5).trim();
            //set sentinel value "-9999" to null (see ftp://ftp.ncdc.noaa.gov/pub/data/ghcn/daily/readme.txt "missing = -9999")
            if (valueAsString.equals("-9999") || valueAsString.isEmpty()) { valueAsString = null; }
            dailyValue.value = valueAsString == null ? null : Integer.parseInt(valueAsString);
            dailyValue.mFlag = input.charAt(offset+5);
            dailyValue.qFlag = input.charAt(offset+6);
            dailyValue.sFlag = input.charAt(offset+7);
            line.dailyValues[i] = dailyValue;
        }

        return line;
    }
}
