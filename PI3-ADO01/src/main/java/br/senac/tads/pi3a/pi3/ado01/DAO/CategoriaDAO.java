/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.DAO;

import br.senac.tads.pi3a.pi3.ado01.Utils.DBConnect;
import br.senac.tads.pi3a.pi3.ado01.Modelos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Marcos Limeira
 */
public class CategoriaDAO {
    
    public static void inserir(Categoria cat) throws SQLException, Exception{
        
        String sql = "INSERT INTO Categoria (Nome)"
                + " VALUES(?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = DBConnect.obterConexao();
            
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, cat.getNome());
           
            pst.execute();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (pst != null && !pst.isClosed()) {
                pst.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
    }
    
}
