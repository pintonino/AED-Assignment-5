/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.Customer.CustomerDirectory;
import Business.DeliveryMan.DeliveryManDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author ninoshka
 */
public class EcoSystem extends Organization{
    // at any time there should be only one system obj present in the app
    private static EcoSystem business; 
    private EnterpriseDirectory enterpriseDirectory;
    private CustomerDirectory customerDirectory;
    private DeliveryManDirectory deliveryManDirectory;
    private OrderDirectory orderDirectory;   
      
    private EcoSystem(){
       super(null);
       enterpriseDirectory = new EnterpriseDirectory();
       customerDirectory = new CustomerDirectory();
       deliveryManDirectory = new DeliveryManDirectory();
       orderDirectory = new OrderDirectory();
    }

    public OrderDirectory getOrderDirectory() {
        return orderDirectory;
    }

    public void setOrderDirectory(OrderDirectory orderDirectory) {
        this.orderDirectory = orderDirectory;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(CustomerDirectory customerDirectory) {
        this.customerDirectory = customerDirectory;
    }

    public DeliveryManDirectory getDeliveryManDirectory() {
        return deliveryManDirectory;
    }

    public void setDeliveryManDirectory(DeliveryManDirectory deliveryManDirectory) {
        this.deliveryManDirectory = deliveryManDirectory;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
       //
       return false;
    }
}
