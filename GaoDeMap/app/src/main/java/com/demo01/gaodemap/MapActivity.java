package com.demo01.gaodemap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;

public class MapActivity extends AppCompatActivity {
    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map = (MapView) findViewById(R.id.map);

        //找到地图控件
        map.onCreate(savedInstanceState);
        // 此方法必须重写
        AMap aMap = map.getMap();
        //得到一个map对象

        LatLng latLng = new LatLng(39.914150,116.26);
        final Marker marker = aMap.addMarker(new MarkerOptions().position(latLng).title("北京").snippet("DefaultMarker"));

    }
}
