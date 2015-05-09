package com.dannyroa.espresso_samples.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by dannyroa on 5/8/15.
 */
public class ViewTeamActivity extends ActionBarActivity {

    private static final String EXTRA_TEAM_NAME = "extra_team_name";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_team);

        TextView tvName = (TextView) findViewById(R.id.team_name);
        tvName.setText(getIntent().getStringExtra(EXTRA_TEAM_NAME));
    }

    public static void launch(Activity activity, Team team) {

        Intent intent = new Intent(activity, ViewTeamActivity.class);
        intent.putExtra(EXTRA_TEAM_NAME, team.getName());
        activity.startActivity(intent);
    }
}
