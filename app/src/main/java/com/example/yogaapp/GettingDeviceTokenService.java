package com.example.yogaapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GettingDeviceTokenService extends Service {
    public GettingDeviceTokenService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}