package com.martienp45.e_catalogbatik.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.martienp45.e_catalogbatik.DetailActivity;
import com.martienp45.e_catalogbatik.R;
import com.martienp45.e_catalogbatik.objek.Koleksi;

import java.util.ArrayList;




public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {
    private ArrayList<Koleksi> mArrayList;
    private ArrayList<Koleksi> mFilteredList;

    public DataAdapter(ArrayList<Koleksi> arrayList){
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_data, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int i) {

        String thumbnail = "http://oresama.000webhostapp.com/uploads/"+mFilteredList.get(i).getFoto1();
        String foto_2 = "http://oresama.000webhostapp.com/uploads/"+mFilteredList.get(i).getFoto2();
        String foto_3 = "http://oresama.000webhostapp.com/uploads/"+mFilteredList.get(i).getFoto3();

        holder.id_inventaris.setText(mFilteredList.get(i).getIdInventaris());
        holder.nama_benda.setText(mFilteredList.get(i).getNamaBenda());
        holder.daerah.setText(mFilteredList.get(i).getDaerah());
        holder.pamer.setText(mFilteredList.get(i).getPamer());

        holder.jenis_benda = mFilteredList.get(i).getJenisBenda();
        holder.kategori = mFilteredList.get(i).getBahan();
        holder.ukuran = mFilteredList.get(i).getUkuran();
        holder.bahan = mFilteredList.get(i).getBahan();
        holder.tahun = mFilteredList.get(i).getTahun();
        holder.penyumbang = mFilteredList.get(i).getPenyumbang();
        holder.deskripsi = mFilteredList.get(i).getDeskripsi();
        holder.foto2 = foto_2;
        holder.foto3 = foto_3;
        holder.foto = thumbnail;

        Glide.with(holder.itemView.getContext())
                .load(thumbnail)
                .thumbnail(0.5f)
                .crossFade()
                .into(holder.foto1);

    }

    @Override
    public int getItemCount(){
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<Koleksi> filteredList = new ArrayList<>();

                    for (Koleksi koleksi : mArrayList) {

                        if (koleksi.getIdInventaris().toLowerCase().contains(charString) ||
                                koleksi.getNamaBenda().toLowerCase().contains(charString) ||
                                koleksi.getDaerah().toLowerCase().contains(charString) ||
                                koleksi.getPamer().toLowerCase().contains(charString)) {
                            filteredList.add(koleksi);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Koleksi>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id_inventaris, nama_benda, daerah, pamer;
        private ImageView foto1;

        public String jenis_benda, kategori, ukuran, bahan, tahun, penyumbang, deskripsi, foto, foto2, foto3;

        public ViewHolder(View view){
            super(view);

            id_inventaris = view.findViewById(R.id.textNoinven);
            nama_benda = view.findViewById(R.id.textNama);
            daerah = view.findViewById(R.id.textDaerah);
            pamer = view.findViewById(R.id.textPamer);
            foto1 = view.findViewById(R.id.imageData);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        Intent intent = new Intent(v.getContext(), DetailActivity.class);
                        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent.putExtra("id_inventaris", id_inventaris.getText());
                        intent.putExtra("nama_benda", nama_benda.getText());
                        intent.putExtra("jenis_benda", jenis_benda);
                        intent.putExtra("kategori", kategori);
                        intent.putExtra("ukuran", ukuran);
                        intent.putExtra("bahan", bahan);
                        intent.putExtra("daerah", daerah.getText());
                        intent.putExtra("tahun", tahun);
                        intent.putExtra("penyumbang", penyumbang);
                        intent.putExtra("deskripsi", deskripsi);
                        intent.putExtra("foto1", foto);
                        intent.putExtra("foto2", foto2);
                        intent.putExtra("foto3", foto3);
                        intent.putExtra("pamer", pamer.getText());
//
                        v.getContext().startActivity(intent);
                    }
                }
            });

        }
    }
}
