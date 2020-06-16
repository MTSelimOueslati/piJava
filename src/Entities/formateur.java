/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Hajer
 */
public class formateur {
    private int idf;
    private String namef;
    private String lastnamef;
    private String email;

    public formateur(int idf, String namef, String lastnamef, String email) {
        this.idf = idf;
        this.namef = namef;
        this.lastnamef = lastnamef;
        this.email = email;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getNamef() {
        return namef;
    }

    public void setNamef(String namef) {
        this.namef = namef;
    }

    public String getLastnamef() {
        return lastnamef;
    }

    public void setLastnamef(String lastnamef) {
        this.lastnamef = lastnamef;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
