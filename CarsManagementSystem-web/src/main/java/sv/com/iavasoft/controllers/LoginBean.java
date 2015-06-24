/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ricardo
 */
@Named(value = "loginBean")
@ViewScoped
public class LoginBean implements Serializable {

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    private String usuario;
    private String passw;

    public String getPassw() {
        return passw;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void validarLogin() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/CarsManagementSystem-web/index.sertracen");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
