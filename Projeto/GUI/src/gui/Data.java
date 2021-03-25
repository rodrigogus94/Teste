/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Rodrigo
 */
public class Data {
    
    private String dia;
    private String mes;
    private String ano;
    
    public Data(){
        Calendar data = Calendar.getInstance();
        this.dia = Integer.toString(data.get(Calendar.DAY_OF_MONTH));
        this.mes = Integer.toString(data.get(Calendar.MAY)+1);
        this.ano = Integer.toString(data.get(Calendar.YEAR));
    }

    public String getData(){
            return this.dia+"/"+this.mes+"/"+this.ano;
        }
    
    
}
