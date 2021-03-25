/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.CClasses;
import Repositorio.RepositorioClasses;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anna Clara e Sophia
 */
@ManagedBean(name = "ControlaClasses")
@SessionScoped
public class ControlaClasses {

    private RepositorioClasses rc = null;
    private CClasses SelectCla;

    public CClasses getSelectCla() {
        return SelectCla;
    }

    public void setSelectCla(CClasses SelectCla) {
        this.SelectCla = SelectCla;
    }

    public ControlaClasses() {
        this.rc = new RepositorioClasses();
    }

    public String inserirConselho(CClasses c){
         this.rc.inserir(c);
         
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu().getRelatorios().add(c);
         
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 alterarAluno(((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu());
       
         
         return "ApresentaAlunos.xhtml";
    }
     public void alterarConselho(CClasses c){
        this.rc.alterar(c);
    }
   
    public CClasses recuperarConselho(int id){
        return this.rc.recuperar(id);
    }
    
    public String deletarConselho(CClasses c){
        this.rc.deletar(c);
        ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu().getRelatorios().remove(c);
         
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 alterarAluno(((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu());
         return "ApresentaAlunos.xhtml";
    }
    
    public List<CClasses> recuperarTodosConselho(){
        return this.rc.recuperarTodos();
    }
}
