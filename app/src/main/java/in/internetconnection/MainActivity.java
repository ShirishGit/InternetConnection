package in.internetconnection;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Button btnCheckSpeed, btnCheckConnection;
    TextView textSpeed, textStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckConnection = findViewById(R.id.button);
        btnCheckSpeed = findViewById(R.id.button2);
        textSpeed = findViewById(R.id.textView2);
        textStatus = findViewById(R.id.textView);

        btnCheckConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isConnected = Connectivity.isConnected(MainActivity.this);
                boolean isWiFi = Connectivity.isConnectedWifi(MainActivity.this);
                boolean isMobileData = Connectivity.isConnectedMobile(MainActivity.this);

                if (isConnected){
                    if (isWiFi){
                        textStatus.setText("Connected to WiFi.");
                    }else if (isMobileData)
                    {
                        textStatus.setText("Connected to Mobile data.");
                    }else {
                        textStatus.setText("Network not available");
                    }
                }
            }
        });

        btnCheckSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean speed = Connectivity.isConnectedFast(MainActivity.this);
                textSpeed.setText("Speed");
            }
        });

    }


}
