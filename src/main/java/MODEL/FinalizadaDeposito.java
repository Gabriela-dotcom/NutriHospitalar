/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class FinalizadaDeposito {
    private int idFinalizada;
    private int idDieta;
    private String nomePaciente;
    private String leito;
    private String ala;
    private String validade;
    private String quantidade;

    public FinalizadaDeposito() {
    }

    public FinalizadaDeposito(int idDieta, String nomePaciente, String leito, String ala, String validade, String quantidade) {
        this.idDieta = idDieta;
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.ala = ala;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public FinalizadaDeposito(int idFinalizada, int idDieta, String nomePaciente, String leito, String ala, String validade, String quantidade) {
        this.idFinalizada = idFinalizada;
        this.idDieta = idDieta;
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.ala = ala;
        this.validade = validade;
        this.quantidade = quantidade;
    }

    public int getIdFinalizada() {
        return idFinalizada;
    }

    public void setIdFinalizada(int idFinalizada) {
        this.idFinalizada = idFinalizada;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getLeito() {
        return leito;
    }

    public void setLeito(String leito) {
        this.leito = leito;
    }

    public String getAla() {
        return ala;
    }

    public void setAla(String ala) {
        this.ala = ala;
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
    

