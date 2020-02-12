/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.User;
import Repositories.UserRepository;
import java.sql.SQLException;

/**
 *
 * @author Juan Cruz
 */
public class UserController {
    
    public static boolean Auth(String username, String password)
    {
        UserRepository Repository = new UserRepository();
        
        return Repository.Auth(username, password);
    }
    
    public static void Create(String username, String password, String name, String surname, String email)
    {
        UserRepository Repository = new UserRepository();
        
        Repository.Create(username, password, name, surname, email);
    }
    
    public static void Update(String username, String email, String name, String surname, String description)
    {
        UserRepository Repository = new UserRepository();
        
        Repository.Update(username, email, name, surname, description);
    }
    
    public static void Delete(int id) throws SQLException
    {
        UserRepository Repository = new UserRepository();
        
        Repository.Delete(id);
    }
    
    public static User Get(String username)
    {
        UserRepository Repository = new UserRepository();
        
        return Repository.Get(username);
    }
    
}
