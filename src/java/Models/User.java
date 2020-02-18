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
public class User {
    private int id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String description;
    private boolean isSuperuser;

    public User(ResultSet Resulset, boolean withoutResulsetNext) throws SQLException
    {
        if(!withoutResulsetNext)
        {
            Resulset.next();
        }
        
        id = Resulset.getInt("id");
        username = Resulset.getString("username");
        name = Resulset.getString("name");
        surname = Resulset.getString("surname");
        email = Resulset.getString("email");
        description = Resulset.getString("description");
        isSuperuser = Resulset.getBoolean("isSuperuser");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        if(description == null)
        {
            return "-";
        }
        
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }
}
