
package auxiliares;


public class PlanoEspecial extends Plano{
    private String nomePlano;
    private String codigo;

    public PlanoEspecial(String nomePlano, String codigo, String data_inicio, String data_vencimento) {
        super(data_inicio, data_vencimento);
        this.nomePlano = nomePlano;
        this.codigo = codigo;
    }

    public PlanoEspecial() {
        
    }
    
    public String getNomePlano() {
        return nomePlano;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
}
