package com.example.cos.androidfridge;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cos.androidfridge.R;

import java.util.ArrayList;
import java.util.List;

//wybieranie sieci wifi
public class Step2 extends AppCompatActivity {

    private final static String TAG = "Step2";

    TextView txtWifiInfo;
    WifiManager wifi;
    WifiScanReceiver wifiReceiver;
    ProgressDialog progress;
    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        list = (ListView) findViewById(R.id.listView);
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiReceiver = new WifiScanReceiver();
        progress = new ProgressDialog(this);
        progress.setMessage("Wyszukuję listę dostępnych sieci :) ");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.show();
        txtWifiInfo = (TextView) findViewById(R.id.textWifi);
        Button btnScan = (Button) findViewById(R.id.buttonScan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Start scan...");
                wifi.startScan();
            }
        });
        btnScan.callOnClick();
    }

    protected void onPause() {
        unregisterReceiver(wifiReceiver);
        super.onPause();
    }

    protected void onResume() {
        registerReceiver(
                wifiReceiver,
                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        );
        super.onResume();
    }

    private class WifiScanReceiver extends BroadcastReceiver {
        public void onReceive(Context c, final Intent intent) {

            List<ScanResult> wifiScanList = wifi.getScanResults();
           final String [] newmaciek = new String[wifiScanList.size()];
            Log.d("petla", "Rozmiar ScanResult" + String.valueOf(wifiScanList.size()));
            int increment=0;
            for (ScanResult x : wifiScanList) {
                newmaciek [increment++] = x.SSID;
                Log.d("petla", "onCreate: " + x.SSID);
            }
            progress.cancel();
            adapter = new ArrayAdapter<String>(getBaseContext(), R.layout.row, newmaciek);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Log.d("naciśnięty item XD", String.valueOf(position));
                    Toast.makeText(getBaseContext(), String.valueOf(newmaciek[position]), Toast.LENGTH_LONG).show(); //TODO wykasować :D
                    Intent i = new Intent(getApplicationContext(), Step3.class);

                    i.putExtra(TAG+"Extras", String.valueOf(newmaciek[position]));
                    startActivity(i);
                    finish();
                    //String message = editText.getText().toString();
                    //intent.putExtra(EXTRA_MESSAGE, message);
//                Intent n = new Intent(getApplicationContext(), yourclass.class);
//                n.putExtra("position", position);
//                startActivity(n);
                }
            });

        }
    }
}