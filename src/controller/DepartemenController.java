package controller;

import dao.DepartemenDAO;
import dao.DatabaseConnection;
import model.Departemen;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartemenController {
    private DepartemenDAO departemenDAO;

    public DepartemenController() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            this.departemenDAO = new DepartemenDAO(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Departemen> getAllDepartemen() {
        try {
            return departemenDAO.getAllDepartemen();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addDepartemen(Departemen departemen) {
        try {
            departemenDAO.insertDepartemen(departemen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDepartemen(Departemen departemen) {
        try {
            departemenDAO.updateDepartemen(departemen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartemen(int idDepartemen) {
        try {
            departemenDAO.deleteDepartemen(idDepartemen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
