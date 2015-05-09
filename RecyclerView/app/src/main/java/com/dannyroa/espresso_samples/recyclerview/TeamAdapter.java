package com.dannyroa.espresso_samples.recyclerview;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

/**
 * Created by dannyroa on 5/8/15.
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder>  {

    List<Team> items;
    Context context;

    public TeamAdapter(Context context, List<Team> items) {
        this.items = items;
        this.context = context;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.list_item_team, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = items.get(position);
        holder.setTeam(team);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        TextView tvName;
        Button btnFollow;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.name);
            btnFollow = (Button) itemView.findViewById(R.id.follow_button);
        }


        public void setTeam(final Team team) {

            tvName.setText(team.getName());

            if (team.isFollowing()) {
                btnFollow.setText(context.getString(R.string.following));
            } else {
                btnFollow.setText(context.getString(R.string.follow));
            }

            btnFollow.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    team.setIsFollowing(!team.isFollowing());
                    if (team.isFollowing()) {
                        btnFollow.setText(context.getString(R.string.following));
                    } else {
                        btnFollow.setText(context.getString(R.string.follow));
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {

                    ViewTeamActivity.launch((Activity) context, team);
                }
            });

        }
    }
}
