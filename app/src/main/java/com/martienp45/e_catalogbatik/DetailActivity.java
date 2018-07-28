package com.martienp45.e_catalogbatik;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dd.processbutton.FlatButton;

public class DetailActivity extends AppCompatActivity
{
    TextView id_inventaris, nama_benda, jenis_benda, kategori, ukuran, bahan, daerah, tahun, penyumbang, deskripsi, pamer;
    ImageView foto1, imageView;
    FlatButton btn_Prev, btn_Next, btn_Mid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        btn_Next = findViewById(R.id.btn_Next); //digunakan untuk mencari button exit
//        btn_Next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent( DetailActivity.this, Detail02.class );
//                startActivity(intent);
//            }
//        });
//        btn_Mid = findViewById(R.id.btn_Mid); //digunakan untuk mencari button exit
//        btn_Mid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent( DetailActivity.this, MenuActivity.class );
//                startActivity(intent);
//            }
//        });

        id_inventaris = findViewById(R.id.txtNoinven);
        nama_benda = findViewById(R.id.txtNama);
        jenis_benda = findViewById(R.id.txtJenis);
        kategori = findViewById(R.id.txtKategori);
        ukuran = findViewById(R.id.txtUkuran);
        bahan = findViewById(R.id.txtBahan);
        daerah = findViewById(R.id.txtDaerah);
        tahun = findViewById(R.id.txtTahun);
        penyumbang = findViewById(R.id.txtPengadaan);
        deskripsi = findViewById(R.id.txtDeskripsi);
        foto1 = findViewById(R.id.foto1);
        pamer = findViewById(R.id.txtPamer);

        id_inventaris.setText(getIntent().getStringExtra("id_inventaris"));
        nama_benda.setText(getIntent().getStringExtra("nama_benda"));
        jenis_benda.setText(getIntent().getStringExtra("jenis_benda"));
        kategori.setText(getIntent().getStringExtra("kategori"));
        ukuran.setText(getIntent().getStringExtra("ukuran"));
        bahan.setText(getIntent().getStringExtra("bahan"));
        daerah.setText(getIntent().getStringExtra("daerah"));
        tahun.setText(getIntent().getStringExtra("tahun"));
        penyumbang.setText(getIntent().getStringExtra("penyumbang"));
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
        pamer.setText(getIntent().getStringExtra("pamer"));

        Glide.with(this.getApplicationContext())
                .load(getIntent().getStringExtra("foto1"))
                .thumbnail(0.5f)
                .crossFade()
                .into(foto1);

        foto1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, DetailFotoActivity.class);
                intent.putExtra("foto1", getIntent().getStringExtra("foto1"));
                intent.putExtra("foto2", getIntent().getStringExtra("foto2"));
                intent.putExtra("foto3", getIntent().getStringExtra("foto3"));
                startActivity(intent);
            }
        }
        );

    }
}
