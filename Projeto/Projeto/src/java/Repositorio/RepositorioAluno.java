package Repositorio;


import InterfaceRepositorio.Interface;
import Negocio.Aluno;
import dao.DaoManagerHiber;
import java.util.List;

public class RepositorioAluno implements Interface<Aluno, String>{

    

    @Override
    public void inserir(Aluno t) {
        DaoManagerHiber.persist(t);
    }

    @Override
    public void alterar(Aluno t) {
        DaoManagerHiber.update(t);
    }
    

    @Override
    public Aluno recuperar(int id) {
        return (Aluno)DaoManagerHiber.recover("from Aluno where id ="+ id).get(0);
    }

    @Override
    public void deletar(Aluno t) {
       dao.DaoManagerHiber.delete(t);
   
}
    @Override
    public List<Aluno> recuperarTodos() {
        return dao.DaoManagerHiber.recover("from Aluno");
    }
   
}
