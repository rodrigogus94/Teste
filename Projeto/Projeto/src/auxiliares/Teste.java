package auxiliares;

import Repositorio.RepositorioPacientes;
import classes.Dependente;
import classes.Paciente;
import auxiliares.Endereco;
import auxiliares.Plano;
import auxiliares.PlanoEspecial;
import auxiliares.PlanoParticular;
import java.util.ArrayList;
public class Teste {
    
    public static void main(String[]args){
          RepositorioPacientes rp = new RepositorioPacientes();
//        Endereco end = new Endereco("Garanhuns","São José","M. Afonso","246",55295100);
//        Dependente dep = new Dependente("12345678900","Eliane","37620918");
//        ArrayList<Plano> pl = new ArrayList<>();
//        pl.add(new PlanoEspecial("unimed","111222","01/01/1111","09/09/9999"));
//        pl.add(new PlanoParticular("02/02/2222","08/08/8888"));
//        ArrayList<String> tel = new ArrayList<>();
//        tel.add("37620918");
//        tel.add("111111111");
//        Paciente p = new Paciente("cesar","10679399461","12345678",end,"masculino","10/04/1996",dep,"Brasil",tel,"PE",pl);
        System.out.println(rp.recuperarTodos().size());
        
    }
}
