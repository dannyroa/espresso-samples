//package com.dannyroa.espresso_samples.recyclerview;
//
//import androidx.test.platform.app.InstrumentationRegistry;
//import android.test.ActivityInstrumentationTestCase2;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import static com.dannyroa.espresso_samples.recyclerview.TestUtils.withRecyclerView;
//
///**
// * Created by dannyroa on 5/8/15.
// */
//
//public class RecyclerViewTest extends ActivityInstrumentationTestCase2<MainActivity> {
//
//    public RecyclerViewTest() {
//        super(MainActivity.class);
//    }
//
//    @Override protected void setUp() throws Exception {
//
//        getActivity();
//    }
//
//    public void testItemClick() {
//
//        onView(withRecyclerView(R.id.recycler_view).atPosition(1)).perform(click());
//
//        onView(withId(R.id.team_name)).check(matches(isDisplayed()));
//
//    }
//
//    public void testFollowButtonClick() {
//
//        onView(withId(R.id.recycler_view)).perform(TestUtils.actionOnItemViewAtPosition(1,
//                                                                                        R.id.follow_button,
//                                                                                        click()));
//        String followingText =
//            InstrumentationRegistry.getTargetContext().getString(R.string.following);
//
//        onView(withRecyclerView(R.id.recycler_view).atPositionOnView(1, R.id.follow_button)).check(matches(withText(followingText)));
//
//    }
//
//}
