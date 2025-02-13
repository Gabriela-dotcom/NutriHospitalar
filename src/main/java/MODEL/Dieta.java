/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class Dieta {
      int idDieta;
     String nomeDieta;

    public Dieta() {
    }

    public Dieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }

    public Dieta(int idDieta, String nomeDieta) {
        this.idDieta = idDieta;
        this.nomeDieta = nomeDieta;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNomeDieta() {
        return nomeDieta;
    }

    public void setNomeDieta(String nomeDieta) {
        this.nomeDieta = nomeDieta;
    }
     
}
