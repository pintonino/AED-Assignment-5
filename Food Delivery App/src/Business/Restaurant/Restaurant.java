/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.Enterprise.Items;
import Business.Organization;
import Business.Role.RestaurantAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author ninoshka
 */
public class Restaurant  extends Organization{
    
    private ArrayList<Items> itemsList;
    
    
    public Restaurant() {
        super(Organization.Type.RestaurantAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new RestaurantAdminRole());
        return roles;
    }

}
