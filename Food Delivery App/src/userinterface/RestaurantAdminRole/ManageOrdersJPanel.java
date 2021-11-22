/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RestaurantAdminRole;

import userinterface.DeliveryManRole.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Items;
import Business.Order;
import Business.Organization;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninoshka
 */
public class ManageOrdersJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
   private  UserAccount account;
    private Organization organization;
     private Enterprise enterprise;
    
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public ManageOrdersJPanel(JPanel userProcessContainer,EcoSystem business,Enterprise enterprise, Organization organization, UserAccount account) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
       this.account=account;
        this.organization=organization;
        this.enterprise=enterprise;
        this.business=business;
        
        populateTable();
    }
    
    public void populateTable(){
          DefaultTableModel dtm = (DefaultTableModel) orderRequestJTable.getModel();
        dtm.setRowCount(0);
        for(Order order:business.getOrderDirectory().getOrderList()) {
   if(order.getRestaurantName()!=null && order.getRestaurantName().equals(enterprise.getName())){
            Object row[] = new Object[6];
            row[0] = order;
            row[1] = order.getCustomerId();
            row[2] = order.getCustomerName();
            row[3] = order.getCustomerNotes();
            row[4] = order.getStatus();
            row[5] = order.getFeedback();
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
        orderRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        BtnDeliverOrder = new javax.swing.JButton();
        AcceptOrderBtn = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        viewItemsBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ItemsListTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 153, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order Id", "Customer Id", "Customer Name", "Message from customer", "Status", "Feedback"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderRequestJTable);
        if (orderRequestJTable.getColumnModel().getColumnCount() > 0) {
            orderRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            orderRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            orderRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            orderRequestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 940, 96));

        refreshJButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        BtnDeliverOrder.setBackground(new java.awt.Color(255, 255, 255));
        BtnDeliverOrder.setText("Assign Delivery Man");
        BtnDeliverOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeliverOrderActionPerformed(evt);
            }
        });
        add(BtnDeliverOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        AcceptOrderBtn.setBackground(new java.awt.Color(255, 255, 255));
        AcceptOrderBtn.setText("Accept Order");
        AcceptOrderBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptOrderBtnActionPerformed(evt);
            }
        });
        add(AcceptOrderBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setText("<- Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        viewItemsBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewItemsBtn.setText("View Items");
        viewItemsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewItemsBtnActionPerformed(evt);
            }
        });
        add(viewItemsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, -1));

        ItemsListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ItemsListTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 290, 170));
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void BtnDeliverOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeliverOrderActionPerformed
        // TODO add your handling code here:
         int selectedRow = orderRequestJTable.getSelectedRow();
        
        if (selectedRow < 0){
            return;
        }
        
        Order order1 = (Order)orderRequestJTable.getValueAt(selectedRow, 0);
         if(order1.getStatus().equals("delivered")||order1.getStatus().equals("order placed")){
            JOptionPane.showMessageDialog(null, "This order has already been delivered");
         return ; }
         if(!order1.getStatus().equals("accepted")){
            JOptionPane.showMessageDialog(null, "Please accept the order first");
         return ; }
         AssignDeliveryManJPanel panel = new AssignDeliveryManJPanel(userProcessContainer,order1,business);
        userProcessContainer.add("AssignDeliveryManJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_BtnDeliverOrderActionPerformed

    private void AcceptOrderBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptOrderBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = orderRequestJTable.getSelectedRow();        
        if (selectedRow < 0){
            return;
        }        
        Order order1 = (Order)orderRequestJTable.getValueAt(selectedRow, 0);
        if(!(order1.getStatus().equalsIgnoreCase("cancelled"))){
            JOptionPane.showMessageDialog(null, "Cancelled orders cannot be accepted");
         return ; }
         if(!(order1.getStatus().equals("order placed"))){
            JOptionPane.showMessageDialog(null, "This order is already accepted");
         return ; }         
         order1.setStatus("accepted");
         JOptionPane.showMessageDialog(null, "Order accepted successfully");
    }//GEN-LAST:event_AcceptOrderBtnActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void viewItemsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemsBtnActionPerformed
        // TODO add your handling code here:
       int selectedRow = orderRequestJTable.getSelectedRow();
       if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select an order"); 
            return;
        }
       Order order1 = (Order)orderRequestJTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) ItemsListTable.getModel();
        dtm.setRowCount(0);
        for(Items i:order1.getItemsList()) {
            Object row[] = new Object[2];
            row[0] = i;
            row[1] = i.getPrice();
            dtm.addRow(row);
        }
    
       
        
        
    }//GEN-LAST:event_viewItemsBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptOrderBtn;
    private javax.swing.JButton BtnDeliverOrder;
    private javax.swing.JTable ItemsListTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderRequestJTable;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton viewItemsBtn;
    // End of variables declaration//GEN-END:variables
}
