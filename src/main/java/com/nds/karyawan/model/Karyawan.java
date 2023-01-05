package com.nds.karyawan.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Karyawan {
    public Karyawan(String namaKaryawan, Date tanggalMasukKerja, String noHp, Integer limitReimbursement) {
        this.nama_karyawan = namaKaryawan;
        this.tanggal_masuk_kerja = tanggalMasukKerja;
        this.limit_reimbursement = limitReimbursement;
        this.no_hp = noHp;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode_karyawan() {
        return kode_karyawan;
    }

    public void setKode_karyawan(String kode_karyawan) {
        this.kode_karyawan = kode_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public Date getTanggal_masuk_kerja() {
        return tanggal_masuk_kerja;
    }

    public void setTanggal_masuk_kerja(Date tanggal_masuk) {
        this.tanggal_masuk_kerja = tanggal_masuk;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public Integer getLimit_reimbursement() {
        return limit_reimbursement;
    }

    public void setLimit_reimbursement(int limit_reimbursement) {
        this.limit_reimbursement = limit_reimbursement;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    private int id;
    private String kode_karyawan;
    private String nama_karyawan;
    private Date tanggal_masuk_kerja;
    private String no_hp;
    private Integer limit_reimbursement;
    private Timestamp created_at;
    private Timestamp updated_at;
    @Override
    public String toString(){
        return this.kode_karyawan+" - "+this.nama_karyawan+" - "+
                this.no_hp+" - "+this.tanggal_masuk_kerja+" - "+this.limit_reimbursement;
    }

}
