package com.example.posttest6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "mainactivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "start");
        Toast.makeText(MainActivity.this, "welcome", Toast.LENGTH_SHORT).show();

        ImageButton masuk_ig = findViewById(R.id.instagram);
        masuk_ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myig = "https://www.instagram.com/ahmada_404/";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myig)));
            }
        });

        ImageButton masuk_twit = findViewById(R.id.twitter);
        masuk_twit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mytw = "https://www.twitter.com/achmads03156910/";
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mytw)));
            }
        });

    }



    public void findmaps() {
        Intent finditmaps = new Intent(MainActivity.this, maps.class);
        startActivity(finditmaps);
    }
    public void findbrowser() {
        Intent finditbrowser = new Intent(MainActivity.this, custom_url.class);
        startActivity(finditbrowser);
    }
    public void findkontak() {
        Intent finditkontak = new Intent(MainActivity.this, kontak.class);
        startActivity(finditkontak);
    }
    public void findmessage() {
        Intent finditmessage = new Intent(MainActivity.this, message.class);
        startActivity(finditmessage);
    }
    public void findhitung(){
        Intent findithitung = new Intent(MainActivity.this, hitung.class);
        startActivity(findithitung);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ini_maps:
                findmaps();
                return true;
            case R.id.ini_browser:
                findbrowser();
                return true;
            case R.id.ini_telephone:
                findkontak();
                return true;
            case R.id.ini_messages:
                findmessage();
                return true;
            case R.id.ini_hitung:
                findhitung();
                return true;
        }return false;
    }



}