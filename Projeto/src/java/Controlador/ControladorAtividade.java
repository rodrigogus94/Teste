/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Negocio.Atividade;
import Repositorio.RepositorioAtividade;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "controladorAtividade")
@SessionScoped
public class ControladorAtividade {
    private RepositorioAtividade ra = null;
    private Atividade selectedAtividade = null;

    public ControladorAtividade() {
        this.ra = new RepositorioAtividade();
    }

    public Atividade getSelectedAtividade() {
        return selectedAtividade;
    }

    public void setSelectedAtividade(Atividade selectedAtividade) {
        this.selectedAtividade = selectedAtividade;
    }
    
    public String inserirAtividade(Atividade a){
        this.ra.inserir(a);
        return "ApresentaAtividades.xhtml";
    }
    
    public String deletarAtividade(Atividade a){
        this.ra.deletar(a);
        return "ApresentaAtividades.xhtml";
    }
    
    public String alterarAtividade(Atividade a){
        this.ra.alterar(a);
        return "ApresentaAtividades.xhtml";
    }
    
    public Atividade recuperarAtividade(int id){
        return this.ra.recuperar(id);
    }
    
    public List<Atividade> recuperarTodasAtividades(){
        return this.ra.recuperarTodos();
    }
}
