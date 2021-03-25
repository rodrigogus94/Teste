/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Aluno;
import Negocio.CClasses;
import Negocio.Disciplina;
import Repositorio.RepositorioAluno;
import Repositorio.RepositorioClasses;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean(name = "controlAluno")
@SessionScoped
public class ControladorAluno {
    
    private RepositorioAluno ra= null;
    private RepositorioClasses rc = null;
    private Aluno Selectalu = null;
    
    
    public Aluno getSelectalu(){
    return Selectalu;
    }
    
    public void setSelectalu(Aluno Selectalu) {
        this.Selectalu = Selectalu;
    }
    
    public ControladorAluno(){
        this.ra = new RepositorioAluno();
        this.rc = new RepositorioClasses();
    }

      
    public String inserirAluno(Aluno a){
         this.ra.inserir(a);
         return "index.xhtml";
    }
     public void alterarAluno(Aluno a){
        this.ra.alterar(a);
    }
   
    public Aluno recuperarAluno(int id){
        return this.ra.recuperar(id);
    }
    
    public void deletarAluno(Aluno a){
        this.ra.deletar(a);
        
    }
    
    public List<Aluno> recuperarTodosAlunos(){
        return this.ra.recuperarTodos();
    }
    public List<CClasses> recuperarRelatorios(){
        return this.getSelectalu().getRelatorios();
    }
    
    public String vincularDisciplina(Disciplina d){
        
        
        return "ApresentaAlunos.xhtml";
    }
}
