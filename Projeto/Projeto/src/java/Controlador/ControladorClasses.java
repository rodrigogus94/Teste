/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.CClasses;
import Repositorio.RepositorioClasses;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Anna Clara e Sophia
 */
@ManagedBean(name = "ControlaClasses")
@SessionScoped
public class ControladorClasses {

    private RepositorioClasses rc = null;
    private CClasses SelectedCla;
    
    

    public CClasses getSelectedCla() {
        return SelectedCla;
    }

    public void setSelectedCla(CClasses SelectCla) {
        this.SelectedCla = SelectCla;
    }

    public ControladorClasses() {
        this.rc = new RepositorioClasses();
        this.SelectedCla = new CClasses();
    }

    public String inserirConselho(CClasses c){
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu().getRelatorios().add(c);
         
         ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 alterarAluno(((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu());
       
         this.rc.inserir(c);
         
         return "ApresentaAlunos.xhtml";
    }
     public void alterarConselho(CClasses c){
         
        this.rc.alterar(c);
    }
   
    public CClasses recuperarConselho(int id){
        return this.rc.recuperar(id);
    }
    
    public String deletarConselho(CClasses c){
        
        
        ((ControladorAluno)((HttpSession)FacesContext.getCurrentInstance().
                 getExternalContext().getSession(true)).getAttribute("controlAluno")).
                 getSelectalu().getRelatorios().remove(c);
         
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
         
         this.rc.deletar(c);
         
         return "ApresentaAlunos.xhtml";
    }
    
    public List<CClasses> recuperarTodosConselho(){
        return this.rc.recuperarTodos();
    }
}
