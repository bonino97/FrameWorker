/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Lenguage;
import Repositories.LanguageRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LanguageController {
    
    public static Lenguage Get(int id)
    {
        LanguageRepository Repository = new LanguageRepository();
    
        return Repository.Get(id, true);
    }
    
    public static ArrayList<Lenguage> GetAll() throws SQLException
    {
        LanguageRepository Repository = new LanguageRepository();
        
        return Repository.GetAll();
    }
    
    public static void Create(Lenguage Len)
    {
        LanguageRepository Repository = new LanguageRepository();
        
        Repository.Create(Len);
    }
    
    public static void Update(String name, String path, int id)
    {   
        LanguageRepository Repository = new LanguageRepository();

        Repository.Update(name, path, id);
    }
    
    public static void Delete(int id) throws SQLException
    {
        LanguageRepository Repository = new LanguageRepository();
        
        Repository.Delete(id);
    }
    
}
