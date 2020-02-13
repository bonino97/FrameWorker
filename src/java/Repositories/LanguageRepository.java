/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Lenguage;
import Models.ResultOperationDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LanguageRepository extends BaseRepository {
    
    public ResultOperationDB Create(Lenguage Len) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst  = null;
        
        try{
            String consulta = "INSERT INTO lenguaje(name, path) VALUES(?, ?)";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString((1), Len.getName());
            pst.setString((2), Len.getPath());
            
            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error creando el lenguaje, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error creando el lenguaje, por favor, reintente.");
        }
        catch(Exception ex)
        {
           Response.setResult(ResultOperationDB.Results.Error);
           Response.setMessage("Hubo un error creando el lenguaje, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
        
        return Response;
    }
    
    public ResultOperationDB Update(String name, String path, int id) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try { 
            String query = "UPDATE lenguaje SET name = ? , path = ? WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), name);
            pst.setString((2), path);
            pst.setInt((3), id);
            
            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error actualizando el lenguaje, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error creando el lenguaje, por favor, reintente.");
        }
        catch(Exception ex)
        {
           Response.setResult(ResultOperationDB.Results.Error);
           Response.setMessage("Hubo un error creando el lenguaje, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
            if(rs != null) rs.close();
        }
        
        return Response;
    } 
    
    public Lenguage Get(int id, boolean closeConexion) throws SQLException{
        PreparedStatement pst  = null;
        ResultSet rs = null;
        Lenguage Response = new Lenguage();
        
        try {
            String query = "SELECT * FROM lenguaje WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), id);
            
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                Response.setId(rs.getInt("id"));
                Response.setName(rs.getString("name"));
                Response.setPath(rs.getString("path"));
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
    
    public ResultOperationDB Delete(int id) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst = null;
        
        try
        {
            String query = "DELETE FROM lenguaje WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), id);
        
            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error eliminando el lenguaje, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error eliminando el lenguaje, por favor, reintente.");
        }
        catch(Exception e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error eliminando el lenguaje, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
        
        return Response; 
    }
    
    public ArrayList<Lenguage> GetAll() throws SQLException
    {
        ArrayList<Lenguage> Response = new ArrayList<>();
        PreparedStatement pst = null;
        
        try
        {
            String query = "SELECT * FROM lenguaje";

            pst = getConexion().prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Lenguage leng = new Lenguage();
                leng.setId(rs.getInt("id"));
                leng.setName(rs.getString("name"));
                leng.setPath(rs.getString("path"));

                Response.add(leng);
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
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
    }
   
}
