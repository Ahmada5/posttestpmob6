package com.example.posttest6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class message extends AppCompatActivity {

    EditText message, number;
    Button send_it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        number = findViewById(R.id.the_number);
        message = findViewById(R.id.the_message);
        send_it = findViewById(R.id.send);

        send_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NUMBER = number.getText().toString().trim();
                String MESSAGE = message.getText().toString().trim();
                if(!TextUtils.isEmpty(MESSAGE) && !TextUtils.isEmpty(NUMBER)) {
                    Intent messageintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + NUMBER));
                    messageintent.putExtra("sms_body", MESSAGE);
                    startActivity(messageintent);
                }
            }
        });

    }
}