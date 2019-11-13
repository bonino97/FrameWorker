/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Juan Cruz
 */
public class Consultas extends Conexion{
    
    public boolean Autenticacion(String userName, String password){
        PreparedStatement pst  = null;
        ResultSet rs = null;
        
        try{
            String consulta = "SELECT * FROM usuario WHERE username = ? AND password = ?";
            
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, userName);
            pst.setString(2, password);
            
            
            rs = pst.executeQuery(); // GUARDA EL RESULTADO DE LA CONSULTA.
            
            if(rs.absolute(1)){
                return true;
            }
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
        
        return false;
    }
    
    public boolean Registrar(String userName, String password, String name, String surname, String email){
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
        catch(Exception e){
            System.err.println("ERROR: "+e);
        }
        finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            }
            catch(Exception e){
                System.err.println("ERROR: "+e);    
            }
        }
        
        return false;
    }
    
    public static void main(String[] args){
        Consultas co = new Consultas();
        System.out.println(co.Autenticacion("test233", "test2"));
    }
}
