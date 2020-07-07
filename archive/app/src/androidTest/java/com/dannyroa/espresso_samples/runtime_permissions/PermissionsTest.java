package com.dannyroa.espresso_samples.runtime_permissions;

/**
 * Created by dannyroa on 11/28/15.
 */

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 23)
public class PermissionsTest {

    private static final String APP_PACKAGE_NAME = "com.dannyroa.espresso_samples.runtime_permissions";
    private static final String INSTALLER_PACKAGE_NAME = "com.android.packageinstaller";

    private UiDevice device;


    private static final int LAUNCH_TIMEOUT = 5000;

    Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        MatcherAssert.assertThat(launcherPackage, IsNull.notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                                     .getLaunchIntentForPackage(APP_PACKAGE_NAME);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(APP_PACKAGE_NAME).depth(0)), LAUNCH_TIMEOUT);
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    @Test
    public void grantLocationPermission() {

        App.setPermissionsModule(new DefaultPermissionsModule());

        device.findObject(By.res(APP_PACKAGE_NAME, "btnRequestLocationPermission")).click();

        UiObject2 btnAllow = device.wait(Until.findObject(By.res(INSTALLER_PACKAGE_NAME, "permission_allow_button")),
                                         500);

        MatcherAssert.assertThat(btnAllow.isEnabled(), Is.is(true));

        btnAllow.click();

        UiObject2 tvLocationPermissionGranted = device.wait(Until.findObject(By.res(APP_PACKAGE_NAME,
                                                                      "tvLocationPermissionGranted")), 10000);

        MatcherAssert.assertThat(tvLocationPermissionGranted, IsNull.notNullValue());

    }
}
