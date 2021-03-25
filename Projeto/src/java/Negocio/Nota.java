/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "nota")
@RequestScoped
    @Entity
    @Table(name = "nota")
public class Nota implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "nota")
    private double nota;
    
    @ManyToOne
//    @Column(name = "Id_Disciplina")
    private Disciplina disciplina;
    
    @ManyToOne
    //(fetch = FetchType.LAZY)
//    @Column(name = "Id_Aluno")
    //@JoinColumn(name = "Id_Aluno", referencedColumnName = "id", insertable = false, updatable = false)
    private Aluno aluno;

    public Nota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
}
