/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projek_pbo;

import database.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WIN10
 */
public class ModelCetak {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    Config koneksi;

    public int totalData() {
        koneksi = new Config();
        conn = koneksi.getConnection();
        int jumlah = 0;

        String sql = "SELECT mahasiswa.nim, mahasiswa.namaMahasiswa, mahasiswa.alamat, "
                + "fakultas.namaFakultas, programstudi.namaProdi "
                + "FROM mahasiswa "
                + "INNER JOIN fakultas ON mahasiswa.kodeFk = fakultas.kodeFk "
                + "INNER JOIN programstudi ON mahasiswa.kodePr = programstudi.kodePr ";
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                jumlah++;
            }

            return jumlah;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error 3: " + ex.getMessage());
        }
        return jumlah;
    }

    public String[][] tampilTabel() {

        String data[][] = new String[totalData()][5];
        koneksi = new Config();
        conn = koneksi.getConnection();
        int index = 0;
        String sql = "SELECT mahasiswa.nim, mahasiswa.namaMahasiswa, mahasiswa.alamat, "
                + "fakultas.namaFakultas, programstudi.namaProdi "
                + "FROM mahasiswa "
                + "INNER JOIN fakultas ON mahasiswa.kodeFk = fakultas.kodeFk "
                + "INNER JOIN programstudi ON mahasiswa.kodePr = programstudi.kodePr ";

        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);

//            rs.last();
            while (rs.next()){
                data[index][0] = rs.getString("nim");
                data[index][1] = rs.getString("namaMahasiswa");
                data[index][2] = rs.getString("alamat");
                data[index][3] = rs.getString("namaFakultas");
                data[index][4] = rs.getString("namaProdi");
                index++;
            }
          return data;
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error 3: " + ex.getMessage());
        }
        
        return data;

    }

}
