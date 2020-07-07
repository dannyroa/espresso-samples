package com.dannyroa.espresso_samples.runtime_permissions;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  private static final int LOCATION_REQUEST_CODE = 101;

  TextView tvLocationPermissionGranted;
  Button btnRequestLocationPermission;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tvLocationPermissionGranted = (TextView) findViewById(R.id.tvLocationPermissionGranted);
    btnRequestLocationPermission = (Button) findViewById(R.id.btnRequestLocationPermission);

    updateUI();
  }

  void updateUI() {
    if (!App.getPermissionsModule().isLocationGranted(this)) {
      tvLocationPermissionGranted.setVisibility(View.GONE);
      btnRequestLocationPermission.setVisibility(View.VISIBLE);
      btnRequestLocationPermission.setOnClickListener(new RequestLocationButtonListener());
    } else {
      tvLocationPermissionGranted.setVisibility(View.VISIBLE);
      btnRequestLocationPermission.setVisibility(View.GONE);
      btnRequestLocationPermission.setOnClickListener(null);
    }
  }

  @Override
  public void onRequestPermissionsResult(
      int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    if (requestCode == LOCATION_REQUEST_CODE) {
      if (grantResults.length == 1) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          updateUI();
        }
      }
    }
  }

  class RequestLocationButtonListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {
      App.getPermissionsModule()
          .requestLocationPermission(MainActivity.this, LOCATION_REQUEST_CODE);
    }
  }
}
