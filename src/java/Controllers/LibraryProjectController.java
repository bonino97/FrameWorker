/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Library;
import Models.Result;
import Models.ResultOperationDB;
import Repositories.LibraryProjectRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryProjectController {
    
    public static Result Add(int idProj, int idLen) throws SQLException
    {
        Result Response = new Result();
     
        LibraryProjectRepository Repository = new LibraryProjectRepository();
        
        ResultOperationDB DBResult = Repository.Add(idProj, idLen);
        
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
    
    public static Result Delete(int idProj, int idLib) throws SQLException
    {   
        Result Response = new Result();
        
        LibraryProjectRepository Repository = new LibraryProjectRepository();

        ResultOperationDB DBResult = Repository.Delete(idProj, idLib);
        
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
