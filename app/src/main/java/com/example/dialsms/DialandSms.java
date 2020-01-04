package com.example.dialsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialandSms extends AppCompatActivity {

    private TextView tv;
    static String phone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialand_sms);
        tv = (TextView)findViewById(R.id.hm);
        Intent i = getIntent();
        String n = i.getStringExtra("number");
        tv.setText(n);
        phone = n;
        Button dial = (Button)findViewById(R.id.dial);
        Button sms = (Button) findViewById(R.id.sms);
        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(DialandSms.this, Manifest.
                        permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // 调用ActivityCompat.requestPermissions() 方法，向用户申请授权
                    ActivityCompat.requestPermissions(DialandSms.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                } else {
                    // 已经授权，使用Intent调用打电话的功能
                    Intent intent = new Intent();
                   //设置Action和Uri
                    intent.setAction(Intent.ACTION_CALL);
                   //设置数据
                    intent.setData(Uri.parse("tel:" + phone));
                    startActivity(intent);
                }
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DialandSms.this,Sms.class);
                startActivity(i);
            }
        });

    }
}
