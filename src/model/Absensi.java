package model;

import java.util.Date;

public class Absensi {
    private int idAbsensi;
    private int idPegawai;
    private Date tanggal;
    private String statusKehadiran;

    public Absensi() {}

    public Absensi(int idAbsensi, int idPegawai, Date tanggal, String statusKehadiran) {
        this.idAbsensi = idAbsensi;
        this.idPegawai = idPegawai;
        this.tanggal = tanggal;
        this.statusKehadiran = statusKehadiran;
    }

    // Getter dan Setter
    public int getIdAbsensi() {
        return idAbsensi;
    }

    public void setIdAbsensi(int idAbsensi) {
        this.idAbsensi = idAbsensi;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatusKehadiran() {
        return statusKehadiran;
    }

    public void setStatusKehadiran(String statusKehadiran) {
        this.statusKehadiran = statusKehadiran;
    }
}
