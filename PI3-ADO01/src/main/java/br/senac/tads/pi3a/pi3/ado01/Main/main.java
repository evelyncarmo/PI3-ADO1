/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3a.pi3.ado01.Main;

import br.senac.tads.pi3a.pi3.ado01.BLL.ProdutoBLL;
import br.senac.tads.pi3a.pi3.ado01.DAO.ProdutoDAO;
import br.senac.tads.pi3a.pi3.ado01.Modelos.Produto;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class main {
    public static void main(String[] args){
        
        Scanner ler = new Scanner(System.in);
        int opcao = 99;
        boolean error;
        
        System.out.println("-- GERENCIAMENTO DE PRODUTOS --");
        System.out.println("");
        do{
            imprimirMenu();
            do{
                error = false;
                try{
                    opcao = ler.nextInt();
                    if(opcao <0 || opcao > 7){
                        error = true;
                    }
                }
                catch (InputMismatchException e) {
                System.out.println("Entrada inválida, inserir número da lista");
                error = true;
                ler.next();
                imprimirMenu();
                }
            }while(error==true); 
            
            
            // SELEÇÃO DO MENU
            switch(opcao){
                case 1: inserirProduto();
                break;
            }
        }while(opcao!=0);
        
    }

    public static void imprimirMenu(){
            System.out.println("Por favor selecione uma opção:");
            System.out.println("1 Inserir Produto");
            System.out.println("2 Alterar Produto");
            System.out.println("3 Remover Produto");
            System.out.println("4 Listar Produtos");
            System.out.println("5 Inserir Categoria");
            System.out.println("6 Remover Categoria");
            System.out.println("7 Listar Categorias");
            System.out.println("");
            System.out.println("0 Sair");
            System.out.println("");
    }
    
    
    /**
     *
     *
     */
    public static void inserirProduto(){
        Scanner ler = new Scanner(System.in);
        Produto p = new Produto();
        
        String erros;
        boolean error;
        
        do{
            System.out.print("Nome do produto: ");
            p.setNome(ler.nextLine());

            System.out.print("Descrição do produto: ");
            p.setDescricao(ler.nextLine());

            System.out.print("Preço de compra: ");
            do{
                error = false;
                try{
                    p.setPrecoCompra(ler.nextDouble());
                }
                catch (InputMismatchException e) {
                System.out.println("Entrada inválida, inserir número com decimais separados por virgula");
                error = true;
                ler.next();
                }
            }while(error==true);

            System.out.print("Preço de venda: ");
            do{
                error = false;
                try{
                    p.setPrecoVenda(ler.nextDouble());
                }
                catch (InputMismatchException e) {
                System.out.println("Entrada inválida, inserir número com decimais separados por virgula");
                error = true;
                ler.next();
                }
            }while(error==true);
            

            System.out.print("Quantidade: ");
            do{
                error = false;
                try{
                    p.setQuantidade(ler.nextInt());
                }
                catch (InputMismatchException e) {
                System.out.println("Entrada inválida, inserir número inteiro positivo");
                error = true;
                ler.next();
                }
            }while(error==true);
            
            
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
