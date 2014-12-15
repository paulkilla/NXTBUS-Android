package au.com.pazzul.nxtbus;

import android.app.Activity;
import android.os.Bundle;
import edu.usf.cutr.siri.android.client.SiriRestClient;
import edu.usf.cutr.siri.android.client.config.SiriRestClientConfig;
import uk.org.siri.siri.Siri;

public class NxtBusActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Client object from this library that will make the request to the server
        SiriRestClient client;

// Setup server config
        SiriRestClientConfig config = new SiriRestClientConfig(SiriRestClientConfig.RESPONSE_TYPE_JSON);  //Request JSON response
        config.setHttpConnectionType(SiriRestClientConfig.HTTP_CONNECTION_TYPE_ANDROID);  //Request using Android HTTP connection object
        config.setJacksonObjectType(SiriRestClientConfig.JACKSON_OBJECT_TYPE_READER);  //Request using the Jackson ObjectReader, which is more efficient than ObjectMapper

// Instantiate client with URLs for server and config
        //http://siri.nxtbus.act.gov.au:11000/requestorcode/sm/status.xml
        client = new SiriRestClient(
                "http://siri.nxtbus.act.gov.au:11000/B5233/vm/status.xml",
                "http://siri.nxtbus.act.gov.au:11000/api/siri/stop-monitoring", config);

        //Get the parameters that will be used to make the request - fill in these with your own info
        String key = getDeveloperKey(); //Get the developer API key to use, perhaps from a config file
        String operatorRef = getOperatorRef();  //Get the operator we're requesting info for
        String monitoringRef = getStopId();  //Get the stop ID we're requesting info for, perhaps from UI field
        String lineRef = getRouteId();  //Get the route ID filter, perhaps from UI field
        int directionRefInt = getDirectionInt(); //Route direction filter (0 or 1)
        String stopMonitoringDetailLevel = "normal";  //Get arrivals up to the specified stop ID (not after)
        int maximumNumberOfCallsOnwardsInt = 3; //Get next 3 arrivals at this stop

//Make request to the server, and get response data in a SIRI object
        Siri siri = client.makeStopMonRequest(key,
                operatorRef,
                monitoringRef,
                lineRef,
                directionRefInt,
                stopMonitoringDetailLevel,
                maximumNumberOfCallsOnwardsInt);
        System.out.println("Test");

    }
}
