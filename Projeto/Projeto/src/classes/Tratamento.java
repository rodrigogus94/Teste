
package classes;

public class Tratamento {
    
    private String tipo;
    private double preco;
    private int sessoes;

    public Tratamento() {
    }

    public Tratamento(String tipo, double preco, int sessoes) {
        this.tipo = tipo;
        this.preco = preco;
        this.sessoes = sessoes;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    public int getSessoes() {
        return sessoes;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setSessoes(int sessoes) {
        this.sessoes = sessoes;
    }
    
    
    
}
