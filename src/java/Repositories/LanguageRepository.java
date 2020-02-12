/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Lenguage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LanguageRepository extends BaseRepository {
    
    public void Create(Lenguage Len)
    {
        PreparedStatement pst  = null;
        
        try{
            String consulta = "INSERT INTO lenguaje(name, path) VALUES(?, ?)";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString((1), Len.getName());
            pst.setString((2), Len.getPath());
            
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
    
    public void Update(String name, String path, int id)
    {
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try { 
            String query = "UPDATE lenguaje SET name = ? , path = ? WHERE id = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), name);
            pst.setString((2), path);
            pst.setInt((3), id);
            
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
    
    public Lenguage Get(int id, boolean closeConexion){
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
            System.err.println("ERROR: "+e);
        }
        finally{
            try{
                if(closeConexion)
                {
                    if(getConexion() != null) getConexion().close();
                }
                
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            }
            catch(SQLException e){
                System.err.println("ERROR: "+e);    
            }
        }
        
        return null;
    } 
    
    public void Delete(int id) throws SQLException
    {
        String query = "DELETE FROM lenguaje WHERE id = ?";
            
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), id);
        
        pst.executeUpdate();
    }
    
    public ArrayList<Lenguage> GetAll() throws SQLException
    {
        ArrayList<Lenguage> Response = new ArrayList<>();
        
        String query = "SELECT * FROM lenguaje";
        
        PreparedStatement pst = getConexion().prepareStatement(query);
        
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
   
}
