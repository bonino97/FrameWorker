/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Library;
import Repositories.LibraryProjectRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryProjectController {
    
    public static void Add(int idProj, int idLen) throws SQLException
    {
        LibraryProjectRepository Repository = new LibraryProjectRepository();
        
        Repository.Add(idProj, idLen);
    }
    
    public static void Delete(int idProj, int idLib) throws SQLException
    {   
        LibraryProjectRepository Repository = new LibraryProjectRepository();

        Repository.Delete(idProj, idLib);
    }
    
}
