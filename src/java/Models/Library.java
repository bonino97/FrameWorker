/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Juan Cruz
 */
public class Library {
    private int id;
    private String name;
    private Lenguage lenguage;

    public Lenguage getLenguage() {
        return lenguage;
    }

    public void setLenguage(Lenguage lenguage) {
        this.lenguage = lenguage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
