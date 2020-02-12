/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Lenguage;
import Models.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class ProjectRepository extends BaseRepository {
    
    public void Create(Project Proj, int idUsuario)
    {
        PreparedStatement pst  = null;
        
        try{
            String consulta = "INSERT INTO proyecto(name, descripcion, idLenguaje, idUsuario) VALUES(?, ?, ?, ?)";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString((1), Proj.getName());
            pst.setString((2), Proj.getDescription());
            pst.setInt((3), Proj.getLenguage().getId());
            pst.setInt((4), idUsuario);
            
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
    
    public void Delete(int code) throws SQLException
    {
        String query = "DELETE FROM proyecto WHERE code = ?";
            
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), code);
        
        pst.executeUpdate();
    }
    
    public Project Get(int code){
        LibraryProjectRepository LibProjRepository = null;
        PreparedStatement pst  = null;
        ResultSet rs = null;
        Project Response = new Project();
        
        try {
            String query = "SELECT code, pro.name nameProject, descripcion, len.id idLen, len.name nameLenguage FROM proyecto pro " +
                           "    INNER JOIN lenguaje len ON len.id = pro.idLenguaje " + 
                           " WHERE code = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setInt((1), code);
            
            rs = pst.executeQuery();
            
            if(rs.next())
            {
                LibProjRepository = new LibraryProjectRepository();
                
                Response.setCode(rs.getInt("code"));
                Response.setName(rs.getString("nameProject"));
                Response.setDescription(rs.getString("descripcion"));
                Response.setLibraries(LibProjRepository.Get(Response.getCode(), false));
                
                Lenguage Len = new Lenguage();
                Len.setId(rs.getInt("idLen"));
                Len.setName(rs.getString("nameLenguage"));
                
                Response.setLenguage(Len);
            }
            
            return Response;
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
        
        return null;
    }
    
    public ArrayList<Project> GetAll(int idUsuario) throws SQLException
    {
        LibraryProjectRepository LibProjRepository = null;
        ArrayList<Project> Response = new ArrayList<>();
        
        String query = "SELECT code, pro.name nameProject, descripcion, len.name nameLenguage FROM proyecto pro " +
                       "    INNER JOIN lenguaje len ON len.id = pro.idLenguaje " + 
                       "WHERE idUsuario = ?";
        
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), idUsuario);
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()) {
                LibProjRepository = new LibraryProjectRepository();
            
                Project proj = new Project();
                proj.setCode(rs.getInt("code"));
                proj.setName(rs.getString("nameProject"));
                proj.setDescription(rs.getString("descripcion"));
                proj.setLibraries(LibProjRepository.Get(proj.getCode(), false));
                
                Lenguage len = new Lenguage();
                len.setName(rs.getString("nameLenguage"));
                proj.setLenguage(len);
                
                Response.add(proj);
        }
        
        return Response;
    }
    
    public void Update(String name, String description, int code)
    {
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try{ 
            String query = "UPDATE proyecto SET name = ?, descripcion = ? WHERE code = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), name);
            pst.setString((2), description);
            pst.setInt((3), code);
            
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
