package com.example.beritaunhas;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Berita implements Parcelable {

    private String judul;
    private String waktu;
    private String isiBerita;
    private String namaUkm;
    private int fotoBerita;

    public Berita(String judul, String waktu, String isiBerita, String namaUkm, int fotoBerita) {
        this.judul = judul;
        this.waktu = waktu;
        this.isiBerita = isiBerita;
        this.namaUkm = namaUkm;
        this.fotoBerita = fotoBerita;
    }

    protected Berita(Parcel in) {
        judul = in.readString();
        waktu = in.readString();
        isiBerita = in.readString();
        namaUkm = in.readString();
        fotoBerita = in.readInt();
    }

    public static final Creator<Berita> CREATOR = new Creator<Berita>() {
        @Override
        public Berita createFromParcel(Parcel in) {
            return new Berita(in);
        }

        @Override
        public Berita[] newArray(int size) {
            return new Berita[size];
        }
    };

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getIsiBerita() {
        return isiBerita;
    }

    public void setIsiBerita(String isiBerita) {
        this.isiBerita = isiBerita;
    }

    public String getNamaUkm() {
        return namaUkm;
    }

    public void setNamaUkm(String namaUkm) {
        this.namaUkm = namaUkm;
    }

    public int getFotoBerita() {
        return fotoBerita;
    }

    public void setFotoBerita(int fotoBerita) {
        this.fotoBerita = fotoBerita;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(waktu);
        dest.writeString(isiBerita);
        dest.writeString(namaUkm);
        dest.writeInt(fotoBerita);
    }


}
