package com.martienp45.e_catalogbatik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dd.processbutton.FlatButton;

public class MenuActivity extends AppCompatActivity {

    FlatButton btn_Exit, btn_Now, btn_All, btn_Tentang; //inisiasi var flatbutton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_Exit = findViewById(R.id.btn_Keluar); //digunakan untuk mencari button exit
        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                Intent sharing = new Intent(Intent.ACTION_SEND);
//                sharing.setType("text/plain");
//                String isi = "tes \n \n http://www.google.com/";
//                sharing.putExtra(Intent.EXTRA_TEXT, isi);
//                startActivity(Intent.createChooser(sharing,"Bagikan Via : "));
            }
        });

        btn_Now = findViewById(R.id.btn_Sekarang); //digunakan untuk mencari button exit
        btn_Now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MenuActivity.this, DataActivity.class );
                intent.putExtra("kategori","all");
                startActivity(intent);
            }
        });

        btn_All = findViewById(R.id.btn_Semua); //digunakan untuk mencari button exit
        btn_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MenuActivity.this, AllActivity.class );
                startActivity(intent);
            }
        });

        btn_Tentang = findViewById(R.id.btn_Tentang); //digunakan untuk mencari button exit
        btn_Tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MenuActivity.this, InfoActivity.class );
                startActivity(intent);
            }
        });
    }
}
