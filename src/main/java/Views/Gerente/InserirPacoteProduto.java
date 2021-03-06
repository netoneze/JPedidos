/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Gerente;

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
public class InserirPacoteProduto extends javax.swing.JFrame {
    ProdutoController productController = new ProdutoController();
    PedidoController orderController = new PedidoController();
    
    ArrayList selectedProducts = new ArrayList<>();
    private static String usuarioId = "";
    DefaultTableModel model;
    private int linha = 0;
    float colValor = 0;
    
    /**
     * Creates new form RegistrarProduct
     */
    public InserirPacoteProduto(String usuarioId) {
        this.usuarioId = usuarioId;
        initComponents();
        ItensUI(true);
        insereProdutoCombox();
        setLocationRelativeTo(null);
        this.model = (DefaultTableModel) tbl_pedidos.getModel();
    }

    public void limpaCampos(){
        label_preco.setText("00.00");
        field_nome.setText("");
        field_total.setText("0");
        this.model.setRowCount(0);
        this.model.setRowCount(18);
        this.linha = 0;
        ItensUI(true);
    }
    
    public void calculaPrecoTotal() {
        colValor = 0;
        for (int i = 0; i < linha; i++) {
            colValor += Float.valueOf(String.valueOf(tbl_pedidos.getValueAt(i, 2)));
        }
        field_total.setText(String.valueOf(colValor));
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
        Float preco = productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()).getProdutoPreco();
        int quantidade = (int) jSpinnerQuantidade.getValue();
        if (quantidade <= 0){
            JOptionPane.showMessageDialog(null, "Quantidade inválida", "Campo inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            float valor = quantidade * preco;
            model.setValueAt(tipo, linha, 0);
            model.setValueAt(quantidade, linha, 1);
            model.setValueAt(valor, linha, 2);
            selectedProducts.add(this.productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()));
            this.model = (DefaultTableModel) tbl_pedidos.getModel();
        }
        return true;
    }
   
    
    public void ItensUI(boolean E){
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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxTipoProduto = new javax.swing.JComboBox<>();
        jSpinnerQuantidade = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        label_preco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pedidos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_adicionar = new javax.swing.JButton();
        field_total = new javax.swing.JTextField();
        field_nome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jpanel.setBackground(new java.awt.Color(228, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Tipo de produto:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Quantidade:");

        jComboBoxTipoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoProdutoActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_preco, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jSpinnerQuantidade))
                    .addGroup(JpanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JpanelLayout.setVerticalGroup(
            JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(label_preco))
                .addGap(26, 26, 26)
                .addGroup(JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Registrar Pacote de Produtos");

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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            tbl_pedidos.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total:");

        btn_adicionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_adicionar.setText("Adicionar");
        btn_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adicionarActionPerformed(evt);
            }
        });

        field_total.setText("0");
        field_total.setToolTipText("");
        field_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_totalActionPerformed(evt);
            }
        });

        field_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nomeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome Pacote:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(615, 615, 615)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btn_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_nome)
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_total, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)
                                .addComponent(btn_salvar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(field_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        JPedidosGer novaTelaGerente = new JPedidosGer(usuarioId);
        novaTelaGerente.setLayout(new BorderLayout());
        novaTelaGerente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        String nome = field_nome.getText();
        float preco = Float.valueOf(field_total.getText());
        String descricao = "";
        if (preco < colValor * 0.70) {
            JOptionPane.showMessageDialog(
                null,
                "Valor menor que o permitido.",
                "Total inválido",
                JOptionPane.ERROR_MESSAGE
            );
        } else if (nome.equals("")){
            JOptionPane.showMessageDialog(
                    null, 
                    "Nome inválido, tente novamente", 
                    "Nome inválido", 
                    JOptionPane.ERROR_MESSAGE
            );
        } else if (linha < 1){
            JOptionPane.showMessageDialog(
                    null, 
                    "Quantidade de produtos inválida", 
                    "Operação inválida", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        else {
            for(int i = 0 ; i < linha ; i++){
                descricao += tbl_pedidos.getValueAt(i, 1) + " " + tbl_pedidos.getValueAt(i, 0);
                if(i != linha - 1 ){
                    descricao += ", ";
                }
            }

            productController.criaProduto(nome, preco, descricao);

            JOptionPane.showMessageDialog(
                null,
                "Pacote salvo com sucesso!",
                "Sucesso",
                JOptionPane.PLAIN_MESSAGE
            ); 
            
            limpaCampos();
       }     
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void jComboBoxTipoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoProdutoActionPerformed
        label_preco.setText(String.valueOf(productController.listaProdutos().get(jComboBoxTipoProduto.getSelectedIndex()).getProdutoPreco()));
    }//GEN-LAST:event_jComboBoxTipoProdutoActionPerformed

    private void btn_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adicionarActionPerformed
        if (this.adicionaNaTabela("update")){
            linha++;
            this.calculaPrecoTotal();
            ItensUI(true);
        }
    }//GEN-LAST:event_btn_adicionarActionPerformed

    private void field_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_totalActionPerformed

    private void field_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nomeActionPerformed

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
            java.util.logging.Logger.getLogger(InserirPacoteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirPacoteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirPacoteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirPacoteProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new InserirPacoteProduto(usuarioId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JButton btn_adicionar;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JTextField field_nome;
    private javax.swing.JTextField field_total;
    private javax.swing.JComboBox<String> jComboBoxTipoProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerQuantidade;
    private javax.swing.JLabel label_preco;
    private javax.swing.JTable tbl_pedidos;
    // End of variables declaration//GEN-END:variables
}
