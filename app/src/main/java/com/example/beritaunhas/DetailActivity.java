package com.example.beritaunhas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beritaunhas.fragment.TambahFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView IV_Foto = findViewById(R.id.IV_FotoDetail);
        TextView TV_UKM = findViewById(R.id.TV_NamaUKMDetail);
        TextView TV_Waktu =findViewById(R.id.TV_WaktuDetail);
        TextView TV_Judul = findViewById(R.id.TV_JudulDetail);
        TextView TV_Detail = findViewById(R.id.TV_IsiDetail);

        Intent intent = getIntent();
        Berita berita = intent.getParcelableExtra("berita");

        IV_Foto.setImageResource(berita.getFotoBerita());
        TV_UKM.setText(berita.getNamaUkm());
        TV_Waktu.setText(berita.getWaktu());
        TV_Judul.setText(berita.getJudul());
        TV_Detail.setText(berita.getIsiBerita());

    }
}