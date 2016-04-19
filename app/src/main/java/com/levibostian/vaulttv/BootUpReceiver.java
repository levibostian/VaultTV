package com.levibostian.vaulttv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public class BootUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if (info != null && info.isConnected()) {
            startApp(context);
        }
    }

    private void startApp(Context context) {
        Intent serviceIntent = new Intent(context, MainActivity.class);
        serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(serviceIntent);
    }

}