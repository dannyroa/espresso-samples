package com.dannyroa.espresso_samples.recyclerview;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    RecyclerView rvTeams;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTeams = (RecyclerView) findViewById(R.id.recycler_view);

        List<Team> teams = new ArrayList<>();
        teams.add(new Team("USA"));
        teams.add(new Team("Belgium"));
        teams.add(new Team("Germany"));
        teams.add(new Team("Philippines"));
        teams.add(new Team("Australia"));
        teams.add(new Team("Costa Rica"));
        teams.add(new Team("Mexico"));
        teams.add(new Team("Korea"));
        teams.add(new Team("Brazil"));
        teams.add(new Team("Chile"));
        teams.add(new Team("Uruguay"));
        teams.add(new Team("Colombia"));

        TeamAdapter adapter = new TeamAdapter(MainActivity.this, teams);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvTeams.setLayoutManager(layoutManager);
        rvTeams.setAdapter(adapter);
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
