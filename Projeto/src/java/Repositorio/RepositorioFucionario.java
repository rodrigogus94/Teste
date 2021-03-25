/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Repositorio;

import InterfaceRepositorio.Interface;
import Negocio.Funcionario;
import dao.DaoManagerHiber;
import java.util.List;

/**
 *
 * @author Rodrigo-Casa
 */
public class RepositorioFucionario implements Interface<Funcionario, String>{

    @Override
    public void inserir(Funcionario t) {
        //t.setSenha(DigestUtils.md5Hex(t.getSenha()));
        dao.DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Funcionario t) {
//        System.out.println("Senha: " + t.getSenha());
//        t.setSenha(DigestUtils.md5Hex(t.getSenha()));
//        System.out.println("Senha: " + t.getSenha());
        t.setSenha(criptografia.Criptografia.criptografar(t.getSenha()));
        dao.DaoManagerHiber.update(t);
    }

    @Override
    public Funcionario recuperar(int id) {
      return  (Funcionario)dao.DaoManagerHiber.recover("from Funcionario where id ="+ id).get(0);
    }

    @Override
    public void deletar(Funcionario t) {
        dao.DaoManagerHiber.delete(t);
    }

    @Override
    public List<Funcionario> recuperarTodos() {
        return dao.DaoManagerHiber.recover("from Funcionario");
    }

    
    public Funcionario recuperarPorLogin(String siape, String senha){
        List<Funcionario> list = DaoManagerHiber.recover("from Funcionario where siape='"+siape+"' and senha='"+senha+"'");
        if(list.isEmpty()){
            return null;
        }else{
            return (Funcionario) list.get(0);
        }
        
    }
}
