package dao;

import model.Pegawai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PegawaiDAO {
    private Connection conn;

    public PegawaiDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Pegawai> getAllPegawai() throws SQLException {
        List<Pegawai> pegawaiList = new ArrayList<>();
        String sql = "SELECT * FROM pegawai";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Pegawai pegawai = new Pegawai(
                rs.getInt("id_pegawai"),
                rs.getString("nama_pegawai"),
                rs.getString("jabatan"),
                rs.getDouble("gaji")
            );
            pegawaiList.add(pegawai);
        }
        return pegawaiList;
    }

    public void insertPegawai(Pegawai pegawai) throws SQLException {
        String sql = "INSERT INTO pegawai (nama_pegawai, jabatan, gaji) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, pegawai.getNamaPegawai());
        pstmt.setString(2, pegawai.getJabatan());
        pstmt.setDouble(3, pegawai.getGaji());
        pstmt.executeUpdate();
    }

    public void updatePegawai(Pegawai pegawai) throws SQLException {
        String sql = "UPDATE pegawai SET nama_pegawai = ?, jabatan = ?, gaji = ? WHERE id_pegawai = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, pegawai.getNamaPegawai());
        pstmt.setString(2, pegawai.getJabatan());
        pstmt.setDouble(3, pegawai.getGaji());
        pstmt.setInt(4, pegawai.getIdPegawai());
        pstmt.executeUpdate();
    }

    public void deletePegawai(int idPegawai) throws SQLException {
        String sql = "DELETE FROM pegawai WHERE id_pegawai = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, idPegawai);
        pstmt.executeUpdate();
    }
}
