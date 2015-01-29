package au.com.pazzul.nxtbus;

import android.os.Handler;
import au.com.pazzul.nxtbus.helper.DateHelper;
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
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HOMEPC on 29/01/2015.
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class Tester {

    @Test
    public void test() {


        Robolectric.runUiThreadTasksIncludingDelayedTasks();
        Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
        String entity = "";
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
                entity = EntityUtils.toString(resEntity);

                System.out.println("It worked: " + entity);
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Test: ");
            System.out.println(Constants.CURRENT_TIMESTAMP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
