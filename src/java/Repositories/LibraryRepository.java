/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Library;
import Models.Project;
import Models.ResultOperationDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryRepository extends BaseRepository {
    
    public ResultOperationDB Create(Library Lib) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst  = null;
        
        try{
            String consulta = "INSERT INTO libreria(name, idLenguaje) VALUES(?, ?)";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString((1), Lib.getName());
            pst.setInt((2), Lib.getLenguage().getId());
            
            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error creando la librearia, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error creando la librearia, por favor, reintente.");
        }
        catch(Exception e)
        {
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error creando la librearia, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
        
        return Response;
    }
    
    public ResultOperationDB Delete(int id) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst  = null;
        
        try{
            String query = "DELETE FROM libreria WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), id);
            
            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error eliminando la librearia, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error eliminando la librearia, por favor, reintente.");
        }
        catch(Exception e)
        {
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error eliminando la librearia, por favor, reintente.");
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
        }
        
        return Response;
    }
    
    public Library Get(int id) throws SQLException{
        LanguageRepository LanRepository = null;
        PreparedStatement pst  = null;
        ResultSet rs = null;
        Library Response = new Library();
        
        try {
            String query = "SELECT * FROM libreria WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), id);
            
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                LanRepository = new LanguageRepository();
                
                Response.setId(rs.getInt("id"));
                Response.setName(rs.getString("name"));
                Response.setLenguage(LanRepository.Get(rs.getInt("idLenguaje"), false));
            }
            
            return Response;
        }
        catch(SQLException e){
            return null;
        }
        catch(Exception ex)
        {
            return null;
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
            if(rs != null) rs.close();
        }
    } 
    
    
  
  public ArrayList<Library> GetAll() throws SQLException
  {
        LanguageRepository LanRepository = null;
        ArrayList<Library> Response = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String query = "SELECT * FROM libreria";
        
            pst = getConexion().prepareStatement(query);        

            rs = pst.executeQuery();

            while (rs.next()) {
                LanRepository = new LanguageRepository();

                Library lib = new Library();
                lib.setId(rs.getInt("id"));
                lib.setName(rs.getString("name"));
                lib.setLenguage(LanRepository.Get(rs.getInt("idLenguaje"), false));

                Response.add(lib);
            }

            return Response;
        }
        catch(SQLException e){
            return null;
        }
        catch(Exception ex)
        {
            return null;
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
            if(rs != null) rs.close();
        }
    }
    
    public ArrayList<Library> GetAll(Project Proj) throws SQLException
    {
        LanguageRepository LanRepository = null;
        ArrayList<Library> Response = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String query = "SELECT * " + 
                           "FROM libreria " + 
                           "WHERE idLenguaje = ? " +
                           "AND id NOT IN (SELECT idLibreria FROM proyectolibreria WHERE idProyecto = ?)";

            pst = getConexion().prepareStatement(query);    
            pst.setInt((1), Proj.getLenguage().getId());
            pst.setInt((2), Proj.getCode());

            rs = pst.executeQuery();

            while (rs.next()) {
                LanRepository = new LanguageRepository();

                Library lib = new Library();
                lib.setId(rs.getInt("id"));
                lib.setName(rs.getString("name"));
                lib.setLenguage(LanRepository.Get(rs.getInt("idLenguaje"), false));

                Response.add(lib);
            }

            return Response;
        }
         catch(SQLException e){
            return null;
        }
        catch(Exception ex)
        {
            return null;
        }
        finally {
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
            if(rs != null) rs.close();
        }
    }
    
    
    public ResultOperationDB Update(String name, int id) throws SQLException
    {
        ResultOperationDB Response = new ResultOperationDB();
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try{ 
            String query = "UPDATE libreria SET name = ? WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), name);
            pst.setInt((2), id);
            
            if(pst.executeUpdate() == 1)
            {
                Response.setResult(ResultOperationDB.Results.OK);
            }
            else
            {
                Response.setResult(ResultOperationDB.Results.Error);
                Response.setMessage("Hubo un error actualizando la librearia, por favor, reintente.");
            }
        }
        catch(SQLException e){
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error actualizando la librearia, por favor, reintente.");
        }
        catch(Exception ex)
        {
            Response.setResult(ResultOperationDB.Results.Error);
            Response.setMessage("Hubo un error actualizando la librearia, por favor, reintente.");
        }
        finally{
            if(getConexion() != null) getConexion().close();
            if(pst != null) pst.close();
            if(rs != null) rs.close();
        }
        
        return Response;
    }
}
