/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class Paciente {
    private int idPaciente;
    private String nomePaciente;
    private String leito;
    private int idDieta; // Atualizado para referenciar a tabela Dieta
    private String ala;

    // Construtor padrão
    public Paciente() {
    }

    // Construtor sem idPaciente (se necessário)
    public Paciente(String nomePaciente, String leito, int idDieta, String ala) {
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.idDieta = idDieta;
        this.ala = ala;
    }

    // Construtor completo
    public Paciente(int idPaciente, String nomePaciente, String leito, int idDieta, String ala) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.idDieta = idDieta;
        this.ala = ala;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getAla() {
        return ala;
    }

    public void setAla(String ala) {
        this.ala = ala;
    }

   
    
}
