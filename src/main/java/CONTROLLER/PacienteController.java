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
    
    //metodo novo para criar presquicão apartir do nome da dieta
  
public Deposito buscarDietaNoDeposito(String nomeDieta) {
    String query = "SELECT idDieta, nomedieta FROM Deposito WHERE nomedieta = ?";
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        
        preparedStatement.setString(1, nomeDieta);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Deposito deposito = new Deposito();
            deposito.setIdDieta(resultSet.getInt("idDieta"));
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
public Deposito buscarDietaNoDeposito2(String nomeDieta) {
    String query = "SELECT idDieta, nomedieta FROM Deposito WHERE nomedieta = ?";
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        
        preparedStatement.setString(1, nomeDieta);  // Passa o nome da dieta como parâmetro
        
        // Executa a consulta e obtém os resultados
        ResultSet resultSet = preparedStatement.executeQuery();

        // Verifica se a dieta foi encontrada
        if (resultSet.next()) {
            // Cria um novo objeto Deposito e popula com os dados retornados
            Deposito deposito = new Deposito();
            deposito.setIdDieta(resultSet.getInt("idDieta"));
            deposito.setNomedieta(resultSet.getString("nomedieta"));
            return deposito;  // Retorna o objeto Deposito com a dieta encontrada
        } else {
            // Caso a dieta não seja encontrada, exibe mensagem de erro
            System.err.println("Dieta não encontrada no depósito: " + nomeDieta);
            return null;  // Retorna null se não encontrar a dieta
        }
    } catch (SQLException e) {
        // Trata erros de banco de dados
        System.err.println("Erro ao buscar dieta no depósito: " + e.getMessage());
        return null;  // Retorna null em caso de erro
    }
}


// fim do metodo nome dieta


    // Método para obter uma lista de pacientes
public List<Paciente> listarPacientes() {
    List<Paciente> lista = new ArrayList<>();
    String query = """
    SELECT p.idPaciente, p.nomePaciente, p.leito, p.ala, p.nomeDieta
    FROM Paciente p
    """;
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement pstmt = conexao.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            Paciente p = new Paciente();
            p.setIdPaciente(rs.getInt("idPaciente"));
            p.setNomePaciente(rs.getString("nomePaciente"));
            p.setLeito(rs.getString("leito"));
            p.setAla(rs.getString("ala"));
            p.setNomeDieta(rs.getString("nomeDieta")); // Pegando diretamente da tabela Paciente
            lista.add(p);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}
//----------------------------------------------------------

//Verifica se paciente já existe
public boolean pacienteExiste(String nomePaciente) {
    // Aqui você vai verificar no banco de dados ou lista se o paciente já existe
    // Exemplo com banco de dados (suponha que você use JDBC):

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean existe = false;

    try {
        conn = Conexao.getConexao(); // Método que retorna a conexão com o BD
        String sql = "SELECT COUNT(*) FROM pacientes WHERE nome = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, nomePaciente);
        rs = stmt.executeQuery();

        if (rs.next()) {
            existe = rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Fechar conexão, statement e resultset
        try { if (rs != null) rs.close(); } catch (SQLException e) {}
        try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }

    return existe;
}


//-----------------------------------------------------------------------------
//-------------------------------------------------------------------------------   
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
    
    
   // Método para atualizar informações da dieta do paciente-------------------
/*public boolean atualizarDietasPac(String nomePaciente, String nomeDieta) {
    // Primeiro, buscar a dieta no depósito com base no nome
   PacienteController controller = new PacienteController();
Deposito deposito = controller.buscarDietaNoDeposito(nomeDieta);


    // Se a dieta não for encontrada, exibe uma mensagem
    if (deposito == null) {
        System.err.println("Dieta não encontrada para o paciente.");
        return false;
    }

    // Se a dieta for encontrada, agora fazemos a atualização do paciente
    String query = "UPDATE Paciente SET idDieta=? WHERE nomePaciente=?";

    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, deposito.getIdDieta()); // Atualizar com o idDieta
        preparedStatement.setString(2, nomePaciente); // Nome do paciente

        int atualizou = preparedStatement.executeUpdate();
        return atualizou > 0; // Se atualizou, retorna true

    } catch (SQLException e) {
        System.err.println("Erro ao atualizar a dieta do paciente! " + e);
        return false;
    }
}*/
    public boolean atualizarPaciente(String nomePaciente, String nomeDieta, String ala, String leito) {
    // Primeiro, buscar a dieta no depósito com base no nome
    Deposito deposito = buscarDietaNoDeposito(nomeDieta);

    // Se a dieta não for encontrada, exibe uma mensagem
    if (deposito == null) {
        System.err.println("Dieta não encontrada para o paciente.");
        return false;
    }

    // Atualiza os campos: idDieta, ala, leito
    String query = "UPDATE Paciente SET idDieta = ?, ala = ?, leito = ? WHERE nomePaciente = ?";

    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, deposito.getIdDieta());
        preparedStatement.setString(2, ala);
        preparedStatement.setString(3, leito);
        preparedStatement.setString(4, nomePaciente);

        int atualizado = preparedStatement.executeUpdate();
        return atualizado > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao atualizar dados do paciente: " + e);
        return false;
    }
}

//---------------------------------------------------------------------------
   /* public Deposito buscarDietaNoDeposito(String nomeDieta) {
    String query = "SELECT idDieta, nomedieta FROM Deposito WHERE nomedieta = ?";
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        
        preparedStatement.setString(1, nomeDieta);  // Passa o nome da dieta como parâmetro
        
        // Executa a consulta e obtém os resultados
        ResultSet resultSet = preparedStatement.executeQuery();

        // Verifica se a dieta foi encontrada
        if (resultSet.next()) {
            // Cria um novo objeto Deposito e popula com os dados retornados
            Deposito deposito = new Deposito();
            deposito.setIdDieta(resultSet.getInt("idDieta"));
            deposito.setNomedieta(resultSet.getString("nomedieta"));
            return deposito;  // Retorna o objeto Deposito com a dieta encontrada
        } else {
            // Caso a dieta não seja encontrada, exibe mensagem de erro
            System.err.println("Dieta não encontrada no depósito: " + nomeDieta);
            return null;  // Retorna null se não encontrar a dieta
        }
    } catch (SQLException e) {
        // Trata erros de banco de dados
        System.err.println("Erro ao buscar dieta no depósito: " + e.getMessage());
        return null;  // Retorna null em caso de erro
    }
}
*/

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
                paciente.setDieta(rs.getString("Dieta")); // Agora pegando o nomeDieta em vez de idDieta

                // Converte o status para "Sim" ou "Não"
                boolean status = rs.getBoolean("Status");
                paciente.setStatus(status ? "Sim" : "Não");

                dadosInformacao.add(paciente);
            }
        }
    }

    return dadosInformacao;
}

/*public List<InformacaoPaciente> ListarInformacaoPacientesView(String nomePaciente) throws SQLException {
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
*/

// fim da listagem


}
