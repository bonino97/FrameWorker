/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Library;
import Models.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryRepository extends BaseRepository {
    
    public void Create(Library Lib)
    {
        PreparedStatement pst  = null;
        
        try{
            String consulta = "INSERT INTO libreria(name, idLenguaje) VALUES(?, ?)";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString((1), Lib.getName());
            pst.setInt((2), Lib.getLenguage().getId());
            
            pst.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("ERROR: "+e);
        }
        finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }
            catch(SQLException e){
                System.err.println("ERROR: "+e);    
            }
        }
    }
    
    public void Delete(int id) throws SQLException
    {
        String query = "DELETE FROM libreria WHERE id = ?";
            
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), id);
        
        pst.executeUpdate();
    }
    
    public Library Get(int id){
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
        catch(Exception e){
            System.err.println("ERROR: "+e);
        }
        finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }
            catch(Exception e){
                System.err.println("ERROR: "+e);    
            }
        }
        
        return null;
    } 
    
    
   public ArrayList<Library> GetAll() throws SQLException
  {
        LanguageRepository LanRepository = null;
        ArrayList<Library> Response = new ArrayList<>();
        
        String query = "SELECT * FROM libreria";
        
        PreparedStatement pst = getConexion().prepareStatement(query);        
        
        ResultSet rs = pst.executeQuery();
        
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
    
    public ArrayList<Library> GetAll(Project Proj) throws SQLException
    {
        LanguageRepository LanRepository = null;
        ArrayList<Library> Response = new ArrayList<>();
        
        String query = "SELECT * " + 
                       "FROM libreria " + 
                       "WHERE idLenguaje = ? " +
                       "AND id NOT IN (SELECT idLibreria FROM proyectolibreria WHERE idProyecto = ?)";
        
        PreparedStatement pst = getConexion().prepareStatement(query);    
        pst.setInt((1), Proj.getLenguage().getId());
        pst.setInt((2), Proj.getCode());
        
        ResultSet rs = pst.executeQuery();
        
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
    
    
    public void Update(String name, int id)
    {
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try{ 
            String query = "UPDATE libreria SET name = ? WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), name);
            pst.setInt((2), id);
            
            pst.executeUpdate();
        }
        catch(SQLException e){
            System.err.println("ERROR: "+e);
        }
        finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }
            catch(SQLException e){
                System.err.println("ERROR: "+e);    
            }
        }
    }
}
