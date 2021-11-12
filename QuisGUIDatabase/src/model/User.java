/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sebastian Berto
 */
public class User {
    private int id;
    private String nama;
    private String email;
    private String password;
    private int idCategory;

    public User(){
    
    }

    public User(int id, String nama, String email, String password, int idCategory) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    
    @Override
    public String toString() {
        return "nama(" + "Nama=" + nama + "email(" + "Email=" + email + "passowrd(" + "Password=" + password + "idCategory(" + "IdCategory=" + idCategory + ')'; 
    }
            
    
    
}
