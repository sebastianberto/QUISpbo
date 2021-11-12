/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Compiler.command;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author Sebastian Berto
 */
public class MainMenu implements ActionListener{
    JLabel JlabelJudul;
    JButton registerbutton, loginbutton, cekdatapengguna;

    DatabaseController controller = new DatabaseController();
    JFrame frame = new JFrame();
    
    public MainMenu(){
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JlabelJudul = new JLabel("Main Menu");
        JlabelJudul.setBounds(400,30,400,30);
        JlabelJudul.setFont(new Font(JlabelJudul.getFont().getName(), JlabelJudul.getFont().getStyle(), 28));
        
        registerbutton = new JButton("Register");
        registerbutton.setBounds(200,200,300,30);
        registerbutton.addActionListener(this);
        loginbutton = new JButton("Login");
        loginbutton.setBounds(200,240,300,30);
        loginbutton.addActionListener(this);
        cekdatapengguna = new JButton("Cek Data Pengguna");
        cekdatapengguna.setBounds(200,280,300,30);
        cekdatapengguna.addActionListener(this);
        
        frame.add(JlabelJudul);
        frame.add(registerbutton);
        frame.add(loginbutton);
        frame.add(cekdatapengguna);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       String command = ae.getActionCommand();
       switch(command){
            case "Register":
                frame.setVisible(false);
                new RegisterScreen();
                break;
            case "Login":
                frame.setVisible(false);
                new LoginScreen();
                break;
            case "Cek Data Pengguna":
                frame.setVisible(false);
                new DataPengguna();
                break;
       }    
    }
}
