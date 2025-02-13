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
  private int idPaciente ;
  private  String nomePaciente ;
  private  String leito;
  private  String dietaPaciente;
  private  String ala ;

    public Paciente(String nomePaciente, String leito, String dietaPaciente, String ala) {
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.dietaPaciente = dietaPaciente;
        this.ala = ala;
    }

    public Paciente(int idPaciente, String nomePaciente, String leito, String dietaPaciente, String ala) {
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
        this.leito = leito;
        this.dietaPaciente = dietaPaciente;
        this.ala = ala;
    }

    public Paciente() {
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

    public String getDietaPaciente() {
        return dietaPaciente;
    }

    public void setDietaPaciente(String dietaPaciente) {
        this.dietaPaciente = dietaPaciente;
    }

    public String getAla() {
        return ala;
    }

    public void setAla(String ala) {
        this.ala = ala;
    }
    
}
