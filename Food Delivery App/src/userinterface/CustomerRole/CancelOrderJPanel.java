/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CustomerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Order;
import Business.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninoshka
 */
public class CancelOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private EcoSystem business;
    
    public CancelOrderJPanel(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business=business;
       populateTable();
    }

    public void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) workRequestJTable.getModel();
        dtm.setRowCount(0);
        for(Order o:business.getOrderDirectory().getOrderList())
        {
         if(o.getCustomerUserName().equals(userAccount.getUsername()) && o.getStatus().equals("order placed"))
         {
            Object row[] = new Object[5];
            row[0] = o;
            row[1] = o.getCustomerName();
             row[2] = o.getCustomerNotes();
            row[3] = o.getStatus();
            row[4] = o.getRestaurantName();
            dtm.addRow(row);
        }
    
        }
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
        workRequestJTable = new javax.swing.JTable();
        btnCancelOrder = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Customer Name", "Message from customer", "Status", "Restaurant Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 950, 96));

        btnCancelOrder.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelOrder.setText("Cancel Order");
        btnCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelOrderActionPerformed(evt);
            }
        });
        add(btnCancelOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, -1, 50));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<-- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelOrderActionPerformed
        // TODO add your handling code here:
         int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row");
            return;
        }
        else{
        Order o = (Order)workRequestJTable.getValueAt(selectedRow,0 );        
        business.getOrderDirectory().deleteOrder(o);
        JOptionPane.showMessageDialog(null, "Order deleted successfully");
        populateTable();
        }
    }//GEN-LAST:event_btnCancelOrderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
