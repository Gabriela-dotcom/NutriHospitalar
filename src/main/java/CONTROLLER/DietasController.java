/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLLER;
//import MODEl.Dieta;
import MODEL.Deposito;
import MODEL.Dieta;
import MODEL.Finalizadas;
import MODEL.InformacaoPaciente;
import MODEL.InformacaoPacienteFim;
import MODEL.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author edi
 */
public class DietasController {
  

   //cadastra uma finalizada, preenchendo  apenas o nome, leito, ala, dieta e
   // deixando o Status "False" no cao "Não".
   /* public boolean cadastrarFinalizada(Finalizadas finalizada) {
    String query = "INSERT INTO finalizada (nomePaciente, leito, ala, idDieta, nomedieta, status) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

        preparedStatement.setString(1, finalizada.getNomePaciente());
        preparedStatement.setString(2, finalizada.getLeito());
        preparedStatement.setString(3, finalizada.getAla());
        preparedStatement.setInt(4, finalizada.getIdDieta());
        preparedStatement.setString(5, finalizada.getNomedieta()); // Nome da dieta agora está correto
        preparedStatement.setBoolean(6, false); // Define o status como false

        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao cadastrar prescrição: " + e.getMessage());
        return false;
    }
}
*/
    //buscar dieta-----------------------------------------------
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
    //-------------------------------------------------------------------------
    
//Cadastro por dieta-------------------------------------------------------------
public boolean cadastrarPrescricaoPorDieta(String nomeDieta, String nomePaciente, String leito, String ala) {
    Deposito deposito = buscarDietaNoDeposito(nomeDieta); // Obtém os dados da dieta no depósito
    
    if (deposito == null) {
        JOptionPane.showMessageDialog(null, "Dieta não encontrada no depósito! Verifique o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String query = "INSERT INTO finalizada (nomePaciente, leito, ala, idDieta, nomedieta, status) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {

        preparedStatement.setString(1, nomePaciente);
        preparedStatement.setString(2, leito);
        preparedStatement.setString(3, ala);
        preparedStatement.setInt(4, deposito.getIdDieta()); // Usa o ID da dieta do depósito
        preparedStatement.setString(5, deposito.getNomedieta()); // Usa o nome da dieta do depósito
        preparedStatement.setBoolean(6, false); // Define o status como false

        int resultado = preparedStatement.executeUpdate();
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Prescrição cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a prescrição.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    } catch (SQLException e) {
        System.err.println("Erro ao cadastrar prescrição: " + e.getMessage());
        return false;
    }
}
//-------------------------------------------------------------------------

//fim metodo cadastrar
   // cadastrar finalizada por nome
   /* public boolean cadastrarFinalizada(Finalizadas finalizada) {
    // Obtém o ID da dieta a partir do nome
    int idDieta = obterIdDietaPorNome(finalizada.getNomeDieta());

    if (idDieta == -1) {
        System.err.println("Erro: Dieta não encontrada para prescrição.");
        return false;
    }

    String query = "INSERT INTO finalizada (nomePaciente, leito, ala, idDieta, status)"
                 + " VALUES (?, ?, ?, ?, ?)";
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
         
        preparedStatement.setString(1, finalizada.getNomePaciente());
        preparedStatement.setString(2, finalizada.getLeito());
        preparedStatement.setString(3, finalizada.getAla());
        preparedStatement.setInt(4, idDieta); // Agora passamos o ID obtido da dieta
        preparedStatement.setBoolean(5, false); // Define o status como false

        int cadastrou = preparedStatement.executeUpdate();
        return cadastrou > 0;

    } catch (SQLException e) {
        System.err.println("Erro ao cadastrar prescrição: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}

 // fim  cadastrar por nome   
    */
//metodo novo para criar presquicão apartir do nome da dieta
 /*   public int obterIdDietaPorNome(String nomeDieta) {
    String query = "SELECT idDieta FROM Dieta WHERE nomeDieta = ?";
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        
        preparedStatement.setString(1, nomeDieta);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("idDieta"); // Retorna o ID da dieta correspondente
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar ID da dieta: " + e.getMessage());
        e.printStackTrace();
    }
    return -1; // Retorna -1 se não encontrar a dieta
}*/
    // fim do metodo nome dieta


   
      // Método para listar detalhes de reservas não entregues
    public List<Finalizadas> listaReservaDetalhesNaoEntregue() {
        String query = "SELECT * FROM finalizada WHERE status = false;";
        List<Finalizadas> lista = new ArrayList<>();
        
        try (Connection conexao = Conexao.getConexao();
             PreparedStatement pstm = conexao.prepareStatement(query);
             ResultSet resultset = pstm.executeQuery()) {

            while (resultset.next()) {
                Finalizadas r = new Finalizadas();
                r.setIdFinalizada(resultset.getInt("idFinalizada"));
                r.setQualFuncionario(resultset.getString("qualFuncionario"));
                r.setTurno(resultset.getBoolean("turno"));
                r.setStatus(resultset.getBoolean("status"));
                r.setIdPaciente(resultset.getInt("idPaciente"));
                r.setIdDeposito(resultset.getInt("idDeposito"));
               

                lista.add(r);
            }
            return lista;

        } catch (SQLException e) {
            System.err.println("Erro ao listar Reservas: " + e);
            return null;
        }
    }

    //metodo para preencher a tabela que contem todas as informações de finaliza
    //da(metodo do pdf)
  

    // Método para listar informações de pacientes a partir da VIEW 'InformacaoPacientesFim'
public List<InformacaoPacienteFim> getDadosInformacaoPacienteFim() {
    String query = "SELECT * FROM InformacaoPacientesFim";
    List<InformacaoPacienteFim> lista = new ArrayList<>();

    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        while (resultSet.next()) {
            InformacaoPacienteFim info = new InformacaoPacienteFim();
            info.setIdFinalizada(resultSet.getInt("IdFinalizada"));
            info.setNome(resultSet.getString("Nome"));
            info.setLeito(resultSet.getString("Leito"));
            info.setNomedieta(resultSet.getInt("nomedieta"));
            info.setAla(resultSet.getString("Ala"));
            info.setTurno(resultSet.getBoolean("Turno"));
            info.setQualFuncionario(resultSet.getBoolean("QualFuncionario"));
            info.setStatus(resultSet.getBoolean("Status"));
            lista.add(info);
        }

    } catch (SQLException e) {
        System.err.println("Erro ao obter dados das finalizações! " + e);
        e.printStackTrace();
    }

    return lista;
}
//------------------------------------------------------------------




//dados de finalizada----------------------------------------------------
 public List<Object[]> getDadosFinalizada() throws SQLException {
    List<Object[]> dadosFinalizada = new ArrayList<>();

    // Consulta SQL ajustada
    String query = "SELECT f.idFinalizada, p.nomePaciente, p.leito, f.idDieta, f.turno, f.qualFuncionario, f.status, f.ala " +
                   "FROM finalizada f " +
                   "JOIN Paciente p ON f.idPaciente = p.idPaciente";

    try (Connection conexao = Conexao.getConexao(); 
         PreparedStatement pstmt = conexao.prepareStatement(query); 
         ResultSet rf = pstmt.executeQuery()) {

        while (rf.next()) {
            Object[] linha = { 
                rf.getInt("idFinalizada"), 
                rf.getString("nomePaciente"), 
                rf.getString("leito"), 
                rf.getInt("idDieta"), 
                rf.getBoolean("turno"),
                rf.getBoolean("qualFuncionario"),
                // Converte o booleano para "Finalizada" ou "Não Finalizada"
                rf.getBoolean("status") ? "Sim" : "Nãa",
                rf.getString("ala")  // Captura a ala
            };
            dadosFinalizada.add(linha);
        }
    }

//fim metodo do pdf
    return dadosFinalizada;
}
//------------------------------------------------------------------------
    // Método para atualizar informações finalizadas
   public List<Paciente> pesquisarPacientePorNome(String nome) {
    List<Paciente> pacientes = new ArrayList<>();
    
    String query = "SELECT p.idPaciente, p.nomePaciente, p.leito, p.idDieta, p.ala, " +
                   "d.nomeDieta " +
                   "FROM Paciente p " +
                   "JOIN Dieta d ON p.idDieta = d.idDieta " +
                   "WHERE p.nomePaciente LIKE ?";
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
        
        // Utiliza LIKE para buscar pelo nome do paciente
        preparedStatement.setString(1, "%" + nome + "%");
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        // Preenche a lista de pacientes com as informações encontradas
        while (resultSet.next()) {
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(resultSet.getInt("idPaciente"));
            paciente.setNomePaciente(resultSet.getString("nomePaciente"));
            paciente.setLeito(resultSet.getString("leito"));
            paciente.setIdDieta(resultSet.getInt("idDieta"));
            paciente.setAla(resultSet.getString("ala"));
            
            pacientes.add(paciente);
        }
        
    } catch (SQLException e) {
        System.err.println("Erro ao buscar paciente: " + e);
    }
    
    return pacientes;
}

//metodo para deposito comfirmar!!!!!   
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
                           "FOREIGN KEY (idDeposito) REFERENCES Deposito(idDeposito));";
            try (PreparedStatement pstmt = conexao.prepareStatement(query)) { 
                pstmt.executeUpdate(); 
                return true; 
            } catch (SQLException e) { 
                e.printStackTrace(); 
                return false; 
            }
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return false; 
        }
    }
    //fim desse metodo

  //metodos de prequiçãos de pacientes
     // Método para verificar e criar a tabela informacaoPaciente, se necessário
    public List<InformacaoPaciente> getDadosInformacaoPacientesView() throws SQLException {
    List<InformacaoPaciente> dadosInformacao = new ArrayList<>();
    String sql = "SELECT Nome, Leito, IdDieta, Status FROM InformacaoPacientes";  // A consulta SQL

    try (Connection conexao = Conexao.getConexao();
         PreparedStatement pstmt = conexao.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            InformacaoPaciente paciente = new InformacaoPaciente();
            paciente.setNome(rs.getString("Nome"));
            paciente.setLeito(rs.getString("Leito"));
            paciente.setIdDieta(rs.getInt("IdDieta"));

            // Converte o status para "Sim" ou "Não"
            boolean status = rs.getBoolean("Status");
            paciente.setStatus(status ? "Sim" : "Não");  // Aqui o status será "Sim" ou "Não"

            dadosInformacao.add(paciente);
        }
    }
    return dadosInformacao;
}
    

    public boolean verificarECriarInformacaoPaciente() {
        String sql = "CREATE TABLE IF NOT EXISTS informacaoPaciente (" +
                     "idFinalizada INT PRIMARY KEY, " +
                     "qualFuncionario BOOLEAN, " +
                     "turno BOOLEAN, " +
                     "status BOOLEAN, " +
                     "idPaciente INT, " +
                     "idDeposito INT, " +
                     "dietaPaciente VARCHAR(40), " +
                     "FOREIGN KEY (idPaciente) REFERENCES Paciente(idPaciente), " +
                     "FOREIGN KEY (idDeposito) REFERENCES Deposito(idDeposito));";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
//Preenche  a tabela tabelaAtualizarPrescricao
/*public List<Object[]> getDadosInformacaoPacientesView() throws SQLException {
    List<Object[]> dadosInformacao = new ArrayList<>();
    String sql = "SELECT Nome, Leito, IdDieta, TurnoResponsavel, Status FROM InformacaoPacientes";

    try (Connection conexao = Conexao.getConexao();
         PreparedStatement pstmt = conexao.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        while (rs.next()) {
            Object[] linha = new Object[5];
            linha[0] = rs.getString("Nome");
            linha[1] = rs.getString("Leito");
            linha[2] = rs.getString("IdDieta");
            linha[3] = rs.getBoolean("TurnoResponsavel");
            
            // Converte o booleano para "Sim" ou "Não"
            boolean status = rs.getBoolean("Status");
            linha[4] = status ? "Sim" : "Não";  // Aqui, "Sim" para true e "Não" para false

            dadosInformacao.add(linha);
        }
    }
    return dadosInformacao;
}
*/


    //fim Atualizar Deita paciete
    
//codigo para converter dados da combo box de deposito para booleanos
public boolean finalizarAtualizacao(String nomePaciente, boolean qualFuncionario, boolean turno, boolean status) {
    String query = "UPDATE finalizada SET qualFuncionario=?, turno=?, status=? WHERE nomePaciente=?";
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        // Definir os parâmetros da consulta
        preparedStatement.setBoolean(1, qualFuncionario);
        preparedStatement.setBoolean(2, turno);
        preparedStatement.setBoolean(3, status);
        preparedStatement.setString(4, nomePaciente);
        
        int atualizou = preparedStatement.executeUpdate();
        return atualizou > 0;
        
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar a finalização do paciente! " + e);
        return false;
    }
}
public boolean excluirFinalizacao(int idFinalizada) {
    String query = "DELETE FROM finalizada WHERE idFinalizada=?";
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        // Definir o parâmetro da consulta
        preparedStatement.setInt(1, idFinalizada);
        
        int excluiu = preparedStatement.executeUpdate();
        return excluiu > 0;
        
    } catch (SQLException e) {
        System.err.println("Erro ao excluir a finalização! " + e);
        return false;
    }
}

//fim codigo combobox

//lista de infos finalizada deposito
 public List<Finalizadas> listarFinalizadas() {
        List<Finalizadas> listaFinalizadas = new ArrayList<>();

        String query = "SELECT f.idFinalizada, p.nomePaciente, p.leito, f.idDieta, p.ala, f.turno, f.qualFuncionario, f.status " +
                       "FROM finalizada f " +
                       "JOIN Paciente p ON f.idPaciente = p.idPaciente";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement pstmt = conexao.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Finalizadas finalizada = new Finalizadas();
                finalizada.setIdFinalizada(rs.getInt("idFinalizada"));
                finalizada.setQualFuncionario(rs.getString("qualFuncionario"));
                finalizada.setIdDieta(rs.getInt("idDieta"));
                finalizada.setIdPaciente(rs.getInt("idPaciente"));
                finalizada.setLeito(rs.getString("leito"));
                finalizada.setAla(rs.getString("ala"));
                finalizada.setTurno(rs.getBoolean("turno"));
                finalizada.setStatus(rs.getBoolean("status"));
                listaFinalizadas.add(finalizada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaFinalizadas;
    }
//fim da lista deposito finalizada
 
 //deposito tudo
 public List<Deposito> listarDepositoTudo() {
    String query = "SELECT idDeposito, idDieta, lote, fornecedor, validade, quantidade, conforme, nomedieta FROM Deposito";
    List<Deposito> lista = new ArrayList<>();

    // Usando try-with-resources para garantir o fechamento dos recursos automaticamente
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        // Iterando sobre o ResultSet para preencher a lista
        while (resultSet.next()) {
            Deposito item = new Deposito();
            item.setIdDeposito(resultSet.getInt("idDeposito"));
            item.setIdDieta(resultSet.getInt("idDieta"));
            item.setLote(resultSet.getString("lote"));
            item.setFornecedor(resultSet.getString("fornecedor"));
            item.setValidade(resultSet.getString("validade"));
            item.setQuantidade(resultSet.getInt ("quantidade"));
            item.setConforme(resultSet.getBoolean("conforme"));
            item.setNomedieta(resultSet.getString("nomedieta"));
            lista.add(item);
        }

    } catch (SQLException e) {
        System.err.println("Erro ao listar dados da tabela Deposito! " + e.getMessage());
        e.printStackTrace();  // Logando o stack trace para facilitar a depuração
    }

    return lista;
}
//fim deposito tudo
 
 
public boolean adicionarDeposito(String tipoDieta, String lote, String fornecedor, String validade, int quantidade, boolean conforme) {
    int idDieta = criarDieta(tipoDieta); // Cria a dieta se necessário e obtém o ID

    if (idDieta == -1) {
        System.err.println("Erro ao criar dieta. A operação de depósito foi cancelada.");
        return false;
    }

    // Consulta SQL atualizada para incluir o campo 'nomedieta'
    String query = "INSERT INTO Deposito (idDieta, lote, fornecedor, validade, quantidade, conforme, nomedieta) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, idDieta);
        preparedStatement.setString(2, lote);
        preparedStatement.setString(3, fornecedor);
        preparedStatement.setString(4, validade);
        preparedStatement.setInt(5, quantidade);
        preparedStatement.setBoolean(6, conforme);
        preparedStatement.setString(7, tipoDieta); // Adicionando nomedieta

        int adicionou = preparedStatement.executeUpdate();

        if (adicionou > 0) {
            System.out.println("Dieta adicionada ao depósito com sucesso!");
            return true;
        } else {
            System.err.println("Erro ao adicionar dieta ao depósito.");
            return false;
        }

    } catch (SQLException e) {
        System.err.println("Erro ao adicionar no depósito! " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}


//fim controller infor deposito
 
 // cria dieta no banco de dados
 public int criarDieta(String tipoDieta) {
    String query = "INSERT INTO Dieta (tipoDieta) VALUES (?) RETURNING idDieta";
    
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setString(1, tipoDieta);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        } else {
            throw new SQLException("Erro ao criar dieta: ID não retornado.");
        }
    } catch (SQLException e) {
        System.err.println("Erro ao criar dieta! " + e);
        return -1;
    }
}
 //fim da criacao de dietas
 
 //listagem de Finalizadas e Deposito
 // Método para listar os dados da view v_finalizada_deposito
public List<Finalizadas> listarFinDeposito() {
    String query = "SELECT idFinalizada, qualFuncionario, turno, status, idPaciente, idDeposito, idDieta, nomePaciente, leito, ala FROM finalizada";
    List<Finalizadas> lista = new ArrayList<>();

    // Usando try-with-resources para garantir o fechamento dos recursos automaticamente
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {

        // Iterando sobre o ResultSet para preencher a lista
        while (resultSet.next()) {
            Finalizadas item = new Finalizadas();
            item.setIdFinalizada(resultSet.getInt("idFinalizada"));
            item.setQualFuncionario(resultSet.getString("qualFuncionario"));
            item.setTurno(resultSet.getBoolean("turno"));
            item.setStatus(resultSet.getBoolean("status"));
            item.setIdPaciente(resultSet.getInt("idPaciente"));
            item.setIdDeposito(resultSet.getInt("idDeposito"));
            item.setIdDieta(resultSet.getInt("idDieta"));
            item.setNomePaciente(resultSet.getString("nomePaciente"));
            item.setLeito(resultSet.getString("leito"));
            item.setAla(resultSet.getString("ala"));
            lista.add(item);
        }

    } catch (SQLException e) {
        System.err.println("Erro ao listar dados da tabela finalizada! " + e.getMessage());
        e.printStackTrace();  // Logando o stack trace para facilitar a depuração
    }

    return lista;
}


 //fim listagem finalizadas+deposito

 //atualizar finalizada de não para sim
 public boolean atualizarStatusFinalizacao(int idFinalizada, boolean status) {
    String query = "UPDATE finalizada SET status = ? WHERE idFinalizada = ?";
    
    try (Connection connection = Conexao.getConexao();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        
        preparedStatement.setBoolean(1, status);
        preparedStatement.setInt(2, idFinalizada);
        
        int linhasAtualizadas = preparedStatement.executeUpdate();
        return linhasAtualizadas > 0;
    } catch (SQLException e) {
        System.err.println("Erro ao atualizar o status! " + e);
        e.printStackTrace();
        return false;
    }
}

 //fim do metodo atualizar finalizada de não para sim
 
 //descontar dietas
    public boolean descontarEstoque(int idDieta, int quantidade) {
        String query = "UPDATE Deposito SET quantidade = quantidade - ? WHERE idDieta = ?";
        
        try (Connection conexao = Conexao.getConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
            
            // Configurar os parâmetros da declaração
            preparedStatement.setInt(1, quantidade);
            preparedStatement.setInt(2, idDieta);
            
            // Executar a atualização
            int linhasAfetadas = preparedStatement.executeUpdate();
            
            // Retorna true se pelo menos uma linha foi afetada
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 public int obterIdDieta(int idFinalizada) {
        String query = "SELECT idDieta FROM Finalizada WHERE idFinalizada = ?";
        try (Connection conexao = Conexao.getConexao();
             PreparedStatement preparedStatement = conexao.prepareStatement(query)) {
            
            // Configurar o parâmetro da consulta
            preparedStatement.setInt(1, idFinalizada);

            // Executar a consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Retornar o idDieta se encontrado
                    return resultSet.getInt("idDieta");
                } else {
                    // Retornar um valor especial (por exemplo, -1) se não for encontrado
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Retornar um valor especial em caso de erro
            return -1;
        }
    }

 //fim descontar dietas
}

 

