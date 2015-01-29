package au.com.pazzul.nxtbus.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by HOMEPC on 29/01/2015.
 */
public class DateHelper {

    public static String generateRequestTimeStamp() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        Date today = Calendar.getInstance().getTime();

        TimeZone tz = TimeZone.getDefault();
        int offset = tz.getRawOffset();

        String offsetString = String.format("%s%02d%02d", offset >= 0 ? "+" : "-", offset / 3600000, (offset / 60000) % 60);
        return df.format(today) + "T" + df2.format(today) + offsetString;

    }

}
