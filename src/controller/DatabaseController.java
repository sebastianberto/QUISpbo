/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

/**
 *
 * @author Sebastian Berto
 */
public class DatabaseController {
    static DatabaseHandler conn = new DatabaseHandler();
    
    // SELECT ALL FROM USER
    public static ArrayList<User> GetAllUser(){
        ArrayList<User> user = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM user";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User usr = new User();
                usr.setId(rs.getInt("id"));
                usr.setNama(rs.getString("nama"));
                usr.setEmail(rs.getString("email"));
                usr.setPassword(rs.getString("password"));
                usr.setIdCategory(rs.getInt("umur"));
                user.add(usr);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return(user);
    }
    
    public static boolean registrasi(String nama,String email, String password){
        conn.connect();
        String query = "INSERT INTO user VALUES (?,?,?)";
        try{
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, password);
            return(true);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return(false);
    }
    
    public static int GetUserBasedCatgory(String idCategory){
        conn.connect();
        ArrayList<User> user = new ArrayList<>();
        int total = 0;
        String query = "SELECT * FROM user WHERE idCategory = '" + idCategory + "'";
        try{
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User usr = new User();
                usr.setNama(rs.getString("nama"));
                usr.setEmail(rs.getString("email"));
                user.add(usr);
            }
            total = user.size();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return (total);
    }
}
