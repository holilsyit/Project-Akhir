/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import javax.swing.JOptionPane;
import java.sql.*;
/**
 *Driver class	com.mysql.cj.jdbc.Driver
 * @author NANANG TRI HANDOYO
 */
public class Config {
    Connection conn;
    
    public Config(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pbo", "root", "");
        } 
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }  
    
    public Connection getConnection(){
    return conn;
    }


}
  



