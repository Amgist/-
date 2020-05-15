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
import android.widget.TextView;

import com.example.administrator.read.R;
import com.example.administrator.read.Y_BGM.Music1;
import com.example.administrator.read.tongyong.internet;

import java.util.HashMap;
import java.util.Map;


public class MainQuestionActivity extends AppCompatActivity {
    private TextView xtv;
    Button Button1,Button2,Button3,back;
    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID
    Map<String, String> params = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ab_mainquestion);

        initSound();
        xtv = (TextView) findViewById(R.id.xtv);
        String alignment = getIntent().getStringExtra("alignment");
        if(alignment.equals("t1")){
            test1();
        }else if(alignment.equals("t2")){
        test2();
        }
        else if(alignment.equals("t2")){
            test3();
        }
        else if(alignment.equals("t2")){
            test4();
        }
        else if(alignment.equals("t2")){
            test5();
        }else if(alignment.equals("t2")){
            test6();
        }

        
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

    private void test1() {
        String s =
                "当你迷路的是时候你会更倾向于\n";
        Intent intent1;
        intent1 = new Intent(MainQuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setText(s);

        Button1 = findViewById(R.id.ch1);
        Button1.setText("自己查地图");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a1","1");
                test2();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                System.out.println("success");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("原路返回");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a1","3");
                test2();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button3 = findViewById(R.id.ch3);
        Button3.setText("问陌生人");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a1","5");
                test2();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });

    }
    private void test2() {
        String s =
                "对于新鲜事物，你的态度是\n";
        Intent intent1;
        intent1 = new Intent(MainQuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setText(s);

        Button1 = findViewById(R.id.ch1);
        Button1.setText("没有兴趣尝试");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a2","1");
                test3();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                System.out.println("success");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("不算喜欢，但也不讨厌");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a2","3");
                test3();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button3 = findViewById(R.id.ch3);
        Button3.setText("很乐于去尝试");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a2","5");
                test3();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
    }
    private void test3() {
        String s =
                "酸甜苦辣咸\n";
        Intent intent1;
        intent1 = new Intent(MainQuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setText(s);

        Button1 = findViewById(R.id.ch1);
        Button1.setText("甜");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a3","1");
                test4();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                System.out.println("success");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("辣");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a3","3");
                test4();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button3 = findViewById(R.id.ch3);
        Button3.setText("其他");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a3","5");
                test4();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
    }
    private void test4() {
        String s =
                "路过一家茶馆，毗邻着一家咖啡厅，你会去\n";
        Intent intent1;
        intent1 = new Intent(MainQuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setText(s);

        Button1 = findViewById(R.id.ch1);
        Button1.setText("茶馆");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a4","1");
                test5();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                System.out.println("success");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("都不去");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a4","3");
                test5();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button3 = findViewById(R.id.ch3);
        Button3.setText("咖啡厅");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a4","5");
                test5();

//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
    }
    private void test5() {
        String s =
                "你更喜欢\n";
        Intent intent1;
        intent1 = new Intent(MainQuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setText(s);

        Button1 = findViewById(R.id.ch1);
        Button1.setText("骄阳渲染下的晚霞");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a5","1");
                test6();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                System.out.println("success");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("干净清爽的蓝天");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a5","3");
                test6();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button3 = findViewById(R.id.ch3);
        Button3.setText("璀璨夺目的星空");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a5","5");
                test6();
//                Intent intent = new Intent();
//                intent.putExtra("alignment", "t1");
//                intent.setClass(MainQuestionActivity.this, MainQuestionActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
    }
    private void test6() {
        String s =
                "相比于躺在床上，你更希望\n";
        Intent intent1;
        intent1 = new Intent(MainQuestionActivity.this, Music1.class);
        String action = Music1.ACTION_MUSIC;
        // 设置action
        intent1.setAction(action);
        startService(intent1);
        xtv.setText(s);

        Button1 = findViewById(R.id.ch1);
        Button1.setText("到一个从来没有去过的地方欣赏风景");
        Button1.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a6","1");
                test7();
//                String result= internet.getsearchresult("http://120.26.179.238:8080/ccxx2/servlet/ComServlet",params);
//                Intent intent = new Intent();
//                intent.putExtra("result", result);
//                System.out.println("success");
//                intent.setClass(MainQuestionActivity.this, TuiActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });
        Button2 = findViewById(R.id.ch2);
        Button2.setText("还是躺在床上休息");
        Button2.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a6","3");
                test7();
//                String result= internet.getsearchresult("http://120.26.179.238:8080/ccxx2/servlet/ComServlet",params);
//                Intent intent = new Intent();
//                intent.putExtra("result", result);
//                intent.setClass(MainQuestionActivity.this, TuiActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });

        Button3.setText("在附件的商场购物");
        Button3.setOnClickListener(new View.OnClickListener() {//注册监听
            @Override //监听点击事件
            public void onClick(View v) {
                playSound();
                params.put("a6","5");
                test7();
//                String result= internet.getsearchresult("http://120.26.179.238:8080/ccxx2/servlet/ComServlet",params);
//                System.out.println(params);
//                System.out.println(result);
//                Intent intent = new Intent();
//                intent.putExtra("result", result);
//                intent.setClass(MainQuestionActivity.this, TuiActivity.class);
//                startActivity(intent);
//                MainQuestionActivity.this.finish();
            }
        });

  }
  private void test7(){
      new Thread() {
          @Override
          public void run() {
            String h=  "http://120.26.179.238:8080/ccxx2/servlet/ComServlet";
              String result = internet.getsearchresult(h, params);

              System.out.println(result);
              Intent intent = new Intent();
                intent.putExtra("result", result);
                intent.setClass(MainQuestionActivity.this, TuiActivity.class);
                startActivity(intent);
                MainQuestionActivity.this.finish();
              }


      }.start();
  }
    
}
