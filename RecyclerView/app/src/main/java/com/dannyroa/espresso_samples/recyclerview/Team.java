package com.dannyroa.espresso_samples.recyclerview;

/**
 * Created by dannyroa on 5/8/15.
 */
public class Team {

    private String name;
    private boolean isFollowing;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollowing() {
        return isFollowing;
    }

    public void setIsFollowing(boolean isFollowing) {
        this.isFollowing = isFollowing;
    }
}
