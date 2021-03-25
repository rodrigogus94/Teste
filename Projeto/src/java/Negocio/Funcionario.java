/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.io.Serializable;
import static javafx.beans.binding.Bindings.length;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean (name = "Fun")
@RequestScoped
@Entity
@Table (name = "Funcionario")
public class Funcionario implements Serializable{
    
    @Id
    @GeneratedValue
    private int id;
    
    
    @Column (name ="nome", length = 60)
    private String nome;
    
    @Column (name = "siape", length = 7)
    private String siape;
    
    @Column (name = "senha", length = 100)
    private String senha;

    public Funcionario() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }
    
    
    
}
