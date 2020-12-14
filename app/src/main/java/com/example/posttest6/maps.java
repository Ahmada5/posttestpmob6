package com.example.posttest6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class maps extends AppCompatActivity {
    //variabel
    EditText SL, SD;
    Button TR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //mngambil variabel
        SL = findViewById(R.id.sourcelocation);
        SD = findViewById(R.id.sourcedestination);
        TR = findViewById(R.id.track);

        TR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mengambil valuenya
                String s_source = SL.getText().toString().trim();
                String s_destination = SD.getText().toString().trim();

                //cek kondisi
                if (s_source.equals("") && s_destination.equals("")){
                    //ketika sama
                    Toast.makeText(getApplicationContext(),"enter your both value", Toast.LENGTH_SHORT).show();
                }else {
                    DisplayTrack(s_source,s_destination);
                }
            }
        });
    }

    private void DisplayTrack(String s_source, String s_destination) {
        //kalau hp tidak ada maps, maka akan langsung di direct ke store
        try {
            //jika sudah terinstall
            Uri uri = Uri.parse("https://www.google.co.in/maps/dir/"+s_source+"/"+s_destination);
            //intent
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //package
            intent.setPackage("com.google.android.apps.maps");
            //flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start
            startActivity(intent);
        }catch (ActivityNotFoundException e){
            //jika tidak install gmaps
            Uri uri = Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //intent
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //start
            startActivity(intent);
        }
    }
}