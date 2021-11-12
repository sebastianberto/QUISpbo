/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DatabaseController;
import static controller.DatabaseController.registrasi;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.User;

/**
 *
 * @author Sebastian Berto
 */
public class RegisterScreen extends JFrame implements ActionListener {
    JFrame frame = new JFrame();
    JLabel labeljudul;
    JTextField emailfield,namafield;
    JPasswordField passwordfield;
    JComboBox kategori1,kategori2;
    JButton confrim,reset;
    
    public RegisterScreen(){
        frame.setSize(1000,80);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        labeljudul = new JLabel("Layar Registrasi");
        labeljudul.setBounds(400,30,400,30);
        labeljudul.setFont(new Font(labeljudul.getFont().getName(), labeljudul.getFont().getStyle(), 28));
        
        emailfield = new JTextField("Email");
        namafield = new JTextField("Nama");
        
        emailfield.setBounds(600,120,300,30);
        namafield.setBounds(600,160,300,30);
        
        passwordfield = new JPasswordField("Password");
        passwordfield.setBounds(600,200,300,30);
        kategori1 = new JComboBox();
        kategori1.setBounds(600,240,300,30);
        
        confrim = new JButton("Confrim");
        reset = new JButton("Reset");
        confrim.setBounds(250,40,300,30);
        reset.setBounds(250,60,300,30);
        confrim.addActionListener(this);
        reset.addActionListener(this);
        
        
        frame.add(labeljudul);
        frame.add(confrim);
        frame.add(reset);
        frame.add(emailfield);
        frame.add(namafield);
        frame.add(passwordfield);
        frame.setLayout(null);
        frame.setVisible(true);  
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       String command = ae.getActionCommand();
       switch(command){
           case "Confrim":
               String nama = namafield.getText();
               String email = emailfield.getText();
               String password = passwordfield.getText();
               ArrayList<User> listuser = DatabaseController.GetAllUser();
               if(email.equals("") && password.equals("")){
                   JOptionPane.showMessageDialog(null, "Data Kosong silahkan isi");
                   break;
               }else{
                   if(DatabaseController.registrasi(nama, email, password)){
                       JOptionPane.showMessageDialog(null,"Registrasi berhasil");
                       new MainMenu();
                       break;
                   }
               }
            case"Reset":
                new RegisterScreen();
                break;
            default:
                break;
       }
    }
    
}
