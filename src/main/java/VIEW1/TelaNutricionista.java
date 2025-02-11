/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;

import CONTROLLER.DietasController;
import CONTROLLER.PacienteController;
import MODEL.Finalizadas;
import MODEL.InformacaoPaciente;
import MODEL.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devmat
 */
public class TelaNutricionista extends javax.swing.JFrame {

    /**
     * Creates new form TelaNutricionista
     */
    public TelaNutricionista() {
       
        initComponents();
        Listagem();
        ListagemAT();
        listarDietas1();
        // Esconde outros painéis que não devem ser visíveis após o login
    dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);

    }
    // Método para limpar os campos de cadastro do paciente
private void limparCampos() {
    campoNomePacienteP.setText("");  // Limpa o campo de nome do paciente
    campoNomeLeitoP.setText("");     // Limpa o campo de leito
    campoAlaP.setText("");           // Limpa o campo de ala
    dietaCampoP.setText("");         // Limpa o campo de ID da dieta
}
private void limparCamposAt() {
   campoPacienteA.setText("");  // Limpa o campo de nome do paciente
    campoDietaA.setText("");         // Limpa o campo de ID da dieta
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
                paciente.getIdDieta(),
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
                paciente.getIdDieta(),
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
public void listarDietas1() {
    try {
        // Criar o controlador para acessar os dados das dietas
        DietasController dietasController = new DietasController();

        // Obter os dados das informações dos pacientes da VIEW
        List<InformacaoPaciente> dadosInformacao = dietasController.getDadosInformacaoPacientesView();

        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaNutriTudo.getModel();

        // Verificando se o modelo da tabela já tem o número correto de colunas
        if (modeloTabela.getColumnCount() == 0) {
            modeloTabela.addColumn("Nome");
            modeloTabela.addColumn("Leito");
            modeloTabela.addColumn("Dieta");
            modeloTabela.addColumn("Status");
            modeloTabela.addColumn("ID Dieta"); // Adicionando coluna para ID Dieta
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
        btnSair3 = new javax.swing.JToggleButton();
        atualizarDietas4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        imgFundoPresquicap = new javax.swing.JLabel();
        dietasAt = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        campoPacienteA = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campoDietaA = new javax.swing.JTextField();
        atualizarBT = new javax.swing.JButton();
        menuEsquerda1 = new javax.swing.JPanel();
        listaDeDietas1 = new javax.swing.JButton();
        presquicao2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAtualizarPrescricao = new javax.swing.JTable();
        imgAtualDiet = new javax.swing.JLabel();
        tabelaPresStatus = new javax.swing.JPanel();
        menuEsquerda2 = new javax.swing.JPanel();
        atualizarDietas2 = new javax.swing.JButton();
        presquicao3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        criarLogin = new javax.swing.JButton();
        pesquisarPaciente = new javax.swing.JTextField();
        pdfTudo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaNutriTudo = new javax.swing.JTable();
        imgAtualDiet1 = new javax.swing.JLabel();
        imgFundoPresquicap1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        prescreverNutricionista.setMaximumSize(new java.awt.Dimension(1000, 800));
        prescreverNutricionista.setMinimumSize(new java.awt.Dimension(1000, 800));
        prescreverNutricionista.setPreferredSize(new java.awt.Dimension(1000, 800));
        prescreverNutricionista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(java.awt.Color.lightGray);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("CADASTRAR PRESCRIÇÃO(do dia).");
        prescreverNutricionista.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, -1, 50));

        campoNomePacienteP.setBackground(new java.awt.Color(238, 236, 236));
        campoNomePacienteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomePacientePActionPerformed(evt);
            }
        });
        prescreverNutricionista.add(campoNomePacienteP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 251, 29));

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nome Paciente:");
        prescreverNutricionista.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        jLabel3.setBackground(java.awt.Color.black);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nome do Leito:");
        prescreverNutricionista.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        campoNomeLeitoP.setBackground(new java.awt.Color(238, 236, 236));
        campoNomeLeitoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeLeitoPActionPerformed(evt);
            }
        });
        prescreverNutricionista.add(campoNomeLeitoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 251, 29));

        cadastrarPresquicaoDia1.setBackground(new java.awt.Color(51, 102, 0));
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
        prescreverNutricionista.add(cadastrarPresquicaoDia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 180, 40));

        campoAlaP.setBackground(new java.awt.Color(238, 236, 236));
        campoAlaP.setMaximumSize(new java.awt.Dimension(64, 22));
        campoAlaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlaPActionPerformed(evt);
            }
        });
        prescreverNutricionista.add(campoAlaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 240, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Deita:");
        prescreverNutricionista.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));

        dietaCampoP.setBackground(new java.awt.Color(238, 236, 236));
        dietaCampoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dietaCampoPActionPerformed(evt);
            }
        });
        prescreverNutricionista.add(dietaCampoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 240, 30));

        dietaBotao.setBackground(new java.awt.Color(51, 102, 0));
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
        prescreverNutricionista.add(dietaBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 170, 39));

        jLabel5.setBackground(java.awt.Color.black);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Tabela de seleção do(a) Nutricionista");
        prescreverNutricionista.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        tabelaPresquicao.setBackground(new java.awt.Color(51, 102, 0));
        tabelaPresquicao.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 102)));
        tabelaPresquicao.setForeground(new java.awt.Color(255, 255, 255));
        tabelaPresquicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome Paciente", "Leito", "ID Dieta", "Ala"
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

        prescreverNutricionista.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 740, 320));

        menuEsquerda3.setBackground(new java.awt.Color(51, 102, 0));
        menuEsquerda3.setForeground(new java.awt.Color(51, 102, 0));

        listaDeDietas3.setFont(new java.awt.Font("Modern No. 20", 0, 14)); // NOI18N
        listaDeDietas3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/extensao-de-arquivo.png"))); // NOI18N
        listaDeDietas3.setLabel("Tabela");
        listaDeDietas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaDeDietas3ActionPerformed(evt);
            }
        });

        btnSair3.setBackground(new java.awt.Color(204, 0, 51));
        btnSair3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/man.png"))); // NOI18N
        btnSair3.setText("Sair");
        btnSair3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair3ActionPerformed(evt);
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

        javax.swing.GroupLayout menuEsquerda3Layout = new javax.swing.GroupLayout(menuEsquerda3);
        menuEsquerda3.setLayout(menuEsquerda3Layout);
        menuEsquerda3Layout.setHorizontalGroup(
            menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEsquerda3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addGroup(menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(listaDeDietas3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(atualizarDietas4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSair3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        menuEsquerda3Layout.setVerticalGroup(
            menuEsquerda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda3Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel16)
                .addGap(56, 56, 56)
                .addComponent(atualizarDietas4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(listaDeDietas3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(btnSair3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        prescreverNutricionista.add(menuEsquerda3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 790));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Leito:");
        prescreverNutricionista.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        imgFundoPresquicap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NutriHospitalar.png"))); // NOI18N
        prescreverNutricionista.add(imgFundoPresquicap, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 860, 800));

        getContentPane().add(prescreverNutricionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1028, 800));

        dietasAt.setBackground(new java.awt.Color(51, 102, 0));
        dietasAt.setForeground(new java.awt.Color(51, 102, 0));
        dietasAt.setMaximumSize(new java.awt.Dimension(1000, 800));
        dietasAt.setMinimumSize(new java.awt.Dimension(1000, 800));
        dietasAt.setPreferredSize(new java.awt.Dimension(1000, 800));
        dietasAt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setText("Atualizar Prescrição");
        dietasAt.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 369, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Nome do Paciente:");
        dietasAt.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 44, 199, -1));

        campoPacienteA.setBackground(new java.awt.Color(238, 236, 236));
        campoPacienteA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPacienteAActionPerformed(evt);
            }
        });
        dietasAt.add(campoPacienteA, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 81, 217, 28));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Dieta:");
        dietasAt.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 121, 199, -1));

        campoDietaA.setBackground(new java.awt.Color(238, 236, 236));
        campoDietaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDietaAActionPerformed(evt);
            }
        });
        dietasAt.add(campoDietaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 155, 217, 28));

        atualizarBT.setBackground(new java.awt.Color(51, 102, 0));
        atualizarBT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        atualizarBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/atualizar.png"))); // NOI18N
        atualizarBT.setText("Atualizar");
        atualizarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarBTActionPerformed(evt);
            }
        });
        dietasAt.add(atualizarBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 197, 50));

        menuEsquerda1.setBackground(new java.awt.Color(51, 102, 0));
        menuEsquerda1.setForeground(new java.awt.Color(51, 102, 0));
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

        javax.swing.GroupLayout menuEsquerda1Layout = new javax.swing.GroupLayout(menuEsquerda1);
        menuEsquerda1.setLayout(menuEsquerda1Layout);
        menuEsquerda1Layout.setHorizontalGroup(
            menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEsquerda1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuEsquerda1Layout.createSequentialGroup()
                        .addComponent(presquicao2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(menuEsquerda1Layout.createSequentialGroup()
                        .addComponent(listaDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(7, Short.MAX_VALUE))))
            .addGroup(menuEsquerda1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuEsquerda1Layout.setVerticalGroup(
            menuEsquerda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel17)
                .addGap(70, 70, 70)
                .addComponent(presquicao2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(listaDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(423, Short.MAX_VALUE))
        );

        dietasAt.add(menuEsquerda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 180, 770));

        tabelaAtualizarPrescricao.setBackground(new java.awt.Color(51, 102, 0));
        tabelaAtualizarPrescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nomedo Paciente", "Leito", "ID Dieta", "Ala"
            }
        ));
        tabelaAtualizarPrescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAtualizarPrescricaoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaAtualizarPrescricao);

        dietasAt.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 763, 263));

        imgAtualDiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NutriHospitalar.png"))); // NOI18N
        dietasAt.add(imgAtualDiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, -4, 840, 800));

        getContentPane().add(dietasAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabelaPresStatus.setBackground(new java.awt.Color(51, 102, 0));
        tabelaPresStatus.setMaximumSize(new java.awt.Dimension(1000, 800));
        tabelaPresStatus.setMinimumSize(new java.awt.Dimension(1000, 800));
        tabelaPresStatus.setPreferredSize(new java.awt.Dimension(1000, 800));
        tabelaPresStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuEsquerda2.setBackground(new java.awt.Color(51, 102, 0));
        menuEsquerda2.setForeground(new java.awt.Color(51, 102, 0));

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
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuEsquerda2Layout.setVerticalGroup(
            menuEsquerda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEsquerda2Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(36, 36, 36)
                .addComponent(presquicao3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(atualizarDietas2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232))
        );

        tabelaPresStatus.add(menuEsquerda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setText("Dieta Entregues Do Dia");
        tabelaPresStatus.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 288, 42));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Pesquisar:");
        tabelaPresStatus.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        criarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/danger.png"))); // NOI18N
        criarLogin.setText("Presquisar Dieta");
        criarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarLoginActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(criarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 140, 20));

        pesquisarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarPacienteActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(pesquisarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 433, -1));

        pdfTudo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pdfTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pdf-file-format_15266347.png"))); // NOI18N
        pdfTudo.setText("PDF");
        pdfTudo.setToolTipText("");
        pdfTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfTudoActionPerformed(evt);
            }
        });
        tabelaPresStatus.add(pdfTudo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 670, 138, 42));

        tabelaNutriTudo.setBackground(new java.awt.Color(236, 231, 231));
        tabelaNutriTudo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome do paciente", "Leito", "ID Dieta", "Status"
            }
        ));
        jScrollPane3.setViewportView(tabelaNutriTudo);

        tabelaPresStatus.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 719, 324));
        tabelaPresStatus.add(imgAtualDiet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 840, 800));

        imgFundoPresquicap1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NutriHospitalar.png"))); // NOI18N
        tabelaPresStatus.add(imgFundoPresquicap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 860, 800));

        getContentPane().add(tabelaPresStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomePacientePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomePacientePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomePacientePActionPerformed

    private void campoNomeLeitoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeLeitoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeLeitoPActionPerformed

    private void cadastrarPresquicaoDia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPresquicaoDia1ActionPerformed
Finalizadas finalizada = new Finalizadas();
if (campoNomePacienteP.getText().isEmpty() || campoNomeLeitoP.getText().isEmpty() || campoAlaP.getText().isEmpty() || dietaCampoP.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de cadastrar.");
} else {
    // Captura os dados dos campos de entrada
    String nomePaciente = campoNomePacienteP.getText();
    String leito = campoNomeLeitoP.getText();
    int idDieta = Integer.parseInt(dietaCampoP.getText());
    String ala = campoAlaP.getText();

    // Cria o objeto Finalizadas e define os dados
    finalizada.setNomePaciente(nomePaciente);
    finalizada.setLeito(leito);
    finalizada.setIdDieta(idDieta);
    finalizada.setAla(ala);

    // Cria um objeto FinalizadasController para inserir a prescrição
   DietasController dao = new DietasController();
    boolean inserir = dao.cadastrarFinalizada(finalizada);

    // Verifica se a inserção foi bem-sucedida
    if (inserir) {
        JOptionPane.showMessageDialog(this, "Prescrição cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        Listagem(); // Atualiza a lista de pacientes
        limparCampos(); // Limpa os campos de entrada
    } else {
        JOptionPane.showMessageDialog(this, "Não foi possível cadastrar a prescrição.", "Erro", JOptionPane.ERROR_MESSAGE);
        limparCamposReservas(); // Se falhar, limpa os campos
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
    }






    }//GEN-LAST:event_dietaBotaoActionPerformed

    private void campoPacienteAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPacienteAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPacienteAActionPerformed

    private void campoDietaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDietaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDietaAActionPerformed

    private void atualizarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarBTActionPerformed
        // TODO add your handling code here:
  // Capturando os dados dos campos de entrada
// Capturando os dados dos campos de entrada
String nomePaciente = campoPacienteA.getText();
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




       
 Listagem();
        ListagemAT();
        listarDietas1();

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
        listarDietas1();
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

    private void btnSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair3ActionPerformed
        // TODO add your handling code here:
        loginTela login = new loginTela();
        login.setVisible(true);
        dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);
 
    prescreverNutricionista.setVisible(false); 
    }//GEN-LAST:event_btnSair3ActionPerformed

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
        listarDietas1();
    }//GEN-LAST:event_listaDeDietas3ActionPerformed

    private void atualizarDietas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarDietas4ActionPerformed
        // TODO add your handling code here:
        dietasAt.setVisible(true);
    tabelaPresStatus.setVisible(false);
    
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
        listarDietas1();
    }//GEN-LAST:event_atualizarDietas4ActionPerformed

    private void presquicao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presquicao2ActionPerformed
        // TODO add your handling code here:
          dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);
   
    prescreverNutricionista.setVisible(true); 
     Listagem();
        ListagemAT();
        listarDietas1();
    }//GEN-LAST:event_presquicao2ActionPerformed

    private void presquicao3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presquicao3ActionPerformed
        // TODO add your handling code here:
                 dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(false);
 
    prescreverNutricionista.setVisible(true); 
     Listagem();
        ListagemAT();
        listarDietas1();
    }//GEN-LAST:event_presquicao3ActionPerformed

    private void atualizarDietas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarDietas2ActionPerformed
        // TODO add your handling code here:
                 dietasAt.setVisible(true);
    tabelaPresStatus.setVisible(false);
    
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
        listarDietas1();
    }//GEN-LAST:event_atualizarDietas2ActionPerformed

    private void listaDeDietas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaDeDietas1ActionPerformed
        // TODO add your handling code here:
                 dietasAt.setVisible(false);
    tabelaPresStatus.setVisible(true);
   
    prescreverNutricionista.setVisible(false); 
     Listagem();
        ListagemAT();
        listarDietas1();
    }//GEN-LAST:event_listaDeDietas1ActionPerformed

    private void tabelaAtualizarPrescricaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAtualizarPrescricaoMouseClicked
        // TODO add your handling code here:
         int linhaSelecionada = tabelaAtualizarPrescricao.getSelectedRow();
        
        // Verificando se alguma linha foi selecionada
        if(linhaSelecionada >= 0){
            // Definir modelo default para a tabela
            DefaultTableModel modelotabela = (DefaultTableModel)tabelaAtualizarPrescricao.getModel();
            
            // Jogando os dados da tabela para os campos de texto
            campoPacienteA.setText(modelotabela.getValueAt(linhaSelecionada, 0).toString()); // Nome
           
            campoDietaA.setText(modelotabela.getValueAt(linhaSelecionada, 2).toString()); // Ala
            
            // Adicione outros campos conforme necessário
        } // fim do if
    
        
    }//GEN-LAST:event_tabelaAtualizarPrescricaoMouseClicked

    private void criarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarLoginActionPerformed
        // TODO add your handling code here:
        TelaAviso aviso = new TelaAviso();
        aviso.setVisible(true);
        //login.setVisible(false);
        dispose();
    }//GEN-LAST:event_criarLoginActionPerformed

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
    private javax.swing.JToggleButton btnSair3;
    private javax.swing.JButton cadastrarPresquicaoDia1;
    private javax.swing.JTextField campoAlaP;
    private javax.swing.JTextField campoDietaA;
    private javax.swing.JTextField campoNomeLeitoP;
    private javax.swing.JTextField campoNomePacienteP;
    private javax.swing.JTextField campoPacienteA;
    private javax.swing.JButton criarLogin;
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
    private javax.swing.JTable tabelaAtualizarPrescricao;
    private javax.swing.JTable tabelaNutriTudo;
    private javax.swing.JPanel tabelaPresStatus;
    private javax.swing.JTable tabelaPresquicao;
    // End of variables declaration//GEN-END:variables
}
