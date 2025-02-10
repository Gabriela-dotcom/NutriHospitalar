/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author UFNT
 */
public class Conexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/nutriHospitalar";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    // Método para obter a conexão
    public Connection getConexao() {
        try {
            // Tenta estabelecer a conexão
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            
            System.err.println("Conectado");
            return conexao;
        } catch (SQLException e) {
            // Trata o erro de conexão
            e.printStackTrace();  // Exibe mais detalhes sobre o erro
            return null;
        }
    }
}
    

