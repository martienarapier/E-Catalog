package com.martienp45.e_catalogbatik;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent( SplashActivity.this, MenuActivity.class ); //pindah activity
            //param 1 = activity sekarang
            //param 2 = activity tujuan
            SplashActivity.this.startActivity(intent);
            //mengaktifkan intent
            SplashActivity.this.finish(); //untuk keluar dari tampilan sekarang
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); //inisiasi activity ini memiliki konten activitysplash
    }
    @Override
    protected void onStart(){
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(runnable, 2000); //2000 waktu pada splash
    }
}
