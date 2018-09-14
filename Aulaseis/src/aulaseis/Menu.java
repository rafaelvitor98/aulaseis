package aula6;

import java.util.Scanner;

public class Menu {
    public int menu;
    public Produto produto;
    public Produto[] ListaProdutos;
    Scanner scan = new Scanner (System.in);

    public void CriaMenu(){
        System.out.println("Digite uma das opções"
                +"\n 1) - Cadastrar Novo"
                +"\n 2) - Listar"
                +"\n 3) - Buscar"
                +"\n 4) - Editar"
                +"\n 0) - Sair"
                +"\n =>");
        menu = scan.nextInt();
        GetExecucao();
    }     
    
    public void GetExecucao(){
        switch(menu){
        case 1:
            Cadastrar();
            break;
        case 2:
            Listar();
            this.CriaMenu();
            break;
        case 3:
            produto = Buscar();
            if (produto == null) {
                System.out.println("Produto não existe");
            
            }else{
                this.ImprimirProduto();
            }
            this.CriaMenu();
            break;
        case 4:
            Editar();
            break;
        case 0:
            System.out.println("O sistema será fechado");
            break;
        default:
            System.out.println("Digite uma das opções do menu");
            this.CriaMenu();
            break;
        }
    }
    public void Cadastrar(){
        System.out.println("Quantos Produtos Deseja cadastrar? ");
        int qtde = scan.nextInt();
        ListaProdutos = new Produto[qtde];
        for (int x = 0; x < qtde; x++){
            ListaProdutos[x] = InformacoesProduto(x +1);
        }
        this.CriaMenu();
    }
    
    public void ImprimirProduto(){
        System.out.println("\nCod: "+ produto.Cod +
                "\nDescricao: " + produto.Descricao +
                "\nValor: " + produto.Valor +
                "\nQuantidade: " + produto.Quantidade);
    }


    public void Editar(){
        this.Listar();
        produto = this.Buscar();
        Produto pro = InformacoesProduto(produto.Cod);
        ListaProdutos[pro.Cod -1] = pro;
        this.CriaMenu();
    }

    public Produto InformacoesProduto (int valor){
        Produto produto = new Produto();
        produto.Cod = valor;
        System.out.println("Digite a Descrição: " );
        produto.Descricao = scan.next();
        System.out.println("Digite uma quantidade: ");
        produto.Quantidade = scan.nextInt();
        System.out.println("Digite um valor unitário: ");
        produto.Valor = scan.nextDouble();
        return produto;
    }

    public Produto Buscar(){
        System.out.println("Digite o Codigo ");
        int pesquisa = scan.nextInt();
        for(int x = 0; x < ListaProdutos.length; x++){
            if (ListaProdutos[x].Cod == pesquisa){
                return ListaProduto[x];
            }
        }
                  return null;
    }
    
    public void Listar(){
        for (int x=0; x<ListaProdutos.length; x++){
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("\nCod: "+ ListaProdutos[x].Cod +
                    "\nDescricao: "+ ListaProdutos[x].Descricao +
                    "\nValor: "+ ListaProdutos[x].Valor +
                    "\nQuantidade: "+ ListaProdutos[x].Quantidade);
        }
        System.out.println("");
    }
    
    
    
    

    




































}



