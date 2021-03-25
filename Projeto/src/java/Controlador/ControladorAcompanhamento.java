/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Acompanhamento;
import Negocio.Aluno;
import Repositorio.RepositorioAcompanhamento;
import Repositorio.RepositorioAluno;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "controladorAcompanhamento")
@SessionScoped
public class ControladorAcompanhamento {
    private RepositorioAcompanhamento ra = null;
    private Acompanhamento selectedAcompanhamento = null;

    public ControladorAcompanhamento() {
        this.ra = new RepositorioAcompanhamento();
    }

    public Acompanhamento getSelectedAcompanhamento() {
        return selectedAcompanhamento;
    }

    public void setSelectedAcompanhamento(Acompanhamento selectedAcompanhamento) {
        this.selectedAcompanhamento = selectedAcompanhamento;
    }
    
    public String inserirAcompanhamento(Acompanhamento a){
//        this.ra.inserir(a);
//        aluno.getAcompanhamentos().add(a);
//        
//        RepositorioAluno ra = new RepositorioAluno();
//        System.out.println("Nome do Aluno: " + aluno.getNome());
//        
//        
//        ra.alterar(aluno);
        
        this.ra.inserir(a);
        
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu().getAcompanhamentos().add(a);
         
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 alterarAluno(((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu());
       
         
         
         return "ApresentaAlunos.xhtml";

        
//        this.ra.inserir(a);
        
//        ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
//                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
//                 getSelectalu().getAcompanhamentos().add(a);
//         
//         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
//                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
//                 alterarAluno(((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
//                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
//                 getSelectalu());
        
        //return "ApresentaAlunos.xhtml";
    }
    
    public String deletarAcompanhamento(Acompanhamento a){
        
        ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu().getAcompanhamentos().remove(a);
         
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 alterarAluno(((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu());
         
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControladorClasses.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         this.ra.deletar(a);
         
         return "ApresentaAlunos.xhtml";
    }
    
    public String alterarAcompanhamento(Acompanhamento a){
        this.ra.alterar(a);
        return "index.xhtml";
    }
    
    public Acompanhamento recuperarAcompanhamento(int id){
        return this.ra.recuperar(id);
    }
    
    public List<Acompanhamento> recuperarAcompanhamento(){
        return this.ra.recuperarTodos();
    }
}
