/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.iavasoft.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;
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

/**
 *
 * @author ricardo
 */
@Named(value = "agregarAutosBean")
@ViewScoped
public class AgregarAutosBean implements Serializable {

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
     * Creates a new instance of AgregarAutosBean
     */
    public AgregarAutosBean() {
        
    }
    
    @PostConstruct
    public void init() {
        System.out.println("INIT##################");
        auto = new Autos();
        edit = false;
        marcasLst = marcasFacade.findAll();
        modelosLst = new ArrayList<>();
        tipoAutomotorLst = tipoAutomotorFacade.findAll();
        propietario = new Propietario();
        
        Autos autoEdit = (Autos) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("autoEdit");
        if (autoEdit != null) {
            
            actualizarAuto(autoEdit);
        }
        
        System.out.println("Fin INIT----------------- ");
    }
    
    private List<Marcas> marcasLst;
    private List<Modelos> modelosLst;
    private List<TipoAutomotor> tipoAutomotorLst;
    private Autos auto;
    private Long marcaSelected;
    private Long modeloSelected;
    private Long tipoAutoSelected;
    private Long propietarioSelected;
    private String propietarioSelectedStr;
    private Propietario propietario;
    private boolean edit;

    //  <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public List<Marcas> getMarcasLst() {
        return marcasLst;
    }

    public void setMarcasLst(List<Marcas> marcasLst) {
        this.marcasLst = marcasLst;
    }
    
    public Autos getAuto() {
        return auto;
    }

    public void setAuto(Autos auto) {
        this.auto = auto;
    }

    public Long getMarcaSelected() {
        return marcaSelected;
    }

    public void setMarcaSelected(Long marcaSelected) {
        this.marcaSelected = marcaSelected;
    }

    public Long getModeloSelected() {
        return modeloSelected;
    }

    public void setModeloSelected(Long modeloSelected) {
        this.modeloSelected = modeloSelected;
    }

    public Long getTipoAutoSelected() {
        return tipoAutoSelected;
    }

    public void setTipoAutoSelected(Long tipoAutoSelected) {
        this.tipoAutoSelected = tipoAutoSelected;
    }

    public Long getPropietarioSelected() {
        return propietarioSelected;
    }

    public void setPropietarioSelected(Long propietarioSelected) {
        this.propietarioSelected = propietarioSelected;
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

    public String getPropietarioSelectedStr() {
        return propietarioSelectedStr;
    }

    public void setPropietarioSelectedStr(String propietarioSelectedStr) {
        this.propietarioSelectedStr = propietarioSelectedStr;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    
    //    </editor-fold>

    public List<Modelos> getModelosLst() {
        return modelosLst;
    }
    
    
    public void buscarModeloByMarca() {
        modelosLst = modelosFacade.findByMarca(marcaSelected);
    }
    
    public void guardarAuto() {
        System.out.println("Guardando Auto!!!!!!!!!!!!");
        List<String> errorMsgs = new ArrayList<>();
        
        if (marcaSelected == null || (marcaSelected != null && marcaSelected == 0)) {
            errorMsgs.add("La MARCA no puede estar vacia.");
        }
        
        if (modeloSelected == null || (modeloSelected != null && modeloSelected == 0)) {
            errorMsgs.add("Debe seleccionar un Modelo. No puede estar vacio.");
        }
        
        if (propietario.getNombres() == null || propietario.getNombres().isEmpty()) {
            errorMsgs.add("El Nombre de propietario no puede estar vacio.");
        }
        
        if (auto.getNumChasis() == null || (auto.getNumChasis() != null && auto.getNumChasis().isEmpty())) {
            errorMsgs.add("Debe de colocar el numero de Chasis");
        }
        
        if (auto.getNumMotor() == null || (auto.getNumMotor() != null && auto.getNumMotor().isEmpty())) {
            errorMsgs.add("Debe de colocar el Numero de Motor");
        }
        
        if (!errorMsgs.isEmpty()) {
            for (String err : errorMsgs) {
                alert(FacesMessage.SEVERITY_WARN, err, "");
            }
            return;
        }
        
        
        auto.setModelo(modelosFacade.find(modeloSelected));
        auto.setTipo(tipoAutomotorFacade.find(tipoAutoSelected));
        
        
        auto.setPropietario(propietarioFacade.update(propietario));
        
        if (!edit) {
            autosFacade.save(auto);
            limpiar();
        } else {
            autosFacade.update(auto);
            limpiar();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/CarsManagementSystem-web/autos/buscar.sertracen");
            } catch (IOException ex) {
                Logger.getLogger(AgregarAutosBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        alert(FacesMessage.SEVERITY_INFO, "Auto guardado con exito!", "");
        
        
        RequestContext.getCurrentInstance().update(":form1");
        
    }
    
    
    public void guardarPropietario() {
        System.out.println("Guardando prop.....");
        RequestContext.getCurrentInstance().update(":form1:txtProp");
    }
        
    
    public void alert(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
    }
    
    private void limpiar() {
        auto = new Autos();
        propietario = new Propietario();
        marcaSelected = 0L;
        modeloSelected = 0L;
        tipoAutoSelected = 0L;
        if (edit) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("autoEdit", null);
            edit = false;
        }
        
    }
    
    public void actualizarAuto(Autos auto) {
        System.out.println("Actualizar!!!!!!!!!!!!");
        edit = true;
        this.auto = auto;
        this.propietario = auto.getPropietario();
        this.marcaSelected = auto.getModelo().getMarca().getId();
        buscarModeloByMarca();
        this.modeloSelected = auto.getModelo().getId();
        this.tipoAutoSelected = auto.getTipo().getId();
        
    }
}
