/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


public class Consulta {
    private Paciente paciente;
    private Tratamento tratamento;
    private double preco;
    private boolean pago = false;

    public Consulta(Paciente paciente, Tratamento tratamento, double preco) {
        this.paciente = paciente;
        this.tratamento = tratamento;
        this.preco = preco;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Tratamento getTratamento() {
        return tratamento;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isPago() {
        return pago;
    }

    public void setTratamento(Tratamento tratamento) {
        this.tratamento = tratamento;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
    
}
