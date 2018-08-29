/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.BLL.Testes;

import br.senac.tads.pi3a.pi3.ado01.BLL.ProdutoBLL;
import br.senac.tads.pi3a.pi3.ado01.DAO.ProdutoDAO;
import br.senac.tads.pi3a.pi3.ado01.Modelos.Produto;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dud Felipe
 */
public class TestaInclusao {
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        Produto p = new Produto();
        
        String erros;
        
        do{
            System.out.print("Nome do produto: ");
            p.setNome(ler.nextLine());

            System.out.print("Descrição do produto: ");
            p.setDescricao(ler.nextLine());

            System.out.print("Preço de compra: ");
            p.setPrecoCompra(ler.nextDouble());

            System.out.print("Preço de venda: ");
            p.setPrecoVenda(ler.nextDouble());

            System.out.print("Quantidade: ");
            p.setQuantidade(ler.nextInt());
            
            erros = ProdutoBLL.inserir(p);
            
            if(!erros.equals("")){
                System.out.println(erros);
                ler.nextLine();
            }
            
        }while(!erros.equals(""));
        
        p.setDataCadastro(new Date());
        
        try{
            ProdutoDAO.inserir(p);
            System.out.println("Produto inserido com sucesso!");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
