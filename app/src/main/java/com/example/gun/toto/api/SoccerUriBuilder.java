package com.example.gun.toto.api;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by namhyun on 2015-01-20.
 */
public class SoccerUriBuilder extends BaseUriBuilder {
    private boolean requestSchedule = false;
    private boolean requestDailySchedule = false;
    private boolean requestDailyBoxScore = false;

    private String mYear = null;
    private String mMonth = null;
    private String mDay = null;

    private final String QUERY_TYPE = "soccer";
    private final String QUERY_BOXSCORE = "boxscore";
    private final String QUERY_REQUEST_TYPE = ".xml";

    @Deprecated
    public SoccerUriBuilder requestSchedule() {
        this.requestSchedule = true;
        return this;
    }

    @Deprecated
    public SoccerUriBuilder requestDailySchedule() {
        this.requestDailySchedule = true;
        return this;
    }

    public SoccerUriBuilder requestDailyBoxScore() {
        this.requestDailyBoxScore = true;
        return this;
    }

    @Override
    public SoccerUriBuilder leagueGroup(String leagueGroupStr) {
        super.leagueGroup(leagueGroupStr);
        return this;
    }

    @Override
    public SoccerUriBuilder version(String versionStr) {
        super.version(versionStr);
        return this;
    }

    @Override
    public SoccerUriBuilder accesslevel(String accessLevelStr) {
        super.accesslevel(accessLevelStr);
        return this;
    }

    public SoccerUriBuilder year(String mYear) {
        this.mYear = mYear;
        return this;
    }

    public SoccerUriBuilder month(String mMonth) {
        this.mMonth = mMonth;
        return this;
    }

    public SoccerUriBuilder day(String mDay) {
        this.mDay = mDay;
        return this;
    }

    @Override
    public Uri build() {
        Uri.Builder builder = getBuilder();
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    @Override
    public Uri.Builder getBuilder() {
        super.requestType(QUERY_TYPE);
        Uri.Builder builder = super.getBuilder();
        if (requestDailyBoxScore) {
            if(mYear == null && mMonth == null && mDay == null){
                return null;
            }
            builder.appendPath(mYear).appendPath(mMonth).appendPath(mDay)
                    .appendPath(QUERY_BOXSCORE + QUERY_REQUEST_TYPE);
        }
        builder.appendQueryParameter(Config.PARAM_API_KEY, Config.API_KEY);
        return builder;
    }

    @Override
    public URL getURL() throws MalformedURLException {
        Uri uri = build();
        if (uri == null) {
            return null;
        }
        return new URL(uri.toString());
    }
}
