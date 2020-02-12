/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juan Cruz
 */
public class UserRepository extends BaseRepository {
    
    public boolean Auth(String userName, String password){
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try{
            String consulta = "SELECT * FROM usuario WHERE username = ? AND password = ?";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, userName);
            pst.setString(2, password);
            
            
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
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
        
        return false;
    }
    
    public boolean Create(String userName, String password, String name, String surname, String email){
        PreparedStatement pst  = null;
        
        try{
            String consulta = "INSERT INTO usuario(username,password,name,surname,email) VALUES(?,?,?,?,?)";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString((1), userName);
            pst.setString((2), password);
            pst.setString((3), name);
            pst.setString((4), surname);
            pst.setString((5), email);
            
            if(pst.executeUpdate() == 1){
                return true;
            }
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
        
        return false;
    }
    
    public boolean Update(String userName, String email, String name, String surname, String description){
        PreparedStatement pst  = null;
        PreparedStatement pstUser  = null;
        ResultSet rs = null;
        
        try{ 
            String query = "UPDATE usuario SET name = ? , surname = ? , email = ? ,  description = ? WHERE username = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), name);
            pst.setString((2), surname);
            pst.setString((3), email);
            pst.setString((4), description);
            pst.setString((5), userName);
            
            if(pst.executeUpdate() == 1){
                return true;
            }
        }
        catch(SQLException e){
            System.err.println("ERROR: "+e);
        }
        finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(pstUser != null) pstUser.close();
                if(rs != null) rs.close();
            }
            catch(SQLException e){
                System.err.println("ERROR: "+e);    
            }
        }
        
        return false;
    }
    
    public User Get(String userName){
        PreparedStatement pst  = null;
        ResultSet rs = null;
        User Response = null;
        
        try {
            String query = "SELECT * FROM usuario where username = ?";
            
            pst = getConexion().prepareStatement(query);
            pst.setString((1), userName);
            
            rs = pst.executeQuery();
            
            Response = new User(rs);
            
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
    
    public void Delete(int id) throws SQLException
    {
        String query = "DELETE FROM usuario WHERE id = ?";
            
        PreparedStatement pst = getConexion().prepareStatement(query);
        pst.setInt((1), id);
        
        pst.executeUpdate();
    }
    
}
