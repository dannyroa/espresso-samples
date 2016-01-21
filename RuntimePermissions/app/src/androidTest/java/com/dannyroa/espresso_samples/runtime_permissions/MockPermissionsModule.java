package com.dannyroa.espresso_samples.runtime_permissions;

import android.app.Activity;
import android.content.Context;

/**
 * Created by dannyroa on 1/21/16.
 */
public class MockPermissionsModule implements PermissionsModule {

    private boolean locationGranted = false;

    @Override public boolean isLocationGranted(Context context) {
        return locationGranted;
    }

    @Override public boolean shouldShowLocationPermissionRationale(Activity activity) {
        return false;
    }

    @Override public void requestLocationPermission(Activity activity, int requestCode) {

    }

    public void setLocationGranted(boolean locationGranted) {
        this.locationGranted = locationGranted;
    }
}
