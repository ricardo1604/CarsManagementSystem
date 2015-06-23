/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.controllers;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author ricardo
 */
@Named(value = "agregarAutosBean")
@ViewScoped
public class AgregarAutosBean implements Serializable {

    /**
     * Creates a new instance of AgregarAutosBean
     */
    public AgregarAutosBean() {
    }
    
    @PostConstruct
    public void init() {
        
    }
    
    
    
    
}
