/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VIEW1;

import CONTROLLER.LoginController;
import MODEL.Usuario;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author edi
 */
public class loginTela extends javax.swing.JFrame {

    /**
     * Creates new form loginTela
     */
    public loginTela() {
        
        setTitle("LOGIN");
        setSize(400, 400); // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Impede redimensionamento da janela
       
        // Centraliza a janela no centro da tela
        setLocationRelativeTo(null);
        // Torna a janela visível
        setVisible(true);
        initComponents();
        olhoBot.setIcon(new ImageIcon("C:/Users/devmat/Downloads/eye-slash.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLog = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logarLog = new javax.swing.JButton();
        emailnome = new javax.swing.JLabel();
        nomeSenha = new javax.swing.JLabel();
        campoEmailLog = new javax.swing.JTextField();
        campoSenhaLog = new javax.swing.JPasswordField();
        olhoBot = new javax.swing.JButton();
        estiloAzul = new javax.swing.JTextField();
        estiloAzul1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        panelLog.setBackground(new java.awt.Color(232, 228, 228));
        panelLog.setForeground(new java.awt.Color(255, 255, 255));

        logarLog.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logarLog.setText("OK");
        logarLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarLogActionPerformed(evt);
            }
        });

        emailnome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        emailnome.setText("Email: ");

        nomeSenha.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nomeSenha.setText("Senha :");

        campoEmailLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailLogActionPerformed(evt);
            }
        });

        olhoBot.setForeground(new java.awt.Color(102, 255, 102));
        olhoBot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                olhoBotActionPerformed(evt);
            }
        });

        estiloAzul.setBackground(new java.awt.Color(51, 102, 0));

        estiloAzul1.setBackground(new java.awt.Color(51, 102, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Bem Vindo ao Login");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel3.setText("NutriHospitalar");

        javax.swing.GroupLayout panelLogLayout = new javax.swing.GroupLayout(panelLog);
        panelLog.setLayout(panelLogLayout);
        panelLogLayout.setHorizontalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(estiloAzul)
            .addComponent(estiloAzul1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelLogLayout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLogLayout.createSequentialGroup()
                        .addComponent(emailnome)
                        .addGap(22, 22, 22)
                        .addComponent(campoEmailLog, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(panelLogLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(64, 64, 64))
                    .addGroup(panelLogLayout.createSequentialGroup()
                        .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLogLayout.createSequentialGroup()
                                .addComponent(logarLog, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(panelLogLayout.createSequentialGroup()
                                .addComponent(nomeSenha)
                                .addGap(16, 16, 16)
                                .addComponent(campoSenhaLog, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(olhoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(panelLogLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLogLayout.setVerticalGroup(
            panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogLayout.createSequentialGroup()
                .addComponent(estiloAzul1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelLogLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoEmailLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailnome))
                        .addGap(45, 45, 45)
                        .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoSenhaLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomeSenha))
                            .addComponent(olhoBot, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logarLog)
                .addGap(40, 40, 40)
                .addComponent(estiloAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logarLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarLogActionPerformed
        // TODO add your handling code here:
      
    String email = campoEmailLog.getText();
    String senha = new String(campoSenhaLog.getPassword()); // Supondo que você esteja usando um JPasswordField

    LoginController loginController = new LoginController();
/*    Usuario usuario = loginController.validarUsuario(email, senha);

    if (usuario != null) {
        if ("Estoquista".equals(usuario.getTipoUsuario())) {
            // Redirecionar para TelaDeposito
            new TelaDeposito().setVisible(true);
        } else if ("Nutricionista".equals(usuario.getTipoUsuario())) {
            // Redirecionar para TelaNutri
            new TelaNutri().setVisible(true);
        }
        this.dispose(); // Fecha a tela de login
    } else {
        JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
    }*/


        
    }//GEN-LAST:event_logarLogActionPerformed
boolean oculto = true;
    private void olhoBotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_olhoBotActionPerformed
        // TODO add your handling code here:
        //se senha wstiver oculta
        if (oculto==true){
            campoSenhaLog.setEchoChar((char)0);//desocultar senha
            oculto=false;
            olhoBot.setIcon(new ImageIcon("C:/Users/devmat/Downloads/eye-slash.png"));
        }else{ //se senha não estiver oculta
            // \u25A0 - quadrado \u2022 - bolinha

            campoSenhaLog.setEchoChar('\u2022');//ocultar senha
            oculto=true;// senha oculta novamente
            olhoBot.setIcon(new ImageIcon("C:/Users/devmat/Downloads/eye-scan-lock.png"));
        }// fim do else
    }//GEN-LAST:event_olhoBotActionPerformed

    private void campoEmailLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailLogActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_campoEmailLogActionPerformed

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
            java.util.logging.Logger.getLogger(loginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoEmailLog;
    private javax.swing.JPasswordField campoSenhaLog;
    private javax.swing.JLabel emailnome;
    private javax.swing.JTextField estiloAzul;
    private javax.swing.JTextField estiloAzul1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logarLog;
    private javax.swing.JLabel nomeSenha;
    private javax.swing.JButton olhoBot;
    private javax.swing.JPanel panelLog;
    // End of variables declaration//GEN-END:variables
}
