/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projek_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN10
 */
public class ControllerLogin {

    public ControllerLogin(Login login,ModelLogin ML) {
        login.getButtonLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = login.getTxt_user().getText();
                String password = login.getTxt_pass().getText();
                
                if(ML.isAdmin(username, password)){
                    String nama= ML.getNama(username);
                    JOptionPane.showMessageDialog(null, "Selamat Datang '" + nama + "'!");
                    login.setVisible(false);
                    //new Menu().setVisible(true);
                    new ControllerMenu(new Menu());
                    }
                
                else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
            }
        });
        
        
    }
    
}
