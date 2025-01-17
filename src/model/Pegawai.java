package model;

public class Pegawai {
    private int idPegawai;
    private String namaPegawai;
    private String jabatan;
    private double gaji;

    public Pegawai() {}

    public Pegawai(int idPegawai, String namaPegawai, String jabatan, double gaji) {
        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    // Getter dan Setter
    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
}
