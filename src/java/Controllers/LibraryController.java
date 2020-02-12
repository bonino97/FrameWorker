/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Library;
import Models.Project;
import Repositories.LibraryRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryController {
    
    public static Library Get(int id)
    {
        LibraryRepository Repository = new LibraryRepository();
        
        return Repository.Get(id);
    }
    
    public static ArrayList<Library> GetAll() throws SQLException
    {
        LibraryRepository Repository = new LibraryRepository();
    
        return Repository.GetAll();
    }
    
    public static ArrayList<Library> GetAll(Project Proj) throws SQLException
    {
        LibraryRepository Repository = new LibraryRepository();
    
        return Repository.GetAll(Proj);
    }
    
    public static void Create(Library Lib)
    {
        LibraryRepository Repository = new LibraryRepository();
        
        Repository.Create(Lib);
    }
    
    public static void Update(String name, int id)
    {
        LibraryRepository Repository = new LibraryRepository();
        
        Repository.Update(name, id);
    }
    
    public static void Delete(int id) throws SQLException
    {
        LibraryRepository Repository = new LibraryRepository();
        
        Repository.Delete(id);
    }
}
