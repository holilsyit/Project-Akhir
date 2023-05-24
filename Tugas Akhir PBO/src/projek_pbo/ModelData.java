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
public class ModelData extends Config {
    
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Config koneksi;
    
    
        
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
    
    
    public boolean insertData(String nim,String nama,String alamat,String idFk,String idPr){
    try{
        
        koneksi = new Config();
        conn = koneksi.getConnection();
        stmt = conn.createStatement();
        
        int insert = stmt.executeUpdate("INSERT INTO mahasiswa(nim, namaMahasiswa, alamat, kodeFk, kodePr) VALUES ('" + nim + "','" + nama + "','" + alamat + "','" + idFk + "','" + idPr + "')");
        
        if (insert == 1) {
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }return true;
    }catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "error : " + ex.getMessage());
    }return false;
       
    }
    
    
}
