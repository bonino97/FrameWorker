/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Project;
import Models.Result;
import Models.ResultOperationDB;
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
    
    public static Project Get(int code) throws SQLException
    {
        ProjectRepository Repository = new ProjectRepository();
        
        return Repository.Get(code);
    }
    
    public static Result Create(Project proj, Integer userId) throws SQLException
    {
        Result Response = new Result();
        
        ProjectRepository Repository = new ProjectRepository();
        
        ResultOperationDB DBResult = Repository.Create(proj, userId);
        
        if(DBResult.getResult() == ResultOperationDB.Results.OK)
        {
            Response.setResult(Result.Results.OK);
        }
        else
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage(DBResult.getMessage());
        }
        
        return Response;
    }
    
    public static Result Update(String name, String description, int code) throws SQLException
    {
        Result Response = new Result();
        
        ProjectRepository Repository = new ProjectRepository();
    
        ResultOperationDB DBResult = Repository.Update(name, description, code);
        
        if(DBResult.getResult() == ResultOperationDB.Results.OK)
        {
            Response.setResult(Result.Results.OK);
        }
        else
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage(DBResult.getMessage());
        }
        
        return Response;
    }
    
    public static Result Delete(int code) throws SQLException
    {
        Result Response = new Result();
        
        ProjectRepository Repository = new ProjectRepository();   
    
        ResultOperationDB DBResult = Repository.Delete(code);
        
        if(DBResult.getResult() == ResultOperationDB.Results.OK)
        {
            Response.setResult(Result.Results.OK);
        }
        else
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage(DBResult.getMessage());
        }
        
        return Response;
    }
}
