package com.example.administrator.read.Y_QA;

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


public class QuestionActivity extends AppCompatActivity {
    private XTextView xtv;
    Button Button1,Button2,Button3,back;
    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ab_question);

        initSound();
        xtv = (XTextView) findViewById(R.id.xtv);
//        String alignment = getIntent().getStringExtra("alignment");
//        if(alignment.equals("t1")){
//            testOne();
//        }else if(alignment.equals("t2")){
            testTwo();
//        }
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

    @SuppressLint("NewApi")
    private void initSound() {
        soundPool =new SoundPool.Builder().build();
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



    private void testTwo() {
        String s =
                "此时此刻，在以下几个场景中，你会想要\n" ;
        Intent intent1;
        intent1 = new Intent( QuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setTextContent(s);
        xtv.setDelayPlayTime(200);
        xtv.setTextAlignment("normal");
        Button1 = findViewById(R.id.ch1);
        Button1.setText("在繁华的城市中穿行");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                Intent intent = new Intent();
                intent.putExtra("alignment","t1");
                System.out.println("success");
                intent.setClass(QuestionActivity.this, MainQuestionActivity.class);
                startActivity(intent);
                QuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("在幽静的森林中徜徉");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                Intent intent = new Intent();
                intent.putExtra("alignment","t1");
                intent.setClass(QuestionActivity.this, MainQuestionActivity.class);
                startActivity(intent);
                QuestionActivity.this.finish();
            }
        });
        Button3 = findViewById(R.id.ch3);
        Button3.setText("在静谧的湖泊边漫步");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                Intent intent = new Intent();
                intent.putExtra("alignment","t1");
                intent.setClass(QuestionActivity.this, MainQuestionActivity.class);
                startActivity(intent);
                QuestionActivity.this.finish();
            }
        });
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {//返回菜单或者重新开始做题
            @Override
            public void onClick(View v) {playSound();
                dialog.setTitle("返回");
                dialog.setMessage("是否要返回主菜单");
                dialog.setNegativeButton("确定", new QuestionActivity.backClick());
                dialog.setPositiveButton("取消", new QuestionActivity.noClick());
                dialog.create();
                dialog.show();

            }
        });
    }

    class noClick implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();

        }
    }
    class backClick implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent();
            intent.putExtra("alignment","t1");
            intent.setClass(QuestionActivity.this, QuestionActivity.class);
            startActivity(intent);
            QuestionActivity.this.finish();

        }
    }
    class okClick implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Intent intent = new Intent();
            intent.setClass(QuestionActivity.this, Login.class);
            startActivity(intent);
            QuestionActivity.this.finish();

        }
    }

}
