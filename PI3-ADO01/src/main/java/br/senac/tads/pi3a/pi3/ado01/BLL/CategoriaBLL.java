/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.BLL;

import br.senac.tads.pi3a.pi3.ado01.Modelos.Categoria;

/**
 *
 * @author Marcos Limeira
 */
public class CategoriaBLL {
    public static String inserir(Categoria cat){ 
        
        String erros = "";
        
        if(cat.getNome() == null || cat.getNome().equals("")){
            erros += "\n\nNome inválido!\n";
        }
        
        return erros;
    }
}
