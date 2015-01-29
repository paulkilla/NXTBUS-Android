package au.com.pazzul.nxtbus;

import au.com.pazzul.nxtbus.helper.DateHelper;
import au.com.pazzul.nxtbus.helper.Transformer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.IOException;
import java.util.Date;

/**
 * Created by HOMEPC on 29/01/2015.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class Tester {

    @Test
    public void testVehicleStatus() {
        Robolectric.runUiThreadTasksIncludingDelayedTasks();
        Robolectric.getFakeHttpLayer().interceptHttpRequests(false);

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(Constants.URL_VEHICLE_STATUS);

            try {
                StringEntity se = new StringEntity(  Constants.SIRI_START_ENVELOPE +
                        "<CheckStatusRequest>\n" +
                        "\n" +
                        "<RequestTimestamp>" + DateHelper.generateRequestTimeStamp() + "</RequestTimestamp>\n" +
                        "\n" +
                        "<RequestorRef>"+Constants.API_KEY+"</RequestorRef>\n" +
                        "\n" +
                        "</CheckStatusRequest>\n" +
                        Constants.SIRI_END_ENVELOPE, HTTP.UTF_8);

                se.setContentType("text/xml");
                httppost.setEntity(se);

                HttpResponse httpresponse = httpclient.execute(httppost);
                HttpEntity resEntity = httpresponse.getEntity();
                String entity = EntityUtils.toString(resEntity);

                System.out.println("It worked: " + entity);
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Test: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTimetablePoll() {
        Robolectric.runUiThreadTasksIncludingDelayedTasks();
        Robolectric.getFakeHttpLayer().interceptHttpRequests(false);

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(Constants.URL_PROD_POLL);

            try {
                String time = DateHelper.generateRequestTimeStamp();
                StringEntity se = new StringEntity(  "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>\n" +
                        "\n" +
                        "<Siri version=\"1.3\" xmlns:ns2=\"http://www.ifopt.org.uk/acsb\" xmlns=\"http://www.siri.org.uk/siri\" \n" +
                        "\n" +
                        "xmlns:ns4=\"http://datex2.eu/schema/2_0RC1/2_0\" xmlns:ns3=\"http://www.ifopt.org.uk/ifopt\">\n" +
                        "\n" +
                        "<ServiceRequest>\n" +
                        "\n" +
                        "<RequestTimestamp>" + time + "</RequestTimestamp>\n" +
                        "\n" +
                        "<RequestorRef>" + Constants.API_KEY + "</RequestorRef>\n" +
                        "\n" +
                        "<ProductionTimetableRequest version=\"1.3\">\n" +
                        "\n" +
                        "<RequestTimestamp>" + time + "</RequestTimestamp>\n" +
                        "\n" +
                        "<ValidityPeriod>\n" +
                        "\n" +
                        "<StartTime>2015-01-29T13:50:04+01:00</StartTime>\n" +
                        "\n" +
                        "<EndTime>2015-01-30T13:50:04+01:00</EndTime>\n" +
                        "\n" +
                        "</ValidityPeriod>\n" +
                        "\n" +
                        "<Lines>\n" +
                        "\n" +
                        "<LineDirection>\n" +
                        "\n" +
                        "<LineRef>ACT_200</LineRef>\n" +
                        "\n" +
                        "<DirectionRef>A</DirectionRef>\n" +
                        "\n" +
                        "<LineDirection>\n" +
                        "\n" +
                        "</Lines>\n" +
                        "\n" +
                        "</ProductionTimetableRequest>" +
                        "</ServiceRequest>\n" +
                        "\n" +
                        "</Siri>", HTTP.UTF_8);

                se.setContentType("text/xml");
                httppost.setEntity(se);

                HttpResponse httpresponse = httpclient.execute(httppost);
                HttpEntity resEntity = httpresponse.getEntity();
                String entity = EntityUtils.toString(resEntity);

                System.out.println("It worked: " + Transformer.prettyFormat(entity));
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Test: ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
