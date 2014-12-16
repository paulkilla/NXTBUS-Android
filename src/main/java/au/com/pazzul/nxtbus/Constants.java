package au.com.pazzul.nxtbus;

/**
 * Created by paulk on 16/12/14.
 */
public class Constants {

    public static String API_KEY = "B5233";
    public static String HOST = "http://siri.nxtbus.act.gov.au:11000";
    public static String STOP_MONITORING = "sm";
    public static String VEHICLE_MONITORING = "vm";
    public static String PROD_TIMETABLE = "pt";
    public static String EST_TIMETABLE = "et";
    public static String STATUS = "status.xml";
    public static String SUBSCRIPTION = "subscription.xml";
    public static String POLL = "polldata.xml";
    public static String REPORT = "dataready.xml";
    public static String DIRECT = "directdelivery.xml";
    public static String REQUEST = "service.xml";

    public static String URL_STOP_STATUS = HOST + "/" + API_KEY + "/" + STOP_MONITORING + "/" + STATUS;
    public static String URL_STOP_SUBSCRIPTION = HOST + "/" + API_KEY + "/" + STOP_MONITORING + "/" + SUBSCRIPTION;
    public static String URL_STOP_POLL = HOST + "/" + API_KEY + "/" + STOP_MONITORING + "/" + POLL;
    @Deprecated
    public static String URL_STOP_REPORT = HOST + "/" + API_KEY + "/" + STOP_MONITORING + "/" + REPORT;
    public static String URL_STOP_DIRECT = HOST + "/" + API_KEY + "/" + STOP_MONITORING + "/" + DIRECT;
    public static String URL_STOP_REQUEST = HOST + "/" + API_KEY + "/" + STOP_MONITORING + "/" + REQUEST;

    public static String URL_VEHICLE_STATUS = HOST + "/" + API_KEY + "/" + VEHICLE_MONITORING + "/" + STATUS;
    public static String URL_VEHICLE_SUBSCRIPTION = HOST + "/" + API_KEY + "/" + VEHICLE_MONITORING + "/" + SUBSCRIPTION;
    public static String URL_VEHICLE_POLL = HOST + "/" + API_KEY + "/" + VEHICLE_MONITORING + "/" + POLL;
    @Deprecated
    public static String URL_VEHICLE_REPORT = HOST + "/" + API_KEY + "/" + VEHICLE_MONITORING + "/" + REPORT;
    public static String URL_VEHICLE_DIRECT = HOST + "/" + API_KEY + "/" + VEHICLE_MONITORING + "/" + DIRECT;
    @Deprecated
    public static String URL_VEHICLE_REQUEST = HOST + "/" + API_KEY + "/" + VEHICLE_MONITORING + "/" + REQUEST;

    public static String URL_PROD_STATUS = HOST + "/" + API_KEY + "/" + PROD_TIMETABLE + "/" + STATUS;
    public static String URL_PROD_SUBSCRIPTION = HOST + "/" + API_KEY + "/" + PROD_TIMETABLE + "/" + SUBSCRIPTION;
    public static String URL_PROD_POLL = HOST + "/" + API_KEY + "/" + PROD_TIMETABLE + "/" + POLL;
    @Deprecated
    public static String URL_PROD_REPORT = HOST + "/" + API_KEY + "/" + PROD_TIMETABLE + "/" + REPORT;
    public static String URL_PROD_DIRECT = HOST + "/" + API_KEY + "/" + PROD_TIMETABLE + "/" + DIRECT;
    @Deprecated
    public static String URL_PROD_REQUEST = HOST + "/" + API_KEY + "/" + PROD_TIMETABLE + "/" + REQUEST;

    public static String URL_EST_STATUS = HOST + "/" + API_KEY + "/" + EST_TIMETABLE + "/" + STATUS;
    public static String URL_EST_SUBSCRIPTION = HOST + "/" + API_KEY + "/" + EST_TIMETABLE + "/" + SUBSCRIPTION;
    public static String URL_EST_POLL = HOST + "/" + API_KEY + "/" + EST_TIMETABLE + "/" + POLL;
    @Deprecated
    public static String URL_EST_REPORT = HOST + "/" + API_KEY + "/" + EST_TIMETABLE + "/" + REPORT;
    @Deprecated
    public static String URL_EST_DIRECT = HOST + "/" + API_KEY + "/" + EST_TIMETABLE + "/" + DIRECT;
    @Deprecated
    public static String URL_EST_REQUEST = HOST + "/" + API_KEY + "/" + EST_TIMETABLE + "/" + REQUEST;


}
