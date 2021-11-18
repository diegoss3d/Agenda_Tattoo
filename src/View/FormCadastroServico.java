package View;

import Controller.FormCadastroServicoController;
import Model.Servico;
import dao.Conexao;
import dao.ServicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class FormCadastroServico extends javax.swing.JFrame {

    private final FormCadastroServicoController controller;

    public FormCadastroServico() {
        initComponents();
        controller = new FormCadastroServicoController(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricao1 = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        TextDescricao = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        TextValor = new javax.swing.JTextField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDescricao1.setBackground(new java.awt.Color(255, 255, 255));
        lblDescricao1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDescricao1.setForeground(new java.awt.Color(255, 255, 255));
        lblDescricao1.setText("Cadastro de serviços");
        getContentPane().add(lblDescricao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        lblDescricao.setBackground(new java.awt.Color(255, 255, 255));
        lblDescricao.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(255, 255, 255));
        lblDescricao.setText("Descrição");
        getContentPane().add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));
        getContentPane().add(TextDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 200, 35));

        lblValor.setBackground(new java.awt.Color(255, 255, 255));
        lblValor.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblValor.setForeground(new java.awt.Color(255, 255, 255));
        lblValor.setText("Valor");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 200, 35));
        getContentPane().add(TextValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 200, 35));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/Cadastro_usuario_background2.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        
        controller.salvaServico();
        
    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(FormCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastroServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastroServico().setVisible(true);
            }
        });
    }

    public JTextField getTextDescricao() {
        return TextDescricao;
    }

    public void setTextDescricao(JTextField TextDescricao) {
        this.TextDescricao = TextDescricao;
    }

    public JTextField getTextValor() {
        return TextValor;
    }

    public void setTextValor(JTextField TextValor) {
        this.TextValor = TextValor;
    }


    


    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JTextField TextDescricao;
    private javax.swing.JTextField TextValor;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblValor;
    // End of variables declaration//GEN-END:variables
}
