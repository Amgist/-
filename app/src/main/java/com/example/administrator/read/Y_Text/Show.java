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
import com.example.administrator.read.Y_Log.RegisterActivity;
import com.example.administrator.read.Y_QA.QuestionActivity;
import com.example.administrator.read.Y_Utils.XTextView;


public class Show extends AppCompatActivity {

    private XTextView xtv;
    Button okay;
    Button back;
    private Intent intent;
    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ab_show);

        xtv = (XTextView) findViewById(R.id.xtv);
        initSound();

       String alignment = getIntent().getStringExtra("alignment");
        if(alignment.equals("t1")){
            testOne();//新用户p1
        }else if(alignment.equals("t2")){
            testTwo();//注册完成后
        }else if(alignment.equals("t3")){
            testThree();//个人信息界面
        }

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
    private void testOne() {
        Intent intent1;
        intent1 = new Intent(Show.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        
        String s =
                " 新用户吗\n" +
                " 那现在需要你去注册一个账号以便你使用我们的APP\n" ;
         
        okay = findViewById(R.id.ch1);
        okay.setOnClickListener(new View.OnClickListener(){
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public  void onClick(View v){playSound();
                Intent intent = new Intent();
                intent.setClass(Show.this, RegisterActivity.class);
                startActivity(intent);
                Show.this.finish();
            }

        });
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Show.this, TargetActivity.class);
                startActivity(intent);
                Show.this.finish();
            }
        });
        xtv.setTextContent(s);
        xtv.setDelayPlayTime(200);
        xtv.setTextAlignment("normal");
    }
    private void testTwo() {
        String s =
                "恭喜你，注册成功\n" +
                "感谢你选择我们的APP\n" +
                "希望我们的APP能够帮助迷茫的你做好选择\n" +
                "接下来需要你输入刚刚注册的用户名跟密码进行登录\n" ;
         
        Intent intent1;
        intent1 = new Intent(Show.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        okay = findViewById(R.id.ch1);

        okay.setOnClickListener(new View.OnClickListener(){
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public  void onClick(View v){playSound();
                Intent intent = new Intent();
                intent.setClass(Show.this, Login.class);
                startActivity(intent);
                Show.this.finish();
            }
        });
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {playSound();
                                        Intent intent = new Intent();
                                        intent.setClass(Show.this,RegisterActivity.class);
                                        startActivity(intent);
                                        Show.this.finish();
                                    }
                                });
        xtv.setTextContent(s);
        xtv.setDelayPlayTime(200);
        xtv.setTextAlignment("normal");

    }

    private void testThree() {//查看个人信息界面
        String s =
                "您还未使用过我们的推荐功能哦\n" +
                "系统无法给出您的个人信息\n" +
                "希望我们的APP能够帮助迷茫的你做好选择\n" ;
        Intent intent1;
        intent1 = new Intent(Show.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        okay = findViewById(R.id.ch1);
        okay.setText("返回主界面");
        okay.setOnClickListener(new View.OnClickListener(){
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public  void onClick(View v){playSound();
                Intent intent = new Intent();
                intent.putExtra("alignment","t1");
                intent.setClass(Show.this, QuestionActivity.class);
                startActivity(intent);
                Show.this.finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {playSound();
                Intent intent = new Intent();
                intent.setClass(Show.this, TargetActivity.class);
                startActivity(intent);
                Show.this.finish();
            }
        });
        xtv.setTextContent(s);
        xtv.setDelayPlayTime(200);
        xtv.setTextAlignment("normal");

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
