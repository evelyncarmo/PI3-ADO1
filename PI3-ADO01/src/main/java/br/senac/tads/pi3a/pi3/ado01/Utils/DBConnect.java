package br.senac.tads.pi3a.pi3.ado01.Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author giovanebarreira
 */
public class DBConnect {
    
     public static Connection obterConexao() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/produtobd", "root", ""); 
        return conn;
    }
}
