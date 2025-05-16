/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author devmat
 */
public class InformacaoPacienteFim {

   private int idFinalizada;
    private String nomedieta;
    private String nome;
    private String leito;
    private String ala;
    private String turno;
    private String qualFuncionario;  // Responsável
    private boolean status;

    public InformacaoPacienteFim() {
    }

    public InformacaoPacienteFim(String nomedieta, String nome, String leito, String ala, String turno, String qualFuncionario, boolean status) {
        this.nomedieta = nomedieta;
        this.nome = nome;
        this.leito = leito;
        this.ala = ala;
        this.turno = turno;
        this.qualFuncionario = qualFuncionario;
        this.status = status;
    }

    public InformacaoPacienteFim(int idFinalizada, String nomedieta, String nome, String leito, String ala, String turno, String qualFuncionario, boolean status) {
        this.idFinalizada = idFinalizada;
        this.nomedieta = nomedieta;
        this.nome = nome;
        this.leito = leito;
        this.ala = ala;
        this.turno = turno;
        this.qualFuncionario = qualFuncionario;
        this.status = status;
    }

    public int getIdFinalizada() {
        return idFinalizada;
    }

    public void setIdFinalizada(int idFinalizada) {
        this.idFinalizada = idFinalizada;
    }

    public String getNomedieta() {
        return nomedieta;
    }

    public void setNomedieta(String nomedieta) {
        this.nomedieta = nomedieta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getQualFuncionario() {
        return qualFuncionario;
    }

    public void setQualFuncionario(String qualFuncionario) {
        this.qualFuncionario = qualFuncionario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

}
