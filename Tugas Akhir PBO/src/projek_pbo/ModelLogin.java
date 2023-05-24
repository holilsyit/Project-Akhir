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
public class ModelLogin extends Config{
    
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Config koneksi;
    
    public boolean isAdmin(String username, String password){
        String sql = "SELECT * FROM admin WHERE username = '" + username + "'AND password = '" + password +"'";
    try{
        
        koneksi = new Config();
        conn = koneksi.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        if(rs.next()){
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                return true;
            }
       }else{
            return false;
        }
    }catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
    return false;
    }
    
    public String getNama(String username){
        String sql = "SELECT nama FROM admin WHERE username = '" + username + "'";
        
        String data=null;
        try{
        
        koneksi = new Config();
        conn = koneksi.getConnection();
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
            data=rs.getString("nama");
        }
        return data;
        
    }catch (SQLException e){
    JOptionPane.showMessageDialog(null, e);
    }
        return data;
    }
}
