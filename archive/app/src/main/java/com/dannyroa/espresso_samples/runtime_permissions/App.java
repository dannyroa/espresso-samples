package com.dannyroa.espresso_samples.runtime_permissions;

import android.app.Application;

/**
 * Created by dannyroa on 11/28/15.
 */
public class App extends Application {

    private static PermissionsModule permissionsModule;
    private static App instance;


    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
        setPermissionsModule(new DefaultPermissionsModule());
    }

    static void setInstance(App app) {
        instance = app;
    }

    public static App getInstance() {
        return instance;
    }

    public static PermissionsModule getPermissionsModule() {
        return permissionsModule;
    }

    public static void setPermissionsModule(PermissionsModule permissionsModule) {
        App.permissionsModule = permissionsModule;
    }
}
