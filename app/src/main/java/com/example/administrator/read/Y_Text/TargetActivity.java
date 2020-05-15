package com.example.administrator.read.Y_Text;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.administrator.read.R;
import com.example.administrator.read.Y_BGM.Music1;
import com.example.administrator.read.Y_Log.Login;
import com.example.administrator.read.Y_Utils.XTextView;


public class TargetActivity extends AppCompatActivity {

    private XTextView xtv;
    Button newone,oldone;
    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ab_target);
        initSound();

        xtv = (XTextView) findViewById(R.id.xtv);
        Intent intent1;
        intent1 = new Intent(TargetActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);

        String s =
                "嗯？\n" +
                "hi，欢迎来到YOYO\n" +
                "那么你是？\n" ;
        newone = findViewById(R.id.ch2);
        oldone =findViewById(R.id.ch1);
        newone.setOnClickListener(new View.OnClickListener(){
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public  void onClick(View v){playSound();
                Intent intent = new Intent();
                intent.putExtra("alignment","t1");
                intent.setClass(TargetActivity.this, Show.class);
                startActivity(intent);
                TargetActivity.this.finish();
            }
        });
        oldone.setOnClickListener(new View.OnClickListener() {//注册监听
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public void onClick(View v) {playSound();
                //通过AsyncTask类提交数据 异步显示
                Intent intent = new Intent();
                intent.setClass(TargetActivity.this, Login.class);
                startActivity(intent);
                TargetActivity.this.finish();
            }
        });
        xtv.setTextContent(s);
        xtv.setDelayPlayTime(200);
        xtv.setTextAlignment("normal");

    }

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.click1, 1);
    }
    private void playSound() {
        soundPool.play(
                soundID,
                0.1f, //左耳道音量【0~1】
                0.5f, //右耳道音量【0~1】
                0, //播放优先级【0表示最低优先级】
                0, //循环模式【0表示循环一次，-1表示一直循环，其他表示数字+1表示当前数字对应的循环次数】
                1 //播放速度【1是正常，范围从0~2】
        );
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("提示：");
            builder.setMessage("您确定退出？");

            //设置确定按钮
            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            //设置取消按钮
            builder.setPositiveButton("容我再想想",null);
            //显示提示框
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }

}
