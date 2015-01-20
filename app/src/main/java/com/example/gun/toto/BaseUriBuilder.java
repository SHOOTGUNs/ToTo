package com.example.gun.toto;

import android.net.Uri;

import java.net.URI;

/**
 * Created by Honeys on 2015-01-20.
 */
public class BaseUriBuilder {
    // TODO


    private String regionStr = null;

    public BaseUriBuilder region(String regionStr) {

        this.regionStr = regionStr;
        return this;
    }

    public Uri.Builder getBuilder() {

        if (regionStr == null) {
            return null;
        }
        return Uri.parse(String.format(Config.API_Base_URL, regionStr, regionStr)).buildUpon();


    }
}
