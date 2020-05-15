package com.example.administrator.read.Y_Log;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.read.MainActivity;
import com.example.administrator.read.R;

public class setting extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ab_setting);

        Button contact= (Button) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, com.example.administrator.read.Y_Log.contact.class);
                startActivity(intent);
            }
        });

        Button cancel= (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(setting.this, Login.class);
                startActivity(intent);
            }
        });

        Button settinghuitui= (Button) findViewById(R.id.settinghuitui);
        settinghuitui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(setting.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
