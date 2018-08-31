/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.BLL;

import br.senac.tads.pi3a.pi3.ado01.Modelos.Categoria;
import br.senac.tads.pi3a.pi3.ado01.Utils.DBConnect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Marcos Limeira
 */
public class CategoriaBLL {
    
    public static String inserir(String cat) throws ClassNotFoundException, SQLException{ 
        
        String erros = "";
        
        String query = "SELECT nome FROM produtobd.categoria";
        
        Connection conn = null;
        Statement st = null;
        ResultSet result;
        ArrayList<String> categorias = new ArrayList<>();
        
        try{
            conn = DBConnect.obterConexao();
            st = conn.createStatement();
            result = st.executeQuery(query);
            
            while(result.next()){
                //int id = result.getInt("id");
                categorias.add(result.getString("nome"));
            }
            
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (st != null && !st.isClosed()) {
                st.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }
        
        
        if(!categorias.contains(cat)){
            erros += "\n\nCategoria inválida!\n";
        }
        
        return erros;
    }
}
