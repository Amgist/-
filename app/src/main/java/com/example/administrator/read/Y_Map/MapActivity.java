package com.example.administrator.read.Y_Map;

import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.example.administrator.read.MainActivity;
import com.example.administrator.read.R;


public class MapActivity extends AppCompatActivity {
    Button button,back;
    private EditText edittext;
    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID
    MapView mMapView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.ab_map);
        //获取地图控件引用

        mMapView = (MapView) findViewById(R.id.bmapView);
        setContentView(R.layout.ab_map);
        button = (Button) findViewById(R.id.enter);
        this.edittext = (EditText) findViewById(R.id.input);
        button.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {

               /* EditText province = (EditText) findViewById(R.id.input);

                Bundle bundle = new Bundle();//新建Bundle
                Province p = new Province(province.getText().toString());
                Bundle data = new Bundle();
                data.putSerializable("province",p);
                intent.putExtras(data);
                */
                Intent intent = new Intent();
                intent.setClass(MapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}
