/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avirato.controller;

import com.avirato.gui.GuiMain;
import com.avirato.model.Customer;
import com.avirato.model.service.Data;
import com.avirato.service.UserApiService;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author Cristian
 */
public class GuiMainController {

    private String result;
    private int apiResponse;
    private UserApiService userApiService = new UserApiService();
    private ActionListener taskPerformer;
    private Timer timer;

    public String createCustomer(Customer customer) {
        try {
            apiResponse = userApiService.putUserRequest(customer.getFirst_name(), customer.getLast_name());
        } catch (IOException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (apiResponse == 200) {
            result = "Se insertó correctamente";
        } else {
            result = "No se pudo insertar";
        }
        return result;
    }

    public String modifyCustomer(Customer customer) {
        userApiService = new UserApiService();
        try {
            apiResponse = userApiService.postUserRequest();
        } catch (IOException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(apiResponse);
        if (apiResponse == 201) {
            result = "Se modificó correctamente";
        } else {
            result = "No se pudo modificar";
        }
        return result;
    }

    public String deleteCustomer(Customer customer) {
        userApiService = new UserApiService();
        try {
            apiResponse = userApiService.deleteUserRequest(customer.getId());
        } catch (IOException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(apiResponse);
        if (apiResponse == 204) {
            result = "Se eliminó correctamente";
        } else {
            result = "No se pudo eliminar";
        }
        return result;
    }

    public Object[] searchCustomerById(Customer customer){
        
        Object[] customerData = null;
        userApiService = new UserApiService();
        Data data = new Data();
        try {
            data = userApiService.getSingleUser(customer.getId());
        } catch (IOException ex) {
            Logger.getLogger(GuiMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int id = data.getId();
        String nombre = data.getFirst_name();
        String telefono = data.getLast_name();
        String correo = data.getEmail();
        String fecha = "02/03";

        customerData = new Object[]{id, nombre, telefono, correo, fecha};
        return customerData;
    }
}
