/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projek_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WIN10
 */
public class ControllerCetak {

    String data[][];

    public ControllerCetak(Cetak cetak, ModelCetak MC) {
        data = MC.tampilTabel();
        cetak.getjTabel().setModel(new DefaultTableModel(data, new String[]{
            "NIM", "Nama Mahasiswa", "Alamat", "Fakultas", "Prodi"
        }));

        cetak.getBtn_cetak().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageFormat header = new MessageFormat("Data Mahasiswa");

                MessageFormat footer = new MessageFormat("Data Mahasiswa Universitas YU Pi EN | Page {0,number,integer}");
                try {
                    cetak.getjTabel().print(JTable.PrintMode.FIT_WIDTH, header, footer);
                } catch (java.awt.print.PrinterException pe) {
                    System.err.format("Cannot print $s%n", pe.getMessage());
                }

            }
        });
        
        
        cetak.getjMenuItemArsip().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetak.dispose();
                new ControllerArsip(new Arsip(), new ModelArsip());
            }
        });
        cetak.getjMenuItemIsi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetak.dispose();
                new ControllerData(new Data(), new ModelData());
            }
        });
        cetak.getjMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetak.dispose();
                new ControllerLogin(new Login(), new ModelLogin());
            }
        });
        cetak.getjMenuItemExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cetak.dispose();
                cetak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }

}
