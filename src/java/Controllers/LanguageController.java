/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Lenguage;
import Models.Result;
import Models.ResultOperationDB;
import Repositories.LanguageRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LanguageController {
    
    public static Lenguage Get(int id) throws SQLException
    {
        LanguageRepository Repository = new LanguageRepository();
    
        return Repository.Get(id, true);
    }
    
    public static ArrayList<Lenguage> GetAll() throws SQLException
    {
        LanguageRepository Repository = new LanguageRepository();
        
        return Repository.GetAll();
    }
    
    public static Result Create(Lenguage Len) throws SQLException
    {
        Result Response = new Result();
        
        LanguageRepository Repository = new LanguageRepository();
        
        if(Len.getName().isEmpty())
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage("El nombre no puede ser vació.");
            
            return Response;
        }
        else if(Len.getPath().isEmpty())
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage("La ruta no puede ser vacía.");
            
            return Response;
        }
        
        ResultOperationDB DBResult = Repository.Create(Len);
        
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
    
    public static Result Update(String name, String path, int id) throws SQLException
    {   
        Result Response = new Result();
        
        LanguageRepository Repository = new LanguageRepository();

        if(name.isEmpty())
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage("El nombre no puede ser vació.");
            
            return Response;
        }
        else if(path.isEmpty())
        {
            Response.setResult(Result.Results.Error);
            Response.setMessage("La ruta no puede ser vacía.");
            
            return Response;
        }
        
        ResultOperationDB DBResult = Repository.Update(name, path, id);
        
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
        
        LanguageRepository Repository = new LanguageRepository();
        
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
