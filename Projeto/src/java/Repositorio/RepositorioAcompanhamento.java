/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import Negocio.Acompanhamento;
import dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Ricardo Alves
 */
public class RepositorioAcompanhamento implements InterfaceRepositorio.Interface<Acompanhamento, String>{

    @Override
    public void inserir(Acompanhamento t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Acompanhamento t) {
        DaoManagerHiber.update(t);
    }

    @Override
    public Acompanhamento recuperar(int id) {
        return (Acompanhamento)DaoManagerHiber.recover("from Acompanhamento where id = " + id);
    }

    @Override
    public void deletar(Acompanhamento t) {
        DaoManagerHiber.delete(t);
    }

    @Override
    public List<Acompanhamento> recuperarTodos() {
        return DaoManagerHiber.recover("from Acompanhamento");
    }
    
}
