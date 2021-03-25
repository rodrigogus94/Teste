/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo-Casa
 */
@ManagedBean(name = "alu")
@RequestScoped
    @Entity
    @Table(name = "Aluno")
public class Aluno {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "Nome", length = 60)
    private String nome;
    
    @Column(name = "matricula" ,length = 20)
    private String matricula;
  
    @OneToMany
    private List<CClasses> Relatorios;
    
    @ManyToMany
    @JoinTable(name="Aluno_cursa_Disciplina", joinColumns=
      {@JoinColumn(name="Id_Aluno")}, inverseJoinColumns=
        {@JoinColumn(name="Id_Disciplina")})
    private List<Disciplina> disciplinas;
    
    
    public Aluno() {
        this.Relatorios = new ArrayList<CClasses>();
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    

    public void addDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    /**
     * @return the Relatorios
     */
    public List<CClasses> getRelatorios() {
        return Relatorios;
    }

    /**
     * @param Relatorios the Relatorios to set
     */
    public void setRelatorios(List<CClasses> Relatorios) {
        this.Relatorios = Relatorios;
    }
    
    
    
}
