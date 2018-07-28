package com.martienp45.e_catalogbatik;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class DetailFotoActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        final String foto1, foto2, foto3;
        Intent intent = getIntent();
        foto1 = intent.getStringExtra("foto1");

        ImageView DetailFoto1 = findViewById(R.id.detailfoto1);
        //digunakan untuk memanggil foto
        Glide.with(DetailFotoActivity.this)
                .load(foto1)
                .thumbnail(Glide.with(DetailFotoActivity.this).load(R.id.foto1))
                .fitCenter()
                .into(DetailFoto1);

        foto2 = intent.getStringExtra("foto2");

        ImageView DetailFoto2 = findViewById(R.id.detailfoto2);
        //digunakan untuk memanggil foto
        Glide.with(DetailFotoActivity.this)
                .load(foto2)
                .thumbnail(Glide.with(DetailFotoActivity.this).load(R.id.foto1))
                .fitCenter()
                .into(DetailFoto2);

        foto3 = intent.getStringExtra("foto3");

        ImageView DetailFoto3 = findViewById(R.id.detailfoto3);
        //digunakan untuk memanggil foto
        Glide.with(DetailFotoActivity.this)
                .load(foto3)
                .thumbnail(Glide.with(DetailFotoActivity.this).load(R.id.foto1))
                .fitCenter()
                .into(DetailFoto3);


    }

}