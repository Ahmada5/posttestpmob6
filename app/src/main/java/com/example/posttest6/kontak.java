package com.example.posttest6;

import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kontak extends AppCompatActivity {

    EditText find_number;
    Button find_number_now;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        find_number = findViewById(R.id.number);
        find_number_now = findViewById(R.id.find_this_number);

        find_number_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String this_number = find_number.getText().toString().trim();
                if(!TextUtils.isEmpty(this_number)) {
                    String dial = "tel:" + this_number;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(kontak.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}