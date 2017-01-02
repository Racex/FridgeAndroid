package com.example.cos.androidfridge;

import android.Manifest;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class SHIT extends AppCompatActivity implements View.OnClickListener {
    private static final int PERMISSION_REQUEST_COARSE_LOCATION = 1;
    WifiManager wifi;
    ListView lv;
    TextView textStatus;
    Button buttonScan;
    int size = 0;
    List<ScanResult> results;

    String ITEM_KEY = "key";
    ArrayList<HashMap<String, String>> arraylist = new ArrayList<HashMap<String, String>>();
    private ListView list;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_main);
        list = (ListView) findViewById(R.id.listView);
        wifi = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);
        buttonScan = (Button) this.findViewById(R.id.buttonScan);
        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(wifi.isWifiEnabled())
                {
                    List<ScanResult> maciek = wifi.getScanResults();
                    ArrayList<String> newmaciek = new ArrayList<>();
                    Log.d("petla", "Rozmiar ScanResult" + String.valueOf(maciek.size()));
                    for (ScanResult x : maciek) {
                        newmaciek.add(x.SSID);
                        Log.d("petla", "onCreate: " + x.SSID);
                    }
                }
                else
                    wifi.setWifiEnabled(true);
            }
        });
        if(wifi.isWifiEnabled()) {
            list = (ListView) findViewById(R.id.listView);

            String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};

            //ArrayList<String> carL = getNetworkName();
            //   carL.addAll(getNetworkName());


            List<ScanResult> maciek = wifi.getScanResults();
            ArrayList<String> newmaciek = new ArrayList<>();
            Log.d("petla", "Rozmiar ScanResult" + String.valueOf(maciek.size()));
            for (ScanResult x : maciek) {
                newmaciek.add(x.SSID);
                Log.d("petla", "onCreate: " + x.SSID);
            }
            Log.d("klucz", String.valueOf(wifi.getConnectionInfo().getSSID()) + String.valueOf(wifi.getConnectionInfo()));


            adapter = new ArrayAdapter<String>(this, R.layout.row, newmaciek);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                    Log.d("naciśnięty item XD", String.valueOf(position));
                    Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT);
//                Intent n = new Intent(getApplicationContext(), yourclass.class);
//                n.putExtra("position", position);
//                startActivity(n);
                }
            });
        }
        //final Handler handler = new Handler();

//        Runnable wifiRunnable = new Runnable() {
//            @Override
//            public void run() {
//                List<ScanResult> results = wifi.getScanResults();
//                if (results == null) {
//
//                    handler.postDelayed(this, 3000);
//                    return;
//                }
//
//                handler.removeCallbacks(this);
//
//                if(results.size() > 0) {
//                    Toast.makeText(getApplicationContext(), "Networks available!", Toast.LENGTH_LONG).show();
//                Log.d("Siec" , String.valueOf(results.size()));
//                }
//            }
//        };
//        wifiRunnable.run();
    }
    














//    public void onReceive(final Context context, final Intent intent) {
//
//        if(intent.getAction().equals(WifiManager.NETWORK_STATE_CHANGED_ACTION)) {
//            NetworkInfo networkInfo =
//                    intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
//            if(networkInfo.isConnected()) {
//                // Wifi is connected
//                Log.d("Inetify", "Wifi is connected: " + String.valueOf(networkInfo));
//            }
//        } else if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
//            NetworkInfo networkInfo =
//                    intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
//            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI &&
//                    ! networkInfo.isConnected()) {
//                // Wifi is disconnected
//                Log.d("Inetify", "Wifi is disconnected: " + String.valueOf(networkInfo));
//            }
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


//    public ArrayList<String> getNetworkName() {
//        ArrayList<String> tempNetworkName = new ArrayList<String>();
//        buttonScan = (Button) findViewById(R.id.buttonScan);
//        tempNetworkName.add("duaop");
//        tempNetworkName.add("dupson");
//        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        if (wifi.isWifiEnabled() == false) {
//            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
//            wifi.setWifiEnabled(true);
//        }
//        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        registerReceiver(mWifiScanReceiver,
//                new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//        wifi.startScan();
//
//        for (ScanResult x : results) {
//            tempNetworkName.add(x.BSSID.toString());
//        }


//  buttonScan.setOnClickListener(this);
//        lv = (ListView)findViewById(R.id.listView1);
//
//        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        if (wifi.isWifiEnabled() == false)
//        {
//            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled", Toast.LENGTH_LONG).show();
//            wifi.setWifiEnabled(true);
//        }
//        //this.adapter = new SimpleAdapter(SHIT.this, arraylist, R.layout.row, new String[] { ITEM_KEY }, new int[] { R.id.RowTekst});
//        lv.setAdapter(this.adapter);
//
//        registerReceiver(new BroadcastReceiver()
//        {
//            @Override
//            public void onReceive(Context c, Intent intent)
//            {
//                results = wifi.getScanResults();
//                size = results.size();
//            }
//        }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));


//
//
//
//
//        arraylist.clear();
//        wifi.startScan();
//
//        //Toast.makeText(this, "Scanning...." + size, Toast.LENGTH_SHORT).show();
//        try
//        {
//            size = size - 1;
//            while (size >= 0)
//            {
//                HashMap<String, String> item = new HashMap<String, String>();
//                item.put(ITEM_KEY, results.get(size).SSID + "  " + results.get(size).capabilities);
//          //      Toast.makeText(SHIT.this, results.get(size).SSID + "  " + results.get(size).capabilities , Toast.LENGTH_LONG);
//                arraylist.add(item);
//                size--;
//                adapter.notifyDataSetChanged();
//            }
//        }
//        catch (Exception e)
//        { }
//        return tempNetworkName;
//    }

    private final BroadcastReceiver mWifiScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent intent) {
            if (intent.getAction().equals(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)) {
                results = wifi.getScanResults();
                for(ScanResult x : wifi.getScanResults())
                Log.d("klucz", x.BSSID + " SSID " + x.SSID);
            }
        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

       String wazne = "Maciek dokończ  inzyniera masz na to tydzien !!! powodzemia :0";
        Toast.makeText(getBaseContext() , wazne , Toast.LENGTH_LONG);

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case PERMISSION_REQUEST_COARSE_LOCATION: {
//                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    Log.d("dupa", "coarse location permission granted");
//                } else {
//                    final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//                    builder.setTitle("Functionality limited");
//                    builder.setMessage("Since location access has not been granted, this app will not be able to discover beacons when in the background.");
//                    builder.setPositiveButton(android.R.string.ok, null);
//                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//
//                        @Override
//                        public void onDismiss(DialogInterface dialog) {
//                        }
//
//                    });
//                    builder.show();
//                }
//                return;
//            }
//        }
//    }

}
