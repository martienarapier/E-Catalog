package com.martienp45.e_catalogbatik.objek;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Koleksi {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_inventaris")
    @Expose
    private String idInventaris;
    @SerializedName("nama_benda")
    @Expose
    private String namaBenda;
    @SerializedName("jenis_benda")
    @Expose
    private String jenisBenda;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("ukuran")
    @Expose
    private String ukuran;
    @SerializedName("bahan")
    @Expose
    private String bahan;
    @SerializedName("daerah")
    @Expose
    private String daerah;
    @SerializedName("tahun")
    @Expose
    private String tahun;
    @SerializedName("penyumbang")
    @Expose
    private String penyumbang;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("id_gambar")
    @Expose
    private String idGambar;
    @SerializedName("foto1")
    @Expose
    private String foto1;
    @SerializedName("foto2")
    @Expose
    private String foto2;
    @SerializedName("foto3")
    @Expose
    private String foto3;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pamer")
    @Expose
    private String pamer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdInventaris() {
        return idInventaris;
    }

    public void setIdInventaris(String idInventaris) {
        this.idInventaris = idInventaris;
    }

    public String getNamaBenda() {
        return namaBenda;
    }

    public void setNamaBenda(String namaBenda) {
        this.namaBenda = namaBenda;
    }

    public String getJenisBenda() {
        return jenisBenda;
    }

    public void setJenisBenda(String jenisBenda) {
        this.jenisBenda = jenisBenda;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public String getDaerah() {
        return daerah;
    }

    public void setDaerah(String daerah) {
        this.daerah = daerah;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getPenyumbang() {
        return penyumbang;
    }

    public void setPenyumbang(String penyumbang) {
        this.penyumbang = penyumbang;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getIdGambar() {
        return idGambar;
    }

    public void setIdGambar(String idGambar) {
        this.idGambar = idGambar;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPamer() {
        return pamer;
    }

    public void setPamer(String pamer) {
        this.pamer = pamer;
    }

}

