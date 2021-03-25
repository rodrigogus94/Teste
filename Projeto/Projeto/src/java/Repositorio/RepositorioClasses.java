/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import InterfaceRepositorio.Interface;
import Negocio.CClasses;
import dao.DaoManagerHiber;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anna Clara e Sophia
 */
public class RepositorioClasses implements Interface<CClasses, String>{
    
   

    @Override
    public void inserir(CClasses t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(CClasses t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public CClasses recuperar(int id) {
        return  (CClasses)DaoManagerHiber.recover("from Classes where id ="+ id).get(0);
    }
    
    
    @Override
    public void deletar(CClasses t) {
        DaoManagerHiber.delete(t);
    }
  

    @Override
    public List<CClasses> recuperarTodos() {
       return DaoManagerHiber.recover("from Classes");
    }
    
    
    
}
