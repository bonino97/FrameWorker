/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Library;
import Models.Project;
import Models.Result;
import Models.ResultOperationDB;
import Repositories.LibraryRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryController {
    
    public static Library Get(int id) throws SQLException
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
    
    public static Result Create(Library Lib) throws SQLException
    {
        Result Response = new Result();
        
        LibraryRepository Repository = new LibraryRepository();
        
        if(Lib.getName().isEmpty())
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage("El nombre no puede ser vació.");
            
            return Response;
        }
        
        ResultOperationDB DBResult = Repository.Create(Lib);
        
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
    
    public static Result Update(String name, int id) throws SQLException
    {
        Result Response = new Result();
        
        LibraryRepository Repository = new LibraryRepository();
        
        if(name.isEmpty())
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage("El nombre no puede ser vació.");
            
            return Response;
        }
        
        ResultOperationDB DBResult = Repository.Update(name, id);
        
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
    
    public static Result Delete(int id) throws SQLException
    {
        Result Response = new Result();
        
        LibraryRepository Repository = new LibraryRepository();
        
        ResultOperationDB DBResult = Repository.Delete(id);
        
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
