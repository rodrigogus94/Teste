/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import Controlador.ControladorDisciplina;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class Teste {
    public static void main(String[] args) {
        ControladorDisciplina c = new ControladorDisciplina();
        List<Disciplina> l = c.recuperarTodasDisciplinas();
        for (int i = 0; i < l.size(); i++) {
        System.out.println(l.get(i).getNome());
            
        }
    }
}
