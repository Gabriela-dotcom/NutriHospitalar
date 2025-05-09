/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;

import MODEL.Deposito;
import MODEL.InformacaoPaciente;
import MODEL.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    
    public Deposito buscarDietaPorNome(String nomeDieta) {
    String query = "SELECT nomedieta FROM Deposito WHERE nomedieta = ?";
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        
        preparedStatement.setString(1, nomeDieta);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Deposito deposito = new Deposito();
            deposito.setNomedieta(resultSet.getString("nomedieta"));
            return deposito;
        } else {
            System.err.println("Dieta não encontrada no depósito: " + nomeDieta);
            return null;
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar dieta no depósito: " + e.getMessage());
        return null;
    }
}

    
    
  /*  public boolean cadastrarPaciente(Paciente paciente) {
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
    }*/
    public boolean cadastrarPaciente(String nomePaciente, String leito, String ala, String nomeDieta) {
    Deposito deposito = buscarDietaPorNome(nomeDieta); // Busca a dieta no depósito

    if (deposito == null) {
        JOptionPane.showMessageDialog(null, "Dieta não encontrada no depósito! Verifique o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String query = "INSERT INTO Paciente (nomePaciente, leito, ala, nomedieta) VALUES (?, ?, ?, ?)";

    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

        preparedStatement.setString(1, nomePaciente);
        preparedStatement.setString(2, leito);
        preparedStatement.setString(3, ala);
        preparedStatement.setString(4, deposito.getNomedieta()); // Usa o nome da dieta

        int resultado = preparedStatement.executeUpdate();
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    } catch (SQLException e) {
        System.err.println("Erro ao cadastrar paciente: " + e.getMessage());
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

//listagem para pesquisa de paciente para tabela 
public List<InformacaoPaciente> ListarInformacaoPacientesView(String nomePaciente) throws SQLException {
    List<InformacaoPaciente> dadosInformacao = new ArrayList<>();
    String sql = "SELECT * FROM InformacaoPacientes WHERE Nome LIKE ?;";

    try (Connection conexao = Conexao.getConexao();
         PreparedStatement pstmt = conexao.prepareStatement(sql)) {

        pstmt.setString(1, "%" + nomePaciente + "%");  // '%' para busca parcial

        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                InformacaoPaciente paciente = new InformacaoPaciente();
                paciente.setNome(rs.getString("Nome"));
                paciente.setLeito(rs.getString("Leito"));
                paciente.setIdDieta(rs.getInt("IdDieta"));

                // Converte o status para "Sim" ou "Não"
                boolean status = rs.getBoolean("Status");
                paciente.setStatus(status ? "Sim" : "Não");

                dadosInformacao.add(paciente);
            }
        }
    }

    return dadosInformacao;
}


// fim da listagem


}
