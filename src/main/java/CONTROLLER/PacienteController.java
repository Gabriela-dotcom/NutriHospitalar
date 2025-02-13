/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Paciente;
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
public class PacienteController {
      // Método para inserir um paciente no banco de dados
  /*  public boolean inserirPaciente(Paciente p) {
        String query = "INSERT INTO Paciente( nomePaciente, leito, ala, idDieta) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = Conexao.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(query)) {
          
            pstmt.setString(2, p.getNomePaciente());
            pstmt.setString(3, p.getLeito());
            pstmt.setString(4, p.getAla());
            pstmt.setInt(5, p.getIdDieta());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }*/

    // Método para obter uma lista de pacientes
    public List<Paciente> listarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        String query = "SELECT idPaciente, nomePaciente, leito, ala, idDieta FROM Paciente";
        try (Connection conexao = Conexao.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("idPaciente"));
                p.setNomePaciente(rs.getString("nomePaciente"));
                p.setLeito(rs.getString("leito"));
                p.setAla(rs.getString("ala"));
                p.setIdDieta(rs.getInt("idDieta"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean cadastrarPaciente(Paciente paciente) {
        String query = "INSERT INTO Paciente (nomePaciente, leito, idDieta, ala)"
                     + " VALUES (?, ?, ?, ?)";

        try (Connection connection = Conexao.getConexao();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Mandar os dados para dentro do INSERT
            preparedStatement.setString(1, paciente.getNomePaciente());
            preparedStatement.setString(2, paciente.getLeito());
            preparedStatement.setInt(3, paciente.getIdDieta());
            preparedStatement.setString(4, paciente.getAla());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Imprimindo erro que deu ao inserir usuário
            System.err.print("Erro ao Inserir Dados: " + e);
            return false;
        }
    }
  /*  public boolean editarPaciente(Paciente paciente) {
    String query = "UPDATE Paciente SET nomePaciente = ?, leito = ?, idDieta = ?, ala = ? WHERE idPaciiente = ?";
    // Conexão com o banco de dados
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        // Mandar os dados para o método update
        preparedStatement.setString(1, paciente.getNomePaciente());
        preparedStatement.setString(2, paciente.getLeito());
        preparedStatement.setInt(3, paciente.getIdDieta());
        preparedStatement.setString(4, paciente.getAla());
        

        int atualizou = preparedStatement.executeUpdate();
        return atualizou > 0;

    } catch (SQLException e) {
        System.err.print("Erro ao atualizar o paciente! " + e);
        return false;
    } // fim do catch
} // fim editarPaciente
*/
   // Método para atualizar informações da dieta do paciente
public boolean atualizarDietasPac(Paciente paciente) {
    String query = "UPDATE Paciente SET idDieta=? WHERE nomePaciente=?";
    // Conexão com o banco de dados
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        // Enviar o novo idDieta para o banco
        preparedStatement.setInt(1, paciente.getIdDieta());
        preparedStatement.setString(2, paciente.getNomePaciente());
        
        int atualizou = preparedStatement.executeUpdate();
        return atualizou > 0;
        
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar a dieta do paciente! " + e);
        return false;
    }
}


}
