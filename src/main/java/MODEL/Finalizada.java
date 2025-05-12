/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class Finalizada {
    private int idFinalizada;
    private String qualFuncionario; 
    private boolean turno;
    private boolean status;
    private int idPaciente;
    private int idDeposito;
    private int idDieta; // Novo campo adicionado
    private String nomePaciente; // Novo campo adicionado
    private String leito; // Novo campo adicionado
    private String ala; // Novo campo adicionado
    private String nomedieta;
    // Construtor padrão
    public Finalizada() {
    }

    public Finalizada(String qualFuncionario, boolean turno, boolean status, int idPaciente, int idDeposito, int idDieta, String nomePaciente, String leito, String ala, String nomedieta) {
        this.qualFuncionario = qualFuncionario;
        this.turno = turno;
        this.status = status;
        this.idPaciente = idPaciente;
        this.idDeposito = idDeposito;
        this.idDieta = idDieta;
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.ala = ala;
        this.nomedieta = nomedieta;
    }

    public Finalizada(int idFinalizada, String qualFuncionario, boolean turno, boolean status, int idPaciente, int idDeposito, int idDieta, String nomePaciente, String leito, String ala, String nomedieta) {
        this.idFinalizada = idFinalizada;
        this.qualFuncionario = qualFuncionario;
        this.turno = turno;
        this.status = status;
        this.idPaciente = idPaciente;
        this.idDeposito = idDeposito;
        this.idDieta = idDieta;
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.ala = ala;
        this.nomedieta = nomedieta;
    }

  

    // Getters and Setters for all fields
    public int getIdFinalizada() {
        return idFinalizada;
    }

    public void setIdFinalizada(int idFinalizada) {
        this.idFinalizada = idFinalizada;
    }

    public String getQualFuncionario() {
        return qualFuncionario;
    }

    public void setQualFuncionario(String qualFuncionario) {
        this.qualFuncionario = qualFuncionario;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDeposito() {
        return idDeposito;
    }

    public void setIdDeposito(int idDeposito) {
        this.idDeposito = idDeposito;
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

    public String getNomedieta() {
        return nomedieta;
    }

    public void setNomedieta(String nomedieta) {
        this.nomedieta = nomedieta;
    }
    
}
