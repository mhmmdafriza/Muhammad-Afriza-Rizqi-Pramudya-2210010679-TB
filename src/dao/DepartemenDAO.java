package dao;

import model.Departemen;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartemenDAO {
    private Connection conn;

    public DepartemenDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Departemen> getAllDepartemen() throws SQLException {
        List<Departemen> departemenList = new ArrayList<>();
        String sql = "SELECT * FROM departemen";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Departemen departemen = new Departemen(
                rs.getInt("id_departemen"),
                rs.getString("nama_departemen")
            );
            departemenList.add(departemen);
        }
        return departemenList;
    }

    public void insertDepartemen(Departemen departemen) throws SQLException {
        String sql = "INSERT INTO departemen (nama_departemen) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, departemen.getNamaDepartemen());
        pstmt.executeUpdate();
    }

    public void updateDepartemen(Departemen departemen) throws SQLException {
        String sql = "UPDATE departemen SET nama_departemen = ? WHERE id_departemen = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, departemen.getNamaDepartemen());
        pstmt.setInt(2, departemen.getIdDepartemen());
        pstmt.executeUpdate();
    }

    public void deleteDepartemen(int idDepartemen) throws SQLException {
        String sql = "DELETE FROM departemen WHERE id_departemen = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idDepartemen);
        pstmt.executeUpdate();
    }
}
