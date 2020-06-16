/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Asus
 */
public class participants {
   private int idpart;
    private int ide_client;
private String name;
 private String lastname;
 private int numero_tel;

    public participants(int idpart, int ide_client, String name, String lastname, int numero_tel) {
        this.idpart = idpart;
        this.ide_client = ide_client;
        this.name = name;
        this.lastname = lastname;
        this.numero_tel = numero_tel;
    }

    public participants(int ide_client, String name, String lastname, int numero_tel) {
        this.ide_client = ide_client;
        this.name = name;
        this.lastname = lastname;
        this.numero_tel = numero_tel;
    }
    

    public participants(int aInt, String string, int aInt0, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdpart() {
        return idpart;
    }

    public void setIdpart(int idpart) {
        this.idpart = idpart;
    }

    public int getIde_client() {
        return ide_client;
    }

    public void setIde_client(int ide_client) {
        this.ide_client = ide_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(int numero_tel) {
        this.numero_tel = numero_tel;
    }

    @Override
    public String toString() {
        return "participants{" + "idpart=" + idpart + ", ide_client=" + ide_client + ", name=" + name + ", lastname=" + lastname + ", numero_tel=" + numero_tel + '}';
    }
    
   
   
}
