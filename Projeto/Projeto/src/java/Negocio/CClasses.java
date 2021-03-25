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
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Anna Clara e Sophia
 */
@ManagedBean(name="Cla")
@RequestScoped
@Entity
@Table(name = "Classes")
public class CClasses implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    
    private String editor;
    
    private String data = getDateTime();
    
    public CClasses() {
        
    }

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }


    public CClasses(String editor) {
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
    public String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    
    
    
    
}
