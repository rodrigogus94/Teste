/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteBanco;

import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Quo;
import java.sql.SQLException;
import java.util.Scanner;

public class Teste {
    
    public static void main(String[] args) throws SQLException{
    String nome;
    int cpf;
    Scanner sc1 = new Scanner(System.in);
    System.out.println("Digite o nome: ");
   nome = sc1.nextLine();
   // nome ="\'"+nome+"\'";
    System.out.println("Digite o cpf: ");
    
    cpf = sc1.nextInt();
    
//    System.out.println("insert into pessoa values ("+id+","+"'"+nome+"'"+","+idade+")");
  
        ConexaoBanco a = new ConexaoBanco();
        a.inserir(nome, cpf);
//        a.alterarNome(id,nome);
//        a.consultar();

    }
}
