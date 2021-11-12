/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author Sebastian Berto
 */
public class DatabaseHandler {
    public Connection con;
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/db_quis_pbo?serverTimezone=" + TimeZone.getDefault().getID();
    private String username = "root";
    private String password = "";
    
    private Connection LogOn(){
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, username, password);
        }catch(Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getLocalizedMessage());
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
        return con;
    }
    
    private void LogOff(){
        try{
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error Ocurred when login" + ex);
        }
    }
    
    public void connect() {
        try {
            con = LogOn();
        } catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }
    
    public void disconnect() {
        try {
            LogOff();
        } catch (Exception ex) {
            System.out.println("Error occured when connecting to database");
        }
    }
}
