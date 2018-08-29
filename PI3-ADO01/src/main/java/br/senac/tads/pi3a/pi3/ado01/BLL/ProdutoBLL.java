/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.BLL;

import br.senac.tads.pi3a.pi3.ado01.Modelos.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dud Felipe
 */
public class ProdutoBLL {
    
    public static String inserir(Produto p){
        
        String erros = "";
        
        if(p.getNome() == null || p.getNome().equals("")){
            erros += "\n\nNome inválido!\n";
        }
        
        if(p.getPrecoCompra() < 0){
            erros += "Preço de compra inválido!\n";
        }
        
        if(p.getPrecoVenda() < 0){
            erros += "Preço de venda inválido!\n";
        }
        
        if(p.getQuantidade() < 0){
            erros += "Quantidade inválida!\n";
        }
        
        return erros;
    }
}
