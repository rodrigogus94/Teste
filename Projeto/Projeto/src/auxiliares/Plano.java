/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

/**
 *
 * @author CASA
 */
public abstract class Plano {
    private String data_inicio;
    private String data_vencimento;

    public Plano(String data_inicio, String data_vencimento) {
        this.data_inicio = data_inicio;
        this.data_vencimento = data_vencimento;
    }

    public Plano() {
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }
    
}
