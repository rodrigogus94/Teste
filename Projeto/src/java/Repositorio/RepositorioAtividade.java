/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import Negocio.Atividade;
import dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class RepositorioAtividade implements InterfaceRepositorio.Interface<Atividade, String>{

    @Override
    public void inserir(Atividade t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Atividade t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Atividade recuperar(int id) {
        return (Atividade)DaoManagerHiber.recover("from Atividade where id = "+ id).get(0);
    }

    @Override
    public void deletar(Atividade t) {
            DaoManagerHiber.delete(t);
    }

    @Override
    public List<Atividade> recuperarTodos() {
        return DaoManagerHiber.recover("from Atividade");
    }
    
}
