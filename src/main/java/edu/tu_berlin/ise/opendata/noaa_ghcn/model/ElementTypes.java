package edu.tu_berlin.ise.opendata.noaa_ghcn.model;

/**
 * Created by aardila on 7/14/17.
 */
public enum ElementTypes {
    
    //The five core elements are:

    PRCP, //Precipitation (tenths of mm)
    SNOW, //Snowfall (mm)
    SNWD, //Snow depth (mm)
    TMAX, //Maximum temperature (tenths of degrees C)
    TMIN, //Minimum temperature (tenths of degrees C)

    //The other elements are:

    ACMC, //Average cloudiness midnight to midnight from 30-second ceilometer data (percent)
    ACMH, //Average cloudiness midnight to midnight from manual observations (percent)
    ACSC, //Average cloudiness sunrise to sunset from 30-second ceilometer data (percent)
    ACSH, //Average cloudiness sunrise to sunset from manual observations (percent)
    AWDR, //Average daily wind direction (degrees)
    AWND, //Average daily wind speed (tenths of meters per second)
    DAEV, //Number of days included in the multiday evaporation total (MDEV)
    DAPR, //Number of days included in the multiday precipiation total (MDPR)
    DASF, //Number of days included in the multiday snowfall total (MDSF)
    DATN, //Number of days included in the multiday minimum temperature (MDTN)
    DATX, //Number of days included in the multiday maximum temperature (MDTX)
    DAWM, //Number of days included in the multiday wind movement (MDWM)
    DWPR, //Number of days with non-zero precipitation included in multiday precipitation total (MDPR)
    EVAP, //Evaporation of water from evaporation pan (tenths of mm)
    FMTM, //Time of fastest mile or fastest 1-minute wind (hours and minutes, i.e., HHMM)
    FRGB, //Base of frozen ground layer (cm)
    FRGT, //Top of frozen ground layer (cm)
    FRTH, //Thickness of frozen ground layer (cm)
    GAHT, //Difference between river and gauge height (cm)
    MDEV, //Multiday evaporation total (tenths of mm; use with DAEV)
    MDPR, //Multiday precipitation total (tenths of mm; use with DAPR and DWPR, if available)
    MDSF, //Multiday snowfall total
    MDTN, //Multiday minimum temperature (tenths of degrees C; use with DATN)
    MDTX, //Multiday maximum temperature (tenths of degress C; use with DATX)
    MDWM, //Multiday wind movement (km)
    MNPN, //Daily minimum temperature of water in an evaporation pan (tenths of degrees C)
    MXPN, //Daily maximum temperature of water in an evaporation pan (tenths of degrees C)
    PGTM, //Peak gust time (hours and minutes, i.e., HHMM)
    PSUN, //Daily percent of possible sunshine (percent)

    TAVG,   //Average temperature (tenths of degrees C)
            //[Note that TAVG from source 'S' corresponds to an average for the period ending at
		    //2400 UTC rather than local midnight]
    THIC,   //Thickness of ice on water (tenths of mm)
    TOBS,   //Temperature at the time of observation (tenths of degrees C)
    TSUN,   //Daily total sunshine (minutes)
    WDF1,   //Direction of fastest 1-minute wind (degrees)
    WDF2,   //Direction of fastest 2-minute wind (degrees)
    WDF5,   //Direction of fastest 5-second wind (degrees)
    WDFG,   //Direction of peak wind gust (degrees)
    WDFI,   //Direction of highest instantaneous wind (degrees)
    WDFM,   //Fastest mile wind direction (degrees)
    WDMV,   //24-hour wind movement (km)
    WESD,   //Water equivalent of snow on the ground (tenths of mm)
    WESF,   //Water equivalent of snowfall (tenths of mm)
    WSF1,   //Fastest 1-minute wind speed (tenths of meters per second)
    WSF2,   //Fastest 2-minute wind speed (tenths of meters per second)
    WSF5,   //Fastest 5-second wind speed (tenths of meters per second)
    WSFG,   //Peak gust wind speed (tenths of meters per second)
    WSFI,   //Highest instantaneous wind speed (tenths of meters per second)
    WSFM,   //Fastest mile wind speed (tenths of meters per second)
}
