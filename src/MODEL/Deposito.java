/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class Deposito {
 private int  idDeposito;
private String dietaDeposito;
private String dataRecibo;
private boolean conforme;
private String validade ;
private String quantidade ;

    public Deposito(String dietaDeposito, String dataRecibo, boolean conforme, String validade, String quantidade) {
        this.dietaDeposito = dietaDeposito;
        this.dataRecibo = dataRecibo;
        this.conforme = conforme;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public Deposito(int idDeposito, String dietaDeposito, String dataRecibo, boolean conforme, String validade, String quantidade) {
        this.idDeposito = idDeposito;
        this.dietaDeposito = dietaDeposito;
        this.dataRecibo = dataRecibo;
        this.conforme = conforme;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public Deposito() {
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
    }

    public String getDietaDeposito() {
        return dietaDeposito;
    }

    public void setDietaDeposito(String dietaDeposito) {
        this.dietaDeposito = dietaDeposito;
    }

    public String getDataRecibo() {
        return dataRecibo;
    }

    public void setDataRecibo(String dataRecibo) {
        this.dataRecibo = dataRecibo;
    }

    public boolean isConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    

}
