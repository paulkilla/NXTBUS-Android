package au.com.pazzul.nxtbus;

import android.app.Activity;
import android.os.Bundle;

public class NxtBusActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new StatusCheck().execute();
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
