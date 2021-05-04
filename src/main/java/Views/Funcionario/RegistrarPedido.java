/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Funcionario;

import Controllers.PedidoController;
import Controllers.ProdutoController;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nelson Toneze
 */
public class RegistrarPedido extends javax.swing.JFrame {
    ProdutoController productController = new ProdutoController();
    PedidoController orderController = new PedidoController();
    
    ArrayList selectedProducts = new ArrayList<>();
    private static String usuarioId = "";
    DefaultTableModel model;
    private int linha = 0;
    
    /**
     * Creates new form RegistrarProduct
     */
    public RegistrarPedido(String usuarioId) {
        this.usuarioId = usuarioId;
        initComponents();
        ItensUI(true, true, true, false, false);
        insereProdutoCombox();
        setLocationRelativeTo(null);
        this.model = (DefaultTableModel) tbl_pedidos.getModel();
    }

    public void limpaCampos(){
        field_nomecliente.setText("");
        field_telefonecliente.setText("");
        label_nome.setText("...");
        label_telefone.setText("...");
        label_preco.setText("00.00");
        label_total.setText("00.00");
        this.model.setRowCount(0);
        this.model.setRowCount(18);
        this.linha = 0;
        ItensUI(true, true, true, false, false);
    }
    
    public void calculaPrecoTotal() {
        float colValor = 0;
        for (int i = 0; i < linha; i++) {
            colValor += Float.valueOf(String.valueOf(tbl_pedidos.getValueAt(i, 3)));
        }
        label_total.setText(String.valueOf(colValor));
    }
    
    public void insereProdutoCombox() {
        if (productController.listaProdutos().size() > 0) {
            for (int i = 0; i < productController.listaProdutos().size(); i++) {
                jComboBoxTipoProduto.addItem(productController.listaProdutos().get(i).getProdutoNome());
            }
        }
    }
    
    public boolean adicionaNaTabela(String mode) {
        String tipo = productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()).getProdutoNome();
        String descricao = productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()).getProdutoDescricao();
        Float preco = productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()).getProdutoPreco();
        int quantidade = (int) jSpinnerQuantidade.getValue();
        if (quantidade <= 0){
            JOptionPane.showMessageDialog(
                    null, 
                    "Quantidade inválida, tente novamente", 
                    "Quantidade inválida", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        } else {
            float valor = quantidade * preco;
            model.setValueAt(tipo, linha, 0);
            model.setValueAt(quantidade, linha, 1);
            model.setValueAt(descricao, linha, 2);
            model.setValueAt(valor, linha, 3);            
            selectedProducts.add(this.productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()));
            this.model = (DefaultTableModel) tbl_pedidos.getModel();
        }
        return true;
    }
    
    public boolean adicionaNomeTelefoneNaLabel(){
        String nome = field_nomecliente.getText();
        String telefone = field_telefonecliente.getText();
        if (nome.equals("") || telefone.equals("")){
            JOptionPane.showMessageDialog(
                    null, 
                    "Nome ou Telefone inválidos, tente novamente", 
                    "Campos inválidos", 
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        } else {
            label_nome.setText(nome);
            label_telefone.setText(telefone);
        }
        return true;
    }
    
    public void ItensUI(boolean A, boolean B, boolean C, boolean D, boolean E){
        btn_addnometelefone.setEnabled(A); 
        field_nomecliente.setEditable(B);
        field_telefonecliente.setEditable(C);
        btn_adicionar.setEnabled(D);
        btn_salvar.setEnabled(E);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        Jpanel = new javax.swing.JPanel();
        field_telefonecliente = new javax.swing.JTextField();
        field_nomecliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipoProduto = new javax.swing.JComboBox<>();
        jSpinnerQuantidade = new javax.swing.JSpinner();
        btn_addnometelefone = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        label_preco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pedidos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        label_nome = new javax.swing.JLabel();
        label_telefone = new javax.swing.JLabel();
        btn_adicionar = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jpanel.setBackground(new java.awt.Color(228, 255, 255));

        field_nomecliente.setToolTipText("Nome Completo");

        jLabel1.setText("Nome do cliente ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tipo de produto:");

        jLabel4.setText("Telefone do cliente");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Quantidade:");

        jComboBoxTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoProdutoActionPerformed(evt);
            }
        });

        btn_addnometelefone.setText("Adicionar Nome/Telefone");
        btn_addnometelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addnometelefoneActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Preço Unitário:");

        label_preco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_preco.setText("00.00");
        label_preco.setToolTipText("");

        javax.swing.GroupLayout JpanelLayout = new javax.swing.GroupLayout(Jpanel);
        Jpanel.setLayout(JpanelLayout);
        JpanelLayout.setHorizontalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btn_addnometelefone)
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_nomecliente)
                            .addComponent(field_telefonecliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTipoProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(JpanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerQuantidade))))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_preco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(field_nomecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(field_telefonecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_addnometelefone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(label_preco))
                .addGap(18, 18, 18)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBoxTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar Pedido");

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        btn_salvar.setBackground(new java.awt.Color(51, 153, 255));
        btn_salvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        tbl_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tipo", "Quantidade", "Descrição", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_pedidos);
        if (tbl_pedidos.getColumnModel().getColumnCount() > 0) {
            tbl_pedidos.getColumnModel().getColumn(0).setResizable(false);
            tbl_pedidos.getColumnModel().getColumn(1).setResizable(false);
            tbl_pedidos.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nome:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Telefone:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total:");

        label_nome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_nome.setText("...");
        label_nome.setToolTipText("");

        label_telefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_telefone.setText("...");
        label_telefone.setToolTipText("");

        btn_adicionar.setText("Adicionar");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        label_total.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_total.setText("00.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btn_adicionar)
                .addGap(249, 249, 249)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_total, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(262, 262, 262)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_telefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(label_nome)
                            .addComponent(label_telefone))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(label_total)
                        .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_adicionar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        JPedidosFunc novaTelaFuncionario = new JPedidosFunc(usuarioId);
        novaTelaFuncionario.setLayout(new BorderLayout());
        novaTelaFuncionario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        String nomeCliente = label_nome.getText();
        String telefoneCliente = label_telefone.getText();
        float total = Float.valueOf(label_total.getText());

        if (nomeCliente.length() > 100  || telefoneCliente.length() > 20) {
            JOptionPane.showMessageDialog(
                null,
                "Nome ou telefone muito grandes.",
                "Cliente inválido",
                JOptionPane.ERROR_MESSAGE
            );
            ItensUI(true, true, true, false, false);
        } else {            
            orderController.criaPedido(nomeCliente, telefoneCliente, total, Integer.parseInt(this.usuarioId), selectedProducts);
            JOptionPane.showMessageDialog(
                null,
                "Pedido salvo com sucesso!",
                "Sucesso",
                JOptionPane.PLAIN_MESSAGE
            );
            
            selectedProducts.clear();
            limpaCampos();
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_addnometelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addnometelefoneActionPerformed
        if (adicionaNomeTelefoneNaLabel()){
            ItensUI(false, false, false, true, false);
        }
    }//GEN-LAST:event_btn_addnometelefoneActionPerformed

    private void jComboBoxTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoProdutoActionPerformed
        label_preco.setText(String.valueOf(productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()).getProdutoPreco()));
    }//GEN-LAST:event_jComboBoxTipoProdutoActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        if(this.adicionaNaTabela("update")){
            linha++;
            calculaPrecoTotal();
            ItensUI(false, false, false, true, true);
        }
    }//GEN-LAST:event_btn_adicionarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPedido(usuarioId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton btn_addnometelefone;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JTextField field_nomecliente;
    private javax.swing.JTextField field_telefonecliente;
    private javax.swing.JComboBox<String> jComboBoxTipoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerQuantidade;
    private javax.swing.JLabel label_nome;
    private javax.swing.JLabel label_preco;
    private javax.swing.JLabel label_telefone;
    private javax.swing.JLabel label_total;
    private javax.swing.JTable tbl_pedidos;
    // End of variables declaration//GEN-END:variables
}
