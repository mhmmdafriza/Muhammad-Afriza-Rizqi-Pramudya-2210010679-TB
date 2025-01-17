package controller;

import dao.PegawaiDAO;
import dao.DatabaseConnection;
import model.Pegawai;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PegawaiController {
    private PegawaiDAO pegawaiDAO;

    public PegawaiController() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            this.pegawaiDAO = new PegawaiDAO(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pegawai> getAllPegawai() {
        try {
            return pegawaiDAO.getAllPegawai();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addPegawai(Pegawai pegawai) {
        try {
            pegawaiDAO.insertPegawai(pegawai);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePegawai(Pegawai pegawai) {
        try {
            pegawaiDAO.updatePegawai(pegawai);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePegawai(int idPegawai) {
        try {
            pegawaiDAO.deletePegawai(idPegawai);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
