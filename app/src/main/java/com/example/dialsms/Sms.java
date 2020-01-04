package com.example.dialsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.dialsms.DialandSms.phone;

public class Sms extends AppCompatActivity {

    private TextView tv;
    private EditText content;
    private String smsContent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        tv = (TextView) findViewById(R.id.hm);
        tv.setText(phone);
        Button send = (Button) findViewById(R.id.send);
        content = (EditText)findViewById(R.id.content);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsContent = content.getText().toString();
                if("".equals(smsContent)){
                    Toast.makeText(Sms.this, "短信内容不能为空", Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+phone));
                intent.putExtra("sms_body", smsContent);
                startActivity(intent);
            }
        });

    }
}
