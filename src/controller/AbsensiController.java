package controller;

import dao.AbsensiDAO;
import dao.DatabaseConnection;
import model.Absensi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AbsensiController {
    private AbsensiDAO absensiDAO;

    public AbsensiController() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            this.absensiDAO = new AbsensiDAO(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Absensi> getAllAbsensi() {
        try {
            return absensiDAO.getAllAbsensi();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addAbsensi(Absensi absensi) {
        try {
            absensiDAO.insertAbsensi(absensi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAbsensi(Absensi absensi) {
        try {
            absensiDAO.updateAbsensi(absensi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAbsensi(int idAbsensi) {
        try {
            absensiDAO.deleteAbsensi(idAbsensi);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
