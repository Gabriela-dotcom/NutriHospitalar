/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author edi
 */
public class Deposito {
    private int idDeposito;
    private int idDieta; // Atualizado para referenciar a tabela Dieta
    private String lote;
    private String fornecedor;
    private String validade;
    private int quantidade;
    private boolean conforme;
    private String nomedieta;
    // Construtor padrão
    public Deposito() {
    }

    public Deposito(int idDeposito, String lote, String fornecedor, String validade, int quantidade, boolean conforme, String nomedieta) {
        this.idDeposito = idDeposito;
        this.lote = lote;
        this.fornecedor = fornecedor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.conforme = conforme;
        this.nomedieta = nomedieta;
    }

    public Deposito(int idDeposito, int idDieta, String lote, String fornecedor, String validade, int quantidade, boolean conforme, String nomedieta) {
        this.idDeposito = idDeposito;
        this.idDieta = idDieta;
        this.lote = lote;
        this.fornecedor = fornecedor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.conforme = conforme;
        this.nomedieta = nomedieta;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isConforme() {
        return conforme;
    }

    public void setConforme(boolean conforme) {
        this.conforme = conforme;
    }

    public String getNomedieta() {
        return nomedieta;
    }

    public void setNomedieta(String nomedieta) {
        this.nomedieta = nomedieta;
    }

   

   
}
 
