package View;

import Controller.FormCadastroClienteController;
import Model.Cliente;
import dao.ClienteDAO;
import dao.Conexao;
import dao.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class FormCadastroCliente extends javax.swing.JFrame {

    private final FormCadastroClienteController controller;

    public FormCadastroCliente() {
        initComponents();
        controller = new FormCadastroClienteController(this);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricao1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        lblSexo = new javax.swing.JLabel();
        btSalvar = new javax.swing.JButton();
        TextSexo = new javax.swing.JTextField();
        lblDataNascimento = new javax.swing.JLabel();
        TextDataNascimento = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        TextTelefone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        TextEmail = new javax.swing.JTextField();
        TextRg = new javax.swing.JTextField();
        lblRg = new javax.swing.JLabel();
        TextEndereco = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        lblCep = new javax.swing.JLabel();
        TextCep = new javax.swing.JTextField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDescricao1.setBackground(new java.awt.Color(255, 255, 255));
        lblDescricao1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblDescricao1.setForeground(new java.awt.Color(255, 255, 255));
        lblDescricao1.setText("Cadastro de clientes");
        getContentPane().add(lblDescricao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        lblNome.setBackground(new java.awt.Color(255, 255, 255));
        lblNome.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));
        getContentPane().add(TextNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 200, 35));

        lblSexo.setBackground(new java.awt.Color(255, 255, 255));
        lblSexo.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblSexo.setForeground(new java.awt.Color(255, 255, 255));
        lblSexo.setText("Sexo");
        getContentPane().add(lblSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 730, 200, 35));
        getContentPane().add(TextSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 200, 35));

        lblDataNascimento.setBackground(new java.awt.Color(255, 255, 255));
        lblDataNascimento.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblDataNascimento.setForeground(new java.awt.Color(255, 255, 255));
        lblDataNascimento.setText("Data Nascimento");
        getContentPane().add(lblDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, -1, -1));
        getContentPane().add(TextDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 200, 35));

        lblTelefone.setBackground(new java.awt.Color(255, 255, 255));
        lblTelefone.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefone.setText("Telefone");
        getContentPane().add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, -1));
        getContentPane().add(TextTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 200, 35));

        lblEmail.setBackground(new java.awt.Color(255, 255, 255));
        lblEmail.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));
        getContentPane().add(TextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 200, 35));
        getContentPane().add(TextRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 200, 35));

        lblRg.setBackground(new java.awt.Color(255, 255, 255));
        lblRg.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblRg.setForeground(new java.awt.Color(255, 255, 255));
        lblRg.setText("Rg");
        getContentPane().add(lblRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, -1, -1));
        getContentPane().add(TextEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 200, 35));

        lblEndereco.setBackground(new java.awt.Color(255, 255, 255));
        lblEndereco.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblEndereco.setForeground(new java.awt.Color(255, 255, 255));
        lblEndereco.setText("Endereco");
        getContentPane().add(lblEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 580, -1, -1));

        lblCep.setBackground(new java.awt.Color(255, 255, 255));
        lblCep.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        lblCep.setForeground(new java.awt.Color(255, 255, 255));
        lblCep.setText("Cep");
        getContentPane().add(lblCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 660, -1, -1));
        getContentPane().add(TextCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 660, 200, 35));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/Cadastro_cliente_background.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        controller.salvaCliente();
        
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
            java.util.logging.Logger.getLogger(FormCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCadastroCliente().setVisible(true);
            }
        });
    }

    public JTextField getTextCep() {
        return TextCep;
    }

    public void setTextCep(JTextField TextCep) {
        this.TextCep = TextCep;
    }

    public JTextField getTextDataNascimento() {
        return TextDataNascimento;
    }

    public void setTextDataNascimento(JTextField TextDataNascimento) {
        this.TextDataNascimento = TextDataNascimento;
    }

    public JTextField getTextEmail() {
        return TextEmail;
    }

    public void setTextEmail(JTextField TextEmail) {
        this.TextEmail = TextEmail;
    }

    public JTextField getTextEndereco() {
        return TextEndereco;
    }

    public void setTextEndereco(JTextField TextEndereco) {
        this.TextEndereco = TextEndereco;
    }

    public JTextField getTextNome() {
        return TextNome;
    }

    public void setTextNome(JTextField TextNome) {
        this.TextNome = TextNome;
    }

    public JTextField getTextRg() {
        return TextRg;
    }

    public void setTextRg(JTextField TextRg) {
        this.TextRg = TextRg;
    }

    public JTextField getTextSexo() {
        return TextSexo;
    }

    public void setTextSexo(JTextField TextSexo) {
        this.TextSexo = TextSexo;
    }

    public JTextField getTextTelefone() {
        return TextTelefone;
    }

    public void setTextTelefone(JTextField TextTelefone) {
        this.TextTelefone = TextTelefone;
    }


    
    


    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JTextField TextCep;
    private javax.swing.JTextField TextDataNascimento;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextEndereco;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextRg;
    private javax.swing.JTextField TextSexo;
    private javax.swing.JTextField TextTelefone;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel lblCep;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRg;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    // End of variables declaration//GEN-END:variables
}
