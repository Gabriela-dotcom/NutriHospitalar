/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author UFNT
 */
public class Telaerror extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Telaerror() {
        setTitle("COPED");
        setSize(900, 700); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Impede redimensionamento da janela
        
        initComponents();
        
        
        // Centraliza a janela no centro da tela
        setLocationRelativeTo(null);
        // Torna a janela visível
        setVisible(true);
       // aplicarLimitacaoDeCaracteres();
        
        painelInicial.setVisible(true);
        painelRetiradaDieta.setVisible(false);
        PainelcadastrosDeDietas.setVisible(false);
        painelDoEstoqueDietas.setVisible(false);
       
    }
      public void limparCampoCadastroFunc(){
       nomeDaDieta.setText("");
        lote.setText("");
        fornecedor.setText("");
    }
      
      
      
      
  /*  private void aplicarLimitacaoDeCaracteres() {
 // Adicionando um filtro de documento para limitar o CPF a 15 caracteres
((AbstractDocument) campoCpfCadastro.getDocument()).setDocumentFilter(new DocumentFilter() {
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) 
            throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() - length >= 14) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) 
            throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() >= 14) {
            super.insertString(fb, offset, text, attr);
        }
    }
});
}*/

// Configuração de layout e adição de outros componentes
// ...

// Código do método de cadastro (ajustado conforme acima)
// ...


    
   
// Configuração de layout e adição de outros componentes
// ...

// Código do método de cadastro (ajustado conforme acima)
// ...

    public void PreencherTabelaFuncionario(){
     /*  // chamando o produtos controller
        FuncionarioController dao = new FuncionarioController();
        // capturando a lista de produtos que vem do banco de dados
        List<Funcionario> lista = dao.listaFuncionario();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaFuncionario.getModel();
    
        // Limpando a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0);
    
        // Verificando se a lista não é nula
        if (lista != null && !lista.isEmpty()) {
            // Jogando os dados para dentro da minha tabela
            for (Funcionario f : lista) {
                // Criando uma nova linha para a tabela
                Object[] linha = {
                f.getIdFuncionario(),
                f.getNomeFuncionario(),
                f.getNomeCargo(),
                f.getCpfFuncionario()
                };
                // Adicionando a linha ao modelo da tabela
                modeloTabela.addRow(linha);
            }
        } else {
            JOptionPane.showMessageDialog (this,"Nenhum Funcionario encontrado.");
        }*/
    }
    
    public void PreencherTabelaSala(){
       /*// chamando o produtos controller
        ChaveController dao = new ChaveController ();
        // capturando a lista de produtos que vem do banco de dados
        List<Chave> lista = dao.listaChave();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaSala.getModel();
    
        // Limpando a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0);
    
        // Verificando se a lista não é nula
        if (lista != null && !lista.isEmpty()) {
            // Jogando os dados para dentro da minha tabela
            for (Chave c : lista) {
                // Criando uma nova linha para a tabela
                Object[] linha = {
                c.getIdChave(),
                c.getNomeSala(),
                };
                // Adicionando a linha ao modelo da tabela
                modeloTabela.addRow(linha);
            }
        } else {
            JOptionPane.showMessageDialog (this,"Nenhuma sala encontrado.");
        }*/
    }
    
     public void PreencherTabelaSelecao(){
      /* // chamando o produtos controller
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
     
     
     
      public void PreencherTabelaTodasReservas(){
     /*  // chamando o produtos controller
        ReservaController dao = new  ReservaController();
        // capturando a lista de produtos que vem do banco de dados
        List<ReservaDetalhes> lista = dao.listaReservaTodasDetal();
        
        // Obtendo o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaTodasResevas.getModel();
    
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
                r.getDataEntrega(),
                r.getHoraEntrega(),
                r.isEntregue()
                };
                // Adicionando a linha ao modelo da tabela
                modeloTabela.addRow(linha);
            }
        } else {
            JOptionPane.showMessageDialog (this,"Nenhuma reserva cadastrada!");
        }*/
    }
     
     
    /*public void limparCampoSelecao(){
        campoFuncionarioSelecao.setText("");
        campoSalaSelecao.setText("");
        setIdFuncionaroTabela(0);
        setIdSalaTabela(0);
    }*/

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelInicial = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        PainelcadastrosDeDietas = new javax.swing.JPanel();
        idCha1 = new javax.swing.JTextField();
        idFun1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomeDaDieta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fornecedor = new javax.swing.JTextField();
        jlabel2 = new javax.swing.JLabel();
        lote = new javax.swing.JTextField();
        validade = new javax.swing.JTextField();
        BcadastrarDieta = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        conforme = new javax.swing.JComboBox<>();
        menuEstoquista = new javax.swing.JPanel();
        bRetirada = new javax.swing.JToggleButton();
        bEstoqueDeDietas = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnSair = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        painelRetiradaDieta = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaRetiradaDieta = new javax.swing.JTable();
        comboPeriodoSelecao = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboRetirada = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        painelDoEstoqueDietas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDeSelecao = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pesquisaDieta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelInicial.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelInicialLayout = new javax.swing.GroupLayout(painelInicial);
        painelInicial.setLayout(painelInicialLayout);
        painelInicialLayout.setHorizontalGroup(
            painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInicialLayout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );
        painelInicialLayout.setVerticalGroup(
            painelInicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInicialLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        PainelcadastrosDeDietas.setBackground(new java.awt.Color(255, 255, 255));

        idCha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCha1ActionPerformed(evt);
            }
        });

        idFun1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFun1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Nome Da Dieta:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Fornecedor:");

        nomeDaDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeDaDietaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Validade:");

        fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedorActionPerformed(evt);
            }
        });

        jlabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlabel2.setText("Lote:");

        lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteActionPerformed(evt);
            }
        });

        BcadastrarDieta.setBackground(new java.awt.Color(0, 102, 0));
        BcadastrarDieta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BcadastrarDieta.setForeground(new java.awt.Color(255, 255, 255));
        BcadastrarDieta.setText("CADASTRAR DIETA");
        BcadastrarDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcadastrarDietaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel13.setText("Cadastro De Dietas Interais");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Conforme:");

        conforme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM", "NÃO" }));

        javax.swing.GroupLayout PainelcadastrosDeDietasLayout = new javax.swing.GroupLayout(PainelcadastrosDeDietas);
        PainelcadastrosDeDietas.setLayout(PainelcadastrosDeDietasLayout);
        PainelcadastrosDeDietasLayout.setHorizontalGroup(
            PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(BcadastrarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 474, Short.MAX_VALUE))
            .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                        .addComponent(nomeDaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelcadastrosDeDietasLayout.createSequentialGroup()
                                .addComponent(idCha1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelcadastrosDeDietasLayout.createSequentialGroup()
                                .addComponent(idFun1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                        .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(lote, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(validade, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addContainerGap())
                    .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                        .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(conforme, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PainelcadastrosDeDietasLayout.setVerticalGroup(
            PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PainelcadastrosDeDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idFun1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idCha1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelcadastrosDeDietasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeDaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jlabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lote, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conforme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(BcadastrarDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );

        menuEstoquista.setBackground(new java.awt.Color(0, 102, 0));
        menuEstoquista.setForeground(new java.awt.Color(51, 102, 0));

        bRetirada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bRetirada.setText("Retirar Dieta");
        bRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetiradaActionPerformed(evt);
            }
        });

        bEstoqueDeDietas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bEstoqueDeDietas.setText("Estoque De Dietas");
        bEstoqueDeDietas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEstoqueDeDietasActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 172, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel12.setText("ESTOQUISTA");

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jToggleButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jToggleButton1.setText("Cadastrar Dietas");

        javax.swing.GroupLayout menuEstoquistaLayout = new javax.swing.GroupLayout(menuEstoquista);
        menuEstoquista.setLayout(menuEstoquistaLayout);
        menuEstoquistaLayout.setHorizontalGroup(
            menuEstoquistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bRetirada, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
            .addComponent(bEstoqueDeDietas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuEstoquistaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(menuEstoquistaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuEstoquistaLayout.createSequentialGroup()
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuEstoquistaLayout.setVerticalGroup(
            menuEstoquistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquistaLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(bRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(bEstoqueDeDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelRetiradaDieta.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel19.setText("TABELA DE RETIRADA:");

        tabelaRetiradaDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dieta", "Horario Da retirada", "Quantidade", "Validade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
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
                selecionarFuncionarioDaTabela(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaRetiradaDieta);
        if (tabelaRetiradaDieta.getColumnModel().getColumnCount() > 0) {
            tabelaRetiradaDieta.getColumnModel().getColumn(0).setMinWidth(50);
            tabelaRetiradaDieta.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaRetiradaDieta.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        comboPeriodoSelecao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATUTINO", "VESPERTINO", "NOTURNO" }));
        comboPeriodoSelecao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPeriodoSelecaoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("PERIODO:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("RESPONSAVEL PELA RETIRADA");

        ComboRetirada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENFERMEIRO", "TECNICO DE ENFERMAGEM", "NUTRICIONISTA" }));
        ComboRetirada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboRetiradaActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 102, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CONCLUIR");

        javax.swing.GroupLayout painelRetiradaDietaLayout = new javax.swing.GroupLayout(painelRetiradaDieta);
        painelRetiradaDieta.setLayout(painelRetiradaDietaLayout);
        painelRetiradaDietaLayout.setHorizontalGroup(
            painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRetiradaDietaLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelRetiradaDietaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelRetiradaDietaLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPeriodoSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(154, 154, 154))
                    .addGroup(painelRetiradaDietaLayout.createSequentialGroup()
                        .addGroup(painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        painelRetiradaDietaLayout.setVerticalGroup(
            painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelRetiradaDietaLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel22))
                .addGap(48, 48, 48)
                .addGroup(painelRetiradaDietaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboRetirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPeriodoSelecao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        painelDoEstoqueDietas.setBackground(new java.awt.Color(255, 255, 255));

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
        TabelaDeSelecao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDeSelecaotabelaSelecaoClick(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDeSelecao);
        if (TabelaDeSelecao.getColumnModel().getColumnCount() > 0) {
            TabelaDeSelecao.getColumnModel().getColumn(4).setMinWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(4).setPreferredWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(4).setMaxWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(5).setMinWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(5).setPreferredWidth(0);
            TabelaDeSelecao.getColumnModel().getColumn(5).setMaxWidth(0);
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("ESTOQUE DE DIETAS");

        bVoltar.setBackground(new java.awt.Color(0, 102, 0));
        bVoltar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bVoltar.setForeground(new java.awt.Color(255, 255, 255));
        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Pesquisar:");

        javax.swing.GroupLayout painelDoEstoqueDietasLayout = new javax.swing.GroupLayout(painelDoEstoqueDietas);
        painelDoEstoqueDietas.setLayout(painelDoEstoqueDietasLayout);
        painelDoEstoqueDietasLayout.setHorizontalGroup(
            painelDoEstoqueDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                .addGroup(painelDoEstoqueDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE))
                    .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                        .addGroup(painelDoEstoqueDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                                .addGap(367, 367, 367)
                                .addComponent(jLabel6))
                            .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDoEstoqueDietasLayout.setVerticalGroup(
            painelDoEstoqueDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(painelDoEstoqueDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDoEstoqueDietasLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDoEstoqueDietasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(pesquisaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuEstoquista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1013, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(267, Short.MAX_VALUE)
                    .addComponent(PainelcadastrosDeDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(267, Short.MAX_VALUE)
                    .addComponent(painelRetiradaDieta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(267, Short.MAX_VALUE)
                    .addComponent(painelDoEstoqueDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(262, Short.MAX_VALUE)
                    .addComponent(painelInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuEstoquista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PainelcadastrosDeDietas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelRetiradaDieta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelDoEstoqueDietas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetiradaActionPerformed
        PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(true);
        painelDoEstoqueDietas.setVisible(false);
        painelInicial.setVisible(false);
        PreencherTabelaFuncionario();
        PreencherTabelaSala();
    }//GEN-LAST:event_bRetiradaActionPerformed

    private void bEstoqueDeDietasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEstoqueDeDietasActionPerformed
        painelDoEstoqueDietas.setVisible(true);
        PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(false);
        painelInicial.setVisible(false);
        PreencherTabelaSelecao();
    }//GEN-LAST:event_bEstoqueDeDietasActionPerformed

    private void idCha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCha1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCha1ActionPerformed

    private void idFun1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFun1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFun1ActionPerformed

    private void nomeDaDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeDaDietaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeDaDietaActionPerformed

    private void fornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedorActionPerformed

 
    
    private void loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loteActionPerformed

    private void BcadastrarDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcadastrarDietaActionPerformed
     /*   String sala = campoNomeSalaCadastro.getText();
        
        ChaveController dao = new ChaveController();
        List<Chave> listaChave = dao.listaChave();
        
        // Verifica se a sala é válida
        if (!sala.isEmpty() && sala.length() >= 3) {
            if (listaChave != null) {
                for (Chave c : listaChave) {
                    if (sala.equalsIgnoreCase(c.getNomeSala())) {
                        JOptionPane.showMessageDialog(null, "Sala já cadastrada");
                        return; 
                    }
                }
            }

            // Cria e insere a nova chave
            Chave chaveCadastrar = new Chave(sala, true);
            boolean sucesso = dao.inserirChave(chaveCadastrar); // Corrigido o nome do método
            if (sucesso) {
               JOptionPane.showMessageDialog(this, "Sala cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a sala!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha o nome da sala corretamente!");
        }*/
    }//GEN-LAST:event_BcadastrarDietaActionPerformed

    private int idFuncionaroTabela;
    private String nomeFuncionarioTabela;
    private void selecionarFuncionarioDaTabela(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selecionarFuncionarioDaTabela
         /* // capturar a linha que o usuario clicou
        int linhaselecionada = tabelaRetiradaDieta.getSelectedRow();
        // verificar se o usuario clicou em alguma linha
        if (linhaselecionada>=0){
          // definir modelo padrão da tabela
          DefaultTableModel modelotabela = (DefaultTableModel) tabelaRetiradaDieta.getModel();
          this.idFuncionaroTabela = Integer.parseInt(modelotabela.getValueAt(linhaselecionada,0).toString());
          this.nomeFuncionarioTabela = modelotabela.getValueAt(linhaselecionada,1).toString();
          String funcionario = modelotabela.getValueAt(linhaselecionada, 0).toString();
          campoFuncionarioSelecao.setText(nomeFuncionarioTabela);
        }*/
    }//GEN-LAST:event_selecionarFuncionarioDaTabela

    private int idSalaTabela;
    private String nomeSalaTabela;

    public int getIdFuncionaroTabela() {
        return idFuncionaroTabela;
    }

    public void setIdFuncionaroTabela(int idFuncionaroTabela) {
        this.idFuncionaroTabela = idFuncionaroTabela;
    }

    public int getIdSalaTabela() {
        return idSalaTabela;
    }

    public void setIdSalaTabela(int idSalaTabela) {
        this.idSalaTabela = idSalaTabela;
    }
    private int idFuncionario;
    private int idChave;
    private void TabelaDeSelecaotabelaSelecaoClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDeSelecaotabelaSelecaoClick
        // TODO add your handling code here:
        // capturar a linha que o usuario clicou
        int linhaselecionada = TabelaDeSelecao.getSelectedRow();
        // verificar se o usuario clicou em alguma linha
       /* if (linhaselecionada>=0){
            // definir modelo padrão da tabela
            DefaultTableModel modelotabela = (DefaultTableModel) TabelaDeSelecao.getModel();
            this.idFuncionario = Integer.parseInt(modelotabela.getValueAt(linhaselecionada,4).toString());
            this.idChave = Integer.parseInt(modelotabela.getValueAt(linhaselecionada, 5).toString());
            String funcionario = modelotabela.getValueAt(linhaselecionada, 0).toString();
            String sala = modelotabela.getValueAt(linhaselecionada, 1).toString();
            //String periodo = modelotabela.getValueAt(linhaselecionada, 1).toString();
            campoNomeFuncionario.setText(funcionario);
            campoNomeSala.setText(sala);
            System.err.println(idFuncionario);
        }// fim do if*/
    }//GEN-LAST:event_TabelaDeSelecaotabelaSelecaoClick

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
      /*  // TODO add your handling code here:
          // Obter a linha selecionada na tabela
    int linhaselecionada = TabelaDeSelecao.getSelectedRow(); 
    
    // Verificar se há uma linha selecionada
    if (linhaselecionada >= 0) { 
        // Obter o modelo da tabela
        DefaultTableModel modelotabela = (DefaultTableModel) TabelaDeSelecao.getModel(); 
        
        // Extrair os valores de idFuncionario e idChave
        int idFuncionario = Integer.parseInt(modelotabela.getValueAt(linhaselecionada, 4).toString()); 
        int idChave = Integer.parseInt(modelotabela.getValueAt(linhaselecionada, 5).toString()); 
        
        // Criar o controlador para excluir a seleção
        SelecaoController controller = new SelecaoController(); 
        
        // Chamar o método para excluir a seleção
        boolean sucesso = controller.excluirSelecao(idFuncionario, idChave); 
        
        // Verificar se a exclusão foi bem-sucedida
        if (sucesso) { 
            JOptionPane.showMessageDialog(this, "Seleção excluída com sucesso!"); 
            PreencherTabelaSelecao(); // Atualiza a tabela
        } else { 
            JOptionPane.showMessageDialog(this, "Erro ao excluir a seleção.");
        } 
    } else { 
        // Caso nenhuma linha tenha sido selecionada
        JOptionPane.showMessageDialog(this, "Selecione uma linha para excluir."); 
    } */
    }//GEN-LAST:event_bVoltarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // Fechar a tela atual
        this.dispose(); 
    
        // Criar uma nova instância da outra tela
        loginTela l = new loginTela();
    
       // Tornar a nova tela visível
       l.setVisible(true);
    }//GEN-LAST:event_btnSairActionPerformed

    private void ComboRetiradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboRetiradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboRetiradaActionPerformed

    private void comboPeriodoSelecaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPeriodoSelecaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPeriodoSelecaoActionPerformed

    
       
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
            java.util.logging.Logger.getLogger(Telaerror.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Telaerror.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Telaerror.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Telaerror.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telaerror().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BcadastrarDieta;
    private javax.swing.JComboBox<String> ComboRetirada;
    private javax.swing.JPanel PainelcadastrosDeDietas;
    private javax.swing.JTable TabelaDeSelecao;
    private javax.swing.JToggleButton bEstoqueDeDietas;
    private javax.swing.JToggleButton bRetirada;
    private javax.swing.JButton bVoltar;
    private javax.swing.JToggleButton btnSair;
    private javax.swing.JComboBox<String> comboPeriodoSelecao;
    private javax.swing.JComboBox<String> conforme;
    private javax.swing.JTextField fornecedor;
    private javax.swing.JTextField idCha1;
    private javax.swing.JTextField idFun1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JTextField lote;
    private javax.swing.JPanel menuEstoquista;
    private javax.swing.JTextField nomeDaDieta;
    private javax.swing.JPanel painelDoEstoqueDietas;
    private javax.swing.JPanel painelInicial;
    private javax.swing.JPanel painelRetiradaDieta;
    private javax.swing.JTextField pesquisaDieta;
    private javax.swing.JTable tabelaRetiradaDieta;
    private javax.swing.JTextField validade;
    // End of variables declaration//GEN-END:variables
}
