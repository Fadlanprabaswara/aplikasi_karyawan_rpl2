/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dlm_data_karyawan {
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    private String sql;
    public String nip;
    public String nama;
    public String jabatan;
    public String jenisKelamin;
    public String agama;
    public String status;
    public String alamat;

    public void simpan() throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO data_karyawan(nip, nama, jabatan, jenis_kelamin, agama, status, alamat) VALUES (?, ?, ?, ?, ?, ?, ?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nip);
        pst.setString(2, nama);
        pst.setString(3, jabatan);
        pst.setString(4, jenisKelamin);
        pst.setString(5, agama);
        pst.setString(6, status);
        pst.setString(7, alamat);
        pst.execute();
        pst.close();
    }

    public void rubah() throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "UPDATE data_karyawan SET nama=?, jabatan=?, jenis_kelamin=?, agama=?, status=?, alamat=? WHERE nip=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, jabatan);
        pst.setString(3, jenisKelamin);
        pst.setString(4, agama);
        pst.setString(5, status);
        pst.setString(6, alamat);
        pst.setString(7, nip);
        pst.executeUpdate();
        pst.close();
    }

    public void hapus() throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "DELETE FROM data_karyawan WHERE nip=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, nip);
            pst.execute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet updateJTable() throws SQLException {
        conn = Koneksi.getKoneksi();
        sql = "SELECT nip, nama, jabatan, jenis_kelamin, agama, status, alamat FROM data_karyawan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}

