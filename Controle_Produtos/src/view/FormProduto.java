/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CategoriaDAO;
import controller.ProdutoDAO;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Produto;

/**
 *
 * @author 828461
 */
public class FormProduto extends javax.swing.JFrame {

    /**
     * Creates new form FormProduto
     */
    public FormProduto() {
        initComponents();
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

        lblId = new javax.swing.JLabel();
        lblValorUnitario = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtPesquisar = new javax.swing.JTextField();
        txtValorUnitario = new javax.swing.JTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblPesquisar = new javax.swing.JLabel();
        rdbNome = new javax.swing.JRadioButton();
        rdbId = new javax.swing.JRadioButton();
        txtNome = new javax.swing.JTextField();
        jScrollBar1 = new javax.swing.JScrollPane();
        tbProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblId.setText("Id");

        lblValorUnitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValorUnitario.setText("Valor Unitário");

        lblCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCategoria.setText("Categoria");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        txtValorUnitario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtValorUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorUnitarioActionPerformed(evt);
            }
        });

        cbxCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovo.setText("novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setText("salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluir.setText("excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPesquisar.setText("Pesquisar");

        rdbNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbNome.setText("nome");

        rdbId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdbId.setText("id");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        tbProdutos.setModel(new javax.swing.table.DefaultTableModel(
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
        tbProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProdutosMouseClicked(evt);
            }
        });
        jScrollBar1.setViewportView(tbProdutos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbId)
                        .addGap(18, 18, 18)
                        .addComponent(rdbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblValorUnitario)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtNome))))
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblNome))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCategoria)
                    .addComponent(lblValorUnitario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPesquisar)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbId)
                    .addComponent(rdbNome)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void txtValorUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorUnitarioActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        estado(true);
//        txtId.setText("");
//        txtNome.setText("");
//        txtValorUnitario.setText("");
//        cbxCategoria.setSelectedIndex(0);
//        txtNome.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        estado(false);
        //criar um objeto para parametrizar a operação
        Produto p  = new Produto();
        
        //Recuperar o ID da categoria no combo categoria
        Categoria c  = (Categoria)cbxCategoria.getSelectedItem();
        p.setId_categoria(c);
        
        //recuperar o nome do produto
        p.setNome(txtNome.getText());
        
        //recuperar o valor unitário do produto
        double vunit = Double.parseDouble(txtValorUnitario.getText().replace(',','.'));
        p.setValorunitario(vunit);
        
        if(txtId.getText().isEmpty()){
            p.setId(null);
        }else{
            p.setId(Long.parseLong(txtId.getText()));
        }
        
        int id = new ProdutoDAO().salvar(p);
        if(id != -1){
            txtId.setText(Integer.toString(id));
            preencherTabela(new ProdutoDAO().listar());
//            txtId.setText("");
//            txtNome.setText("");
//            txtValorUnitario.setText("");
//            cbxCategoria.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null,"Operação realizada com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Não foi possível realizar a operação");
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Selecione um registro para edição.");
            estado(false);
        }else{
            estado(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
//        if(txtId.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null,"Selecione um registro para excluir.");
//            estado(false);
//        }else{
//            
//            int resp = JOptionPane.showConfirmDialog(null,"Tem certeza de que deseja apagar o registro?","Controle Produtos",JOptionPane.YES_NO_OPTION);
//            Produto p  = new Produto();
//            
//            //recuperando informações do objeto
//            p.setNome(txtNome.getText());
//            p.setId(Integer.parseInt(Integer.parseInt(txtId.getText())));
//            p.setValorunitario(Double.parseDouble(txtValorUnitario.getText()));           
//            p.setId_categoria(((Categoria)cbxCategoria.getSelectedItem())); 
//            
//            if (resp == JOptionPane.YES_OPTION){
//                //remover o registro tabela
//                int remover = new ProdutoDAO().remover((int)p.getId());
//            }else{
//                estado(false);
//            }
//            
//            JOptionPane.showMessageDialog(null,"Excluído id: "+Integer.parseInt(tbProdutos.getValueAt(tbProdutos.getSelectedRow(),0).toString()));
//            
//            preencherFormulario(1);
//            preencherTabela(new ProdutoDAO().listar());
//            
//        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       estado(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tbProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProdutosMouseClicked
        
        preencherFormulario(0);
        
    }//GEN-LAST:event_tbProdutosMouseClicked

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        
        String chave = txtPesquisar.getText();
        List<Produto> resultado = null;
        
        if(chave.isEmpty()){
            resultado = new ProdutoDAO().listar();
        }else{
            if(rdbNome.isSelected()){
                resultado = new ProdutoDAO().pesquisarPorNome(chave);
            }else if(rdbId.isSelected()){
                resultado = new ProdutoDAO().pesquisarPorID(Integer.parseInt(chave));
            }
        }
        
        if(resultado != null){
            preencherTabela(resultado);
        }
        
    }//GEN-LAST:event_txtPesquisarKeyReleased

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
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JScrollPane jScrollBar1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblValorUnitario;
    private javax.swing.JRadioButton rdbId;
    private javax.swing.JRadioButton rdbNome;
    private javax.swing.JTable tbProdutos;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
    
      private void configurarFormulario(){
        this.setTitle("Controle de Produtos");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        txtId.setEnabled(false);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbId);
        bg.add(rdbNome);
        rdbId.setSelected(true);
        configurarTabela();
        estado(false);
        preencherComboCategoria();
        preencherTabela(new ProdutoDAO().listar());
    }
    
    private void configurarTabela(){
        DefaultTableModel m = new DefaultTableModel(
            new Object[]{"Id","Nome","Categoria","Vl.Unit"}, 0){
          
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tbProdutos.setModel(m);
    }
    
    private void estado(boolean e) {
        txtNome.setEnabled(e);
        cbxCategoria.setEnabled(e);
        txtValorUnitario.setEnabled(e);
        btnSalvar.setEnabled(e);
        txtPesquisar.setEnabled(!e);
        btnNovo.setEnabled(!e);
        btnEditar.setEnabled(!e);
        btnExcluir.setEnabled(!e);
        btnCancelar.setEnabled(e);
    }
    
    private void preencherFormulario(int count){
        
        estado(true);
        btnExcluir.setEnabled(true);
        
        int linha = tbProdutos.getSelectedRow();
        
        //se count > 0 linha += 1
        linha += count > 0 ? 1 : 0;
        
        if(linha >= tbProdutos.getRowCount()){
            linha = 0;
        }
        
        if(linha >= 0){
            
            txtId.setText(tbProdutos.getValueAt(linha,0).toString());
            txtNome.setText(tbProdutos.getValueAt(linha,1).toString());
            txtValorUnitario.setText(tbProdutos.getValueAt(linha,3).toString());
            Categoria c =(Categoria)tbProdutos.getValueAt(linha,2);
            cbxCategoria.getModel().setSelectedItem(c);
        }
    }
    
    private void preencherComboCategoria(){
        
        List<Categoria> lista = new CategoriaDAO().listar();
        if(lista != null){
            DefaultComboBoxModel m = new DefaultComboBoxModel();
            for(Categoria c : lista){
                m.addElement(c);
            }
            cbxCategoria.setModel(m);
        }
    }
    
    private void preencherTabela(List<Produto> lista){
        configurarTabela();
        if(lista != null){
            if(lista.size()>0){
                configurarTabela();
                DefaultTableModel m = (DefaultTableModel)tbProdutos.getModel();
                for(Produto p : lista){
                    m.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        //p.getId_categoria(),
                        new CategoriaDAO().pesquisarPorId((int) p.getId_categoria().getId()),
                        p.getValorunitario()
                    });
                }
                tbProdutos.setModel(m);
            }
        }
    }
}
