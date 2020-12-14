package com.example.posttest6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class custom_url extends AppCompatActivity {

    EditText find_url;
    Button find_it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_url);

        find_url = findViewById(R.id.text_find);
        find_it = findViewById(R.id.text_find_it);

        find_it.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String this_url = find_url.getText().toString().trim();
                Uri url=Uri.parse("https://"+this_url);
                Intent urlintent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(urlintent);
            }
        });
    }


}