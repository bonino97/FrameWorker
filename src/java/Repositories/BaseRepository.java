/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juan Cruz
 */
public class BaseRepository {
    private String USERNAME = "root";
    private String UNICODE = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
    private String PASSWORD = "AVGtdc11456";
    private String HOST = "192.168.5.7";
    private String PORT = "33060";
    private String DATABASE = "frameworker";
    private String CLASSNAME = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://node52411-frame-worker.jl.serv.net.mx/"+DATABASE+"?"+UNICODE;
    private Connection con;
    
    public BaseRepository()
    {
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }
        catch(ClassNotFoundException | SQLException e){
            System.err.println("ERROR: "+e);
        }
    }
    
    public Connection getConexion(){
        return con;
    }
}