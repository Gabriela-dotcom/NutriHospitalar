/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Finalizadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edi
 */
public class DietasController {
     public List<Finalizadas> listaReservaDetalhesNaoEntregue() {
        String query = "SELECT * FROM ReservaDetalhes where entregue = false;";
        List<Finalizadas> lista = new ArrayList<>();
        try (Connection conexao = new Conexao().getConexao();
             PreparedStatement pstm = conexao.prepareStatement(query);
             ResultSet resultset = pstm.executeQuery()) {

            while (resultset.next()) {
                Finalizadas r = new Finalizadas();
                r.setIdFinalizada(resultset.getInt("idFinalizada"));
                r.setQualFuncionario(resultset.getString("qualFuncionario"));
                r.setTurno(resultset.getBoolean("turno"));
                r.setStatus(resultset.getBoolean("Status"));
                r.setIdPaciente(resultset.getInt("idPaciente"));
                r.setIdDeposito(resultset.getInt("idDeposito"));
                r.setDietaPaciente(resultset.getBoolean("DietaPaciente"));

                lista.add(r);
            }
            return lista;

        } catch (SQLException e) {
            System.err.print("Erro ao listar Reservas" + e);
            return null;
        }
    }
    public List<Object[]> getDadosFinalizada() throws SQLException { 
    List<Object[]> dadosFinalizada = new ArrayList<>(); 
    
    String query = "SELECT idfinalizada, qualFuncionario, turno, Status, idPaciente, idDeposito, dietaPaciente FROM tabelaReservasInfo"; 
    
    try (Connection conexao = new Conexao().getConexao(); 
         PreparedStatement pstmt = conexao.prepareStatement(query); 
         ResultSet rf = pstmt.executeQuery()) { 
        
        while (rf.next()) { 
            Object[] linha = { 
                rf.getInt("idFinalizada"), 
                rf.getString("nomeQualfuncionario"), 
                rf.getString("turno"), 
                rf.getBoolean("status") ? "Finalizada" : "Não Finalizada" ,
                rf.getString("idPaciente"), 
                rf.getString("idDeposito"), 
                rf.getString("dietaPaciente") 
            }; 
            dadosFinalizada.add(linha); 
        } 
    } 
    
    return dadosFinalizada; 
}
    
 public boolean atualizarFinalizadaInfo() {
        try (Connection conexao = Conexao.getConexao()) { 
           verificarECriarInformacaoPaciente(); // Verificar e criar a tabela se necessário

            // Limpar a tabela antes de inserir novos dados
            String limparQuery = "DELETE FROM informacaoPaciente"; 
            try (PreparedStatement pstmt = conexao.prepareStatement(limparQuery)) { 
                pstmt.executeUpdate(); 
            }

            String query = "CREATE TABLE IF NOT EXISTS finalizada (" +
                     "idFinalizada INT PRIMARY KEY, " +
                     "turno BOOLEAN, " +
                     "status BOOLEAN, " +
                     "idPaciente INT, " +
                     "idDeposito INT, " +
                     "dietaPaciente VARCHAR(40), " +
                     "FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente), " +
                     "FOREIGN KEY (idDeposito) REFERENCES Deposito(idDeposito)";
            try (PreparedStatement pstmt = conexao.prepareStatement(query)) { 
                pstmt.executeUpdate(); 
                return true; 
  
        } catch (SQLException e) { 
                e.printStackTrace(); 
                return false; 
            
        }
        }
 }
        
    public boolean verificarECriarInformacaoPaciente() {
        // Implementação do método para verificar e criar a tabela finalizada, se necessário
        String sql = "CREATE TABLE IF NOT EXISTS informacaoPaciente (" +
                     "idFinalizada INT PRIMARY KEY, "+
                     "qualFuncionario BOOLEAN,"+
                     "turno BOOLEAN,"+
                     "status BOOLEAN,"+
                     "idPaciente INT,"+
                     "idDeposito INT,"+
                     "dietaPaciente VARCHAR(40),"+
                   "FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente),"+
                    "FOREIGN KEY (idDeposito) REFERENCES Deposito(idDeposito);";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
