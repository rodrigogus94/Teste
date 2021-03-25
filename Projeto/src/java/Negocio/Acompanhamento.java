/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Alves
 */
@ManagedBean(name = "acompanhamento")
@RequestScoped
    @Entity
    @Table(name = "Acompanhamento")
public class Acompanhamento implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    
    @Column(name = "data")
    private String data = getDateTime();
    
    private String relatorioAcompanhamento;

    public Acompanhamento() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRelatorioAcompanhamento() {
        return relatorioAcompanhamento;
    }

    public void setRelatorioAcompanhamento(String relatorioAcompanhamento) {
        this.relatorioAcompanhamento = relatorioAcompanhamento;
    }
    
    public String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }
}
