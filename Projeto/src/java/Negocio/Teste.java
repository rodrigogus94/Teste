/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Controlador.ControlaClasses;
import Controlador.ControladorAluno;
import Controlador.ControladorDisciplina;
import Controlador.ControladorFuncionario;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class Teste {
    public static void main(String[] args) {
        //Controlador.ControladorFuncionario c = new ControladorFuncionario();
        //List<Funcionario> l = c.recuperarTodosFuncionarios();
//        for (Funcionario funcionario : l) {
//            System.out.println(funcionario.getSenha());
//            }
        //System.out.println(l.get(1).getSenha());
//        l.get(1).setSenha("1234567");
//        c.alterarFuncionario(l.get(1));
//        System.out.println(l.get(1).getSenha());
//        }
        
        
        Controlador.ControlaClasses cc = new ControlaClasses();
        List<CClasses> l = cc.recuperarTodosConselho();
        
        for (int i = 0; i < l.size(); i++) {
            CClasses conselho = l.get(i);
            System.out.println(conselho.getEditor());
        conselho.setEditor("novo conselhosabcjksndkcjilksjxhsdck");
        cc.alterarConselho(conselho);
        System.out.println(conselho.getEditor());
        }
        
        
    }
}
