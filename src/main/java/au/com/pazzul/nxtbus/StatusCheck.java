package au.com.pazzul.nxtbus;

import android.os.AsyncTask;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by paulk on 16/12/14.
 */
public class StatusCheck extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        String entity = "";
        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(Constants.URL_VEHICLE_STATUS);

            try {
                StringEntity se = new StringEntity(  Constants.SIRI_START_ENVELOPE +
                        "<CheckStatusRequest>\n" +
                        "\n" +
                        "<RequestTimestamp>2013-12-29T14:09:41.000+01:00</RequestTimestamp>\n" +
                        "\n" +
                        "<RequestorRef>"+Constants.API_KEY+"</RequestorRef>\n" +
                        "\n" +
                        "</CheckStatusRequest>\n" +
                        Constants.SIRI_END_ENVELOPE, HTTP.UTF_8);

                se.setContentType("text/xml");
                httppost.setEntity(se);

                HttpResponse httpresponse = httpclient.execute(httppost);
                HttpEntity resEntity = httpresponse.getEntity();
                //tvData.setText(EntityUtils.toString(resEntity));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

}
