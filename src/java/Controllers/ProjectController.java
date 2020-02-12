/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Project;
import Repositories.ProjectRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class ProjectController {
    
    public static ArrayList<Project> GetAll(int userId) throws SQLException
    {
        ProjectRepository Repository = new ProjectRepository();
        
        return Repository.GetAll(userId);
    }
    
    public static Project Get(int code)
    {
        ProjectRepository Repository = new ProjectRepository();
        
        return Repository.Get(code);
    }
    
    public static void Create(Project proj, Integer userId)
    {
        ProjectRepository Repository = new ProjectRepository();
        
        Repository.Create(proj, userId);
    }
    
    public static void Update(String name, String description, int code)
    {
        ProjectRepository Repository = new ProjectRepository();
    
        Repository.Update(name, description, code);
    }
    
    public static void Delete(int code) throws SQLException
    {
        ProjectRepository Repository = new ProjectRepository();   
    
        Repository.Delete(code);
    }
}
