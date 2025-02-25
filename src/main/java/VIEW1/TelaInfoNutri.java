/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.sql.SQLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import CONTROLLER.DietasController;
import MODEL.Finalizadas;
import MODEL.InformacaoPacienteFim;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//import Model.Chave;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author edi
 */
public class TelaInfoNutri extends javax.swing.JFrame {
 private Timer timer;
    /**
     * Creates new form TelaInfoNutri
     */
    
    public TelaInfoNutri() {
        initComponents();
           listarInformacaoPacientesFim();
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
public void listarInformacaoPacientesFim() {
    // Criar o controlador para acessar os dados das finalizações
    DietasController controller = new DietasController();
    
    // Obter os dados das finalizações
    List<InformacaoPacienteFim> dadosInformacao = controller.getDadosInformacaoPacienteFim();
    
    // Obter o modelo da tabela
    DefaultTableModel modeloTabela = (DefaultTableModel) informacaoPacienteNutri.getModel();
    
    // Verificando se o modelo da tabela já tem o número correto de colunas
    if (modeloTabela.getColumnCount() == 0) {
        modeloTabela.addColumn("ID Finalizada");
        modeloTabela.addColumn("Nome");
        modeloTabela.addColumn("Leito");
        modeloTabela.addColumn("Dieta");
        modeloTabela.addColumn("Ala");
        modeloTabela.addColumn("Turno");
        modeloTabela.addColumn("Responsável");
        modeloTabela.addColumn("Status");
    }
    
    // Limpar a tabela antes de adicionar novos dados
    modeloTabela.setRowCount(0);
    
    // Adicionar cada linha de dados à tabela
    for (InformacaoPacienteFim paciente : dadosInformacao) {
        modeloTabela.addRow(new Object[]{
            paciente.getIdFinalizada(),
            paciente.getNome(),
            paciente.getLeito(),
            paciente.getIdDieta(),
            paciente.getAla(),
            paciente.isTurno(),
            paciente.isQualFuncionario(),
            paciente.isStatus() ? "Sim" : "Não"
        });
    }
}











  // Método para iniciar o temporizador
    private void iniciarTemporizador() {
        int delay = 5000; // Delay de 5 segundos (5000 milissegundos)
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 listarInformacaoPacientesFim(); // Atualizar a tabela periodicamente
            }
        });
        timer.start();
    }

    // Método para parar o temporizador quando necessário
    public void pararTemporizador() {
        if (timer != null) {
            timer.stop();
        }
    }


private void atualizarTableActionPerformed() {
   DietasController dietasController = new DietasController();
    boolean sucesso = dietasController.atualizarFinalizadaInfo();

    if (sucesso) {
         listarInformacaoPacientesFim(); // Chama o método para listar as reservas e atualizar a tabela
    } else {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar a tabela.");
    }
}





    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        topoLogo = new javax.swing.JTextField();
        tabelaProduto = new javax.swing.JScrollPane();
        informacaoPacienteNutri = new javax.swing.JTable();
        Fechar1 = new javax.swing.JButton();
        pdff = new javax.swing.JButton();
        atualizarTabelaBT = new javax.swing.JButton();
        imagemFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(1000, 700, 700, 700));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Presquições Infos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 160, 30));

        topoLogo.setBackground(new java.awt.Color(51, 102, 0));
        topoLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topoLogoActionPerformed(evt);
            }
        });
        jPanel1.add(topoLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, 0, 1000, 40));

        informacaoPacienteNutri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Finalizada", "Nome do Paciente", "leito", "ID Dieta", "Ala", "Turno", "Responsavel", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        informacaoPacienteNutri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                informacaoPacienteNutriMouseClicked(evt);
            }
        });
        tabelaProduto.setViewportView(informacaoPacienteNutri);

        jPanel1.add(tabelaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 970, 440));

        Fechar1.setBackground(new java.awt.Color(0, 102, 0));
        Fechar1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Fechar1.setForeground(new java.awt.Color(255, 255, 255));
        Fechar1.setText("FECHAR");
        Fechar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Fechar1ActionPerformed(evt);
            }
        });
        jPanel1.add(Fechar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 140, 50));

        pdff.setText(" Baixar PDF");
        pdff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdffActionPerformed(evt);
            }
        });
        jPanel1.add(pdff, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 170, 40));

        atualizarTabelaBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarTabelaBTActionPerformed(evt);
            }
        });
        jPanel1.add(atualizarTabelaBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 510, 40, 30));
        jPanel1.add(imagemFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1000, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void topoLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topoLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topoLogoActionPerformed

    private void informacaoPacienteNutriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_informacaoPacienteNutriMouseClicked
/*
    // CAPTURAR QUAL LINHA O USUÁRIO CLICOU
    int linhaSelecionada = informacaoPaciente.getSelectedRow();

    // verificando se alguma linha foi selecionada
    if (linhaSelecionada >= 0) {
        // definir modelo default para a tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) informacaoPaciente.getModel();
        
        // Jogando os dados da tabela para os campos de texto, verificando se não são null
        Object idChaveObj = modeloTabela.getValueAt(linhaSelecionada, 0);
        Object nomeChaveObj = modeloTabela.getValueAt(linhaSelecionada, 1);
        Object disponibilidadeObj = modeloTabela.getValueAt(linhaSelecionada, 2);

        if (idChaveObj != null) {
            idChave = Integer.parseInt(idChaveObj.toString());
        } else {
            idChave = -1; // ou algum valor padrão que indica ausência de valor
        }
        
        if (nomeChaveObj != null) {
            nomeChave1.setText(nomeChaveObj.toString());
        } else {
            nomeChave1.setText(""); // ou algum valor padrão
        }
        
        if (disponibilidadeObj != null) {
            disponibilidade.setText(disponibilidadeObj.toString());
        } else {
            disponibilidade.setText(""); // ou algum valor padrão
        }
    }
*/
    }//GEN-LAST:event_informacaoPacienteNutriMouseClicked

    private void Fechar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Fechar1ActionPerformed
        // TODO add your handling code here:
      // cadastrarUsuario.setVisible(false);
      //panelModificar.setVisible(false);
     // panelMenuCooped.setVisible(true);
     TelaNutricionista nutri = new  TelaNutricionista();
     nutri.setVisible(true);
     dispose();

    }//GEN-LAST:event_Fechar1ActionPerformed

    private void pdffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdffActionPerformed
        String pdfPath = "RelatorioDietas.pdf";
        try {
            Document documento = new Document() ;
            PdfWriter.getInstance(documento, new java.io.FileOutputStream(pdfPath));

            // Abrir PDF
            documento.open();

            // Criando TABELA do PDF
            // Capturando a quantidade de colunas da minha tabela
            int colunas = informacaoPacienteNutri.getColumnCount();

            // Definindo a nossa tabela dentro do PDF
            PdfPTable tabela = new PdfPTable(colunas);
            // Definindo a escala da tabela 100%, 80% ou 50%
            tabela.setWidthPercentage(100);

            // Adicionando o nome das colunas na tabela do PDF
            for (int i = 0; i < colunas; i++) {
                tabela.addCell(new Phrase(informacaoPacienteNutri.getColumnName(i)));
            }

            // Adicionando os dados na tabela PDF
            DefaultTableModel modelTabela = (DefaultTableModel) informacaoPacienteNutri.getModel();

            // Usando laço de repetição para inserir os dados
            for (int ln = 0; ln < modelTabela.getRowCount(); ln++) {
                for (int c = 0; c < modelTabela.getColumnCount(); c++) {
                    // Adicionando os dados dentro da tabela
                    Object valorcelula = modelTabela.getValueAt(ln, c);
                    // Adicionando os dados dentro da tabela
                    tabela.addCell(valorcelula != null ? valorcelula.toString() : "");
                }
            }

            // Adicionando a tabela dentro do documento PDF
            documento.add(tabela);
            documento.close();
            // Mensagem de sucesso
            JOptionPane.showMessageDialog(this, "PDF gerado com sucesso!");

            // Abrir o PDF automaticamente
            File pdfFile = new File(pdfPath);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum app encontrado para abrir o PDF.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível gerar o PDF!");
        }

    }//GEN-LAST:event_pdffActionPerformed

    private void atualizarTabelaBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarTabelaBTActionPerformed
        // TODO add your handling code here:
        atualizarTabelaBT.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Chama o método que atualiza a tabela
         listarInformacaoPacientesFim();
    }
});
    }//GEN-LAST:event_atualizarTabelaBTActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInfoNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInfoNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInfoNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInfoNutri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInfoNutri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Fechar1;
    private javax.swing.JButton atualizarTabelaBT;
    private javax.swing.JLabel imagemFundo;
    private javax.swing.JTable informacaoPacienteNutri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton pdff;
    private javax.swing.JScrollPane tabelaProduto;
    private javax.swing.JTextField topoLogo;
    // End of variables declaration//GEN-END:variables
}
