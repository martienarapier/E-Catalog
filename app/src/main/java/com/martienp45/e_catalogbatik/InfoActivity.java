package com.martienp45.e_catalogbatik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dd.processbutton.FlatButton;

public class InfoActivity extends AppCompatActivity {

    FlatButton btn_Profil, btn_Pandu, btn_Lokasi; //inisiasi var flatbutton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btn_Profil = findViewById(R.id.btn_Profil); //digunakan untuk mencari button exit
        btn_Profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( InfoActivity.this, ProfilActivity.class );
                startActivity(intent);
            }
        });

        btn_Pandu = findViewById(R.id.btn_Pandu); //digunakan untuk mencari button exit
        btn_Pandu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( InfoActivity.this, PanduActivity.class );
                startActivity(intent);
            }
        });

        btn_Lokasi = findViewById(R.id.btn_Lokasi); //digunakan untuk mencari button exit
        btn_Lokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( InfoActivity.this, MapsActivity.class );
                startActivity(intent);
            }
        });
    }
}
