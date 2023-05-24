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
public class ControllerArsip {

    public ControllerArsip(Arsip arsip, ModelArsip MA) {

        arsip.getBtn_cari().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cariNIM = arsip.getTxt_nimCari().getText();
//                System.out.println(cariNIM);

                String data[] = MA.cariMahasiswa(cariNIM);
//                System.out.println(data[0]);
//                System.out.println(data[1]);

                String dataFP[] = MA.setNamaFakultasProdi(data[3], data[4]);
//                System.out.println(dataFP[0]);
//                System.out.println(dataFP[1]);

                arsip.getTxt_nim().setText(data[1]);
                arsip.getTxt_nama().setText(data[0]);
                arsip.getTxt_alamat().setText(data[2]);
                arsip.getCombo_fk().setSelectedItem(dataFP[0]);
                arsip.getCombo_pr().setSelectedItem(dataFP[1]);
            }
        });

        arsip.getCombo_fk().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (arsip.getCombo_fk().getSelectedItem().toString().equalsIgnoreCase("FTI")) {
                    arsip.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Informatika", "Sistem Informasi"}));
                } else if (arsip.getCombo_fk().getSelectedItem().toString().equalsIgnoreCase("FISIP")) {
                    arsip.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Hubungan Internasional", "Sosiologi"}));
                } else if (arsip.getCombo_fk().getSelectedItem().toString().equalsIgnoreCase("FTM")) {
                    arsip.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Perminyakan", "Pertambangan"}));
                } else {
                    arsip.getCombo_pr().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
                }
            }
        });

        arsip.getBtn_ubh().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cariNIM = arsip.getTxt_nimCari().getText();
                String nim = arsip.getTxt_nim().getText();
                String nama = arsip.getTxt_nama().getText();
                String alamat = arsip.getTxt_alamat().getText();
                String fakultas = arsip.getCombo_fk().getSelectedItem().toString();
                String prodi = arsip.getCombo_pr().getSelectedItem().toString();

                String dataFP[] = MA.setIDFakultasProdi(fakultas, prodi);
                MA.updateData(nim, nama, alamat, dataFP[0], dataFP[1], cariNIM);
            }
        });

        arsip.getBtn_hps().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nim = arsip.getTxt_nim().getText();

                MA.hapusMahasiswa(nim);

                arsip.getTxt_nimCari().setText("");
                arsip.getTxt_nim().setText("");
                arsip.getTxt_nama().setText("");
                arsip.getTxt_alamat().setText("");
                arsip.getCombo_fk().setSelectedIndex(0);
                arsip.getCombo_pr().setSelectedIndex(0);

            }
        });

        arsip.getjMenuItemIsi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arsip.dispose();
                new ControllerData(new Data(), new ModelData());
            }
        });
        arsip.getjMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arsip.dispose();
                new ControllerLogin(new Login(), new ModelLogin());
            }
        });
        arsip.getjMenuItemExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arsip.dispose();
                arsip.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        arsip.getjMenuItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arsip.dispose();
                new ControllerCetak(new Cetak(), new ModelCetak());
            }
        });

    }
}
