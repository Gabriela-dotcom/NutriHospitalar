/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;

import CONTROLLER.Conexao;
import CONTROLLER.DietasController;
import CONTROLLER.PacienteController;
import MODEL.Deposito;
import MODEL.Finalizada;
import MODEL.InformacaoPaciente;
import MODEL.Paciente;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devmat'
 */
public class TelaNutricionista extends javax.swing.JFrame {

    public TelaNutricionista() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criação ou chamada dos componentes
        initComponents(); // se estiver usando NetBeans
        iconeTela();
        PesquisaPacientes(); // Chama o método para ativar a pesquisa
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(prescreverNutricionista, BorderLayout.CENTER);

        Listagem();
        ListagemAT();
        ListagemDePacientes();

            dietasAt.setVisible(false);
        tabelaPresStatus.setVisible(false);

        setVisible(true); // No final
        
    }


    
 // Método sem argumento, lista todos os pacientes
public void ListagemDePacientes() {
    ListagemDePacientes(""); // Chama a versão do método com filtro passando uma string vazia
}
private void iconeTela(){  
        try {

        Image iconeTitulo = ImageIO.read(getClass().getResource("/icones/saude.png"));
       
            this.setIconImage(iconeTitulo);
           
        } catch(IOException ex) {
          System.out.println("Erro ao importar icone: " + ex.getMessage());
        }        
   
    }
// Método com filtro por nome do paciente-------------------------------
public void ListagemDePacientes(String nomePaciente) {
    // Chamando o controlador que obtém os dados dos pacientes com o filtro
    PacienteController controller = new PacienteController();

    // Capturando a lista de pacientes filtrada pelo nome
    List<InformacaoPaciente> listaPacientes = null;
    try {
        listaPacientes = controller.ListarInformacaoPacientesView(nomePaciente);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao listar pacientes: " + ex.getMessage());
        return; // Evita continuar caso ocorra um erro
    }

    // Obtendo o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaNutriTudo1.getModel();

    // Limpando a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);

    // Verificando se a lista não é nula ou vazia
    if (listaPacientes != null && !listaPacientes.isEmpty()) {
        // Inserindo os dados na tabela
        for (InformacaoPaciente paciente : listaPacientes) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
                paciente.getNome(),
                paciente.getLeito(),
                paciente.getDieta(), // Troca idDieta por nomeDieta
                paciente.getStatus(),
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado.");
    }
}
public void ListagemDePacientes2(String nomePaciente) {
    PacienteController controller = new PacienteController();
    
    // Apenas chamamos o método normalmente, sem try-catch
    List<Paciente> listaPacientes = controller.listarPacientesPorNome(nomePaciente);

    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaNutriTudo1.getModel();
    modeloTabela.setRowCount(0);

    if (listaPacientes != null && !listaPacientes.isEmpty()) {
        for (Paciente paciente : listaPacientes) {
            modeloTabela.addRow(new Object[]{
                paciente.getNomePaciente(),
                paciente.getLeito(),
                paciente.getNomeDieta(),
                paciente.getAla()
            });
        }
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado.");
    }
}


//-----------------------------------------------------------------------

//Metodo de pesquisa-----------------------------------------------------
public void PesquisaPacientes() {
    pesquisarPaciente.getDocument().addDocumentListener(
        new DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                Pesquisar();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                Pesquisar();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                Pesquisar();
            }

            // Método de pesquisa que chama ListagemDePacientes com filtro
            private void Pesquisar() {
                String filtro = pesquisarPaciente.getText(); // Captura o texto digitado
                ListagemDePacientes(filtro); // Chama o método passando o filtro como parâmetro
            }
        }
    );
}
//------------------------------------------------------------------------------
    
    
    // Método para limpar os campos de cadastro do paciente
private void limparCampos() {
    campoNomePacienteP.setText("");  // Limpa o campo de nome do paciente
    campoNomeLeitoP.setText("");     // Limpa o campo de leito
    campoAlaP.setText("");           // Limpa o campo de ala
    dietaCampoP.setText("");         // Limpa o campo de ID da dieta
}
private void limparCamposAt() {
   campoPacienteA.setText("");  // Limpa o campo de nome do paciente
    campoAlaA.setText("");         // Limpa o campo de ID da dieta
    campoNomeLeitoP.setText("");           // Limpa o campo de ala
    dietaCampoP.setText("");
}
// Método para limpar os campos de reserva (caso haja campos específicos para isso)
private void limparCamposReservas() {
    // Aqui você pode limpar campos relacionados à reserva, se houver. Exemplo:
    campoNomePacienteP.setText("");  // Limpa o campo de nome do paciente
    campoNomeLeitoP.setText("");     // Limpa o campo de leito
    campoAlaP.setText("");           // Limpa o campo de ala
    dietaCampoP.setText("");         // Limpa o campo de ID da dieta
    // Adicione outros campos, caso haja, para limpar
}
//lista para atualizar
//aqui pegamosos dados do controller e jogamos na nossa tabela
   // Aqui pegamos os dados do controller e jogamos na nossa tabela
public void Listagem() {
    // Chamando o controller para acessar os dados dos pacientes
    PacienteController controller = new PacienteController();
    // Capturando a lista de informações dos pacientes do banco de dados
    List<Paciente> listaPacientes = controller.listarPacientes();
    
    // Obtendo o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPresquicao.getModel();
   
    // Limpando a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);
   
    // Verificando se a lista não é nula
    if (listaPacientes != null && !listaPacientes.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Paciente paciente : listaPacientes) {
            // Criando uma nova linha para a tabela
            Object[] linha = {
               
                paciente.getNomePaciente(),
                paciente.getLeito(),
                paciente.getNomeDieta(),

                paciente.getAla()
            };
            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado.");
    }
}

public void ListagemAT() {
    // Chamando o controller para acessar os dados dos pacientes
    PacienteController controller = new PacienteController();
    // Capturando a lista de informações dos pacientes do banco de dados
    List<Paciente> listaPacientes = controller.listarPacientes();
    
    // Obtendo o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaAtualizarPrescricao.getModel();
   
    // Limpando a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);
   
    // Verificando se a lista não é nula
    if (listaPacientes != null && !listaPacientes.isEmpty()) {
        // Jogando os dados para dentro da minha tabela
        for (Paciente paciente : listaPacientes) {
            // Criando uma nova linha para a tabela
           Object[] linha = {
    paciente.getNomePaciente(),
    paciente.getLeito(),
    paciente.getNomeDieta(), // ✅ Agora mostra o nome da dieta corretamente
    paciente.getAla()
};

            // Adicionando a linha ao modelo da tabela
            modeloTabela.addRow(linha);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum paciente encontrado.");
    }
}

// Método para atualizar os dados na tabela
/*private void atualizarTabela() {
    try {
        // Captura os valores dos campos de entrada
        String nomePaciente = campoPacienteA.getText();
        String leito = campoLeitoA.getText();
        int idDieta = Integer.parseInt(campoDietaA.getText());
        String ala = campoAla1.getText();
        
        // Cria o objeto Paciente com os dados fornecidos
        Paciente p = new Paciente();
        p.setNomePaciente(nomePaciente);
        p.setLeito(leito);
        p.setIdDieta(idDieta);
        p.setAla(ala);
        
        // Criar o controlador para acessar os dados da base de dados e atualizar o paciente
        PacienteController PController = new PacienteController();
        
        // Atualiza as informações do paciente na base de dados
        boolean sucesso = PController.editarPaciente(p);
        
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            listarDietas(); // Atualiza a tabela com os novos dados
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível atualizar o paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar o paciente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}

*/
//fim lista atualizar
    //listagem de paciente
/* public void Listagem() {
    try {
        // Chamando o PacienteController
        PacienteController pacienteController = new PacienteController();
        
        // Capturando a lista de pacientes do banco de dados
        List<Paciente> lista = pacienteController.listarPacientes();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel)tabelaPresquicao.getModel();
        
        // Verificando se o modelo da tabela já tem 5 colunas
        if (modeloTabela.getColumnCount() == 0) {
            // Definindo as colunas da tabela
            modeloTabela.addColumn("ID Paciente");
            modeloTabela.addColumn("Nome");
            modeloTabela.addColumn("Leito");
            modeloTabela.addColumn("ID Dieta");
            modeloTabela.addColumn("Ala");
        }
    
        // Limpando a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0);
    
        // Verificando se a lista não é nula
        if (lista != null && !lista.isEmpty()) {
            // Jogando os dados para dentro da tabela
            for (Paciente paciente : lista) {
                // Criando uma nova linha para a tabela
                Object[] linha = {
                    paciente.getIdPaciente(),
                    paciente.getNomePaciente(),
                    paciente.getLeito(),
                    paciente.getIdDieta() ,
                    paciente.getAla()
                };
                // Adicionando a linha ao modelo da tabela
                modeloTabela.addRow(linha);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum paciente cadastrado!");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela: " + e.getMessage());
    }
}*/
 //fim listagem
 //Listar finalizadas
/*
public void listarDietas1() {
    try {
        // Criar o controlador para acessar os dados das dietas
        DietasController dietasController = new DietasController();

        // Obter os dados das informações dos pacientes da VIEW
        List<InformacaoPaciente> dadosInformacao = dietasController.getDadosInformacaoPacientesView();

        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaNutriTudo1.getModel();

        // Verificando se o modelo da tabela já tem o número correto de colunas
        if (modeloTabela.getColumnCount() == 0) {
            modeloTabela.addColumn("Nome");
            modeloTabela.addColumn("Leito");
            modeloTabela.addColumn("idDieta");
              modeloTabela.addColumn("ID Dieta"); // Adicionando coluna para ID Dieta
            modeloTabela.addColumn("Status");
            
        }

        // Limpar a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0);

        // Adicionar cada linha de dados à tabela
        for (InformacaoPaciente paciente : dadosInformacao) {
            modeloTabela.addRow(new Object[]{
                paciente.getNome(),
                paciente.getLeito(),
                paciente.getDieta(),
                paciente.getStatus(),  // Status já será "Sim" ou "Não"
                paciente.getIdDieta()  // Adicionando ID Dieta
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela: " + e.getMessage());
    }
}


*/




 // fim listar dietas
    // Método para atualizar a tabela com a lista de pacientes
private void atualizarTabela(List<Object[]> dadosPaciente) {
    // Obter o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaPresquicao.getModel();
    
    // Limpar a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);

    // Adicionar cada linha de dados à tabela
    for (Object[] dados : dadosPaciente) {
        modeloTabela.addRow(dados);  // Adiciona cada array de dados como uma nova linha na tabela
    }
}
private void atualizarTabela2(List<Object[]> dadosPaciente) {
    // Obter o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaAtualizarPrescricao.getModel();
    
    // Limpar a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);

    // Adicionar cada linha de dados à tabela
    for (Object[] dados : dadosPaciente) {
        modeloTabela.addRow(dados);  // Adiciona cada array de dados como uma nova linha na tabela
    }
}
private void atualizarTabela3(List<Object[]> dadosPaciente) {
    // Obter o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaNutriTudo1.getModel();
    
    // Limpar a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);

    // Adicionar cada linha de dados à tabela
    for (Object[] dados : dadosPaciente) {
        modeloTabela.addRow(dados);  // Adiciona cada array de dados como uma nova linha na tabela
    }
}

 //fim  atualizar Tabela 
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        prescreverNutricionista = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        campoNomePacienteP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNomeLeitoP = new javax.swing.JTextField();
        cadastrarPresquicaoDia1 = new javax.swing.JButton();
        campoAlaP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dietaCampoP = new javax.swing.JTextField();
        dietaBotao = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPresquicao = new javax.swing.JTable();
        menuEsquerda3 = new javax.swing.JPanel();
        listaDeDietas3 = new javax.swing.JButton();
        atualizarDietas4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        saida = new javax.swing.JButton();
        usuario1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        atualizarTabelaBT2 = new javax.swing.JButton();
        imgFundoPresquicap = new javax.swing.JLabel();
        dietasAt = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        campoPacienteA = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campoAlaA = new javax.swing.JTextField();
        atualizarBT = new javax.swing.JButton();
        menuEsquerda1 = new javax.swing.JPanel();
        listaDeDietas1 = new javax.swing.JButton();
        presquicao2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        usuario2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAtualizarPrescricao = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        campoLeitoA = new javax.swing.JTextField();
        campoDietaA2 = new javax.swing.JTextField();
        atualizarTabelaBT1 = new javax.swing.JButton();
        imgAtualDiet = new javax.swing.JLabel();
        tabelaPresStatus = new javax.swing.JPanel();
        menuEsquerda2 = new javax.swing.JPanel();
        atualizarDietas2 = new javax.swing.JButton();
        presquicao3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        usuario3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pesquisarPaciente = new javax.swing.JTextField();
        pdfTudo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaNutriTudo1 = new javax.swing.JTable();
        atualizarTabelaBT = new javax.swing.JButton();
        botaoPD = new javax.swing.JButton();
        imgAtualDiet1 = new javax.swing.JLabel();
        imgFundoPresquicap1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prescreverNutricionista.setMaximumSize(new java.awt.Dimension(1920, 1080));
        prescreverNutricionista.setMinimumSize(new java.awt.Dimension(1920, 1080));
        prescreverNutricionista.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jLabel6.setBackground(java.awt.Color.lightGray);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("CADASTRAR PRESCRIÇÃO(do dia).");

        campoNomePacienteP.setBackground(new java.awt.Color(238, 236, 236));
        campoNomePacienteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomePacientePActionPerformed(evt);
            }
        });

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nome Paciente:");

        jLabel3.setBackground(java.awt.Color.black);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nome do Leito:");

        campoNomeLeitoP.setBackground(new java.awt.Color(238, 236, 236));
        campoNomeLeitoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeLeitoPActionPerformed(evt);
            }
        });

        cadastrarPresquicaoDia1.setBackground(new java.awt.Color(51, 102, 255));
        cadastrarPresquicaoDia1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cadastrarPresquicaoDia1.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarPresquicaoDia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/registro-online.png"))); // NOI18N
        cadastrarPresquicaoDia1.setText("Pedido");
        cadastrarPresquicaoDia1.setActionCommand("RESERVAR");
        cadastrarPresquicaoDia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPresquicaoDia1ActionPerformed(evt);
            }
        });

        campoAlaP.setBackground(new java.awt.Color(238, 236, 236));
        campoAlaP.setMaximumSize(new java.awt.Dimension(64, 22));
        campoAlaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlaPActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Dieta:");

        dietaCampoP.setBackground(new java.awt.Color(238, 236, 236));
        dietaCampoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietaCampoPActionPerformed(evt);
            }
        });

        dietaBotao.setBackground(new java.awt.Color(51, 102, 255));
        dietaBotao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dietaBotao.setForeground(new java.awt.Color(255, 255, 255));
        dietaBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/paciente (1).png"))); // NOI18N
        dietaBotao.setText("Cadastrar Paciente");
        dietaBotao.setActionCommand("RESERVAR");
        dietaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietaBotaoActionPerformed(evt);
            }
        });

        jLabel5.setBackground(java.awt.Color.black);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tabela de seleção do(a) Nutricionista");

        tabelaPresquicao.setBackground(new java.awt.Color(204, 204, 204));
        tabelaPresquicao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabelaPresquicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome Paciente", "Leito", "Dieta", "Ala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaPresquicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPresquicaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPresquicao);

        menuEsquerda3.setBackground(new java.awt.Color(51, 102, 255));
        menuEsquerda3.setForeground(new java.awt.Color(51, 102, 255));

        listaDeDietas3.setFont(new java.awt.Font("Modern No. 20", 0, 14)); // NOI18N
        listaDeDietas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/extensao-de-arquivo.png"))); // NOI18N
        listaDeDietas3.setLabel("Tabela");
        listaDeDietas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaDeDietas3ActionPerformed(evt);
            }
        });

        atualizarDietas4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        atualizarDietas4.setText("Atualizar Dietas");
        atualizarDietas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarDietas4ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel16.setText("Nutricionista");

        saida.setBackground(new java.awt.Color(255, 0, 0));
        saida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/man.png"))); // NOI18N
        saida.setText("Sair");
        saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saidaActionPerformed(evt);
            }
        });

        usuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imagem-do-usuario-com-fundo-preto.png"))); // NOI18N

        javax.swing.GroupLayout menuEsquerda3Layout = new javax.swing.GroupLayout(menuEsquerda3);
        menuEsquerda3.setLayout(menuEsquerda3Layout);
        menuEsquerda3Layout.setHorizontalGroup(
            menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEsquerda3Layout.createSequentialGroup()
                .addGroup(menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuEsquerda3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listaDeDietas3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuEsquerda3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel16))
                    .addGroup(menuEsquerda3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(atualizarDietas4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuEsquerda3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuEsquerda3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(saida)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        menuEsquerda3Layout.setVerticalGroup(
            menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarDietas4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(listaDeDietas3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Ala:");

        atualizarTabelaBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaBT2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout prescreverNutricionistaLayout = new javax.swing.GroupLayout(prescreverNutricionista);
        prescreverNutricionista.setLayout(prescreverNutricionistaLayout);
        prescreverNutricionistaLayout.setHorizontalGroup(
            prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, prescreverNutricionistaLayout.createSequentialGroup()
                .addGroup(prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(atualizarTabelaBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addComponent(menuEsquerda3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgFundoPresquicap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel2))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addGap(228, 228, 228)
                                .addComponent(jLabel4))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jLabel20))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(campoAlaP, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(cadastrarPresquicaoDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(campoNomeLeitoP, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(dietaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(dietaCampoP, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(campoNomePacienteP, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(667, 667, 667))
        );
        prescreverNutricionistaLayout.setVerticalGroup(
            prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                .addGroup(prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel20))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campoAlaP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(cadastrarPresquicaoDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel5))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(campoNomeLeitoP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(dietaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(dietaCampoP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(campoNomePacienteP, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(prescreverNutricionistaLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(jLabel2)
                            .addGap(45, 45, 45)
                            .addGroup(prescreverNutricionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(145, 145, 145)
                            .addComponent(jScrollPane1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(atualizarTabelaBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6))
                        .addComponent(imgFundoPresquicap, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menuEsquerda3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dietasAt.setBackground(new java.awt.Color(255, 255, 255));
        dietasAt.setForeground(new java.awt.Color(51, 102, 0));
        dietasAt.setMaximumSize(new java.awt.Dimension(1920, 1080));
        dietasAt.setMinimumSize(new java.awt.Dimension(1920, 1080));
        dietasAt.setName(""); // NOI18N
        dietasAt.setPreferredSize(new java.awt.Dimension(1920, 1080));
        dietasAt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setText("Atualizar Prescrição");
        dietasAt.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 230, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Nome do Paciente:");
        dietasAt.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 199, -1));

        campoPacienteA.setBackground(new java.awt.Color(238, 236, 236));
        campoPacienteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPacienteAActionPerformed(evt);
            }
        });
        dietasAt.add(campoPacienteA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 217, 28));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Leito:");
        dietasAt.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 199, 30));

        campoAlaA.setBackground(new java.awt.Color(238, 236, 236));
        campoAlaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlaAActionPerformed(evt);
            }
        });
        dietasAt.add(campoAlaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 217, 30));

        atualizarBT.setBackground(new java.awt.Color(51, 102, 255));
        atualizarBT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        atualizarBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        atualizarBT.setText("Atualizar");
        atualizarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarBTActionPerformed(evt);
            }
        });
        dietasAt.add(atualizarBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 580, 197, 50));

        menuEsquerda1.setBackground(new java.awt.Color(51, 102, 255));
        menuEsquerda1.setForeground(new java.awt.Color(255, 255, 255));
        menuEsquerda1.setPreferredSize(new java.awt.Dimension(205, 770));

        listaDeDietas1.setFont(new java.awt.Font("Modern No. 20", 0, 14)); // NOI18N
        listaDeDietas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/extensao-de-arquivo.png"))); // NOI18N
        listaDeDietas1.setLabel("Tabela");
        listaDeDietas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaDeDietas1ActionPerformed(evt);
            }
        });

        presquicao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/typewriter_4228946.png"))); // NOI18N
        presquicao2.setText("Cadastrar");
        presquicao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presquicao2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel17.setText("Nutricionista");

        usuario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imagem-do-usuario-com-fundo-preto.png"))); // NOI18N

        javax.swing.GroupLayout menuEsquerda1Layout = new javax.swing.GroupLayout(menuEsquerda1);
        menuEsquerda1.setLayout(menuEsquerda1Layout);
        menuEsquerda1Layout.setHorizontalGroup(
            menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEsquerda1Layout.createSequentialGroup()
                .addGroup(menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuEsquerda1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(listaDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuEsquerda1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(presquicao2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuEsquerda1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuEsquerda1Layout.setVerticalGroup(
            menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel17)
                .addGap(26, 26, 26)
                .addComponent(presquicao2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(listaDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        dietasAt.add(menuEsquerda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 180, 780));

        tabelaAtualizarPrescricao.setBackground(new java.awt.Color(204, 204, 204));
        tabelaAtualizarPrescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nomedo Paciente", "Leito", "Dieta", "Ala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaAtualizarPrescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAtualizarPrescricaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaAtualizarPrescricao);

        dietasAt.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 763, 263));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Ala:");
        dietasAt.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 199, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Dieta:");
        dietasAt.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 199, -1));

        campoLeitoA.setBackground(new java.awt.Color(238, 236, 236));
        campoLeitoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLeitoAActionPerformed(evt);
            }
        });
        dietasAt.add(campoLeitoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 217, 28));

        campoDietaA2.setBackground(new java.awt.Color(238, 236, 236));
        campoDietaA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDietaA2ActionPerformed(evt);
            }
        });
        dietasAt.add(campoDietaA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 217, 28));

        atualizarTabelaBT1.setBackground(new java.awt.Color(246, 242, 242));
        atualizarTabelaBT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/carregando.png"))); // NOI18N
        atualizarTabelaBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaBT1ActionPerformed(evt);
            }
        });
        dietasAt.add(atualizarTabelaBT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 560, 40, 30));

        imgAtualDiet.setBackground(new java.awt.Color(255, 255, 255));
        dietasAt.add(imgAtualDiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, -4, 820, 800));

        tabelaPresStatus.setBackground(new java.awt.Color(255, 255, 255));
        tabelaPresStatus.setMaximumSize(new java.awt.Dimension(1920, 1080));
        tabelaPresStatus.setMinimumSize(new java.awt.Dimension(1920, 1080));
        tabelaPresStatus.setPreferredSize(new java.awt.Dimension(1920, 1080));
        tabelaPresStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuEsquerda2.setBackground(new java.awt.Color(51, 102, 255));
        menuEsquerda2.setForeground(new java.awt.Color(51, 102, 255));

        atualizarDietas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        atualizarDietas2.setText("Atualizar Dietas");
        atualizarDietas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarDietas2ActionPerformed(evt);
            }
        });

        presquicao3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/typewriter_4228946.png"))); // NOI18N
        presquicao3.setText("Cadastrar");
        presquicao3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presquicao3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel15.setText("Nutricionista");

        usuario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imagem-do-usuario-com-fundo-preto.png"))); // NOI18N

        javax.swing.GroupLayout menuEsquerda2Layout = new javax.swing.GroupLayout(menuEsquerda2);
        menuEsquerda2.setLayout(menuEsquerda2Layout);
        menuEsquerda2Layout.setHorizontalGroup(
            menuEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEsquerda2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(presquicao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(atualizarDietas2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuEsquerda2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(menuEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuEsquerda2Layout.setVerticalGroup(
            menuEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(usuario3, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(jLabel15)
                .addGap(24, 24, 24)
                .addComponent(presquicao3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(atualizarDietas2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );

        tabelaPresStatus.add(menuEsquerda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 180, 800));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setText("Dieta Entregues Do Dia");
        tabelaPresStatus.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 288, 42));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Pesquisar:");
        tabelaPresStatus.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        pesquisarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarPacienteActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(pesquisarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 162, 433, 30));

        pdfTudo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pdfTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pdf-file-format_15266347.png"))); // NOI18N
        pdfTudo.setText("PDF");
        pdfTudo.setToolTipText("");
        pdfTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfTudoActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(pdfTudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 620, 138, 42));

        tabelaNutriTudo1.setBackground(new java.awt.Color(204, 204, 204));
        tabelaNutriTudo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome do paciente", "Leito", "Dieta", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaNutriTudo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaNutriTudo1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaNutriTudo1);

        tabelaPresStatus.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 719, 324));

        atualizarTabelaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaBTActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(atualizarTabelaBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 530, 40, 30));

        botaoPD.setForeground(new java.awt.Color(255, 255, 255));
        botaoPD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/magnifier (1).png"))); // NOI18N
        botaoPD.setBorder(null);
        botaoPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPDActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(botaoPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 40, 40));

        imgAtualDiet1.setMaximumSize(new java.awt.Dimension(128, 128));
        imgAtualDiet1.setMinimumSize(new java.awt.Dimension(128, 128));
        tabelaPresStatus.add(imgAtualDiet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 830, 820));
        tabelaPresStatus.add(imgFundoPresquicap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 860, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dietasAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tabelaPresStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(prescreverNutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dietasAt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tabelaPresStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(prescreverNutricionista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomePacientePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomePacientePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomePacientePActionPerformed

    private void campoNomeLeitoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeLeitoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeLeitoPActionPerformed

    private void cadastrarPresquicaoDia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPresquicaoDia1ActionPerformed
// Remove espaços em branco e valida
String nomePaciente = campoNomePacienteP.getText().trim();
String leito = campoNomeLeitoP.getText().trim();
String nomeDieta = dietaCampoP.getText().trim();
String ala = campoAlaP.getText().trim();

if (nomePaciente.isEmpty() || leito.isEmpty() || nomeDieta.isEmpty() || ala.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios. Preencha corretamente.");
} else {
    DietasController dao = new DietasController();
    boolean sucesso = dao.cadastrarPrescricaoPorDieta(nomeDieta, nomePaciente, leito, ala);

    if (sucesso) {
        Listagem();
        limparCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar. Verifique os dados e tente novamente.");
    }
}

    }//GEN-LAST:event_cadastrarPresquicaoDia1ActionPerformed

    private void campoAlaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAlaPActionPerformed

    private void dietaCampoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietaCampoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dietaCampoPActionPerformed

    private void dietaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dietaBotaoActionPerformed
// TODO add your handling code here:
// Método para cadastrar um novo paciente
/*
    if (campoNomePacienteP.getText().isEmpty() || campoNomeLeitoP.getText().isEmpty() || campoAlaP.getText().isEmpty() || dietaCampoP.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null,"Preencha todos os campos antes de cadastrar.");
    } else {
        // Captura os dados dos campos de entrada
        String nomePaciente = campoNomePacienteP.getText();
        String leito = campoNomeLeitoP.getText();
        int idDieta = Integer.parseInt(dietaCampoP.getText()); // Captura o ID da Dieta a partir do campo dietaCampo
        String ala = campoAlaP.getText();

        // Cria o objeto Paciente e define os dados
        Paciente p = new Paciente();
        p.setNomePaciente(nomePaciente);
        p.setLeito(leito);
        p.setIdDieta(idDieta); // Define o ID da Dieta
        p.setAla(ala); // Define o Ala

        // Cria um objeto PacientesController para cadastrar o paciente
        PacienteController dao = new PacienteController();
        boolean inserir = dao.cadastrarPaciente(p);

        // Verifica se a inserção foi bem-sucedida
        if (inserir) {
            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            Listagem(); // Atualiza a lista de pacientes
            limparCampos(); // Limpa os campos de entrada
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível cadastrar o paciente.", "Erro", JOptionPane.ERROR_MESSAGE);
            limparCamposReservas(); // Se falhar, limpa os campos
        }
    }*/

/*
// Captura os textos removendo espaços em branco
String nomePaciente = campoNomePacienteP.getText().trim();
String leito = campoNomeLeitoP.getText().trim();
String ala = campoAlaP.getText().trim();
String nomeDieta = dietaCampoP.getText().trim();

// Verifica se algum campo está vazio
if (nomePaciente.isEmpty() || leito.isEmpty() || ala.isEmpty() || nomeDieta.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de cadastrar.");
} else {
    PacienteController dao = new PacienteController();
    boolean sucesso = dao.cadastrarPaciente(nomePaciente, leito, ala, nomeDieta);

    if (sucesso) {
        Listagem();
        limparCampos();
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente. Verifique os dados.");
    }
}
*/


String nomePaciente = campoNomePacienteP.getText().trim();
String leito = campoNomeLeitoP.getText().trim();
String ala = campoAlaP.getText().trim();
String nomeDieta = dietaCampoP.getText().trim();

if (nomePaciente.isEmpty() || leito.isEmpty() || ala.isEmpty() || nomeDieta.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de cadastrar.");
} else {
    PacienteController dao = new PacienteController();

    if (dao.pacienteExiste(nomePaciente)) {
        JOptionPane.showMessageDialog(null, "Paciente com este nome já está cadastrado.");
    } else {
        boolean sucesso = dao.cadastrarPaciente(nomePaciente, leito, ala, nomeDieta);

        if (sucesso) {
            Listagem();
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente. Verifique os dados.");
        }
    }
}





    }//GEN-LAST:event_dietaBotaoActionPerformed

    private void campoPacienteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPacienteAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPacienteAActionPerformed

    private void campoAlaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAlaAActionPerformed

    private void atualizarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarBTActionPerformed
        // TODO add your handling code here:
  // Capturando os dados dos campos de entrada
// Capturando os dados dos campos de entrada
/*String nomePaciente = campoPacienteA.getText();
int idDieta = Integer.parseInt(campoDietaA.getText()); // Captura o ID da Dieta a partir do campo campoDieta

try {
    PacienteController controller = new PacienteController();
    // Objeto do tipo Paciente
    Paciente paciente = new Paciente();
    paciente.setNomePaciente(nomePaciente);
    paciente.setIdDieta(idDieta); // Define o ID da Dieta

    // Mandando o nome do paciente e o idDieta para o método de atualização
    boolean atualizou = controller.atualizarDietasPac(paciente);
    if (atualizou) {
        JOptionPane.showMessageDialog(null, "Dieta do paciente atualizada com sucesso!");
        ListagemAT();
        limparCamposAt();
    } else {
        JOptionPane.showMessageDialog(null, "Não foi possível atualizar a dieta do paciente.");
    }
} catch (Exception e) {
    System.err.print("Erro ao atualizar: " + e);  
}

*/
// Suponha que os dados do paciente e da dieta sejam inseridos em campos de texto
// Captura os valores dos campos
/*String nomePaciente = campoPacienteA.getText().trim();  // Nome do paciente
String nomeDieta = campoAlaA.getText().trim();  // Nome da dieta

// Chama o método do controller para atualizar a dieta
PacienteController pacienteController = new PacienteController();
boolean atualizado = pacienteController.atualizarDietasPac(nomePaciente, nomeDieta);

if (atualizado) {
    JOptionPane.showMessageDialog(null, "Dieta do paciente atualizada com sucesso!");
    ListagemAT();  // Método para atualizar a lista de pacientes, se necessário
    limparCamposAt();  // Limpa os campos da interface
} else {
    JOptionPane.showMessageDialog(null, "Erro ao atualizar a dieta. Verifique o nome do paciente ou dieta.");
}



       
 Listagem();
        ListagemAT();
      */
String nomePaciente = campoPacienteA.getText().trim();  // Nome do paciente
String nomeDieta = campoDietaA2.getText().trim();          // Nome da dieta
String ala = campoAlaA.getText().trim();                // Campo novo
String leito = campoLeitoA.getText().trim();            // Campo novo

PacienteController pacienteController = new PacienteController();
boolean atualizado = pacienteController.atualizarPaciente(nomePaciente, nomeDieta, ala, leito);

if (atualizado) {
    JOptionPane.showMessageDialog(null, "Informações do paciente atualizadas com sucesso!");
    Listagem();    // Atualiza a lista se necessário
    ListagemAT();  // Atualiza outra lista, se usada
    limparCamposAt();  // Limpa os campos da interface
    
} else {
    JOptionPane.showMessageDialog(null, "Erro ao atualizar. Verifique o nome do paciente ou a dieta.");
}


    }//GEN-LAST:event_atualizarBTActionPerformed

    private void pdfTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfTudoActionPerformed
        // TODO add your handling code here:
  TelaInfoNutri info = new TelaInfoNutri();
       info.setVisible(true);
        dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);
    tabelaPresStatus.setVisible(false);
     Listagem();
        ListagemAT();
     
    }//GEN-LAST:event_pdfTudoActionPerformed

    private void pesquisarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarPacienteActionPerformed
        // TODO add your handling code here:
        DietasController dietasController = new DietasController();

        pesquisarPaciente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pesquisar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pesquisar();
            }

            private void pesquisar() {
                String nomePaciente = pesquisarPaciente.getText();

                try {
                    // Chama o método do controller para buscar os dados finalizados
                    List<Object[]> dadosFinalizada = dietasController.getDadosFinalizada();

                    // Filtra os dados com base no nome do paciente
                    List<Object[]> dadosFiltrados = new ArrayList<>();
                    for (Object[] dados : dadosFinalizada) {
                        String nome = (String) dados[1];  // Índice 1 é onde está o nome do paciente
                        if (nome.toLowerCase().contains(nomePaciente.toLowerCase())) {
                            dadosFiltrados.add(dados);
                        }
                    }

                    // Atualiza a tabela com os dados encontrados
                    atualizarTabela(dadosFiltrados);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao pesquisar pacientes: " + e.getMessage());
                }
            }
        });
    }//GEN-LAST:event_pesquisarPacienteActionPerformed

    private void tabelaPresquicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPresquicaoMouseClicked

        int linhaSelecionada = tabelaPresquicao.getSelectedRow();
        
        // Verificando se alguma linha foi selecionada
        if(linhaSelecionada >= 0){
            // Definir modelo default para a tabela
            DefaultTableModel modelotabela = (DefaultTableModel)tabelaPresquicao.getModel();
            
            // Jogando os dados da tabela para os campos de texto
            campoNomePacienteP.setText(modelotabela.getValueAt(linhaSelecionada, 0).toString()); // Nome
            campoNomeLeitoP.setText(modelotabela.getValueAt(linhaSelecionada, 1).toString()); // Leito
            dietaCampoP.setText(modelotabela.getValueAt(linhaSelecionada, 2).toString()); // Dieta (ID Dieta)
            campoAlaP.setText(modelotabela.getValueAt(linhaSelecionada, 3).toString()); // Ala
            
            // Adicione outros campos conforme necessário
        } // fim do if
    
        
    }//GEN-LAST:event_tabelaPresquicaoMouseClicked

    private void listaDeDietas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaDeDietas3ActionPerformed
        // TODO add your handling code here:
         dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(true);
   
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
        
    }//GEN-LAST:event_listaDeDietas3ActionPerformed

    private void atualizarDietas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarDietas4ActionPerformed
        // TODO add your handling code here:
        dietasAt.setVisible(true);
    tabelaPresStatus.setVisible(false);
    
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
        
    }//GEN-LAST:event_atualizarDietas4ActionPerformed

    private void presquicao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presquicao2ActionPerformed
        // TODO add your handling code here:
          dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);
   
    prescreverNutricionista.setVisible(true); 
     Listagem();
        ListagemAT();
        
    }//GEN-LAST:event_presquicao2ActionPerformed

    private void presquicao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presquicao3ActionPerformed
        // TODO add your handling code here:
                 dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);
 
    prescreverNutricionista.setVisible(true); 
     Listagem();
        ListagemAT();
        
    }//GEN-LAST:event_presquicao3ActionPerformed

    private void atualizarDietas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarDietas2ActionPerformed
        // TODO add your handling code here:
                 dietasAt.setVisible(true);
    tabelaPresStatus.setVisible(false);
    
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
      
    }//GEN-LAST:event_atualizarDietas2ActionPerformed

    private void listaDeDietas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaDeDietas1ActionPerformed
        // TODO add your handling code here:
                 dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(true);
   
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
       
    }//GEN-LAST:event_listaDeDietas1ActionPerformed

    private void tabelaAtualizarPrescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAtualizarPrescricaoMouseClicked
        // TODO add your handling code here:
     /*    int linhaSelecionada = tabelaAtualizarPrescricao.getSelectedRow();
        
        // Verificando se alguma linha foi selecionada
        if(linhaSelecionada >= 0){
            // Definir modelo default para a tabela
            DefaultTableModel modelotabela = (DefaultTableModel)tabelaAtualizarPrescricao.getModel();
            
            // Jogando os dados da tabela para os campos de texto
            campoPacienteA.setText(modelotabela.getValueAt(linhaSelecionada, 0).toString()); // Nome
           
            campoAlaA.setText(modelotabela.getValueAt(linhaSelecionada, 2).toString()); // Ala
            
            // Adicione outros campos conforme necessário
        } // fim do if
    
        */
      int linhaSelecionada = tabelaAtualizarPrescricao.getSelectedRow();
        
        // Verificando se alguma linha foi selecionada
        if(linhaSelecionada >= 0){
            // Definir modelo default para a tabela
            DefaultTableModel modelotabela = (DefaultTableModel)tabelaAtualizarPrescricao.getModel();
            
            // Jogando os dados da tabela para os campos de texto
            campoPacienteA.setText(modelotabela.getValueAt(linhaSelecionada, 0).toString()); // Nome
           campoLeitoA.setText(modelotabela.getValueAt(linhaSelecionada, 1).toString()); // Leito
            campoDietaA2.setText(modelotabela.getValueAt(linhaSelecionada, 2).toString()); // Dieta (ID Dieta)
            campoAlaA.setText(modelotabela.getValueAt(linhaSelecionada, 3).toString()); // Ala
            
            // Adicione outros campos conforme necessário
        } // fim do if

    }//GEN-LAST:event_tabelaAtualizarPrescricaoMouseClicked

    private void saidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saidaActionPerformed
        // TODO add your handling code here:
        loginTela login = new loginTela();
        login.setVisible(true);
dietasAt.setVisible(true);
    tabelaPresStatus.setVisible(false);
    dietasAt.setVisible(true);
        ((JFrame) SwingUtilities.getWindowAncestor(saida)).dispose();
        // Dentro do construtor da tela de depósito

    }//GEN-LAST:event_saidaActionPerformed

    private void tabelaNutriTudo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaNutriTudo1MouseClicked
        // TODO add your handling code here:
         // Captura a linha que o usuário clicou
    int linhaSelecionada = tabelaNutriTudo1.getSelectedRow();
    
    if (linhaSelecionada >= 0) {
        // Define o modelo padrão da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaNutriTudo1.getModel();

        // Captura os valores da linha selecionada
        String nomePaciente = modeloTabela.getValueAt(linhaSelecionada, 0).toString(); // Coluna "Nome"
        String leitoPaciente = modeloTabela.getValueAt(linhaSelecionada, 1).toString(); // Coluna "Leito"
        int idDieta = Integer.parseInt(modeloTabela.getValueAt(linhaSelecionada, 2).toString()); // Coluna "IdDieta"
        String statusPaciente = modeloTabela.getValueAt(linhaSelecionada, 3).toString(); // Coluna "Status"

       
    }
        
    }//GEN-LAST:event_tabelaNutriTudo1MouseClicked

    private void campoLeitoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoLeitoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoLeitoAActionPerformed

    private void campoDietaA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDietaA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDietaA2ActionPerformed

    private void atualizarTabelaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaBTActionPerformed
        // TODO add your handling code here:

        atualizarTabelaBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método que atualiza a tabela
                ListagemDePacientes();
            }
        });
        ListagemDePacientes();
        ListagemAT();  // Atualiza outra lista, se usada
    limparCamposAt();  // Limpa os campos da interface
    }//GEN-LAST:event_atualizarTabelaBTActionPerformed

    private void atualizarTabelaBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaBT1ActionPerformed
        // TODO add your handling code here:

        atualizarTabelaBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método que atualiza a tabela
                ListagemAT();
            }
        });
        ListagemAT();
        ListagemAT();  // Atualiza outra lista, se usada
    limparCamposAt();  // Limpa os campos da interface
    }//GEN-LAST:event_atualizarTabelaBT1ActionPerformed

    private void atualizarTabelaBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaBT2ActionPerformed
        // TODO add your handling code here:
        atualizarTabelaBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método que atualiza a tabela
                Listagem();
            }
        });
        Listagem();
       ListagemAT();  // Atualiza outra lista, se usada
    limparCamposAt();  // Limpa os campos da interface
    }//GEN-LAST:event_atualizarTabelaBT2ActionPerformed

    private void botaoPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPDActionPerformed
        // TODO add your handling code here:
    botaoPD.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nomePaciente = pesquisarPaciente.getText().trim();
        ListagemDePacientes(nomePaciente); // Faz a pesquisa ao clicar no botão
    }
});


    }//GEN-LAST:event_botaoPDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaNutricionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNutricionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNutricionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNutricionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNutricionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizarBT;
    private javax.swing.JButton atualizarDietas2;
    private javax.swing.JButton atualizarDietas4;
    private javax.swing.JButton atualizarTabelaBT;
    private javax.swing.JButton atualizarTabelaBT1;
    private javax.swing.JButton atualizarTabelaBT2;
    private javax.swing.JButton botaoPD;
    private javax.swing.JButton cadastrarPresquicaoDia1;
    private javax.swing.JTextField campoAlaA;
    private javax.swing.JTextField campoAlaP;
    private javax.swing.JTextField campoDietaA2;
    private javax.swing.JTextField campoLeitoA;
    private javax.swing.JTextField campoNomeLeitoP;
    private javax.swing.JTextField campoNomePacienteP;
    private javax.swing.JTextField campoPacienteA;
    private javax.swing.JButton dietaBotao;
    private javax.swing.JTextField dietaCampoP;
    private javax.swing.JPanel dietasAt;
    private javax.swing.JLabel imgAtualDiet;
    private javax.swing.JLabel imgAtualDiet1;
    private javax.swing.JLabel imgFundoPresquicap;
    private javax.swing.JLabel imgFundoPresquicap1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton listaDeDietas1;
    private javax.swing.JButton listaDeDietas3;
    private javax.swing.JPanel menuEsquerda1;
    private javax.swing.JPanel menuEsquerda2;
    private javax.swing.JPanel menuEsquerda3;
    private javax.swing.JButton pdfTudo;
    private javax.swing.JTextField pesquisarPaciente;
    private javax.swing.JPanel prescreverNutricionista;
    private javax.swing.JButton presquicao2;
    private javax.swing.JButton presquicao3;
    private javax.swing.JButton saida;
    private javax.swing.JTable tabelaAtualizarPrescricao;
    private javax.swing.JTable tabelaNutriTudo1;
    private javax.swing.JPanel tabelaPresStatus;
    private javax.swing.JTable tabelaPresquicao;
    private javax.swing.JLabel usuario1;
    private javax.swing.JLabel usuario2;
    private javax.swing.JLabel usuario3;
    // End of variables declaration//GEN-END:variables
}
