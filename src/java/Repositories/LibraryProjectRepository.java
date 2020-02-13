/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Library;
import Models.ResultOperationDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryProjectRepository extends BaseRepository {
    
    public ArrayList<Library> Get(int codProj, boolean closeConexion) throws SQLException        
    {
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Library> Response = new ArrayList<>();
        
        String query = "SELECT lib.id, lib.name FROM proyectolibreria plib " +
                       "    INNER JOIN libreria lib ON plib.idLibreria = lib.id " +
                       "WHERE plib.idProyecto = ?";
        
        try{ 
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), codProj);
            
            rs = pst.executeQuery();

            while (rs.next()) {
                Library lib = new Library();
                lib.setId(rs.getInt("id"));
                lib.setName(rs.getString("name"));

                Response.add(lib);
            }

            return Response;
        }
        catch(SQLException e){
            return null;
        }
        catch(Exception e){
            return null;
        }
        finally {
            if(closeConexion)
            {
                if(getConexion() != null) getConexion().close();
            }

            if(pst != null) pst.close();
            if(rs != null) rs.close();
        }
    }
    
    public ResultOperationDB Delete(int idProj, int idLib) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst = null;
        
        try
        {
            String query = "DELETE FROM proyectolibreria WHERE idProyecto = ? AND idLibreria = ?";

            pst = getConexion().prepareStatement(query);
            pst.setInt((1), idProj);
            pst.setInt((2), idLib);

            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error eliminando la libreria del proyecto, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error eliminando la libreria del proyecto, por favor, reintente.");
        }
        catch(Exception e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error eliminando la libreria del proyecto, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
        
        return Response;
    }
     
    public ResultOperationDB Add(int idProj, int idLib) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst = null;
        
        try
        {
            String query = "INSERT INTO proyectolibreria (idProyecto, idLibreria) VALUES(?, ?)";
            
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), idProj);
            pst.setInt((2), idLib);

            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error añadiendo la libreria al proyecto, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error añadiendo la libreria al proyecto, por favor, reintente.");
        }
        catch(Exception e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error añadiendo la libreria al proyecto, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
        
        return Response;
    }
}
