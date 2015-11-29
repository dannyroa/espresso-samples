package com.dannyroa.espresso_samples.runtime_permissions;

import android.app.Activity;
import android.content.Context;

/**
 * Created by dannyroa on 11/28/15.
 */
public interface PermissionsModule {
    boolean isLocationGranted(Context context);

    boolean shouldShowLocationPermissionRationale(Activity activity);

    void requestLocationPermission(Activity activity, int requestCode);
}