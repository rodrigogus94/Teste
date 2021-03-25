/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Conversores;

import Controlador.ControladorAluno;
import Controlador.ControladorDisciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ricardo Alves
 */
@FacesConverter(value="disciplinaConverter")
public class DisciplinaConverter implements Converter{
    
     @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String key) {
        int Key;
        Key = Integer.parseInt(key);
        FacesContext context = FacesContext.getCurrentInstance();
         ControladorDisciplina cd = (ControladorDisciplina) context.getELContext().getELResolver().getValue(context.getELContext(), null, "ControladorDisciplina");
 
        return cd.recuperarDisciplina(Key);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       return o.toString();
    }
    
    
    public static void main(String[] args) {
        
    }
}
