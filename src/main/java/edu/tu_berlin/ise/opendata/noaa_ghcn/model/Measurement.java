package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

/**
 * Created by aardila on 7/14/17.
 */
public class Measurement {
    public String id;
    public int year;
    public int month;
    public String element;
    //public ElementTypes element;
    public Value[] values;

    public static Measurement deserialize(final String input) {
        Measurement measurement = new Measurement();
        measurement.id = input.substring(0,11);
        measurement.year = Integer.parseInt(input.substring(11,15));
        measurement.month = Integer.parseInt(input.substring(15,17));
        measurement.element = input.substring(17,21);
        //measurement.element = ElementTypes.valueOf(input.substring(17,21));
        final int valuesStartIndex = 21;
        final int valueLength = 8;
        final int lengthOfValues = input.length() - valuesStartIndex;
        if (lengthOfValues % valueLength != 0) {
            return null;
        }
        final int numValues = lengthOfValues / valueLength;
        measurement.values = new Value[numValues];

        for (int i = 0; i < numValues; i++) {
            int offset = valuesStartIndex + (valueLength * i);
            Value value = new Value();
            String valueAsString = input.substring(offset, offset+5).trim();
            if (valueAsString.equals("-9999") || valueAsString.isEmpty()) { valueAsString = null; }
            value.value = valueAsString == null ? null : Integer.parseInt(valueAsString);
            value.mFlag = input.charAt(offset+5);
            value.qFlag = input.charAt(offset+6);
            value.sFlag = input.charAt(offset+7);
            measurement.values[i] = value;
        }

        return measurement;
    }
}
