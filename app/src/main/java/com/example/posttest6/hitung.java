package com.example.posttest6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class hitung extends AppCompatActivity {
    EditText jari_jari;
    Button mulai_hitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung);

        jari_jari = findViewById(R.id.jari);
        mulai_hitung = findViewById(R.id.hitung);
        final TextView hasil_luas = findViewById(R.id.luas);
        final TextView hasil_volume = findViewById(R.id.volume);

        mulai_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jari_jari.length()==0){
                    Toast.makeText(getApplicationContext(), "jari-jari kosong", Toast.LENGTH_SHORT).show();
                }else {
                    String jarifix = jari_jari.getText().toString().trim();
                    double r = Double.parseDouble(jarifix);
                    double h_luas = 4*r*r*3.14;
                    double h_volume = (r*r*r*3.14)*4/3;
                    String output_luas = String.valueOf(h_luas);
                    String output_vol = String.valueOf(h_volume);
                    hasil_luas.setText(output_luas);
                    hasil_volume.setText(output_vol);
                }

            }
        });
    }
}