/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projek_pbo;

import database.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN10
 */
public class ModelArsip {

    Connection conn;
    Statement stmt;
    ResultSet rs;
    Config koneksi;
    
        
    public String[] cariMahasiswa(String cariNIM) {
        
        
        String sql = "SELECT mahasiswa.nim, mahasiswa.namaMahasiswa, mahasiswa.alamat, "
                + "fakultas.kodeFk, programstudi.kodePr "
                + "FROM mahasiswa "
                + "INNER JOIN fakultas ON mahasiswa.kodeFk = fakultas.kodeFk  "
                + "INNER JOIN programstudi ON mahasiswa.kodePr = programstudi.kodePr "
                + "WHERE nim = '" + cariNIM + "'";
        String data[] = new String[5];
        try {
            
            koneksi = new Config();
            conn = koneksi.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                 
                    data[1] = rs.getString("nim");
                    data[0] = rs.getString("namaMahasiswa");
                    data[2] = rs.getString("alamat");
                    data[3] = rs.getString("kodeFk");
                    data[4] = rs.getString("kodePr");
                    return data;
                
            } else {
                JOptionPane.showMessageDialog(null, "NIM Tidak Ditemukan !!");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return data;
    }

    public String[] setNamaFakultasProdi(String idFk,String idPr) {
            String data[] = new String[2];
        if (idFk.equalsIgnoreCase("KF001")) {
            data[0] = "FTI";

            if (idPr.equalsIgnoreCase("KP001")) {
                data[1] = "Informatika";
            } else if (idPr.equalsIgnoreCase("KP002")) {
                data[1] = "Sistem Informasi";
            }
        } else if (idFk.equalsIgnoreCase("KF002")) {
            data[0] = "FISIP";

            if (idPr.equalsIgnoreCase("KP003")) {
                data[1] = "Hubungan Internasional";
            } else if (idPr.equalsIgnoreCase("KP004")) {
                data[1] = "Sosiologi";
            }
        } else if (idFk.equalsIgnoreCase("KF003")) {
            data[0] = "FTM";

            if (idPr.equalsIgnoreCase("KP005")) {
                data[1] = "Pertambangan";
            } else if (idPr.equalsIgnoreCase("KP006")) {
                data[1] = "Perminyakan";
            }
        }
        return data;
    }
    
    public String[] setIDFakultasProdi(String fakultas, String prodi){
        
        String data[] = new String[2];
    if(fakultas.equalsIgnoreCase("FTI")){
        data[0] = "KF001";
        
        if(prodi.equalsIgnoreCase("Informatika")){
        data[1] = "KP001";
        }
        else if(prodi.equalsIgnoreCase("Sistem Informasi")){
        data[1] = "KP002";
        }
    }else if(fakultas.equalsIgnoreCase("FISIP")){
        data[0] = "KF002";
        
        if(prodi.equalsIgnoreCase("Hubungan Internasional")){
        data[1] = "KP003";
        }
        else if(prodi.equalsIgnoreCase("Sosiologi")){
        data[1] = "KP004";
        }
    }else if(fakultas.equalsIgnoreCase("FTM")){
        data[0] = "KF003";
        
        if(prodi.equalsIgnoreCase("Pertambangan")){
        data[1] = "KP005";
        }
        else if(prodi.equalsIgnoreCase("Perminyakan")){
        data[1] = "KP006";
        }
    }
    return data;
    }
    
    public void updateData(String nim,String nama, String alamat, String idFk, String idPr, String cariNIM){
     try{
        stmt = conn.createStatement();
        
        int update = stmt.executeUpdate("UPDATE mahasiswa SET nim = '" + nim + "', " 
                + "namaMahasiswa = '" + nama + "', "
                + "alamat = '" + alamat + "', "
                + "kodeFk = '" + idFk + "', "
                + "kodePr = '" + idPr + "'" 
                + " WHERE nim = '" + cariNIM + "'");   
        
        if (update == 1) {
            JOptionPane.showMessageDialog(null, "Data Diubah");
        }
        
    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error 2: " + ex.getMessage());
    }
    
    }
    
    public void hapusMahasiswa(String nim) {
        try {
            stmt = conn.createStatement();

            int delete = stmt.executeUpdate("DELETE FROM mahasiswa WHERE nim='" + nim + "'");

            if (delete == 1) {
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error 2: " + ex.getMessage());
        }

    }
    
}
