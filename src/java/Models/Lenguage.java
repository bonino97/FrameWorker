/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan Cruz
 */
public class Lenguage {
    
    private int id;
    private String name;
    private String path;

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    
}
