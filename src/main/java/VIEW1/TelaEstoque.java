/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;

import CONTROLLER.DietasController;
import MODEL.Deposito;
import MODEL.FinalizadaDeposito;
import MODEL.Finalizada;
import MODEL.InformacaoPacienteFim;
import com.itextpdf.awt.geom.Dimension;
import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
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
        configurarPesquisaDieta();
        // Dentro do construtor da tela de depósito
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         listarDepositoTudo();
         listarFinalizadaDeposito();
     PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(true);
        painelDoEstoqueDietas.setVisible(false);
        
         
    }
   // Método para fechar a tela
    public void fecharTela() {
        dispose();
    }
    
      // Método para verificar se a data está próxima de vencer
    public static boolean isValidadeProxima(String validadeString) {
        // Defina o formato da data (ajuste se o seu formato for diferente)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Obter a data de validade como Date
            Date validadeDate = sdf.parse(validadeString);
            
            // Obter a data atual
            Date dataAtual = new Date();

            // Calcular a diferença em milissegundos
            long diff = validadeDate.getTime() - dataAtual.getTime();

            // Calcular a diferença em dias
            long diffDays = diff / (1000 * 60 * 60 * 24);

            // Verificar se a data de validade está dentro de 7 dias
            return diffDays <= 7 && diffDays >= 0;  // Dentro de 7 dias e não no passado
        } catch (ParseException e) {
            System.err.println("Erro ao converter a data: " + e.getMessage());
            return false;
        }
    }
    
 
    
  

    // Método para configurar o evento do botão de sair
    private void configurarBotaoDeSair() {
        JButton seuBotaoDeSair = new JButton("Sair");
        seuBotaoDeSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginTela login = new loginTela();
                login.setVisible(true);
                fecharTela();
            }
        });

        // Adicione o botão à tela
        add(saida);
    }
  //  limpar campos  
private void limparCampos() {
    nomeDaDietaD.setText("");
    loteD.setText("");
    validadeD.setText("");
    
}// fim limpar campos



//CÓDIGO PARA ALTERAR COR DA TABELA ONDE STATUS SIM/NÃO ---------------------
public class StatusCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null) {
            String status = value.toString().toLowerCase();

            if (status.equals("sim")) {
                c.setBackground(Color.GREEN);
                c.setForeground(Color.BLACK);
            } else if (status.equals("não") || status.equals("nao")) {
                c.setBackground(Color.RED);
                c.setForeground(Color.WHITE);
            } else {
                c.setBackground(Color.WHITE);
                c.setForeground(Color.BLACK);
            }
        } else {
            c.setBackground(Color.WHITE);
            c.setForeground(Color.BLACK);
        }

        return c;
    }
}
//-----------------------------------------------------------------------------
 // Aqui você coloca a classe renderer
    class ValidadeCellRenderer extends DefaultTableCellRenderer {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            try {
                String dataStr = value.toString();
                LocalDate validade = LocalDate.parse(dataStr, formatter);
                LocalDate hoje = LocalDate.now();

                if (validade.isBefore(hoje)) {
                    c.setBackground(Color.RED);
                } else if (!validade.isBefore(hoje) && validade.isBefore(hoje.plusDays(7))) {
                    c.setBackground(Color.YELLOW);
                } else {
                    c.setBackground(Color.GREEN);
                }
            } catch (Exception e) {
                c.setBackground(Color.WHITE); // caso dê erro na data
            }

            return c;
        }
    }


//listagem de deposito(o que tem armazenado)
public void listarDepositoTudo() { 
    try { 
        // Criar o controlador para acessar os dados da tabela Deposito
        DietasController dietasController = new DietasController(); 
        
        // Obter os dados da tabela Deposito
        List<Deposito> dadosInformacao = dietasController.listarDepositoTudo(); 
        
        // Obter o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel)TabelaDeDeposito.getModel(); 
        
        // Verificando se o modelo da tabela já tem o número correto de colunas
        if (modeloTabela.getColumnCount() == 0) {
            modeloTabela.addColumn("ID Deposito");
            modeloTabela.addColumn("ID Dieta");
            modeloTabela.addColumn("Lote");
            modeloTabela.addColumn("Fornecedor");
            modeloTabela.addColumn("Validade");
            modeloTabela.addColumn("Quantidade");
            modeloTabela.addColumn("Conforme");
            modeloTabela.addColumn("nomedieta");
        }
        
        // Limpar a tabela antes de adicionar novos dados
        modeloTabela.setRowCount(0); 
          TabelaDeDeposito.getColumnModel().getColumn(4).setCellRenderer(new ValidadeCellRenderer());
        // Adicionar cada linha de dados à tabela
        for (Deposito linha : dadosInformacao) { 
            modeloTabela.addRow(new Object[] {
                linha.getIdDeposito(),
                linha.getIdDieta(),
                linha.getLote(),
                linha.getFornecedor(),
                linha.getValidade(),
                linha.getQuantidade(),
                linha.isConforme() ? "Sim" : "Não",
                linha.getNomedieta()
            }); 
        } // **Aqui o try é corretamente fechado**
      

    } catch (Exception e) {  // **Agora o catch está no lugar correto**
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Erro ao atualizar a tabela: " + e.getMessage()); 
    } 
}


//fim listagem deposito
private void configurarPesquisaDieta() {
    pesquisaDieta.getDocument().addDocumentListener(new DocumentListener() {
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
            String nomeDieta = pesquisaDieta.getText().trim();
            listarDepositoPorNome(nomeDieta);
        }
    });
}


//Metodo para pesquisa no deposito
public void listarDepositoPorNome(String nomeDieta) {
    try { 
        DietasController dietasController = new DietasController(); 
        List<Deposito> dadosFiltrados = dietasController.listarDepositoPorNome(nomeDieta);

        DefaultTableModel modeloTabela = (DefaultTableModel) TabelaDeDeposito.getModel(); 
        
        // Limpa os dados atuais antes de adicionar os filtrados
        modeloTabela.setRowCount(0);

        for (Deposito linha : dadosFiltrados) { 
            modeloTabela.addRow(new Object[] {
                linha.getIdDeposito(),
                linha.getIdDieta(),
                linha.getLote(),
                linha.getFornecedor(),
                linha.getValidade(),
                linha.getQuantidade(),
                linha.isConforme() ? "Sim" : "Não",
                linha.getNomedieta()
            });
        }

    } catch (Exception e) {
        e.printStackTrace(); 
        JOptionPane.showMessageDialog(null, "Erro ao pesquisar na tabela: " + e.getMessage()); 
    } 
}
//atualiza conforme o usuário digita no deposito


//-------------------------------------------------------------------------------
//meetodo de lisatagem para Tabela de retirada deposito
public void listarFinalizadaDeposito() { 
    try { 
        DietasController dietasController = new DietasController(); 
        List<InformacaoPacienteFim> dadosInformacao = dietasController.listarFinDeposito(); 
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaRetiradaDieta.getModel(); 

       if (modeloTabela.getColumnCount() == 0) {
    modeloTabela.addColumn("ID Finalizada");
    modeloTabela.addColumn("Nome Dieta");
    modeloTabela.addColumn("Nome Paciente");
    modeloTabela.addColumn("Leito");
    modeloTabela.addColumn("Ala");
    modeloTabela.addColumn("Turno");
    modeloTabela.addColumn("Responsável");
    modeloTabela.addColumn("Status");
    modeloTabela.addColumn("ID Dieta"); // <-- adiciona o ID da dieta
}


        modeloTabela.setRowCount(0); 
        tabelaRetiradaDieta.getColumnModel().getColumn(7).setCellRenderer(new StatusCellRenderer());

        for (InformacaoPacienteFim linha : dadosInformacao) { 
           modeloTabela.addRow(new Object[] {
    linha.getIdFinalizada(),
    linha.getNomedieta(),
    linha.getNome(),
    linha.getLeito(),
    linha.getAla(),
    linha.getTurno(),
    linha.getQualFuncionario(),
    linha.isStatus() ? "Sim" : "Não",
    linha.getIdDieta() // <-- adicionado
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
        jlabel2 = new javax.swing.JLabel();
        loteD = new javax.swing.JTextField();
        atData = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        menuEstoquista2 = new javax.swing.JPanel();
        bRetirada2 = new javax.swing.JToggleButton();
        jLabel15 = new javax.swing.JLabel();
        infoDeposito1 = new javax.swing.JToggleButton();
        usuario1 = new javax.swing.JLabel();
        fornecedorD = new javax.swing.JComboBox<>();
        conformeD = new javax.swing.JCheckBox();
        quantidadeD = new javax.swing.JComboBox<>();
        validadeD = new javax.swing.JFormattedTextField();
        adicionarMais = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaDeDeposito1 = new javax.swing.JTable();
        BcadastrarDieta1 = new javax.swing.JButton();
        painelRetiradaDieta = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaRetiradaDieta = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaofinal = new javax.swing.JButton();
        menuEstoquista1 = new javax.swing.JPanel();
        bEstoqueDeDietas1 = new javax.swing.JToggleButton();
        jLabel14 = new javax.swing.JLabel();
        infoDeposito = new javax.swing.JToggleButton();
        saida = new javax.swing.JButton();
        usuario2 = new javax.swing.JLabel();
        qualIDqualFinalizada1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        finalizarSim1 = new javax.swing.JCheckBox();
        turnoBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        responsavelBox1 = new javax.swing.JComboBox<>();
        qualID1 = new javax.swing.JTextField();
        atualizarTabelaBT1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        painelDoEstoqueDietas = new javax.swing.JPanel();
        atualizarTabelaBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDeDeposito = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pesquisaDieta = new javax.swing.JTextField();
        botaoPD = new javax.swing.JButton();
        imgFundo2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        PainelcadastrosDeDietas.setBackground(new java.awt.Color(255, 255, 255));
        PainelcadastrosDeDietas.setMaximumSize(new java.awt.Dimension(1920, 1080));
        PainelcadastrosDeDietas.setMinimumSize(new java.awt.Dimension(1920, 1080));
        PainelcadastrosDeDietas.setPreferredSize(new java.awt.Dimension(1920, 1080));
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

        jlabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlabel2.setText("Lote:");
        PainelcadastrosDeDietas.add(jlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 258, 220, 27));

        loteD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteDActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(loteD, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 291, 251, 29));

        atData.setBackground(new java.awt.Color(0, 102, 255));
        atData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        atData.setForeground(new java.awt.Color(255, 255, 255));
        atData.setText("Atualizar Dieta");
        atData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atDataActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(atData, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 700, 200, 39));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setText("Cadastro De Dietas Interais");
        PainelcadastrosDeDietas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 72, 340, 40));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar mais da mesma Dieta.");
        PainelcadastrosDeDietas.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 290, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Quantidade:");
        PainelcadastrosDeDietas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 488, -1, -1));

        menuEstoquista2.setBackground(new java.awt.Color(0, 102, 255));
        menuEstoquista2.setForeground(new java.awt.Color(0, 102, 255));
        menuEstoquista2.setMaximumSize(new java.awt.Dimension(178, 686));
        menuEstoquista2.setMinimumSize(new java.awt.Dimension(178, 686));

        bRetirada2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        bRetirada2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/receptor (1).png"))); // NOI18N
        bRetirada2.setText("Retirar Dieta");
        bRetirada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirada2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel15.setText("ESTOQUISTA");

        infoDeposito1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoDeposito1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/estoque.png"))); // NOI18N
        infoDeposito1.setText("Estoque");
        infoDeposito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDeposito1ActionPerformed(evt);
            }
        });

        usuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imagem-do-usuario-com-fundo-preto.png"))); // NOI18N

        javax.swing.GroupLayout menuEstoquista2Layout = new javax.swing.GroupLayout(menuEstoquista2);
        menuEstoquista2.setLayout(menuEstoquista2Layout);
        menuEstoquista2Layout.setHorizontalGroup(
            menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista2Layout.createSequentialGroup()
                .addGroup(menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuEstoquista2Layout.createSequentialGroup()
                        .addGroup(menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuEstoquista2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(bRetirada2))
                            .addGroup(menuEstoquista2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(menuEstoquista2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(infoDeposito1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        menuEstoquista2Layout.setVerticalGroup(
            menuEstoquista2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(53, 53, 53)
                .addComponent(bRetirada2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(infoDeposito1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(619, Short.MAX_VALUE))
        );

        PainelcadastrosDeDietas.add(menuEstoquista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 180, 1070));

        fornecedorD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAvisks", "Chavinsks", "Babinsks", "Stravinsks", "Chololisks", " " }));
        PainelcadastrosDeDietas.add(fornecedorD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 250, 30));

        conformeD.setText("Sim\n\n");
        PainelcadastrosDeDietas.add(conformeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 610, -1, -1));

        quantidadeD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", " " }));
        PainelcadastrosDeDietas.add(quantidadeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 120, 30));

        validadeD.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        try {
            validadeD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        validadeD.setToolTipText("");
        PainelcadastrosDeDietas.add(validadeD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, 250, 30));

        adicionarMais.setFont(new java.awt.Font("Consolas", 3, 18)); // NOI18N
        adicionarMais.setForeground(new java.awt.Color(34, 23, 23));
        adicionarMais.setText("Adicionar Mais");
        adicionarMais.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adicionarMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarMaisActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(adicionarMais, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, 270, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Conforme:");
        PainelcadastrosDeDietas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 581, 102, -1));

        TabelaDeDeposito1.setBackground(new java.awt.Color(204, 204, 204));
        TabelaDeDeposito1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome Dieta", "Lote", "Fornecedor", "Validade", "Quantidade", "Conforme"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelaDeDeposito1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDeDeposito1tabelaSelecaoClick(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaDeDeposito1);

        PainelcadastrosDeDietas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 270, 890, 230));

        BcadastrarDieta1.setBackground(new java.awt.Color(0, 102, 255));
        BcadastrarDieta1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BcadastrarDieta1.setForeground(new java.awt.Color(255, 255, 255));
        BcadastrarDieta1.setText("CADASTRAR DIETA");
        BcadastrarDieta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcadastrarDieta1ActionPerformed(evt);
            }
        });
        PainelcadastrosDeDietas.add(BcadastrarDieta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 700, 200, 39));

        painelRetiradaDieta.setBackground(new java.awt.Color(255, 255, 255));
        painelRetiradaDieta.setMaximumSize(new java.awt.Dimension(1920, 1080));
        painelRetiradaDieta.setMinimumSize(new java.awt.Dimension(1920, 1080));
        painelRetiradaDieta.setPreferredSize(new java.awt.Dimension(1920, 1080));
        painelRetiradaDieta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabelaRetiradaDieta.setBackground(new java.awt.Color(204, 204, 204));
        tabelaRetiradaDieta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Qual Finalizada", "Dieta", "Nome Paciente", "Leito", "Ala", "Turno", "Responsavel", "Status", "Id Dieta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaRetiradaDieta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaRetiradaDietaselecionarFuncionarioDaTabela(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaRetiradaDieta);

        painelRetiradaDieta.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 768, 262));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("TABELA DE RETIRADA:");
        painelRetiradaDieta.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 369, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Finalizar");
        painelRetiradaDieta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 281, -1));

        botaofinal.setBackground(new java.awt.Color(0, 102, 255));
        botaofinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaofinal.setForeground(new java.awt.Color(255, 255, 255));
        botaofinal.setText("CONCLUIR");
        botaofinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofinalActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(botaofinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 262, 48));

        menuEstoquista1.setBackground(new java.awt.Color(0, 102, 255));
        menuEstoquista1.setForeground(new java.awt.Color(51, 102, 0));

        bEstoqueDeDietas1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bEstoqueDeDietas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/retirada icon.png"))); // NOI18N
        bEstoqueDeDietas1.setText("Recebimento");
        bEstoqueDeDietas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEstoqueDeDietas1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel14.setText("ESTOQUISTA");

        infoDeposito.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        infoDeposito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/estoque.png"))); // NOI18N
        infoDeposito.setText("Estoque");
        infoDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoDepositoActionPerformed(evt);
            }
        });

        saida.setBackground(new java.awt.Color(255, 0, 0));
        saida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/man.png"))); // NOI18N
        saida.setText("Sair");
        saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saidaActionPerformed(evt);
            }
        });

        usuario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/imagem-do-usuario-com-fundo-preto.png"))); // NOI18N

        javax.swing.GroupLayout menuEstoquista1Layout = new javax.swing.GroupLayout(menuEstoquista1);
        menuEstoquista1.setLayout(menuEstoquista1Layout);
        menuEstoquista1Layout.setHorizontalGroup(
            menuEstoquista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(menuEstoquista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bEstoqueDeDietas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(saida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuEstoquista1Layout.setVerticalGroup(
            menuEstoquista1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuEstoquista1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel14)
                .addGap(105, 105, 105)
                .addComponent(bEstoqueDeDietas1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(infoDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 521, Short.MAX_VALUE)
                .addComponent(saida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        painelRetiradaDieta.add(menuEstoquista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 1080));

        qualIDqualFinalizada1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualIDqualFinalizada1ActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(qualIDqualFinalizada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 130, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Responsavel");
        painelRetiradaDieta.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 281, -1));

        finalizarSim1.setText("Sim");
        painelRetiradaDieta.add(finalizarSim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 470, -1, -1));

        turnoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespetino", " " }));
        turnoBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                turnoBoxActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(turnoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 200, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("ID Dieta");
        painelRetiradaDieta.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 281, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Turno");
        painelRetiradaDieta.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 281, -1));

        responsavelBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enfermeiro", "Medico", " " }));
        painelRetiradaDieta.add(responsavelBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 200, 30));

        qualID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qualID1ActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(qualID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 130, 30));

        atualizarTabelaBT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/carregando.png"))); // NOI18N
        atualizarTabelaBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaBT1ActionPerformed(evt);
            }
        });
        painelRetiradaDieta.add(atualizarTabelaBT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 330, 40, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Qual Finalizada");
        painelRetiradaDieta.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 281, -1));

        painelDoEstoqueDietas.setBackground(new java.awt.Color(255, 255, 255));
        painelDoEstoqueDietas.setMaximumSize(new java.awt.Dimension(1920, 1080));
        painelDoEstoqueDietas.setMinimumSize(new java.awt.Dimension(1920, 1080));
        painelDoEstoqueDietas.setPreferredSize(new java.awt.Dimension(1920, 1080));
        painelDoEstoqueDietas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atualizarTabelaBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/carregando.png"))); // NOI18N
        atualizarTabelaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaBTActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(atualizarTabelaBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, 40, 30));

        TabelaDeDeposito.setBackground(new java.awt.Color(204, 204, 204));
        TabelaDeDeposito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Deposito", "ID Dieta", "Lote", "Fornecedor", "Validade", "Quantidade", "Conforme", "Nome Dieta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TabelaDeDeposito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDeDepositotabelaSelecaoClick(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDeDeposito);

        painelDoEstoqueDietas.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 980, 476));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setText("ESTOQUE DE DIETAS");
        painelDoEstoqueDietas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 22, -1, -1));

        bVoltar.setBackground(new java.awt.Color(0, 102, 255));
        bVoltar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        bVoltar.setForeground(new java.awt.Color(255, 255, 255));
        bVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/voltar.png"))); // NOI18N
        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(bVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 750, 246, 59));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Pesquisar:");
        painelDoEstoqueDietas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 55, -1, 30));

        pesquisaDieta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisaDietaActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(pesquisaDieta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 415, -1));

        botaoPD.setForeground(new java.awt.Color(255, 255, 255));
        botaoPD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/magnifier (1).png"))); // NOI18N
        botaoPD.setBorder(null);
        botaoPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPDActionPerformed(evt);
            }
        });
        painelDoEstoqueDietas.add(botaoPD, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 50, 40));

        imgFundo2.setBackground(new java.awt.Color(255, 255, 255));
        painelDoEstoqueDietas.add(imgFundo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 792));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(13, 13, 13)
                    .addComponent(PainelcadastrosDeDietas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
            .addGap(0, 1091, Short.MAX_VALUE)
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

    private void loteDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loteDActionPerformed

    private void atDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atDataActionPerformed
// Capturando os dados dos campos de entrada
/*
if (nomeDaDietaD.getText().isEmpty() || loteD.getText().isEmpty() || fornecedorD.getSelectedItem() == null || validadeD.getText().isEmpty() || quantidadeD.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de adicionar.");
} else {
  String tipoDieta = nomeDaDietaD.getText();
String lote = loteD.getText();
String fornecedor = fornecedorD.getSelectedItem().toString();
String validade = validadeD.getText();
int quantidade = Integer.parseInt(quantidadeD.getSelectedItem().toString()); // Corrigido aqui
boolean conforme = conformeD.isSelected();


   try {
        DietasController adicionarDeposito = new DietasController();
        boolean adicionou = adicionarDeposito.adicionarDeposito(tipoDieta, lote, fornecedor, validade, quantidade, conforme);
        
        if (adicionou) {
            JOptionPane.showMessageDialog(null, "Dieta adicionada ao depósito com sucesso!");
            
            // Atualiza a tabela com a listagem atualizada
            listarFinalizadaDeposito();
            
            // Limpa os campos do formulário
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar o produto ao depósito.");
            listarFinalizadaDeposito();
            
            // Limpa os campos do formulário
            limparCampos();
        }
    } catch (Exception e) {
        System.err.print("Erro ao adicionar ao depósito: " + e);
    }
}
*/
//Novo metodo para ser possível adicionar mais ietas

// Suponha que essa checkbox já esteja na sua interface
if (nomeDaDietaD.getText().isEmpty() || loteD.getText().isEmpty() || fornecedorD.getSelectedItem() == null || validadeD.getText().isEmpty() || quantidadeD.getSelectedItem() == null) {
    JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de adicionar.");
} else {
    String tipoDieta = nomeDaDietaD.getText();
    String lote = loteD.getText();
    String fornecedor = fornecedorD.getSelectedItem().toString();
    String validade = validadeD.getText();
    int quantidade = Integer.parseInt(quantidadeD.getSelectedItem().toString());
    boolean conforme = conformeD.isSelected();
    boolean usarDietaExistente = adicionarMais.isSelected(); // <-- aqui usamos sua checkbox

    try {
        DietasController adicionarDeposito = new DietasController();
        boolean adicionou = adicionarDeposito.adicionarDeposito(tipoDieta, lote, fornecedor, validade, quantidade, conforme, usarDietaExistente);

        if (adicionou) {
            JOptionPane.showMessageDialog(null, "Dieta adicionada ao depósito com sucesso!");
            listarFinalizadaDeposito(); // Atualiza a tabela
            limparCampos();             // Limpa os campos
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar o produto ao depósito.");
            listarFinalizadaDeposito();
            limparCampos();
        }

    } catch (Exception e) {
        System.err.print("Erro ao adicionar ao depósito: " + e);
    }
}


    }//GEN-LAST:event_atDataActionPerformed

    private void TabelaDeDepositotabelaSelecaoClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDeDepositotabelaSelecaoClick
       
    }//GEN-LAST:event_TabelaDeDepositotabelaSelecaoClick

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
   PainelcadastrosDeDietas.setVisible(false);
        painelRetiradaDieta.setVisible(true);
        painelDoEstoqueDietas.setVisible(false);     
    }//GEN-LAST:event_bVoltarActionPerformed

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

    private void qualIDqualFinalizada1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualIDqualFinalizada1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualIDqualFinalizada1ActionPerformed

    private void tabelaRetiradaDietaselecionarFuncionarioDaTabela(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaRetiradaDietaselecionarFuncionarioDaTabela
// Obtém a linha selecionada na tabelaRetiradaDieta
/*
int linhaSelecionada = tabelaRetiradaDieta.getSelectedRow();

// Verifica se alguma linha foi selecionada
if (linhaSelecionada >= 0) {
    // Define o modelo padrão para a tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaRetiradaDieta.getModel();
    
    // Joga os dados da tabela para os campos de texto
    qualIDqualFinalizada1.setText(modeloTabela.getValueAt(linhaSelecionada, 0).toString()); // Nome Paciente
   
    // Adicione outros campos conforme necessário
} // fim do if
*/
// Obtém a linha selecionada na tabelaRetiradaDieta
int linhaSelecionada = tabelaRetiradaDieta.getSelectedRow();

// Verifica se alguma linha foi selecionada
if (linhaSelecionada >= 0) {
    // Define o modelo padrão para a tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) tabelaRetiradaDieta.getModel();
 qualIDqualFinalizada1.setText(modeloTabela.getValueAt(linhaSelecionada, 0).toString()); 
    // Pega o valor da última coluna (índice 8)
    qualID1.setText(modeloTabela.getValueAt(linhaSelecionada, 8).toString());

    // Se quiser pegar outras colunas, exemplo da primeira:
    // qualID.setText(modeloTabela.getValueAt(linhaSelecionada, 0).toString());
}

    }//GEN-LAST:event_tabelaRetiradaDietaselecionarFuncionarioDaTabela
public void gerarPDF() {
    // Código para gerar o PDF
    // ...
}

    private void botaofinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofinalActionPerformed
/*try {
    // Verificar se a opção de finalização está marcada
    boolean finalizarSim = finalizarSim1.isSelected();
    if (!finalizarSim) {
        JOptionPane.showMessageDialog(null, "Marque a opção para finalizar antes de prosseguir.");
        return;
    }

    // Obter o ID da finalização
    int idFinalizada = Integer.parseInt(qualFinalizada.getText());

    // Obter valores selecionados nos comboBoxes
    String turnoSelecionado = (String) turnoBox.getSelectedItem();
    String responsavelSelecionado = (String) responsavelBox1.getSelectedItem();

    // Validar se algo foi selecionado
    if (turnoSelecionado == null || turnoSelecionado.isEmpty() ||
        responsavelSelecionado == null || responsavelSelecionado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione o turno e o responsável.");
        return;
    }

    // Atualizar o status da finalização
    DietasController dietasController = new DietasController();
    boolean statusAtualizado = dietasController.atualizarStatusFinalizacao(idFinalizada, true);

    if (!statusAtualizado) {
        JOptionPane.showMessageDialog(null, "Não foi possível atualizar o status.");
        return;
    }

    // Atualizar turno e responsável no banco
    boolean atualizadoTurnoResp = dietasController.atualizarTurnoEResponsavel(idFinalizada, turnoSelecionado, responsavelSelecionado);
    if (!atualizadoTurnoResp) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar turno e responsável.");
        return;
    }

    // Obter o ID da dieta associada
    int idDieta = dietasController.obterIdDieta(idFinalizada);
    if (idDieta == -1) {
        JOptionPane.showMessageDialog(null, "Dieta não encontrada para esta finalização.");
        return;
    }

    // Verificar se há dieta suficiente no estoque
    if (!dietasController.verificarDisponibilidadeEstoque(idDieta, 1)) {
        JOptionPane.showMessageDialog(null, "Sem esta dieta no estoque!");
        return;
    }

    // Descontar 1 unidade do estoque
    boolean estoqueAtualizado = dietasController.descontarEstoque(idDieta, 1);
    if (!estoqueAtualizado) {
        JOptionPane.showMessageDialog(null, "Falha ao atualizar o estoque.");
        return;
    }

    JOptionPane.showMessageDialog(null, "Finalização e estoque atualizados com sucesso!");

    // Gerar o PDF
    gerarPDF();

    // Caminho do PDF
    String caminhoDoPdf = "C:\\Users\\edi\\Documents\\NetBeansProjects\\nutriHopitalarMaven\\src\\main\\resources\\PDF Finalizar\\Prescrição Nutricional.pdf";
    File arquivoPdf = new File(caminhoDoPdf);

    // Abrir o PDF se existir
    if (arquivoPdf.exists()) {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(arquivoPdf);
        } else {
            JOptionPane.showMessageDialog(null, "Abertura de PDF não suportada.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Arquivo PDF não encontrado.");
    }

    // Atualizar a tabela na tela
    listarFinalizadaDeposito();

} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Erro ao concluir a operação: " + ex.getMessage());
}
*/
try {
    // Verificar se a opção de finalização está marcada
    boolean finalizarSim = finalizarSim1.isSelected();
    if (!finalizarSim) {
        JOptionPane.showMessageDialog(null, "Marque a opção para finalizar antes de prosseguir.");
        return;
    }

    int idFinalizada = Integer.parseInt(qualIDqualFinalizada1.getText());

    String turnoSelecionado = (String) turnoBox.getSelectedItem();
    String responsavelSelecionado = (String) responsavelBox1.getSelectedItem();

    if (turnoSelecionado == null || turnoSelecionado.isEmpty() ||
        responsavelSelecionado == null || responsavelSelecionado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione o turno e o responsável.");
        return;
    }

    DietasController dietasController = new DietasController();

    // Obter o ID da dieta associada à finalização
    int idDieta = dietasController.obterIdDieta(idFinalizada);
    if (idDieta == -1) {
        JOptionPane.showMessageDialog(null, "Dieta não encontrada para esta finalização.");
        return;
    }

    // Verifica se a dieta existe no estoque com quantidade suficiente **ANTES** de atualizar status
    boolean disponivel = dietasController.verificarDisponibilidadeEstoque(idDieta, 1);
    if (!disponivel) {
        JOptionPane.showMessageDialog(null, "Sem esta dieta no estoque! Finalização cancelada.");
        return;
    }

    // Descontar 1 unidade da dieta no estoque
    boolean estoqueAtualizado = dietasController.descontarEstoque(idDieta, 1);
    if (!estoqueAtualizado) {
        JOptionPane.showMessageDialog(null, "Falha ao atualizar o estoque. Finalização cancelada.");
        return;
    }

    // **Agora sim, atualiza o status de finalização**
    boolean statusAtualizado = dietasController.atualizarStatusFinalizacao(idFinalizada, true);
    if (!statusAtualizado) {
        JOptionPane.showMessageDialog(null, "Não foi possível atualizar o status.");
        return;
    }

    // Atualiza turno e responsável
    boolean atualizadoTurnoResp = dietasController.atualizarTurnoEResponsavel(idFinalizada, turnoSelecionado, responsavelSelecionado);
    if (!atualizadoTurnoResp) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar turno e responsável.");
        return;
    }

    // Confirmação final
    JOptionPane.showMessageDialog(null, "Finalização e estoque atualizados com sucesso!");

    gerarPDF(); // Gerar PDF

    String caminhoDoPdf = "C:\\Users\\edi\\Documents\\GitCarlos nutri\\nutriHopitalarMaven\\src\\main\\resources\\PDF Finalizar\\Presquição Nutricional.pdf";
    File arquivoPdf = new File(caminhoDoPdf);

    if (arquivoPdf.exists() && Desktop.isDesktopSupported()) {
        Desktop.getDesktop().open(arquivoPdf);
    } else {
        JOptionPane.showMessageDialog(null, "Arquivo PDF não encontrado ou abertura não suportada.");
    }

    // Atualiza tabela da tela
    listarFinalizadaDeposito();

} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Erro ao concluir a operação: " + ex.getMessage());
}



System.out.println("ID da dieta selecionado: " + qualIDqualFinalizada1.getText());
        
    }//GEN-LAST:event_botaofinalActionPerformed

    private void pesquisaDietaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisaDietaActionPerformed
/*pesquisaDieta.getDocument().addDocumentListener(new DocumentListener() {
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
        String nomeDieta = pesquisaDieta.getText().trim();
        listarDepositoPorNome(nomeDieta);
    }
});*/
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisaDietaActionPerformed

    private void saidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saidaActionPerformed
        // TODO add your handling code here:
        loginTela login = new loginTela();
        login.setVisible(true);
       
        ((JFrame) SwingUtilities.getWindowAncestor(saida)).dispose();
        // Dentro do construtor da tela de depósito


    }//GEN-LAST:event_saidaActionPerformed

    private void turnoBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_turnoBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_turnoBoxActionPerformed

    private void qualID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qualID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qualID1ActionPerformed

    private void atualizarTabelaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaBTActionPerformed
        // TODO add your handling code here:

        atualizarTabelaBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método que atualiza a tabela
                listarDepositoTudo();
            }
        });
        listarDepositoTudo();
    }//GEN-LAST:event_atualizarTabelaBTActionPerformed

    private void atualizarTabelaBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaBT1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:

        atualizarTabelaBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método que atualiza a tabela
                listarFinalizadaDeposito();
            }
        });
        listarFinalizadaDeposito();
    }//GEN-LAST:event_atualizarTabelaBT1ActionPerformed

    private void botaoPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPDActionPerformed
        // TODO add your handling code here:
        botaoPD.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeDieta = pesquisaDieta.getText().trim();
        listarDepositoPorNome(nomeDieta);
    }
});

    }//GEN-LAST:event_botaoPDActionPerformed

    private void adicionarMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarMaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adicionarMaisActionPerformed

    private void TabelaDeDeposito1tabelaSelecaoClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDeDeposito1tabelaSelecaoClick
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaDeDeposito1tabelaSelecaoClick

    private void BcadastrarDieta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcadastrarDieta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BcadastrarDieta1ActionPerformed

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
    private javax.swing.JButton BcadastrarDieta1;
    private javax.swing.JPanel PainelcadastrosDeDietas;
    private javax.swing.JTable TabelaDeDeposito;
    private javax.swing.JTable TabelaDeDeposito1;
    private javax.swing.JCheckBox adicionarMais;
    private javax.swing.JButton atData;
    private javax.swing.JButton atualizarTabelaBT;
    private javax.swing.JButton atualizarTabelaBT1;
    private javax.swing.JToggleButton bEstoqueDeDietas1;
    private javax.swing.JToggleButton bRetirada2;
    private javax.swing.JButton bVoltar;
    private javax.swing.JButton botaoPD;
    private javax.swing.JButton botaofinal;
    private javax.swing.JCheckBox conformeD;
    private javax.swing.JCheckBox finalizarSim1;
    private javax.swing.JComboBox<String> fornecedorD;
    private javax.swing.JTextField idCha1;
    private javax.swing.JTextField idFun1;
    private javax.swing.JLabel imgFundo2;
    private javax.swing.JToggleButton infoDeposito;
    private javax.swing.JToggleButton infoDeposito1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JTextField loteD;
    private javax.swing.JPanel menuEstoquista1;
    private javax.swing.JPanel menuEstoquista2;
    private javax.swing.JTextField nomeDaDietaD;
    private javax.swing.JPanel painelDoEstoqueDietas;
    private javax.swing.JPanel painelRetiradaDieta;
    private javax.swing.JTextField pesquisaDieta;
    private javax.swing.JTextField qualID1;
    private javax.swing.JTextField qualIDqualFinalizada1;
    private javax.swing.JComboBox<String> quantidadeD;
    private javax.swing.JComboBox<String> responsavelBox1;
    private javax.swing.JButton saida;
    private javax.swing.JTable tabelaRetiradaDieta;
    private javax.swing.JComboBox<String> turnoBox;
    private javax.swing.JLabel usuario1;
    private javax.swing.JLabel usuario2;
    private javax.swing.JFormattedTextField validadeD;
    // End of variables declaration//GEN-END:variables
}
