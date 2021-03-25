package classes;

import auxiliares.Endereco;
import auxiliares.Plano;
import auxiliares.PlanoEspecial;
import auxiliares.PlanoParticular;
import java.util.ArrayList;
        
public class Paciente {

    private String nome;
    private String cpf;
    private String identidade;
    private String sexo;
    private String data_nasc;
    private Dependente dependente = null;
    private String naturalidade;
    private ArrayList <String> telefones;
    private String uf;
    private ArrayList <Plano> plano;
    private Endereco endereco;

    public Paciente(String nome, String cpf, String identidade, Endereco endereco, String sexo, String data_nasc, Dependente dependente, String naturalidade, ArrayList<String> telefones, String uf, ArrayList<Plano> plano) {
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.dependente = dependente;
        this.naturalidade = naturalidade;
        this.telefones = telefones;
        this.uf = uf;
        this.plano = plano;
        this.endereco = endereco;
    }
    
    public Paciente(){
        
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    

    public String getIdentidade() {
        return identidade;
    }

   

    public String getNaturalidade() {
        return naturalidade;
    }

    public ArrayList<String> getTelefones() {
        return telefones;
    }

    public String getUf() {
        return uf;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public ArrayList<Plano> getPlano() {
        return plano;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public void setPlano(ArrayList<Plano> plano) {
        this.plano = plano;
    }

    public void setTelefones(ArrayList<String> telefones) {
        this.telefones = telefones;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
}
