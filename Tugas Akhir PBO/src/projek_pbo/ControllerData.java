/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projek_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;

/**
 *
 * @author WIN10
 */
public class ControllerData {

    String nim, nama, alamat, fakultas, prodi;
    String idFk = null;
    String idPr = null;
    
    public ControllerData(Data data, ModelData MD) {
        data.getBtn_submit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nim = data.getTxt_nim().getText();
                nama = data.getTxt_nama().getText();
                alamat = data.getTxt_alamat().getText();
                fakultas = data.getCombo_fk().getSelectedItem().toString();
                prodi = data.getCombo_pr().getSelectedItem().toString();

                String dataFP[] = MD.setIDFakultasProdi(fakultas, prodi);
                idFk = dataFP[0];
                idPr = dataFP[1];

                MD.insertData(nim, nama, alamat, idFk, idPr);

                data.getTxt_nim().setText("");
                data.getTxt_nama().setText("");
                data.getTxt_alamat().setText("");
                data.getCombo_fk().setSelectedIndex(0);
                data.getCombo_pr().setSelectedIndex(0);

            }
        });
        
        data.getCombo_fk().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (data.getCombo_fk().getSelectedItem().toString().equalsIgnoreCase("FTI")) {
                    data.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Informatika", "Sistem Informasi"}));
                } else if (data.getCombo_fk().getSelectedItem().toString().equalsIgnoreCase("FISIP")) {
                    data.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Hubungan Internasional", "Sosiologi"}));
                } else if (data.getCombo_fk().getSelectedItem().toString().equalsIgnoreCase("FTM")) {
                    data.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Perminyakan", "Pertambangan"}));
                } else {
                    data.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
                }
            }
        });
        
        
        data.getjMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.dispose();
                new ControllerLogin(new Login(),new ModelLogin()); 
            }
          
        });
        
        data.getjMenuItemExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.dispose();
                data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        
        data.getjMenuItemArsip().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.dispose();
                new ControllerArsip(new Arsip(), new ModelArsip());
                
            }
        });
        
        data.getjMenuItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.dispose();
                new ControllerCetak(new Cetak(), new ModelCetak());
            }
        });

    }

}
