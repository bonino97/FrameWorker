/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.Library;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juan Cruz
 */
public class LibraryProjectRepository extends BaseRepository {
    
    public ArrayList<Library> Get(int codProj, boolean closeConexion)        
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
            System.err.println("ERROR: "+e);
            return Response;
        }
        finally{
            try {
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
    }
    
     public void Delete(int idProj, int idLib) throws SQLException
    {
        String query = "DELETE FROM proyectolibreria WHERE idProyecto = ? AND idLibreria = ?";
            
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), idProj);
        pst.setInt((2), idLib);
        
        pst.executeUpdate();
    }
     
    public void Add(int idProj, int idLib) throws SQLException
    {
        String query = "INSERT INTO proyectolibreria (idProyecto, idLibreria) VALUES(?, ?)";
            
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), idProj);
        pst.setInt((2), idLib);
        
        pst.executeUpdate();
    }
}
