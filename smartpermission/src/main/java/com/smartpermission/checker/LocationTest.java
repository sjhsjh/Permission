package com.smartpermission.checker;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;

import java.util.List;

class LocationTest implements PermissionTest {
    private LocationManager mManager;

    private static class MLocationListener implements LocationListener {
        private LocationManager mManager;

        public MLocationListener(LocationManager manager) {
            this.mManager = manager;
        }

        public void onLocationChanged(Location location) {
            this.mManager.removeUpdates(this);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            this.mManager.removeUpdates(this);
        }

        public void onProviderEnabled(String provider) {
            this.mManager.removeUpdates(this);
        }

        public void onProviderDisabled(String provider) {
            this.mManager.removeUpdates(this);
        }
    }

    LocationTest(Context context) {
        this.mManager = (LocationManager) context.getSystemService("location");
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"})
    public boolean test() throws Throwable {
        List<String> list = this.mManager.getProviders(true);
        if (!(list.contains("gps") || list.contains("network"))) {
            this.mManager.requestLocationUpdates("gps", 0, 0.0f, new MLocationListener(this.mManager));
        }
        return true;
    }
}
