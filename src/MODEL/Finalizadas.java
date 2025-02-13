/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class Finalizadas {
  private  int idFinalizada;
  private  String qualFuncionario; 
  private  boolean turno ;
  private  boolean status;
  private  int idPaciente ;
  private   int idDeposito ;
  private  boolean dietaPaciente ;

    public Finalizadas(String qualFuncionario, boolean turno, boolean status, int idPaciente, int idDeposito, boolean dietaPaciente) {
        this.qualFuncionario = qualFuncionario;
        this.turno = turno;
        this.status = status;
        this.idPaciente = idPaciente;
        this.idDeposito = idDeposito;
        this.dietaPaciente = dietaPaciente;
    }

    public Finalizadas(int idFinalizada, String qualFuncionario, boolean turno, boolean status, int idPaciente, int idDeposito, boolean dietaPaciente) {
        this.idFinalizada = idFinalizada;
        this.qualFuncionario = qualFuncionario;
        this.turno = turno;
        this.status = status;
        this.idPaciente = idPaciente;
        this.idDeposito = idDeposito;
        this.dietaPaciente = dietaPaciente;
    }

    public Finalizadas() {
    }

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

    public boolean isDietaPaciente() {
        return dietaPaciente;
    }

    public void setDietaPaciente(boolean dietaPaciente) {
        this.dietaPaciente = dietaPaciente;
    }
   
}
