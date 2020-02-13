/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Result;
import Models.ResultOperationDB;
import Models.User;
import Repositories.UserRepository;
import java.sql.SQLException;

/**
 *
 * @author Juan Cruz
 */
public class UserController {
    
    public static boolean Auth(String username, String password) throws SQLException
    {
        UserRepository Repository = new UserRepository();
        
        return Repository.Auth(username, password);
    }
    
    public static Result Create(String username, String password, String name, String surname, String email) throws SQLException
    {
        Result Response = new Result();
        UserRepository Repository = new UserRepository();
        
        ResultOperationDB DBResult = Repository.Create(username, password, name, surname, email);
        
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
    
    public static Result Update(String username, String email, String name, String surname, String description) throws SQLException
    {
        Result Response = new Result();
        UserRepository Repository = new UserRepository();
        
        ResultOperationDB DBResult = Repository.Update(username, email, name, surname, description);
        
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
        UserRepository Repository = new UserRepository();
        
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
    
    public static User Get(String username) throws SQLException
    {
        UserRepository Repository = new UserRepository();
        
        return Repository.Get(username);
    }
    
}
