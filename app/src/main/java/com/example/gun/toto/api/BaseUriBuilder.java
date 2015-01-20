package com.example.gun.toto.api;

import android.net.Uri;

import com.example.gun.toto.Config;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Honeys on 2015-01-20.
 */
public class BaseUriBuilder {
    private String requestType = null;
    private String accessLevelStr = null;
    private String versionStr = null;
    private String leagueGroupStr = null;

    public BaseUriBuilder requestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public BaseUriBuilder leagueGroup(String leagueGroupStr) {
        this.leagueGroupStr = leagueGroupStr;
        return this;
    }

    public BaseUriBuilder version(String versionStr) {
        this.versionStr = versionStr;
        return this;
    }

    public BaseUriBuilder accesslevel(String accessLevelStr) {
        this.accessLevelStr = accessLevelStr;
        return this;
    }

    public Uri build() {
        Uri.Builder builder = getBuilder();
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Uri.Builder getBuilder() {
        if (accessLevelStr == null && versionStr == null && leagueGroupStr == null) {
            return null;
        }
        return Uri.parse(String.format(
                Config.API_Base_URL, requestType, accessLevelStr, versionStr, leagueGroupStr)).buildUpon();
    }

    public URL getURL() throws MalformedURLException {
        Uri uri = build();
        if (uri == null) {
            return null;
        }
        return new URL(uri.toString());
    }
}
