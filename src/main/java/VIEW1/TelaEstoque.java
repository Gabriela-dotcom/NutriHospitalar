/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;

import CONTROLLER.DietasController;
import MODEL.Deposito;
import MODEL.FinalizadaDeposito;
import MODEL.Finalizadas;
import java.awt.Desktop;
import java.io.File;
import java.sql.SQLException;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author devmat
 */
public class TelaEstoque extends javax.swing.JFrame {

    /**
     * Creates new form TelaEstoque
     */
    public TelaEstoque() {
        initComponents();
         listarDepositoTudo();
         listarFinalizadaDeposito();
         PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(true);
        painelDoEstoqueDietas.setVisible(false);
        
    }
  //  limpar campos  
private void limparCampos() {
    nomeDaDietaD.setText("");
    loteD.setText("");
    fornecedorD.setText("");
    validadeD.setText("");
    quantidadeD.setText("");
    conformeD.setSelectedIndex(0); // Definindo para o primeiro item, por exemplo, "Sim"
}// fim limpar campos

//listagem de deposito(o que tem armazenado)
public void listarDepositoTudo() { 
    try { 
        // Criar o controlador para acessar os dados da tabela Deposito
        DietasController dietasController = new DietasController(); 
        
        // Obter os dados da tabela Deposito
        List<Deposito> dadosInformacao = dietasController. listarDepositoTudo(); 
        
        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel)TabelaDeDeposito.getModel(); 
        
        // Verificando se o modelo da tabela já tem o número correto de colunas
        if (modeloTabela.getColumnCount() == 0) {
            modeloTabela.addColumn("ID Depósito");
            modeloTabela.addColumn("ID Dieta");
            modeloTabela.addColumn("Lote");
            modeloTabela.addColumn("Fornecedor");
            modeloTabela.addColumn("Validade");
            modeloTabela.addColumn("Quantidade");
            modeloTabela.addColumn("Conforme");
        }
        
        // Limpar a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0); 
        
        // Adicionar cada linha de dados à tabela
        for (Deposito linha : dadosInformacao) { 
            modeloTabela.addRow(new Object[] {
                linha.getIdDeposito(),
                linha.getIdDieta(),
                linha.getLote(),
                linha.getFornecedor(),
                linha.getValidade(),
                linha.getQuantidade(),
                linha.isConforme() ? "Sim" : "Não"
            }); 
        } 
    } catch (Exception e) { 
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela: " + e.getMessage()); 
    } 
}

//fim listagem deposito

//meetodo de lisatagem para Tabela de retirada deposito
public void listarFinalizadaDeposito() { 
    try { 
        // Criar o controlador para acessar os dados da tabela finalizada
        DietasController dietasController = new DietasController(); 
        
        // Obter os dados da tabela finalizada
        List<Finalizadas> dadosInformacao = dietasController.listarFinDeposito(); 
        
        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaRetiradaDieta.getModel(); 
        
        // Verificando se o modelo da tabela já tem o número correto de colunas
        if (modeloTabela.getColumnCount() == 0) {
            modeloTabela.addColumn("ID Finalizada");
            modeloTabela.addColumn("ID Dieta");
            modeloTabela.addColumn("Nome Paciente");
            modeloTabela.addColumn("Leito");
            modeloTabela.addColumn("Ala");
            modeloTabela.addColumn("Turno");
            modeloTabela.addColumn("Responsável");
            modeloTabela.addColumn("Status");
            modeloTabela.addColumn("ID Paciente");
            modeloTabela.addColumn("ID Depósito");
        }
        
        // Limpar a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0); 
        
        // Adicionar cada linha de dados à tabela
        for (Finalizadas linha : dadosInformacao) { 
            modeloTabela.addRow(new Object[] {
                linha.getIdFinalizada(),
                linha.getIdDieta(),
                linha.getNomePaciente(),
                linha.getLeito(),
                linha.getAla(),
                linha.isTurno() ? "Sim" : "Não",
                linha.getQualFuncionario(),
                linha.isStatus() ? "Sim" : "Não",
                linha.getIdPaciente(),
                linha.getIdDeposito()
            }); 
        } 
    } catch (Exception e) { 
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela: " + e.getMessage()); 
    } 
}




//fim metodo da tabela de retirada deposito 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelcadastrosDeDietas = new javax.swing.JPanel();
        idCha1 = new javax.swing.JTextField();
        idFun1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomeDaDietaD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fornecedorD = new javax.swing.JTextField();
        jlabel2 = new javax.swing.JLabel();
        loteD = new javax.swing.JTextField();
        validadeD = new javax.swing.JTextField();
        BcadastrarDieta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        conformeD = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        quantidadeD = new javax.swing.JTextField();
        menuEstoquista2 = new javax.swing.JPanel();
        bRetirada2 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        infoDeposito1 = new javax.swing.JToggleButton();
        imgFundo = new javax.swing.JLabel();
        painelRetiradaDieta = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaRetiradaDieta = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botaofinal = new javax.swing.JButton();
        menuEstoquista1 = new javax.swing.JPanel();
        bEstoqueDeDietas1 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        infoDeposito = new javax.swing.JToggleButton();
        btnSair3 = new javax.swing.JToggleButton();
        qualFinalizada = new javax.swing.JTextField();
        finalizarSim1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        imgFundo1 = new javax.swing.JLabel();
        painelDoEstoqueDietas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDeDeposito = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        criarLogin = new javax.swing.JButton();
        pesquisaDieta = new javax.swing.JTextField();
        imgFundo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 800));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        setPreferredSize(new java.awt.Dimension(1000, 800));

        PainelcadastrosDeDietas.setBackground(new java.awt.Color(255, 255, 255));
        PainelcadastrosDeDietas.setMaximumSize(new java.awt.Dimension(1000, 800));
        PainelcadastrosDeDietas.setMinimumSize(new java.awt.Dimension(1000, 800));
        PainelcadastrosDeDietas.setPreferredSize(new java.awt.Dimension(1000, 800));
        PainelcadastrosDeDietas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idCha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCha1ActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(idCha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 110, 0, 0));

        idFun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFun1ActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(idFun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(982, 110, 0, 0));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Nome Da Dieta:");
        PainelcadastrosDeDietas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Fornecedor:");
        PainelcadastrosDeDietas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 338, -1, -1));

        nomeDaDietaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeDaDietaDActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(nomeDaDietaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 211, 251, 29));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Validade:");
        PainelcadastrosDeDietas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 422, -1, -1));

        fornecedorD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedorDActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(fornecedorD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 375, 251, 29));

        jlabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlabel2.setText("Lote:");
        PainelcadastrosDeDietas.add(jlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 258, 220, 27));

        loteD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteDActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(loteD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 291, 251, 29));
        PainelcadastrosDeDietas.add(validadeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 453, 247, 29));

        BcadastrarDieta.setBackground(new java.awt.Color(0, 102, 0));
        BcadastrarDieta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BcadastrarDieta.setForeground(new java.awt.Color(255, 255, 255));
        BcadastrarDieta.setText("CADASTRAR DIETA");
        BcadastrarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcadastrarDietaActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(BcadastrarDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 732, 200, 39));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setText("Cadastro De Dietas Interais");
        PainelcadastrosDeDietas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Conforme:");
        PainelcadastrosDeDietas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 581, 102, -1));

        conformeD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));
        conformeD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conformeDActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(conformeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 618, 102, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Quantidade:");
        PainelcadastrosDeDietas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 488, -1, -1));
        PainelcadastrosDeDietas.add(quantidadeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 525, 247, 29));

        menuEstoquista2.setBackground(new java.awt.Color(0, 102, 0));
        menuEstoquista2.setForeground(new java.awt.Color(51, 102, 0));
        menuEstoquista2.setMaximumSize(new java.awt.Dimension(178, 686));
        menuEstoquista2.setMinimumSize(new java.awt.Dimension(178, 686));

        bRetirada2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bRetirada2.setText("Retirar Dieta");
        bRetirada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirada2ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel15.setText("ESTOQUISTA");

        infoDeposito1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoDeposito1.setText("Estoque");
        infoDeposito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDeposito1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuEstoquista2Layout = new javax.swing.GroupLayout(menuEstoquista2);
        menuEstoquista2.setLayout(menuEstoquista2Layout);
        menuEstoquista2Layout.setHorizontalGroup(
            menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(bRetirada2)
                    .addComponent(infoDeposito1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        menuEstoquista2Layout.setVerticalGroup(
            menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel15)
                .addGap(71, 71, 71)
                .addComponent(bRetirada2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(infoDeposito1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(381, Short.MAX_VALUE))
        );

        PainelcadastrosDeDietas.add(menuEstoquista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 806));

        imgFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NutriHospitalar.png"))); // NOI18N
        PainelcadastrosDeDietas.add(imgFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 6, 820, 792));

        painelRetiradaDieta.setBackground(new java.awt.Color(255, 255, 255));
        painelRetiradaDieta.setMaximumSize(new java.awt.Dimension(1000, 800));
        painelRetiradaDieta.setMinimumSize(new java.awt.Dimension(1000, 800));
        painelRetiradaDieta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel19.setText("TABELA DE RETIRADA:");
        painelRetiradaDieta.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 369, -1));

        tabelaRetiradaDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Qual Finalizada", "ID Dieta", "Nome Paciente", "Leito", "Ala", "Turno", "Responsavel", "Quantidade", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRetiradaDieta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRetiradaDietaselecionarFuncionarioDaTabela(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaRetiradaDieta);

        painelRetiradaDieta.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 768, 262));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Finalizar");
        painelRetiradaDieta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 281, -1));

        botaofinal.setBackground(new java.awt.Color(51, 102, 0));
        botaofinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaofinal.setForeground(new java.awt.Color(255, 255, 255));
        botaofinal.setText("CONCLUIR");
        botaofinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofinalActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(botaofinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(373, 700, 262, 48));

        menuEstoquista1.setBackground(new java.awt.Color(0, 102, 0));
        menuEstoquista1.setForeground(new java.awt.Color(51, 102, 0));

        bEstoqueDeDietas1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bEstoqueDeDietas1.setText("Recebimento");
        bEstoqueDeDietas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEstoqueDeDietas1ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel14.setText("ESTOQUISTA");

        infoDeposito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoDeposito.setText("Estoque");
        infoDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDepositoActionPerformed(evt);
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

        javax.swing.GroupLayout menuEstoquista1Layout = new javax.swing.GroupLayout(menuEstoquista1);
        menuEstoquista1.setLayout(menuEstoquista1Layout);
        menuEstoquista1Layout.setHorizontalGroup(
            menuEstoquista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuEstoquista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(bEstoqueDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEstoquista1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        menuEstoquista1Layout.setVerticalGroup(
            menuEstoquista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel14)
                .addGap(119, 119, 119)
                .addComponent(bEstoqueDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(infoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(btnSair3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        painelRetiradaDieta.add(menuEstoquista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 800));

        qualFinalizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualFinalizadaActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(qualFinalizada, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 130, 30));

        finalizarSim1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim" }));
        painelRetiradaDieta.add(finalizarSim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Qual Finalizada");
        painelRetiradaDieta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 281, -1));

        imgFundo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NutriHospitalar.png"))); // NOI18N
        painelRetiradaDieta.add(imgFundo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, -2, 840, 800));

        painelDoEstoqueDietas.setBackground(new java.awt.Color(255, 255, 255));
        painelDoEstoqueDietas.setMaximumSize(new java.awt.Dimension(1000, 800));
        painelDoEstoqueDietas.setMinimumSize(new java.awt.Dimension(1000, 800));
        painelDoEstoqueDietas.setPreferredSize(new java.awt.Dimension(1000, 800));
        painelDoEstoqueDietas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TabelaDeDeposito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome Dieta", "Quantidade", "Lote", "Validade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaDeDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDeDepositotabelaSelecaoClick(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDeDeposito);

        painelDoEstoqueDietas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 988, 476));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("ESTOQUE DE DIETAS");
        painelDoEstoqueDietas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 22, -1, -1));

        bVoltar.setBackground(new java.awt.Color(0, 102, 0));
        bVoltar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bVoltar.setForeground(new java.awt.Color(255, 255, 255));
        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(bVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 246, 59));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Pesquisar:");
        painelDoEstoqueDietas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, -1, 30));

        criarLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/danger.png"))); // NOI18N
        criarLogin.setText("Presquisar Dieta");
        criarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarLoginActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(criarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 140, 20));

        pesquisaDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaDietaActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(pesquisaDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 415, -1));

        imgFundo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/NutriHospitalar.png"))); // NOI18N
        painelDoEstoqueDietas.add(imgFundo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 792));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1035, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(PainelcadastrosDeDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(painelRetiradaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(painelDoEstoqueDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(PainelcadastrosDeDietas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(painelRetiradaDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(painelDoEstoqueDietas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idCha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCha1ActionPerformed

    private void idFun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFun1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFun1ActionPerformed

    private void nomeDaDietaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeDaDietaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeDaDietaDActionPerformed

    private void fornecedorDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedorDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedorDActionPerformed

    private void loteDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loteDActionPerformed

    private void BcadastrarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcadastrarDietaActionPerformed
     // Capturando os dados dos campos de entrada
  if (nomeDaDietaD.getText().isEmpty() || loteD.getText().isEmpty() || fornecedorD.getText().isEmpty() || validadeD.getText().isEmpty() || quantidadeD.getText().isEmpty() || conformeD.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(null,"Preencha todos os campos antes de adicionar.");
} else {
    String tipoDieta = nomeDaDietaD.getText(); // Assumindo que tipoDieta é nomeDaDietaD
    String lote = loteD.getText();
    String fornecedor = fornecedorD.getText();
    String validade = validadeD.getText();
    String quantidade = quantidadeD.getText();
    boolean conforme = Boolean.parseBoolean(conformeD.getSelectedItem().toString());

    try {
        DietasController depositoController = new DietasController();
        boolean adicionou = depositoController.adicionarDeposito(tipoDieta, lote, fornecedor, validade, quantidade, conforme);
        if (adicionou) {
            JOptionPane.showMessageDialog(null, "Dieta adicionada ao depósito com sucesso!");
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar o produto ao depósito.");
        }
    } catch (Exception e) {
        System.err.print("Erro ao adicionar ao depósito: " + e);
    }
}



    }//GEN-LAST:event_BcadastrarDietaActionPerformed

    private void TabelaDeDepositotabelaSelecaoClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDeDepositotabelaSelecaoClick
       
    }//GEN-LAST:event_TabelaDeDepositotabelaSelecaoClick

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
   PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(true);
        painelDoEstoqueDietas.setVisible(false);     
    }//GEN-LAST:event_bVoltarActionPerformed

    private void conformeDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conformeDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conformeDActionPerformed

    private void bEstoqueDeDietas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEstoqueDeDietas1ActionPerformed
   PainelcadastrosDeDietas.setVisible(true);
        painelRetiradaDieta.setVisible(false);
        painelDoEstoqueDietas.setVisible(false);  
         listarDepositoTudo();
         listarFinalizadaDeposito();// TODO add your handling code here:
    }//GEN-LAST:event_bEstoqueDeDietas1ActionPerformed

    private void infoDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoDepositoActionPerformed
        // TODO add your handling code here:
        PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(false);
        painelDoEstoqueDietas.setVisible(true);
         listarDepositoTudo();
         listarFinalizadaDeposito();
    }//GEN-LAST:event_infoDepositoActionPerformed

    private void bRetirada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetirada2ActionPerformed
        // TODO add your handling code here:
           PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(true);
        painelDoEstoqueDietas.setVisible(false);
         listarDepositoTudo();
         listarFinalizadaDeposito();
    }//GEN-LAST:event_bRetirada2ActionPerformed

    private void infoDeposito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoDeposito1ActionPerformed
        // TODO add your handling code here:
         PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(false);
        painelDoEstoqueDietas.setVisible(true);
         listarDepositoTudo();
         listarFinalizadaDeposito();
    }//GEN-LAST:event_infoDeposito1ActionPerformed

    private void qualFinalizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualFinalizadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualFinalizadaActionPerformed

    private void tabelaRetiradaDietaselecionarFuncionarioDaTabela(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRetiradaDietaselecionarFuncionarioDaTabela
// Obtém a linha selecionada na tabelaRetiradaDieta
int linhaSelecionada = tabelaRetiradaDieta.getSelectedRow();

// Verifica se alguma linha foi selecionada
if (linhaSelecionada >= 0) {
    // Define o modelo padrão para a tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaRetiradaDieta.getModel();
    
    // Joga os dados da tabela para os campos de texto
    qualFinalizada.setText(modeloTabela.getValueAt(linhaSelecionada, 0).toString()); // Nome Paciente
   
    // Adicione outros campos conforme necessário
} // fim do if

    }//GEN-LAST:event_tabelaRetiradaDietaselecionarFuncionarioDaTabela

    private void botaofinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofinalActionPerformed
        // TODO add your handling code here:
    try {
        // Obtenha o valor selecionado na combobox
        boolean finalizarSim = Boolean.parseBoolean(finalizarSim1.getSelectedItem().toString());

        // Obtenha o ID da finalização do campo de texto
        int idFinalizada = Integer.parseInt(qualFinalizada.getText());

        // Atualize o status na tabela finalizada
        DietasController dietasController = new DietasController();
        boolean atualizado = dietasController.atualizarStatusFinalizacao(idFinalizada, finalizarSim);

          if (atualizado) {
            JOptionPane.showMessageDialog(null, "Status atualizado com sucesso!");

            // Caminho do arquivo PDF
            String caminhoDoPdf = "C:\\Users\\devmat\\Documents\\NetBeansProjects\\nutriHopitalarMaven\\nutriHopitalarMaven\\NutriHospitalar\\src\\main\\resources\\PDF Finalizar\\Presquição Nutricional.pdf";

            // Abrir o PDF
            File arquivoPdf = new File(caminhoDoPdf);
            if (arquivoPdf.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(arquivoPdf);
                } else {
                    JOptionPane.showMessageDialog(null, "Abertura de PDF não suportada.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Arquivo PDF não encontrado.");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o status.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Erro ao atualizar o status: " + e.getMessage());
    }




        
    }//GEN-LAST:event_botaofinalActionPerformed

    private void pesquisaDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisaDietaActionPerformed

    private void btnSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair3ActionPerformed
        // TODO add your handling code here:
        loginTela login = new loginTela();
        login.setVisible(true);
        dispose();
         PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(false);
        painelDoEstoqueDietas.setVisible(false);
    }//GEN-LAST:event_btnSair3ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BcadastrarDieta;
    private javax.swing.JPanel PainelcadastrosDeDietas;
    private javax.swing.JTable TabelaDeDeposito;
    private javax.swing.JToggleButton bEstoqueDeDietas1;
    private javax.swing.JToggleButton bRetirada2;
    private javax.swing.JButton bVoltar;
    private javax.swing.JButton botaofinal;
    private javax.swing.JToggleButton btnSair3;
    private javax.swing.JComboBox<String> conformeD;
    private javax.swing.JButton criarLogin;
    private javax.swing.JComboBox<String> finalizarSim1;
    private javax.swing.JTextField fornecedorD;
    private javax.swing.JTextField idCha1;
    private javax.swing.JTextField idFun1;
    private javax.swing.JLabel imgFundo;
    private javax.swing.JLabel imgFundo1;
    private javax.swing.JLabel imgFundo2;
    private javax.swing.JToggleButton infoDeposito;
    private javax.swing.JToggleButton infoDeposito1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JTextField loteD;
    private javax.swing.JPanel menuEstoquista1;
    private javax.swing.JPanel menuEstoquista2;
    private javax.swing.JTextField nomeDaDietaD;
    private javax.swing.JPanel painelDoEstoqueDietas;
    private javax.swing.JPanel painelRetiradaDieta;
    private javax.swing.JTextField pesquisaDieta;
    private javax.swing.JTextField qualFinalizada;
    private javax.swing.JTextField quantidadeD;
    private javax.swing.JTable tabelaRetiradaDieta;
    private javax.swing.JTextField validadeD;
    // End of variables declaration//GEN-END:variables
}
