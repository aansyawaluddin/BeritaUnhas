package com.example.beritaunhas.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.beritaunhas.Berita;
import com.example.beritaunhas.BeritaAdapter;
import com.example.beritaunhas.DataSource;
import com.example.beritaunhas.R;

public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvPostingan = view.findViewById(R.id.rv_post);
        rvPostingan.setHasFixedSize(true);
        BeritaAdapter beritaAdapter = new BeritaAdapter(DataSource.beritas);
        rvPostingan.setAdapter(beritaAdapter);

        Button btn_ajukan = view.findViewById(R.id.btn_ajukan);

        btn_ajukan.setOnClickListener(v -> {
            TambahFragment tambahFragment = new TambahFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, tambahFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}