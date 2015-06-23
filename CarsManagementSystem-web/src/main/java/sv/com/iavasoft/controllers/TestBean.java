/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.controllers;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import sv.com.iavasoft.entities.Autos;
import sv.com.iavasoft.entities.dao.facade.AutosFacade;

/**
 *
 * @author ricardo
 */
@Named(value = "testBean")
@ViewScoped
public class TestBean implements Serializable {
    
    @EJB
    private AutosFacade autosFacade;
    
    /**
     * Creates a new instance of TestBean
     */
    public TestBean() {
    }
    
    @PostConstruct
    public void init() {
        obtenerListaAutos();
    }
    
    private List<Autos> autosList;

    public List<Autos> getAutosList() {
        return autosList;
    }

    public void setAutosList(List<Autos> autosList) {
        this.autosList = autosList;
    }
    
    
    public void obtenerListaAutos() {
        autosList = autosFacade.findAll();
        for (Autos a : autosList) {
            System.out.println("#############Auto: " + a.getPlacas());
        }
    }
    
}
