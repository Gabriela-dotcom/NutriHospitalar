/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

/**
 *
 * @author devmat
 */
public class Deposito {
    private int idDieta;
    private String lote;
    private String fornecedor;
    private String validade;
    private String quantidade;
    private boolean conforme;

    public Deposito() {
    }

    public Deposito(int idDieta, String lote, String fornecedor, String validade, String quantidade, boolean conforme) {
        this.idDieta = idDieta;
        this.lote = lote;
        this.fornecedor = fornecedor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.conforme = conforme;
    }

    public Deposito(String lote, String fornecedor, String validade, String quantidade, boolean conforme) {
        this.lote = lote;
        this.fornecedor = fornecedor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.conforme = conforme;
    }

    // Getters e Setters
    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
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

    public boolean isConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }
}


