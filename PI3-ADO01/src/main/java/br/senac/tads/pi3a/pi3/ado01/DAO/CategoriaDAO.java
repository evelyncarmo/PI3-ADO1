/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.DAO;

import br.senac.tads.pi3a.pi3.ado01.Utils.DBConnect;
import br.senac.tads.pi3a.pi3.ado01.Modelos.Categoria;
import br.senac.tads.pi3a.pi3.ado01.Modelos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Marcos Limeira
 */
public class CategoriaDAO {
    
    public static void ligar(Categoria cat, Produto p) throws SQLException, Exception{
        
        long prodID;
        int catID;
        
        String fetchProduto = "SELECT id FROM produto WHERE nome="+p.getNome();
        
        String fetchCat = "SELECT id FROM categoria WHERE nome="+cat.getNome();
        
        String linkQuery = "INSERT INTO PRODUTOBD.PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA)"
                + " VALUES(?, ?)";
        
        Connection conn = null;
        Statement st = null;
        ResultSet result;
        PreparedStatement pst = null;
        
        try{
            conn = DBConnect.obterConexao();
            
            st = conn.createStatement();
            result = st.executeQuery(fetchProduto);
            prodID = result.getLong("id");
            
            result = st.executeQuery(fetchCat);
            catID = result.getInt("id");
            
            
            pst = conn.prepareStatement(linkQuery);
            
            pst.setLong(1, prodID);
            pst.setInt(2, catID);
           
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
