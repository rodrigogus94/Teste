/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import conversores.AbstractEntity;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "disciplina")
@RequestScoped
    @Entity
    @Table(name = "Disciplina")

public class Disciplina implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "nome")
    private String nome;
    
    @OneToMany
    private List<Nota> notas;
    
    @ManyToMany
    //(mappedBy = "disciplinas")
    private List<Aluno> alunos;
 
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

}
