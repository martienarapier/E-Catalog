package com.martienp45.e_catalogbatik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dd.processbutton.FlatButton;

/**
 * Created by user on 10/03/2018.
 */

public class AllActivity extends AppCompatActivity
{
    FlatButton btn_Dalam, btn_Sisir, btn_Nusan, btn_Kontem, btn_Manca, btn_Nonbat;
    @Override
    protected void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldata);

        btn_Dalam = findViewById(R.id.btn_Dalam); //digunakan untuk mencari button exit
        btn_Dalam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AllActivity.this, DataActivity.class );
                intent.putExtra("kategori","Pedalaman");
                startActivity(intent);
            }
        });

        btn_Sisir = findViewById(R.id.btn_Sisir); //digunakan untuk mencari button exit
        btn_Sisir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AllActivity.this, DataActivity.class );
                intent.putExtra("kategori","Pesisir");
                startActivity(intent);
            }
        });

        btn_Nusan = findViewById(R.id.btn_Nusan); //digunakan untuk mencari button exit
        btn_Nusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AllActivity.this, DataActivity.class );
                intent.putExtra("kategori","Nusantara");
                startActivity(intent);
            }
        });

        btn_Kontem = findViewById(R.id.btn_Kontem); //digunakan untuk mencari button exit
        btn_Kontem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AllActivity.this, DataActivity.class );
                intent.putExtra("kategori","Kontemporer");
                startActivity(intent);
            }
        });

        btn_Manca = findViewById(R.id.btn_Manca); //digunakan untuk mencari button exit
        btn_Manca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AllActivity.this, DataActivity.class );
                intent.putExtra("kategori","Mancanegara");
                startActivity(intent);
            }
        });

        btn_Nonbat = findViewById(R.id.btn_Nonbat); //digunakan untuk mencari button exit
        btn_Nonbat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( AllActivity.this, DataActivity.class );
                intent.putExtra("kategori","NonBatik");
                startActivity(intent);
            }
        });
    }
}