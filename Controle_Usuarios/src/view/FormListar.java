/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteDAO;
import controller.UsuarioDAO;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Usuario;

/**
 *
 * @author 828461
 */
public class FormListar extends javax.swing.JFrame {
    public static List<Cliente> clientes = new ArrayList();
    public static List<Usuario> usuarios = new ArrayList();
    public static int indicador;
    /**
     * Creates new form FormCadastrar
     */
    public FormListar(int indicador) {
        initComponents();
        this.indicador = indicador;
        configurarFormulario();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVisualizar = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        rdbId = new javax.swing.JRadioButton();
        rdbNome = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVisualizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVisualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVisualizarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVisualizar);

        txtPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        rdbId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbId.setText("Id");
        rdbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbIdActionPerformed(evt);
            }
        });

        rdbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbNome.setText("Nome");
        rdbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rdbId)
                .addGap(18, 18, 18)
                .addComponent(rdbNome)
                .addGap(18, 18, 18)
                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbId)
                    .addComponent(rdbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVisualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVisualizarMouseClicked
        
        int lines = tblVisualizar.getSelectedRow();
        
        if(this.indicador == 1){
            FormCadastroCliente alterar_cliente = new FormCadastroCliente(
            tblVisualizar.getValueAt(lines,0).toString(),
            tblVisualizar.getValueAt(lines,1).toString(),
            tblVisualizar.getValueAt(lines,2).toString(),
            tblVisualizar.getValueAt(lines,3).toString(),
            Boolean.parseBoolean(tblVisualizar.getValueAt(lines,4).toString()));
            alterar_cliente.setVisible(true);
            this.dispose();
        }else if (this.indicador == 0){
            FormCadastroUsuario alterar_usuario = new FormCadastroUsuario(
            tblVisualizar.getValueAt(lines,0).toString(),
            tblVisualizar.getValueAt(lines,1).toString(),
            tblVisualizar.getValueAt(lines,2).toString(),
            tblVisualizar.getValueAt(lines,3).toString(),
            Boolean.parseBoolean(tblVisualizar.getValueAt(lines,4).toString()));
            alterar_usuario.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_tblVisualizarMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        String chave = txtPesquisar.getText();
        
        if(chave.isEmpty()){
            configurarFormulario();
        }else{
            if(rdbNome.isSelected()){
                if(this.indicador == 1){
                    clientes = new ClienteDAO().pesquisarPorNome(chave);
                    if(clientes != null){
                        configurarListarClientes();
                    }else{
                        System.out.println("recebeu nomes de Clientes");
                    }
                }else if(this.indicador == 0){
                    usuarios = new UsuarioDAO().pesquisarPorNome(chave);
                    if(usuarios != null){
                        configurarListarUsuarios();
                    }else{
                        System.out.println("recebeu nomes de Usuarios");
                    }
                }                
            }else if(rdbId.isSelected()){
                if(this.indicador == 1){
                    clientes = new ClienteDAO().pesquisarPorID(Integer.parseInt(chave));
                    if(clientes != null){
                        configurarListarClientes();
                    }else{
                        System.out.println("recebeu IDs de Clientes");
                    }
                }else if(this.indicador == 0){
                    usuarios = new UsuarioDAO().pesquisarPorID(Integer.parseInt(chave));
                    if(usuarios != null){
                        configurarListarUsuarios();
                    }else{
                        System.out.println("recebeu IDs de Usuarios");
                    }
                }
            }else{
                configurarFormulario();
            }
        }
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void rdbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbIdActionPerformed
        if(rdbId.isSelected()){
            rdbNome.setSelected(false);
        }
    }//GEN-LAST:event_rdbIdActionPerformed

    private void rdbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNomeActionPerformed
        if(rdbNome.isSelected()){
            rdbId.setSelected(false);
        }
    }//GEN-LAST:event_rdbNomeActionPerformed

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
            java.util.logging.Logger.getLogger(FormListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormListar(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbId;
    private javax.swing.JRadioButton rdbNome;
    private javax.swing.JTable tblVisualizar;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
    
    public void configurarListarClientes(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //posicionamento do formulario
        this.setLocationRelativeTo(null);
        //redimensionamento
        this.setResizable(false);
        this.setTitle("Clientes cadastrados");
        
        DefaultTableModel tableclientes = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                } 
        };
        tableclientes.addColumn("Id");
        tableclientes.addColumn("Nome");
        tableclientes.addColumn("Telefone");
        tableclientes.addColumn("Email");
        tableclientes.addColumn("Status");
        
        
        for (Cliente cliente : clientes) {
            tableclientes.addRow(new Object[]{cliente.getId(),cliente.getNome(),cliente.getTelefone(),cliente.getEmail(),cliente.isEstado()});
        }
        tblVisualizar.setModel(tableclientes);
    }
    
    public void configurarListarUsuarios(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //posicionamento do formulario
        this.setLocationRelativeTo(null);
        //redimensionamento
        this.setResizable(false);
        this.setTitle("Usuários cadastrados");
        
        DefaultTableModel tableusuarios = new DefaultTableModel(){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                } 
        };
        tableusuarios.addColumn("Id");
        tableusuarios.addColumn("Login");
        tableusuarios.addColumn("Senha");
        tableusuarios.addColumn("Resposta");
        tableusuarios.addColumn("Status");
        
        for (Usuario usuario : usuarios) {
            tableusuarios.addRow(new Object[]{usuario.getId(),usuario.getLogin(),usuario.getSenha(),usuario.getResposta(),usuario.isEstado()});
        }
        tblVisualizar.setModel(tableusuarios);
    }
    
    private void configurarFormulario(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //posicionamento do formulario
        this.setLocationRelativeTo(null);
        //redimensionamento
        this.setResizable(false);        
        //leitura das informações do banco
        try {
            if(this.indicador == 1){
                clientes = new ClienteDAO().listar();
                configurarListarClientes();
            }else if(this.indicador == 0){
                usuarios = new UsuarioDAO().listar();
                configurarListarUsuarios();
            }
            
        } catch (Exception e) {
            System.out.println("ERRO: "+e.getMessage());
        }
    }
    
}
