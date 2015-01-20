package com.example.gun.toto;

import android.net.Uri;

import java.net.URI;

/**
 * Created by Honeys on 2015-01-20.
 */
public class BaseUriBuilder {
    /* TODO API 주소 :http(s)://api.sportsdatallc.org/soccer- Trial v3/eu/schema/matches-boxscore.xsd?api_key=hve64x7hegks6j6jgw5fx7jr"
       TODO API key : hve64x7hegks6j6jgw5fx7jr
       sport api 사이트에서 soccer api 중에 Daily Boxscore 라는 부분의 API주소를 긁었으며
       이 API 주소를 통해 매일 축구경기의 스코어를 보여주고 업데이트 해주며 경기분석을 해주는 앱 */

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
