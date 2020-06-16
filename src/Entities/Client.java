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
public class Client {
    private int id_client;
    private String name;
    private String lastname;
    private int numero_tel;

    public Client(int id_client, String name, String lastname, int numero_tel) {
        this.id_client = id_client;
        this.name = name;
        this.lastname = lastname;
        this.numero_tel = numero_tel;
    }

    public Client(int id_client, String name, String lastname) {
        this.id_client = id_client;
        this.name = name;
        this.lastname = lastname;
    }
    

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
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
        return "Client{" + "id_client=" + id_client + ", name=" + name + ", lastname=" + lastname + ", numero_tel=" + numero_tel + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
