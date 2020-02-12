/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class Project {
    
    private int code;
    private String name;
    private String description;
    private Lenguage lenguage;
    private ArrayList<Library> Libraries;

    public ArrayList<Library> getLibraries() {
        return Libraries;
    }

    public void setLibraries(ArrayList<Library> Libraries) {
        this.Libraries = Libraries;
    }

    public Lenguage getLenguage() {
        return lenguage;
    }

    public void setLenguage(Lenguage lenguage) {
        this.lenguage = lenguage;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
