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
import sv.com.iavasoft.entities.Marcas;
import sv.com.iavasoft.entities.Modelos;
import sv.com.iavasoft.entities.Propietario;
import sv.com.iavasoft.entities.TipoAutomotor;
import sv.com.iavasoft.entities.dao.facade.AutosFacade;
import sv.com.iavasoft.entities.dao.facade.MarcasFacade;
import sv.com.iavasoft.entities.dao.facade.ModelosFacade;
import sv.com.iavasoft.entities.dao.facade.PropietarioFacade;
import sv.com.iavasoft.entities.dao.facade.TipoAutomotorFacade;
import sv.com.iavasoft.utils.Filtros;

/**
 *
 * @author ricardo
 */
@Named(value = "buscarAutosBean")
@ViewScoped
public class BuscarAutosBean implements Serializable{

    
    @EJB
    private MarcasFacade marcasFacade;
    
    @EJB
    private ModelosFacade modelosFacade;
    
    @EJB
    private TipoAutomotorFacade tipoAutomotorFacade;
    
    @EJB
    private PropietarioFacade propietarioFacade;
    
    @EJB
    private AutosFacade autosFacade;
    
    
    /**
     * Creates a new instance of BuscarAutosBean
     */
    public BuscarAutosBean() {
    }
    
    @PostConstruct
    public void init() {
        filtros = new Filtros();
        marcasLst = marcasFacade.findAll();
        tipoAutomotorLst = tipoAutomotorFacade.findAll();
        propietariosLst = propietarioFacade.findAll();
    }
    
    private Filtros filtros;
    private List<Marcas> marcasLst;
    private List<Modelos> modelosLst;
    private List<TipoAutomotor> tipoAutomotorLst;
    private List<Propietario> propietariosLst;
    private List<Autos> autosMainList;

    public Filtros getFiltros() {
        return filtros;
    }

    public void setFiltros(Filtros filtros) {
        this.filtros = filtros;
    }

    public List<Marcas> getMarcasLst() {
        return marcasLst;
    }

    public void setMarcasLst(List<Marcas> marcasLst) {
        this.marcasLst = marcasLst;
    }

    public List<Modelos> getModelosLst() {
        return modelosLst;
    }

    public void setModelosLst(List<Modelos> modelosLst) {
        this.modelosLst = modelosLst;
    }

    public List<TipoAutomotor> getTipoAutomotorLst() {
        return tipoAutomotorLst;
    }

    public void setTipoAutomotorLst(List<TipoAutomotor> tipoAutomotorLst) {
        this.tipoAutomotorLst = tipoAutomotorLst;
    }

    public List<Propietario> getPropietariosLst() {
        return propietariosLst;
    }

    public void setPropietariosLst(List<Propietario> propietariosLst) {
        this.propietariosLst = propietariosLst;
    }

    public List<Autos> getAutosMainList() {
        return autosMainList;
    }

    public void setAutosMainList(List<Autos> autosMainList) {
        this.autosMainList = autosMainList;
    }
    
    
    
    
 
    public void llenarListaModelos() {
        if (filtros != null) {
            if (filtros.getMarca() != null) {
                modelosLst = modelosFacade.findByMarca(filtros.getMarca());
            }
        }
    }
    
    public void buscarAutomoviles() {
        autosMainList = autosFacade.findAll();
        if (filtros != null) {
            
        }
    }
    
    
}
