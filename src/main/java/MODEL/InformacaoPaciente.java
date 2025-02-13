/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author devmat
 */
    
   public class InformacaoPaciente {
    private String nome;
    private String leito;
    private String dieta;
    private String status;  // O status será uma String, "Sim" ou "Não"
    private int idDieta;

    public InformacaoPaciente() {
    }

    public InformacaoPaciente(String nome, String leito, String dieta, String status, int idDieta) {
        this.nome = nome;
        this.leito = leito;
        this.dieta = dieta;
        this.status = status;
        this.idDieta = idDieta;
    }

    // Getters e setters
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

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }
}



