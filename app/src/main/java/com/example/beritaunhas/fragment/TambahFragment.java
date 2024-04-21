package com.example.beritaunhas.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.beritaunhas.R;

public class TambahFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tambah, container, false);

        Button btn_kirim = view.findViewById(R.id.btn_kirim);
        EditText et_nam = view.findViewById(R.id.et_nama);
        EditText et_nomor = view.findViewById(R.id.et_nomor);
        EditText et_judul = view.findViewById(R.id.et_judul);
        Spinner spinnerJenisBerita = view.findViewById(R.id.spinnerJenisBerita);

        String[] jenisBeritaOptions = {"Lomba", "Beasiswa", "Fakultas", "Seminar", "Lain-lain"};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(requireContext(), R.layout.spinner_dropdown_item, jenisBeritaOptions);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerJenisBerita.setAdapter(spinnerAdapter);

        btn_kirim.setOnClickListener(v -> {
            String nama = et_nam.getText().toString().trim();
            String nomor = et_nomor.getText().toString().trim();
            String judul = et_judul.getText().toString().trim();
            String jenisBerita = spinnerJenisBerita.getSelectedItem().toString();

            if (nama.isEmpty() || nomor.isEmpty() || judul.isEmpty() || jenisBerita.isEmpty()) {
                // Tampilkan pesan kesalahan jika ada field yang kosong
                if (nama.isEmpty()) {
                    et_nam.setError("Nama tidak boleh kosong");
                }
                if (nomor.isEmpty()) {
                    et_nomor.setError("Nomor tidak boleh kosong");
                }
                if (judul.isEmpty()) {
                    et_judul.setError("Judul tidak boleh kosong");
                }
                if (jenisBerita.isEmpty()) {
                    // Jika jenis berita belum dipilih
                    TextView errorText = (TextView) spinnerJenisBerita.getSelectedView();
                    errorText.setError("Pilih jenis berita");
                    errorText.setTextColor(Color.RED); // Opsional: Ubah warna teks menjadi merah
                }
            } else {
                // Semua field telah diisi, pindah ke fragment berikutnya
                ValidasiFragment validasiFragment = new ValidasiFragment();
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, validasiFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}
