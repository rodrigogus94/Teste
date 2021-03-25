/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Disciplina;
import Negocio.Nota;
import Repositorio.RepositorioDisciplina;
import Repositorio.RepositorioNota;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "ControladorDisciplina")
@SessionScoped
public class ControladorDisciplina {
    
    private RepositorioDisciplina rd = null;
    private RepositorioNota rn = null;
    private Disciplina selectedDisciplina = null;
    

    public Disciplina getSelectedDisciplina() {
        return selectedDisciplina;
    }

    public void setSelectedDisciplina(Disciplina selectedDisciplina) {
        this.selectedDisciplina = selectedDisciplina;
    }

    public ControladorDisciplina() {
        this.rd = new RepositorioDisciplina();
        this.rn = new RepositorioNota();
    }
    
    public String inserirDisciplina(Disciplina d){
        this.rd.inserir(d);
         
         return "index.xhtml";
    }
    
    public String deletarDisciplina(Disciplina d){
        this.rd.deletar(d);
         
         return "index.xhtml";
    }
    
    public void alterarDisciplina(Disciplina d){
        this.rd.alterar(d);
    }
    
    public Disciplina recuperarDisciplina(int id){
        return (Disciplina) this.rd.recuperar(id);
    }
    
    public List<Disciplina> recuperarTodasDisciplinas(){
        return this.rd.recuperarTodos();
    }
}
