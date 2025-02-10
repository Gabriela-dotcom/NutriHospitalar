/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;


import static java.awt.SystemColor.menu;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UFNT
 */
public class TelaNutri extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public TelaNutri() {
        
        setTitle("Porteiro");
        setSize(900, 700); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Impede redimensionamento da janela
        
        initComponents();
        
          // Centraliza a janela no centro da tela
        setLocationRelativeTo(null);

        // Torna a janela visível
        setVisible(true);
        panelMenu.setVisible(false);
        infoPacienteTabela.setVisible(false);
        panelCadastroDeReservas.setVisible(false);
        panelDeAtualizarPrescricao.setVisible(true);
        campoNomePaciente.setEditable(false);
        campoNomeLeito.setEditable(false);
        campoDieta.setEditable(false);
        campoLeito.setEditable(false);
       
    }
    
    private void listarReservasNoPainel() { 
    // Implemente a lógica para listar asinformações no painel `informacaoPacientes` 
    // Exemplo simplificado para adicionar uma tabela ao painel
    String[] colunas = {"ID Paciente", "Nome Paciente", "Leito", 
                        "Dieta", "Turno", "Responsavel", "Status"};
    
    DefaultTableModel modeloTabela = new DefaultTableModel(colunas, 0); 
    
   /* try { 
        // Criar o controlador para acessar os dados dos pacientes
        ReservaController reservaController = new ReservaController(); 
        
        // Obter os dados dos pacientes
        List<Object[]> dadosReservas = reservaController.getDadosReservas(); 
        
        // Adicionar as linhas à tabela
        for (Object[] linha : dadosReservas) { 
            modeloTabela.addRow(linha); 
        } 
        
        // Criar a tabela com o modelo de dados
        JTable tabelaReservas = new JTable(modeloTabela); 
        
        // Criar um JScrollPane para adicionar a tabela
        JScrollPane scrollPane = new JScrollPane(tabelaReservas); 
        
        // Adicione a tabela ao painel `informacaoPacientes`
        informacaoPacientes.removeAll(); // Remove componentes anteriores, se houver
        informacaoPacientes.add(scrollPane); 
        
        // Atualiza e repinta o painel
        informacaoPacientes.revalidate(); // Atualiza o painel
        informacaoPacientes.repaint(); // Repinta o painel 
    } catch (SQLException e) { 
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(this, "Erro ao listar reservas: " + e.getMessage()); 
    } */
}


    private void atualizarTabelaReservas() { 
   /* try { 
        // Criar o controlador para acessar os dados das reservas
        ReservaController reservaController = new ReservaController(); 
        
        // Obter os dados das reservas
        List<Object[]> dadosReservas = reservaController.getDadosReservas(); 
        
        // Obter o modelo da tabela
        DefaultTableModel model = (DefaultTableModel) tabelaReservaInfo.getModel(); 
        
        // Limpar a tabela antes de adicionar novos dados
        model.setRowCount(0); 
        
        // Adicionar cada linha de dados à tabela
        for (Object[] linha : dadosReservas) { 
            model.addRow(linha); 
        } 
    } catch (SQLException e) { 
        // Tratar exceção de SQL
        e.printStackTrace(); 
        
        // Exibir mensagem de erro
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela: " + e.getMessage()); 
    } */
}

    public void listarReservas() { 
  /*  try { 
        // Criar o controlador para acessar os dados das reservas
        ReservaController reservaController = new ReservaController(); 
        
        // Obter os dados das reservas
        List<Object[]> dadosReservas = reservaController.getDadosReservas(); 
        
        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaReservaInfo.getModel(); 
        
        // Limpar a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0); 
        
        // Adicionar cada linha de dados à tabela
        for (Object[] linha : dadosReservas) { 
            modeloTabela.addRow(linha); 
        } 
    } catch (SQLException e) { 
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela: " + e.getMessage()); 
    } */
}


        // aqui pegamos os dados do controller e jogamos na nossa tabela
    public void PreencherTabelaSelecao(){
       /*// chamando o produtos controller
        SelecaoController dao = new SelecaoController();
        // capturando a lista de produtos que vem do banco de dados
        List<Selecao> lista = dao.listaSelecao();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaDeSelecao.getModel();
    
        // Limpando a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0);
    
        // Verificando se a lista não é nula
        if (lista != null && !lista.isEmpty()) {
            // Jogando os dados para dentro da minha tabela
            for (Selecao s : lista) {
                // Criando uma nova linha para a tabela
                Object[] linha = {
                s.getNomeFuncionario(),
                s.getNomeSala(),
                s.getPeriodo(),
                s.getCpfFuncionario(),
                s.getIdfuncionario(),
                s.getIdchave()
               
                };
                // Adicionando a linha ao modelo da tabela
                modeloTabela.addRow(linha);
            }
        } else {
            JOptionPane.showMessageDialog (this,"Nenhuma seleção encontrada.");
        }*/
    }
    
    public void PreencherTabelaDevolucao(){
      /* // chamando o produtos controller
        ReservaController dao = new  ReservaController();
        // capturando a lista de produtos que vem do banco de dados
        List<ReservaDetalhes> lista = dao.listaReservaDetalhesNaoEntregue();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaDevolucao.getModel();
    
        // Limpando a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0);
    
        // Verificando se a lista não é nula
        if (lista != null && !lista.isEmpty()) {
            // Jogando os dados para dentro da minha tabela
            for (ReservaDetalhes r : lista) {
                // Criando uma nova linha para a tabela
                Object[] linha = {
                r.getIdReserva(),
                r.getNomeFuncionario(),
                r.getNomeSala(),
                r.getDataDeReserva(),
                r.getHoraReserva(),
                r.isEntregue()
                };
                // Adicionando a linha ao modelo da tabela
                modeloTabela.addRow(linha);
            }
        } else {
            JOptionPane.showMessageDialog (this,"Nenhuma reserva cadastrada!");
        }*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        BtnCadastrarReserva = new javax.swing.JToggleButton();
        BtnDevolucao = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        iconUsuario = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSair = new javax.swing.JToggleButton();
        panelCadastroDeReservas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDeSelecao = new javax.swing.JTable();
        cAla = new javax.swing.JTextField();
        idCha = new javax.swing.JTextField();
        idFun = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoNomePaciente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cadastrarReservarDoDia = new javax.swing.JButton();
        campoNomeLeito = new javax.swing.JTextField();
        pesquisar = new javax.swing.JButton();
        panelDeAtualizarPrescricao = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        campoDieta = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        campoLeito = new javax.swing.JTextField();
        devolverChave = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaAtualizarPrescricao = new javax.swing.JTable();
        campoPaciente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campoAla = new javax.swing.JTextField();
        infoPacienteTabela = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        informacaoPacientes = new javax.swing.JTable();
        botaoAtualizar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pesquisarPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMenu.setBackground(new java.awt.Color(0, 102, 0));

        BtnCadastrarReserva.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnCadastrarReserva.setText("Aualizar Dietas");
        BtnCadastrarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadastrarReservaActionPerformed(evt);
            }
        });

        BtnDevolucao.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnDevolucao.setText("Lista De Entregues do dia");
        BtnDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDevolucaoActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(iconUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel12.setText("Nutricionista");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BtnCadastrarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(42, 42, 42))))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap(47, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(BtnCadastrarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(BtnDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        panelCadastroDeReservas.setBackground(new java.awt.Color(255, 255, 255));
        panelCadastroDeReservas.setToolTipText("");
        panelCadastroDeReservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaDeSelecao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Paciente", "Nome do Pacinte", "Leito", "Dieta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaDeSelecao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaSelecaoClick(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDeSelecao);
        if (TabelaDeSelecao.getColumnModel().getColumnCount() > 0) {
            TabelaDeSelecao.getColumnModel().getColumn(0).setResizable(false);
            TabelaDeSelecao.getColumnModel().getColumn(1).setResizable(false);
            TabelaDeSelecao.getColumnModel().getColumn(2).setResizable(false);
            TabelaDeSelecao.getColumnModel().getColumn(3).setResizable(false);
            TabelaDeSelecao.getColumnModel().getColumn(4).setMinWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(4).setPreferredWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(4).setMaxWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(5).setMinWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(5).setPreferredWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        panelCadastroDeReservas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 260, 974, 407));

        cAla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAlaActionPerformed(evt);
            }
        });
        panelCadastroDeReservas.add(cAla, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 230, 30));

        idCha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idChaActionPerformed(evt);
            }
        });
        panelCadastroDeReservas.add(idCha, new org.netbeans.lib.awtextra.AbsoluteConstraints(929, 78, 0, 0));

        idFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFunActionPerformed(evt);
            }
        });
        panelCadastroDeReservas.add(idFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(905, 78, 0, 0));

        jLabel2.setBackground(java.awt.Color.black);
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Nome Paciente:");
        panelCadastroDeReservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 58, -1, -1));

        jLabel3.setBackground(java.awt.Color.black);
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Nome do Leito:");
        panelCadastroDeReservas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 118, -1, -1));

        campoNomePaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomePacienteActionPerformed(evt);
            }
        });
        panelCadastroDeReservas.add(campoNomePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 83, 251, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Ala:");
        panelCadastroDeReservas.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        jLabel5.setBackground(java.awt.Color.black);
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tabela de seleção do(a) Nutricionista");
        panelCadastroDeReservas.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 229, -1, -1));

        jLabel6.setBackground(java.awt.Color.black);
        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("CADASTRAR PRESCRIÇÃO(do dia).");
        panelCadastroDeReservas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 14, -1, -1));

        cadastrarReservarDoDia.setBackground(new java.awt.Color(51, 102, 0));
        cadastrarReservarDoDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cadastrarReservarDoDia.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarReservarDoDia.setText("Pedido");
        cadastrarReservarDoDia.setActionCommand("RESERVAR");
        cadastrarReservarDoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarReservarDoDiaActionPerformed(evt);
            }
        });
        panelCadastroDeReservas.add(cadastrarReservarDoDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 184, 160, 39));

        campoNomeLeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeLeitoActionPerformed(evt);
            }
        });
        panelCadastroDeReservas.add(campoNomeLeito, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 149, 251, 29));
        panelCadastroDeReservas.add(pesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(929, 218, 51, 36));

        panelDeAtualizarPrescricao.setBackground(new java.awt.Color(51, 102, 0));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setText("Atualizar Prescrição");

        campoDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDietaActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Dieta:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Leito:");

        devolverChave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        devolverChave.setText("Atualizar");
        devolverChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverChaveActionPerformed(evt);
            }
        });

        tabelaAtualizarPrescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID paciente", "Nome Paciente", "Leito", "Dieta", "Ala"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAtualizarPrescricao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selecionarNaTabelaDevolucao(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaAtualizarPrescricao);

        campoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPacienteActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Nome do Paciente:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ala:");

        javax.swing.GroupLayout panelDeAtualizarPrescricaoLayout = new javax.swing.GroupLayout(panelDeAtualizarPrescricao);
        panelDeAtualizarPrescricao.setLayout(panelDeAtualizarPrescricaoLayout);
        panelDeAtualizarPrescricaoLayout.setHorizontalGroup(
            panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeAtualizarPrescricaoLayout.createSequentialGroup()
                .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelDeAtualizarPrescricaoLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(campoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelDeAtualizarPrescricaoLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(campoLeito, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoAla)
                                    .addComponent(campoDieta, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(97, 97, 97))
                        .addGroup(panelDeAtualizarPrescricaoLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 992, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDeAtualizarPrescricaoLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(devolverChave, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(269, Short.MAX_VALUE))
        );
        panelDeAtualizarPrescricaoLayout.setVerticalGroup(
            panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDeAtualizarPrescricaoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDeAtualizarPrescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLeito, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAla, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(devolverChave, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        infoPacienteTabela.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        informacaoPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Paciente", "Nome Paciente", "Leito", "Dieta", "Turno", "Responsavel", "Status"
            }
        ));
        informacaoPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informacaoPacientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(informacaoPacientes);

        botaoAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.setToolTipText("");
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel7.setText("Dieta Entregues Do Dia");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Pesquisar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(446, 446, 446)
                        .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 946, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(pesquisarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pesquisarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout infoPacienteTabelaLayout = new javax.swing.GroupLayout(infoPacienteTabela);
        infoPacienteTabela.setLayout(infoPacienteTabelaLayout);
        infoPacienteTabelaLayout.setHorizontalGroup(
            infoPacienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        infoPacienteTabelaLayout.setVerticalGroup(
            infoPacienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelCadastroDeReservas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(204, 204, 204)
                    .addComponent(panelDeAtualizarPrescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(infoPacienteTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(panelCadastroDeReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelDeAtualizarPrescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(infoPacienteTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limparCamposReservas(){
        campoNomePaciente.setText("");
        campoNomeLeito.setText("");
        setIdFuncionarioSelec(0);
        setIdChaveSelec(0);
    }
    private void BtnCadastrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadastrarReservaActionPerformed
       panelCadastroDeReservas.setVisible(true);
       panelDeAtualizarPrescricao.setVisible(false);
       infoPacienteTabela.setVisible(false);
       idCha.setVisible(false);
       idFun.setVisible(false);
       PreencherTabelaSelecao();
       limparCamposReservas();
    }//GEN-LAST:event_BtnCadastrarReservaActionPerformed

    public void limparCamposDevol(){
        campoDieta.setText("");
        campoLeito.setText("");
        setIdReservaSelect(0);
    }
    private void BtnDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDevolucaoActionPerformed
        panelDeAtualizarPrescricao.setVisible(true);
        infoPacienteTabela.setVisible(false);
        panelCadastroDeReservas.setVisible(false);
        PreencherTabelaDevolucao();
        limparCamposDevol();
       
    }//GEN-LAST:event_BtnDevolucaoActionPerformed

    private void campoNomePacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomePacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomePacienteActionPerformed

    private void idFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFunActionPerformed

    private void idChaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idChaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idChaActionPerformed

    private void cAlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAlaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cAlaActionPerformed

    private void campoNomeLeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeLeitoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeLeitoActionPerformed

    private int idFuncionarioSelec;
    private int idChaveSelec;
    public int getIdFuncionarioSelec() {
        return idFuncionarioSelec;
    }
    public void setIdFuncionarioSelec(int idFuncionarioSelec) {
        this.idFuncionarioSelec = idFuncionarioSelec;
    }
    public int getIdChaveSelec() {
        return idChaveSelec;
    }
    public void setIdChaveSelec(int idChaveSelec) {
        this.idChaveSelec = idChaveSelec;
    }
    
    
    private void tabelaSelecaoClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaSelecaoClick
         // TODO add your handling code here:
        
        // capturar a linha que o usuario clicou
        int linhaselecionada = TabelaDeSelecao.getSelectedRow();
        
        // verificar se o usuario clicou em alguma linha
        if (linhaselecionada>=0){
          // definir modelo padrão da tabela
          DefaultTableModel modelotabela = (DefaultTableModel) TabelaDeSelecao.getModel();
          this.idFuncionarioSelec = Integer.parseInt(modelotabela.getValueAt(linhaselecionada,4).toString());
          this.idChaveSelec = Integer.parseInt(modelotabela.getValueAt(linhaselecionada, 5).toString());
          String funcionario = modelotabela.getValueAt(linhaselecionada, 0).toString();
          String sala = modelotabela.getValueAt(linhaselecionada, 1).toString();
          //String periodo = modelotabela.getValueAt(linhaselecionada, 1).toString();
          campoNomePaciente.setText(funcionario);
          campoNomeLeito.setText(sala);

          System.err.println(idFuncionarioSelec);
        }// fim do if
    }//GEN-LAST:event_tabelaSelecaoClick

    private void cadastrarReservarDoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarReservarDoDiaActionPerformed
/*    if (getIdFuncionarioSelec() == 0 || getIdChaveSelec() == 0) {
    JOptionPane.showMessageDialog(null, "Faça uma seleção na tabela");
} else {
    DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String dataAtualFormatada = LocalDate.now().format(formatar);

    DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("HH:mm");
    String horaAtualFormatada = LocalTime.now().format(formatarHora);
    Reserva r = new Reserva();
    r.setIdFuncionario(idFuncionarioSelec);
    r.setIdChave(idChaveSelec);
    r.setDataReserva(dataAtualFormatada);
    r.setHoraReserva(horaAtualFormatada);
    r.setEntregue(false);

    ReservaController dao = new ReservaController();
    boolean inserir = dao.inserirReserva(r);

    if (inserir) {
        JOptionPane.showMessageDialog(this, "Reserva cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Não foi possível cadastrar a reserva. A chave já está reservada.", "Erro", JOptionPane.ERROR_MESSAGE);
        limparCamposReservas();
    }

    System.err.println(r.toString());
}
*/
    }//GEN-LAST:event_cadastrarReservarDoDiaActionPerformed

    private int idReservaSelect; 
    public int getIdReservaSelect() {
        return idReservaSelect;
    }
    public void setIdReservaSelect(int idReservaSelect) {
        this.idReservaSelect = idReservaSelect;
    }
    private void informacaoPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informacaoPacientesMouseClicked
        // TODO add your handling code here:
   /*     // Capturar a linha que o usuário clicou
int linhaSelecionada = tabelaReservaInfo.getSelectedRow(); 

// Verificar se o usuário clicou em alguma linha
if (linhaSelecionada >= 0) { 
    // Definir modelo padrão da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaReservaInfo.getModel(); 

    // Preencher os campos de texto com os dados da linha selecionada
    campoIdFuncionario.setText(modeloTabela.getValueAt(linhaSelecionada, 0).toString()); 
    campoNomeFuncionario.setText(modeloTabela.getValueAt(linhaSelecionada, 1).toString()); 
    campoNomeSala.setText(modeloTabela.getValueAt(linhaSelecionada, 2).toString()); 
    campoDisponibilidade.setText(modeloTabela.getValueAt(linhaSelecionada, 3).toString()); 
    campoHoraReserva.setText(modeloTabela.getValueAt(linhaSelecionada, 4).toString()); 
    campoHoraEntrega.setText(modeloTabela.getValueAt(linhaSelecionada, 5).toString()); 
    checkBoxEntregue.setSelected(modeloTabela.getValueAt(linhaSelecionada, 6).toString().equals("Sim")); 
}
*/
    }//GEN-LAST:event_informacaoPacientesMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // Fechar a tela atual
        this.dispose();

        // Criar uma nova instância da outra tela
        loginTela l = new loginTela();

        // Tornar a nova tela visível
        l.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void campoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPacienteActionPerformed

    private void selecionarNaTabelaDevolucao(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selecionarNaTabelaDevolucao
        // TODO add your handling code here:

        // capturar a linha que o usuario clicou
        int linhaselecionada = tabelaAtualizarPrescricao.getSelectedRow();

        // verificar se o usuario clicou em alguma linha
        if (linhaselecionada>=0){
            // definir modelo padrão da tabela
            DefaultTableModel modelotabela = (DefaultTableModel) tabelaAtualizarPrescricao.getModel();
            this.idReservaSelect = Integer.parseInt(modelotabela.getValueAt(linhaselecionada,0).toString());
            String funcionario = modelotabela.getValueAt(linhaselecionada, 1).toString();
            String sala = modelotabela.getValueAt(linhaselecionada, 2).toString();
            campoDieta.setText(funcionario);
            campoLeito.setText(sala);
        }// fim do if
    }//GEN-LAST:event_selecionarNaTabelaDevolucao

    private void devolverChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverChaveActionPerformed
        /*  if(getIdReservaSelect() == 0){
            JOptionPane.showMessageDialog (this,"selecione uma reserva na tabela!");
        }else{
            DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String data = LocalDate.now().format(formatar);

            DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("HH:mm");
            String hora = LocalTime.now().format(formatarHora);

            ReservaController dao = new ReservaController();
            boolean devolucao = dao.devolucao(idReservaSelect, data, hora);

            if(!devolucao){
                JOptionPane.showMessageDialog(this, "Erro ao realizar devolução!", "Erro", JOptionPane.ERROR_MESSAGE);

            }else{
                JOptionPane.showMessageDialog(this, "Devolução realizada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                PreencherTabelaDevolucao();
                limparCamposDevol();
            }
        }*/
    }//GEN-LAST:event_devolverChaveActionPerformed

    private void campoDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDietaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNutri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BtnCadastrarReserva;
    private javax.swing.JToggleButton BtnDevolucao;
    private javax.swing.JTable TabelaDeSelecao;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JTextField cAla;
    private javax.swing.JButton cadastrarReservarDoDia;
    private javax.swing.JTextField campoAla;
    private javax.swing.JTextField campoDieta;
    private javax.swing.JTextField campoLeito;
    private javax.swing.JTextField campoNomeLeito;
    private javax.swing.JTextField campoNomePaciente;
    private javax.swing.JTextField campoPaciente;
    private javax.swing.JButton devolverChave;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JTextField idCha;
    private javax.swing.JTextField idFun;
    private javax.swing.JPanel infoPacienteTabela;
    private javax.swing.JTable informacaoPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel panelCadastroDeReservas;
    private javax.swing.JPanel panelDeAtualizarPrescricao;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JButton pesquisar;
    private javax.swing.JTextField pesquisarPaciente;
    private javax.swing.JTable tabelaAtualizarPrescricao;
    // End of variables declaration//GEN-END:variables
}
