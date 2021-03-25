/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Nota;
import Repositorio.RepositorioNota;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "ControladorNota")
@SessionScoped
public class ControladorNota {
    
    private RepositorioNota rn = null;
    private Nota selectedNota = null;

    public Nota getSelectedNota() {
        return selectedNota;
    }

    public void setSelectedNota(Nota selectedNota) {
        this.selectedNota = selectedNota;
    }

    public ControladorNota() {
        this.rn = new RepositorioNota();
    }
    
    public String inserirNota(Nota n){
        this.rn.inserir(n);
         
        return "index.xhtml";
    }
    
    public void alterarNota(Nota n){
        this.rn.alterar(n);
    }
    
    public String deletarNota(Nota n){
        this.rn.deletar(n);
         
         return "index.xmtml";
    }
    
}
