package com.dannyroa.espresso_samples.recyclerview;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.dannyroa.espresso_samples.recyclerview.TestUtils.withRecyclerView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewTest {

  @Rule
  public ActivityScenarioRule<MainActivity> activityScenarioRule
      = new ActivityScenarioRule<>(MainActivity.class);

  @Test
  public void itemClick() {

    onView(withRecyclerView(R.id.recycler_view).atPosition(1)).perform(click());

    onView(withId(R.id.team_name)).check(matches(isDisplayed()));

  }

  @Test
  public void followButton_Click() {
    onView(withId(R.id.recycler_view)).perform(TestUtils.actionOnItemViewAtPosition(1,
        R.id.follow_button, click()));
    String followingText = InstrumentationRegistry.getInstrumentation().getTargetContext()
        .getString(R.string.following);

    onView(withRecyclerView(R.id.recycler_view).atPositionOnView(1, R.id.follow_button))
        .check(matches(withText(followingText)));
  }
}