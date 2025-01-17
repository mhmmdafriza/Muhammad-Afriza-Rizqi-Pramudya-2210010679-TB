package dao;

import model.Absensi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbsensiDAO {
    private Connection conn;

    public AbsensiDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Absensi> getAllAbsensi() throws SQLException {
        List<Absensi> absensiList = new ArrayList<>();
        String sql = "SELECT * FROM absensi";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Absensi absensi = new Absensi(
                rs.getInt("id_absensi"),
                rs.getInt("id_pegawai"),
                rs.getDate("tanggal"),
                rs.getString("status_kehadiran")
            );
            absensiList.add(absensi);
        }
        return absensiList;
    }

    public void insertAbsensi(Absensi absensi) throws SQLException {
        String sql = "INSERT INTO absensi (id_pegawai, tanggal, status_kehadiran) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, absensi.getIdPegawai());
        pstmt.setDate(2, new java.sql.Date(absensi.getTanggal().getTime()));
        pstmt.setString(3, absensi.getStatusKehadiran());
        pstmt.executeUpdate();
    }

    public void updateAbsensi(Absensi absensi) throws SQLException {
        String sql = "UPDATE absensi SET id_pegawai = ?, tanggal = ?, status_kehadiran = ? WHERE id_absensi = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, absensi.getIdPegawai());
        pstmt.setDate(2, new java.sql.Date(absensi.getTanggal().getTime()));
        pstmt.setString(3, absensi.getStatusKehadiran());
        pstmt.setInt(4, absensi.getIdAbsensi());
        pstmt.executeUpdate();
    }

    public void deleteAbsensi(int idAbsensi) throws SQLException {
        String sql = "DELETE FROM absensi WHERE id_absensi = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idAbsensi);
        pstmt.executeUpdate();
    }
}
