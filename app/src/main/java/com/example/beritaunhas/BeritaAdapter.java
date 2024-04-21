package com.example.beritaunhas;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {

    private ArrayList<Berita> beritas;

    public BeritaAdapter(ArrayList<Berita> beritas) {
        this.beritas = beritas;
    }

    @NonNull
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postingan, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.ViewHolder holder, int position) {

        Berita berita1 = beritas.get(position);

        holder.TV_Judul.setText(berita1.getJudul());
        holder.TV_Waktu.setText(berita1.getWaktu());
        holder.IV_fotoBerita.setImageResource(berita1.getFotoBerita());


        holder.TV_Judul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.context, DetailActivity.class);
                intent.putExtra("berita", berita1);
                holder.context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return beritas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TV_Judul, TV_Waktu;
        TextView TV_JudulDetail, TV_IsiBerita, TV_NamaUkm, TV_WaktuDetail;
        ImageView IV_fotoBerita, IV_FotoDetail;

        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TV_Judul = itemView.findViewById(R.id.TV_Judul);
            TV_Waktu = itemView.findViewById(R.id.TV_Waktu);
            IV_fotoBerita = itemView.findViewById(R.id.IV_FotoBerita);

            IV_FotoDetail = itemView.findViewById(R.id.IV_FotoDetail);
            TV_JudulDetail = itemView.findViewById(R.id.TV_JudulDetail);
            TV_IsiBerita = itemView.findViewById(R.id.TV_IsiDetail);
            TV_NamaUkm = itemView.findViewById(R.id.TV_NamaUKMDetail);
            TV_WaktuDetail = itemView.findViewById(R.id.TV_WaktuDetail);

            context = itemView.getContext();
        }
    }
}
