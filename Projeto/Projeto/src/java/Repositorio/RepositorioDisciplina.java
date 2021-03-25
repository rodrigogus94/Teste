/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class RepositorioDisciplina implements InterfaceRepositorio.Interface{

    @Override
    public void inserir(Object t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Object t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Object recuperar(int id) {
       return DaoManagerHiber.recover("from Disciplina where id ="+ id).get(0);
    }

    @Override
    public void deletar(Object t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List recuperarTodos() {
        return DaoManagerHiber.recover("from Disciplina");
    }
    
}
