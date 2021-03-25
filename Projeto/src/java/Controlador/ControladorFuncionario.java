/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Funcionario;
import Repositorio.RepositorioFucionario;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean (name = "ControladorFuncio")
@SessionScoped
public class ControladorFuncionario {
    
    private RepositorioFucionario rf = null;
    private Funcionario selectFun = null;
    private Funcionario login = null;
    

    public ControladorFuncionario() {
        this.rf = new RepositorioFucionario();
    }

    public Funcionario getSelectFun() {
        return selectFun;
    }

    public void setSelectFun(Funcionario selectFun) {
        this.selectFun = selectFun;
    }
    
    public String inserirFuncionario(Funcionario f){
        //f.setSenha(DigestUtils.md5Hex(f.getSenha()));
        f.setSenha(criptografia.Criptografia.criptografar(f.getSenha()));
        this.rf.inserir(f);
         return "index.xhtml";
    }
     public void alterarFuncionario(Funcionario f){
         //f.setSenha(DigestUtils.md5Hex(f.getSenha()));
         System.out.println(f.getSenha());
        f.setSenha(criptografia.Criptografia.criptografar(f.getSenha()));
        System.out.println(f.getSenha());
         this.rf.alterar(f);
    }
   
    public Funcionario recuperarFuncionario(int id){
        return this.rf.recuperar(id);
    }
    
    public void deletarFuncionario(Funcionario f){
        this.rf.deletar(f);
    }
    
    public List<Funcionario> recuperarTodosFuncionarios(){
        return this.rf.recuperarTodos();
    }

    public Funcionario getLogin() {
        return login;
    }

    public void setLogin(Funcionario login) {
        this.login = login;
    }
  
    public String validarLogin(Funcionario fun){
        //fun.setSenha(DigestUtils.md5Hex(fun.getSenha()));
        fun.setSenha(criptografia.Criptografia.criptografar(fun.getSenha()));
        this.login = this.rf.recuperarPorLogin(fun.getSiape(), fun.getSenha());
        
      if(this.login != null){
          ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("usuarioLogado", this.login);
          return "index.xhtml";
      }
      else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login inválido"));
      }
      return null;
  }
    
    public void logoff(){
        this.login = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("logar.xhtml");
        } catch (IOException ex) {
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "UsuÃ¡rio", ex.getMessage()));
        }
    }
    
    public boolean verificarSeTemUsuarios() {
        return this.rf.recuperarTodos().isEmpty();
    }
    
}
