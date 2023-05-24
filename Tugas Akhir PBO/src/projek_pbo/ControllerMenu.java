/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projek_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author WIN10
 */
public class ControllerMenu {

    public ControllerMenu(Menu menu) {
        menu.getjMenuItemLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                new ControllerLogin(new Login(),new ModelLogin()); 
            }
          
        });
        
        menu.getjMenuItemExit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        menu.getjMenuItemIsi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                new ControllerData(new Data(), new ModelData());
            }
        });
        
        menu.getjMenuItemArsip().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                new ControllerArsip(new Arsip(), new ModelArsip());
                
            }
        });
        
        menu.getjMenuItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.dispose();
                new ControllerCetak(new Cetak(), new ModelCetak());
            }
        });
        
    }
    
}
