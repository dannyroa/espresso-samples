package com.dannyroa.espresso_samples.runtime_permissions;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by dannyroa on 11/28/15.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    MockPermissionsModule permissionsModule = new MockPermissionsModule();

    @Rule public TestName name = new TestName();

    Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }

    @Rule public ActivityTestRule<MainActivity> activityTestRule =
        new ActivityTestRule<>(MainActivity.class, true, false);

    @Before public void setUp() {
        App.setPermissionsModule(permissionsModule);
    }

    @Test
    public void shouldShowLocationGrantedText() {

        permissionsModule.setLocationGranted(true);

        Intent intent = new Intent(getContext(), MainActivity.class);
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.tvLocationPermissionGranted)).check(matches(withEffectiveVisibility(
            ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.btnRequestLocationPermission)).check(matches(withEffectiveVisibility(
            ViewMatchers.Visibility.GONE)));

    }

    @Test
    public void shouldShowRequestLocationButton() {

        permissionsModule.setLocationGranted(false);

        Intent intent = new Intent(getContext(), MainActivity.class);
        activityTestRule.launchActivity(intent);

        onView(withId(R.id.btnRequestLocationPermission)).check(matches(
            withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.tvLocationPermissionGranted)).check(matches(withEffectiveVisibility(
            ViewMatchers.Visibility.GONE)));

    }
}