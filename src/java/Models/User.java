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
    public int id;
    public String username;
    public String name;
    public String surname;
    public String email;
    public String description;
    
    public User(ResultSet Resulset) throws SQLException
    {
        if(Resulset.next())
        {
            id = Resulset.getInt("id");
            username = Resulset.getString("username");
            name = Resulset.getString("name");
            surname = Resulset.getString("surname");
            email = Resulset.getString("email");
            description = Resulset.getString("description");
        }
    }
}
