package au.com.pazzul.nxtbus;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
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

public class NxtBusActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

//Make request to the server, and get response data in a SIRI object
        try {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://siri.nxtbus.act.gov.au:11000/B5233/vm/status.xml");

            try {
                StringEntity se = new StringEntity( "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>\n" +
                        "\n" +
                        "<Siri version=\"2.0\" xmlns:ns2=\"http://www.ifopt.org.uk/acsb\" xmlns=\"http://www.sir\n" +
                        "\n" +
                        "i.org.uk/siri\" xmlns:ns4=\"http://datex2.eu/schema/2_0RC1/2_0\" xmlns:ns3=\"http://ww\n" +
                        "\n" +
                        "w.ifopt.org.uk/ifopt\">\n" +
                        "\n" +
                        "<CheckStatusRequest>\n" +
                        "\n" +
                        "<RequestTimestamp>2013-12-29T14:09:41.000+01:00</RequestTimestamp>\n" +
                        "\n" +
                        "<RequestorRef>B5233</RequestorRef>\n" +
                        "\n" +
                        "</CheckStatusRequest>\n" +
                        "\n" +
                        "</Siri>", HTTP.UTF_8);

                se.setContentType("text/xml");
                httppost.setEntity(se);

                HttpResponse httpresponse = httpclient.execute(httppost);
                HttpEntity resEntity = httpresponse.getEntity();
                //tvData.setText(EntityUtils.toString(resEntity));
                String entity = EntityUtils.toString(resEntity);

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


    }

    private String getDeveloperKey() {
        return "B5233";
    }

    public String getOperatorRef() {
        return "ACT";
    }

    public String getStopId() {
        return "0200";
    }

    public String getRouteId() {
        return "200";
    }

    public int getDirectionInt() {
        return 0;
    }
}
