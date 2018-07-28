package com.martienp45.e_catalogbatik;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.martienp45.e_catalogbatik.adapter.DataAdapter;
import com.martienp45.e_catalogbatik.api.Client;
import com.martienp45.e_catalogbatik.api.Service;
import com.martienp45.e_catalogbatik.objek.Koleksi;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Koleksi> mArrayList;
    private DataAdapter sAdapter;
    private MenuItem search;
    private SearchView searchView;
    private boolean ascending = true;
    String kategori;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);


        Toolbar toolbar = findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);
        String labelatas;
        kategori = getIntent().getStringExtra("kategori");
        if(kategori.equals("all")){
            labelatas="Now on Museum";
        }else{
            labelatas = "Batik "+kategori;
        }
        getSupportActionBar().setTitle(labelatas);
//        this.setTitle(kategori);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        mRecyclerView = findViewById(R.id.recview);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void loadJSON(){

        Service serviceAPI = Client.getClient();
        Call<JsonArray> loadKoleksi = serviceAPI.getKoleksi(kategori);
        loadKoleksi.enqueue(new Callback<JsonArray>() {

            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response)
            {
                String koleksiString = response.body().toString();

                Type listType = new TypeToken<ArrayList<Koleksi>>() {}.getType();

                mArrayList = getTeamListFromJson(koleksiString, listType);

                mRecyclerView.setItemAnimator(new DefaultItemAnimator());

                    sAdapter = new DataAdapter(mArrayList);
                    mRecyclerView.setAdapter(sAdapter);
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

                Log.d("Error",t.getMessage());
            }

        });
}

    public static <T> ArrayList<T> getTeamListFromJson(String jsonString, Type type) {
        if (!isValid(jsonString)) {
            return null;
        }
        return new Gson().fromJson(jsonString, type);
    }

    public static boolean isValid(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem cari = menu.findItem(R.id.btnSearch);
        cari.setVisible(false);

        search = menu.findItem(R.id.search);
        searchView  = (SearchView) search.getActionView();
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
//            case R.id.btnAsc:
//                sortArray();
//                sortArrayAscending();
//                break;
//            case R.id.btnDes:
//                sortArray();
//                sortArrayDescending();
//                break;
            case R.id.btnRef:
                loadJSON();
                break;

        }
        return super.onOptionsItemSelected(item);

    }


    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (sAdapter != null) {
                    sAdapter.getFilter().filter(newText);

                }
                return true;
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}

