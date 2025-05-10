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
    private String nome;
    private String leito;
    private int nomedieta;
    private String ala;
    private boolean turno;
    private boolean qualFuncionario;  // Responsável
    private boolean status;

    public InformacaoPacienteFim() {
    }

    public InformacaoPacienteFim(String nome, String leito, int nomedieta, String ala, boolean turno, boolean qualFuncionario, boolean status) {
        this.nome = nome;
        this.leito = leito;
        this.nomedieta = nomedieta;
        this.ala = ala;
        this.turno = turno;
        this.qualFuncionario = qualFuncionario;
        this.status = status;
    }

    public InformacaoPacienteFim(int idFinalizada, String nome, String leito, int nomedieta, String ala, boolean turno, boolean qualFuncionario, boolean status) {
        this.idFinalizada = idFinalizada;
        this.nome = nome;
        this.leito = leito;
        this.nomedieta = nomedieta;
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

    public int getNomedieta() {
        return nomedieta;
    }

    public void setNomedieta(int nomedieta) {
        this.nomedieta = nomedieta;
    }

   

    public String getAla() {
        return ala;
    }

    public void setAla(String ala) {
        this.ala = ala;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isQualFuncionario() {
        return qualFuncionario;
    }

    public void setQualFuncionario(boolean qualFuncionario) {
        this.qualFuncionario = qualFuncionario;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
