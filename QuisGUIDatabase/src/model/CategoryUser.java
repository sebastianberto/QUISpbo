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
public class CategoryUser {
    private int idCategory;
    private String nama;

    public CategoryUser(){
        
    }
    public CategoryUser(int idCategory, String nama) {
        this.idCategory = idCategory;
        this.nama = nama;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
}
