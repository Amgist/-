package com.example.administrator.read.Y_Log;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.SoundPool;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.read.MainActivity;
import com.example.administrator.read.R;
import com.example.administrator.read.Y_Text.TargetActivity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    //private static final int REQUEST_CODE = 2;
    HttpPost httpRequest=new HttpPost(UriAPI.HTTPCustomer);
    TextView show_login;
    Button loginButton;
    EditText user;
    EditText pass;
    Button register;
    ProgressDialog progressDialog;
    private SoundPool soundPool;//声明一个SoundPool
    private int soundID;//创建某个声音对应的音频ID
    /** Called when the activity is first created. */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ab_longin);
        /*loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);*/
        loginButton = findViewById(R.id.button);
        register = findViewById(R.id.register);
        user =(EditText) findViewById(R.id.username);
        pass =(EditText) findViewById(R.id.password);
        show_login =(TextView) findViewById(R.id.show_login);
        initSound();

        progressDialog = new ProgressDialog(this);
        //注册按钮
        register.setOnClickListener(new View.OnClickListener() {//注册监听
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public void onClick(View v) {
                //通过AsyncTask类提交数据 异步显示
                Intent intent = new Intent();
                intent.setClass(Login.this, TargetActivity.class);
                startActivity(intent);
                Login.this.finish();
                        playSound();
            }
        });
        //登录按钮
        loginButton.setOnClickListener(new View.OnClickListener() {//注册监听
            @SuppressWarnings("unchecked")
            @Override //监听点击事件
            public void onClick(View v) {
                //通过AsyncTask类提交数据 异步显示
                new Login.AT().execute(user.getText().toString(),pass.getText().toString());
                        playSound();
            }
        });


    }
    @SuppressLint("NewApi")
    private void initSound() {
        soundPool = new SoundPool.Builder().build();
        soundID = soundPool.load(this, R.raw.click, 1);
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

    class noClick implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();

        }

    }
    public class UriAPI {
    /** 定义一个Uri **/
    public static final String HTTPCustomer ="http://120.26.179.238:8080/ccxx2/servlet/CustomerServlet";
}
@SuppressWarnings("rawtypes")
class AT extends AsyncTask {

    String result="";
    @Override
    protected void onPreExecute() {
        //加载progressDialog
        progressDialog.show();
    }

    @SuppressLint("WrongThread")
    @Override
    protected Object doInBackground(Object... params_obj) {
        CharSequence user_name="";
        CharSequence pass_word="";

        user_name = user.getText();

        pass_word = pass.getText();
        if(!user_name.equals("")&&!pass_word.equals("")){
            //请求数据
            HttpPost httpRequest  = new HttpPost(Login.UriAPI.HTTPCustomer);
            //创建参数
            List<NameValuePair> params=new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", user_name.toString()));
            params.add(new BasicNameValuePair("password", pass_word.toString()));
            //params.add(new BasicNameValuePair("flag","0"));
            try {
                //对提交数据进行编码
                httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                HttpResponse httpResponse=new DefaultHttpClient().execute(httpRequest);
                //获取响应服务器的数据
                if (httpResponse.getStatusLine().getStatusCode()==200) {
                    //利用字节数组流和包装的绑定数据
                    byte[] data =new byte[2048];
                    //先把从服务端来的数据转化成字节数组
                    data = EntityUtils. toByteArray((HttpEntity)httpResponse.getEntity());
                    //再创建字节数组输入流对象
                    ByteArrayInputStream bais = new ByteArrayInputStream(data);
                    //绑定字节流和数据包装流
                    DataInputStream dis = new DataInputStream(bais);
                    //将字节数组中的数据还原成原来的各种数据类型，代码如下：
                    result=new String(dis.readUTF());
                    Log.i("服务器返回信息:", result);
                }
            } catch(ClientProtocolException e){
                e.printStackTrace();
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    AlertDialog.Builder dialog = new AlertDialog.Builder(Login.this);
    @Override
    protected void onPostExecute(Object result) {
        String res=result.toString();
        String bool1= "success";
        String bool2= "null";
        String bool4= "failure";
        if(res.equals(bool1)) {
            //获得服务器返回信息成功信息
            Intent intent = new Intent();

            intent.setClass(Login.this, MainActivity.class);
            startActivity(intent);
            Login.this.finish();

        }
        else if(res.equals(bool2)) {
            //获得服务器返回信息成功后

            //弹出对话框
            dialog.setTitle("服务器信息");
            dialog.setMessage("请输入账号密码");
            dialog.setPositiveButton("'确定", new Login.noClick());
            dialog.create();
            dialog.show();


        }
        else if(res.equals(bool4)){
            //弹出对话框
            dialog.setTitle("服务器信息");
            dialog.setMessage("用户名或密码错误");
            dialog.setPositiveButton("'确定", new Login.noClick());
            dialog.create();
            dialog.show();

        }
        else{
            dialog.setTitle("服务器信息");
            dialog.setMessage("无法连接到服务器，请稍后再试");
            dialog.setPositiveButton("'确定", new Login.noClick());
            dialog.create();
            dialog.show();
        }
        //取消进度条
        progressDialog.cancel();

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


}