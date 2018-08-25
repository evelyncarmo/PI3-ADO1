/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.DAO;

import br.senac.tads.pi3a.pi3.ado01.Utils.DBConnect;
import br.senac.tads.pi3a.pi3.ado01.Modelos.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author Dud Felipe
 */
public class ProdutoDAO {
    
    public static void inserir(Produto p) throws SQLException, Exception{
        
        String sql = "INSERT INTO Produto (Nome, Descricao, Preco_Compra, Preco_Venda, Quantidade, DT_Cadastro)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try{
            conn = DBConnect.obterConexao();
            
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, p.getNome());
            pst.setString(2, p.getDescricao());
            pst.setDouble(3, p.getPrecoCompra());
            pst.setDouble(4, p.getPrecoVenda());
            pst.setInt(5, p.getQuantidade());
            
            Timestamp t = new Timestamp(p.getDataCadastro().getTime());
            pst.setTimestamp(6, t);
            
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
