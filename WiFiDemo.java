//package com.example.cos.androidfridge;
//
//import android.app.Activity;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.IntentFilter;
//import android.content.pm.PackageManager;
//import android.net.wifi.ScanResult;
//import android.net.wifi.WifiManager;
//import android.os.Bundle;
//import android.os.Handler;
//import android.support.v7.app.AlertDialog;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class WiFiDemo extends Activity {
//
//    private static final int PERMISSION_REQUEST_COARSE_LOCATION = ;
//    List<ScanResult> wifiList;
//    WifiManager mainWifi;
//    WifiReceiver receiverWifi;
//    Button button;
//    StringBuilder sb = new StringBuilder();
//
//    private final Handler handler = new Handler();
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//
//        receiverWifi = new WifiReceiver();
//        registerReceiver(receiverWifi, new IntentFilter(
//                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//        if(mainWifi.isWifiEnabled()==false)
//        {
//            mainWifi.setWifiEnabled(true);
//        }
//
//
//        doInback();
//        button = (Button) findViewById(R.id.buttonScan);
//    }
//
//    public void doInback()
//    {
//        handler.postDelayed(new Runnable() {
//
//            @Override
//            public void run()
//            {
//                // TODO Auto-generated method stub
//                mainWifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//
//                receiverWifi = new WifiReceiver();
//                registerReceiver(receiverWifi, new IntentFilter(
//                        WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//                mainWifi.startScan();
//                doInback();
//            }
//        }, 1000);
//
//    }
//
//    public void onClick(View view)
//    {   String temp = "dupa";
//
//        for(ScanResult x : wifiList)
//        {
//        temp +=x.SSID;
//
//        }
//        Toast.makeText(WiFiDemo.this, temp, Toast.LENGTH_LONG);
//
//
//    }
//
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add(0, 0, 0, "Refresh");
//        return super.onCreateOptionsMenu(menu);}
//    public boolean onMenuItemSelected(int featureId, MenuItem item) {
//        mainWifi.startScan();
//
//        return super.onMenuItemSelected(featureId, item);}
//
//
//    @Override
//    protected void onPause()
//    {
//        unregisterReceiver(receiverWifi);
//        super.onPause();
//    }
//
//    @Override
//    protected void onResume()
//    {
//        registerReceiver(receiverWifi, new IntentFilter(
//                WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
//        super.onResume();
//    }
//
//    class WifiReceiver extends BroadcastReceiver
//    {
//        public void onReceive(Context c, Intent intent)
//        {
//
//            ArrayList<String> connections=new ArrayList<String>();
//            ArrayList<Float> Signal_Strenth= new ArrayList<Float>();
//
//            sb = new StringBuilder();
//
//            wifiList = mainWifi.getScanResults();
//          //  Toast.makeText(WiFiDemo.this, (String) mainWifi.getScanResults(), Toast.LENGTH_LONG);
//            for(int i = 0; i < wifiList.size(); i++)
//            {
//
//                connections.add(wifiList.get(i).SSID);
//            }
//
//
//        }
//    }
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
//
//
//
//}