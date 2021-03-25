/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

public class Endereco {
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento = null;
    private int cep;

    public Endereco(String cidade,String bairro, String rua, String numero, int cep) {
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
    }
    
    public Endereco(){
        
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }
    
    public String getCidade(){
        return cidade;
    }
    
    public String getComplemento(){
        return complemento;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
}
