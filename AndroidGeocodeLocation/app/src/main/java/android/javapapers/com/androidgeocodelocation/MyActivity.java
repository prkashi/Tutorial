package android.javapapers.com.androidgeocodelocation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends Activity {
    String locationAddress;
    Button btnGPSShowLocation;    Button btnShowAddress;    TextView tvAddress;


    Button mother;
    Button sister;
    Button wife;

    AppLocationService appLocationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        appLocationService = new AppLocationService(
                MyActivity.this);
        btnShowAddress = (Button) findViewById(R.id.father);
        mother = (Button) findViewById(R.id.mother) ;
        sister = (Button) findViewById(R.id.sister) ;
        wife = (Button) findViewById(R.id.wife) ;
        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Location location = appLocationService
                        .getLocation(LocationManager.GPS_PROVIDER);

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
                //double latitude = 37.422005;
                //double longitude = -122.084095

                if (location != null) {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();
                    LocationAddress locationAddress = new LocationAddress();
                    locationAddress.getAddressFromLocation(latitude, longitude,
                            getApplicationContext(), new GeocoderHandler());

                } else {
                    showSettingsAlert();
                }

            }
        }
 );
        mother.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View arg0) {

                                                  Location location = appLocationService
                                                          .getLocation(LocationManager.GPS_PROVIDER);

                                                  //you can hard-code the lat & long if you have issues with getting it
                                                  //remove the below if-condition and use the following couple of lines
                                                  //double latitude = 37.422005;
                                                  //double longitude = -122.084095

                                                  if (location != null) {
                                                      double latitude = location.getLatitude();
                                                      double longitude = location.getLongitude();
                                                      LocationAddress locationAddress = new LocationAddress();
                                                      locationAddress.getAddressFromLocation(latitude, longitude,
                                                              getApplicationContext(), new GeocoderHandler());

                                                  } else {
                                                      showSettingsAlert();
                                                  }

                                              }
                                          }
        );
        sister.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View arg0) {

                                                  Location location = appLocationService
                                                          .getLocation(LocationManager.GPS_PROVIDER);

                                                  //you can hard-code the lat & long if you have issues with getting it
                                                  //remove the below if-condition and use the following couple of lines
                                                  //double latitude = 37.422005;
                                                  //double longitude = -122.084095

                                                  if (location != null) {
                                                      double latitude = location.getLatitude();
                                                      double longitude = location.getLongitude();
                                                      LocationAddress locationAddress = new LocationAddress();
                                                      locationAddress.getAddressFromLocation(latitude, longitude,
                                                              getApplicationContext(), new GeocoderHandler());

                                                  } else {
                                                      showSettingsAlert();
                                                  }

                                              }
                                          }
        );
        wife.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View arg0) {

                                                  Location location = appLocationService
                                                          .getLocation(LocationManager.GPS_PROVIDER);

                                                  //you can hard-code the lat & long if you have issues with getting it
                                                  //remove the below if-condition and use the following couple of lines
                                                  //double latitude = 37.422005;
                                                  //double longitude = -122.084095

                                                  if (location != null) {
                                                      double latitude = location.getLatitude();
                                                      double longitude = location.getLongitude();
                                                      LocationAddress locationAddress = new LocationAddress();
                                                      locationAddress.getAddressFromLocation(latitude, longitude,
                                                              getApplicationContext(), new GeocoderHandler());

                                                  } else {
                                                      showSettingsAlert();
                                                  }

                                              }
                                          }
        );




    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                MyActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        MyActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {

            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            sendSMS(locationAddress);

        }
    }
    private void sendSMS(String locationAddress)
    {

        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
                new Intent(), 0);
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("8622948420", null, locationAddress, sentPI, null);
    }

}