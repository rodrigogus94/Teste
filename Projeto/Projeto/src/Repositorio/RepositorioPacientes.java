
package Repositorio;

import auxiliares.Endereco;
import auxiliares.Plano;
import auxiliares.PlanoEspecial;
import auxiliares.PlanoParticular;
import bd.Conexao;
import classes.Dependente;
import interfaces.IRepositorioPacientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import classes.Paciente;
import classes.Paciente;
import interfaces.IRepositorioPacientes;
import java.util.ArrayList;

public class RepositorioPacientes implements IRepositorioPacientes{
    
    public RepositorioPacientes() {
    }

    @Override
    public void inserir(Paciente paciente) {
        String sql = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?)";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            pst.setString(1, paciente.getCpf());
            pst.setString(2, paciente.getNome());
            pst.setString(3, paciente.getIdentidade());
            pst.setString(4, paciente.getSexo());
            pst.setString(5, paciente.getData_nasc());
            pst.setString(6, paciente.getUf());
             pst.setString(7, paciente.getNaturalidade());
            System.out.println("1");
            
            System.out.println("2");
            
            
            pst.execute();

            pst.close();
            conn.close();
            
            for(int i=0;i<paciente.getPlano().size();i++){
                if(paciente.getPlano().get(i) instanceof PlanoParticular){
                inserirPlanoParticular(paciente,i);
            }
                else{
                    inserirPlanoEspecial(paciente, i);
                }
            }
            
            inserirEndereco(paciente);
            inserirDependente(paciente);
            inserirTelefones(paciente);
            System.out.println("3");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inserirDependente(Paciente paciente){
        String sql = "INSERT INTO dependente VALUES (?,?,?,?)";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, paciente.getCpf());
            pst.setString(2, paciente.getDependente().getCpf());
            pst.setString(3, paciente.getDependente().getNome());
            pst.setString(4, paciente.getDependente().getTelefone());
            
            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void inserirEndereco(Paciente paciente){
        String sql = "INSERT INTO Endereco VALUES (?,?,?,?,?,?,?)";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, paciente.getCpf());
            pst.setString(2, paciente.getEndereco().getCidade());
            pst.setString(3, paciente.getEndereco().getBairro());
            pst.setString(4, paciente.getEndereco().getRua());
            pst.setString(5, paciente.getEndereco().getNumero());
            pst.setString(6, paciente.getEndereco().getComplemento());
            pst.setInt(7, paciente.getEndereco().getCep());

            pst.execute();

            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inserirPlanoParticular(Paciente paciente,int i){
        String sql = "INSERT INTO PlanoParticular VALUES (?,?,?)";
        PlanoParticular plano =(PlanoParticular) paciente.getPlano().get(i);
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
            
            pst.setString(1, paciente.getCpf());
            pst.setString(2, plano.getData_inicio());
            pst.setString(3, plano.getData_vencimento());

            pst.execute();
            
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inserirPlanoEspecial(Paciente paciente,int i){
        String sql = "INSERT INTO PlanoEspecial VALUES (?,?,?,?,?)";
        PlanoEspecial plano =(PlanoEspecial) paciente.getPlano().get(i);
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
           
            pst.setString(1, paciente.getCpf());
             pst.setString(2, plano.getNomePlano());
             pst.setString(3, plano.getCodigo());
            pst.setString(4, paciente.getPlano().get(i).getData_inicio());
            pst.setString(5, paciente.getPlano().get(i).getData_vencimento());

            pst.execute();
            
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void inserirTelefones(Paciente paciente){
        String sql = "INSERT INTO telefone_paciente VALUES (?,?)";
        
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            
           for(int i=0;i<paciente.getTelefones().size();i++){
            pst.setString(1, paciente.getCpf());
            pst.setString(2, paciente.getTelefones().get(i));
            

            pst.execute();
           }
            
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletar(Paciente paciente) {
       String sql = "DELETE FROM paciente where cpf=?";
       
       deletarDependente(paciente.getCpf());
       deletarEndereco(paciente.getCpf());
       deletarTelefones(paciente.getCpf());
       deletarPlanoEspecial(paciente.getCpf());
       deletarPlanoParticular(paciente.getCpf());
       
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, paciente.getCpf());

            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void deletarEndereco(String cpf){
        String sql = "DELETE FROM Endereco where cpf_paciente=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cpf);

            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void deletarDependente(String cpf){
        String sql = "DELETE FROM Dependente where cpf_paciente=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cpf);

            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void deletarPlanoParticular(String cpf){
        String sql = "DELETE FROM PlanoParticular where cpf_paciente=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cpf);

            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void deletarPlanoEspecial(String cpf){
        String sql = "DELETE FROM PlanoEspecial where cpf_paciente=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cpf);

            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void deletarTelefones(String cpf){
        String sql = "DELETE FROM Telefone_paciente where cpf_paciente=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cpf);

            pst.execute();

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void atualizar(Paciente paciente) {
        String sql = "UPDATE paciente SET NOME=?, NATURALIDADE=?";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, paciente.getNome());       
            pst.setString(2, paciente.getNaturalidade());
            inserirEndereco(paciente);
            
            pst.executeUpdate();

            pst.close();
            conn.close();
            
            for(int i=0;i<paciente.getPlano().size();i++){
                if(paciente.getPlano().get(i) instanceof PlanoParticular){
                inserirPlanoParticular(paciente,i);
            }
                else{
                    inserirPlanoEspecial(paciente, i);
                }
                inserirEndereco(paciente);
                inserirDependente(paciente);
                inserirTelefones(paciente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } 
    }

    @Override
    public Paciente recuperar(String cpf) {
        String sql = "SELECT * FROM paciente WHERE cpf=?";
        Paciente p = new Paciente();

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String identidade = rs.getString("IDENTIDADE");
                String sexo = rs.getString("SEXO");
                String nascimento = rs.getString("DATA_NASC");
                String naturalidade = rs.getString("NATURALIDADE");
                String uf = rs.getString("UF");

                p.setNome(nome);
                p.setCpf(cpf);
                p.setIdentidade(identidade);
                p.setSexo(sexo);
                p.setData_nasc(nascimento);
                p.setNaturalidade(naturalidade);
                p.setUf(uf);
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        p.setPlano(recuperarPlano(p));
        p.setEndereco(recuperarEndereco(p));
        p.setDependente(recuperarDependente(p));
        return p;
    }

    @Override
    public ArrayList<Paciente> recuperarTodos() {
        String sql = "SELECT * FROM paciente";
        ArrayList<Paciente> lista = new ArrayList<>();
        Paciente p;

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                p = new Paciente();
                String cpf = rs.getString("CPF");
                String nome = rs.getString("NOME");
                String identidade = rs.getString("IDENTIDADE");
                String sexo = rs.getString("SEXO");
                String nascimento = rs.getString("DATA_NASC");
                String naturalidade = rs.getString("NATURALIDADE");
                String uf = rs.getString("UF");

                p.setNome(nome);
                p.setCpf(cpf);
                p.setData_nasc(nascimento);
                p.setIdentidade(identidade);
                p.setSexo(sexo);
                p.setData_nasc(nascimento);
                p.setNaturalidade(naturalidade);
                p.setUf(uf);
               
                p.setPlano(recuperarPlano(p));
                p.setEndereco(recuperarEndereco(p));
                p.setDependente(recuperarDependente(p));
                
                lista.add(p);
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
       
        return lista; 
    }
    
    public static ArrayList<String> recuperarTelefones(String cpf){
        String sql = "SELECT * FROM Telefone_paciente WHERE cpf_paciente=?";
        ArrayList<String> l = new ArrayList<>();

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                String telefone = rs.getString("TELEFONE");
                
                l.add(telefone);
               
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return l;
    }
    
    public static Endereco recuperarEndereco(Paciente paciente){
        String sql = "SELECT * FROM Endereco WHERE cpf_paciente=?";
        Endereco end = new Endereco();

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, paciente.getCpf());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String cidade = rs.getString("CIDADE");
                String bairro = rs.getString("BAIRRO");
                String rua = rs.getString("RUA");
                String numero = rs.getString("NUMERO");
                String complemento = rs.getString("COMPLEMENTO");
                int cep = rs.getInt("CEP");

                end.setCidade(cidade);
                end.setBairro(bairro);
                end.setRua(rua);
                end.setNumero(numero);
                end.setComplemento(complemento);
                end.setCep(cep);
                
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return end;
    }
    
    public static Dependente recuperarDependente(Paciente paciente){
        String sql = "SELECT * FROM dependente WHERE cpf_paciente=?";
        Dependente dep = new Dependente();

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, paciente.getCpf());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String nome = rs.getString("NOME");
                String cpf = rs.getString("CPF_DEPENDENTE");
                String telefone = rs.getString("TELEFONE");
                

                dep.setNome(nome);
                dep.setCpf(cpf);
                dep.setTelefone(telefone);
                
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return dep;
    }
    
    public static ArrayList<Plano> recuperarPlano(Paciente paciente){
        ArrayList<Plano> planos = new ArrayList<>();
        recuperarPlanoEspecial(planos, paciente.getCpf());
        recuperarPlanoParticular(planos, paciente.getCpf());
        return planos;
    }
    
    private static void recuperarPlanoEspecial(ArrayList<Plano> l,String cpf){
        String sql = "SELECT * FROM PlanoEspecial WHERE cpf_paciente=?";
        PlanoEspecial pl;

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                pl = new PlanoEspecial();
                String nomePlano = rs.getString("NOMEPLANO");
                String codigo = rs.getString("CODIGO");
                String data_inicio = rs.getString("DATA_INICIO");
                String data_vencimento = rs.getString("DATA_VENCIMENTO");

                pl.setNomePlano(nomePlano);
                pl.setCodigo(codigo);
                pl.setData_inicio(data_inicio);
                pl.setData_vencimento(data_vencimento);
                
                l.add(pl);
               
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void recuperarPlanoParticular(ArrayList<Plano> l,String cpf){
        String sql = "SELECT * FROM PlanoParticular WHERE cpf_paciente=?";
        PlanoParticular pl;

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                pl = new PlanoParticular();
                
                String data_inicio = rs.getString("DATA_INICIO");
                String data_vencimento = rs.getString("DATA_VENCIMENTO");

               
                pl.setData_inicio(data_inicio);
                pl.setData_vencimento(data_vencimento);
                
                l.add(pl);
               
            }

            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
