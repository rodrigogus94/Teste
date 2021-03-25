/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import classes.Paciente;

public interface IRepositorioPacientes {
     public void inserir(Paciente paciente);
    public void deletar(Paciente paciente);
    public void atualizar(Paciente paciente);
    public Paciente recuperar(String identidade);
    public ArrayList<Paciente> recuperarTodos();
    
}
